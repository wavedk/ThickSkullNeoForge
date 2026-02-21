/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thickskull.init;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.thickskull.network.OpenInventoryMessage;

@EventBusSubscriber(Dist.CLIENT)
public class ThickskullneoforgeModKeyMappingsExtra {
	public static final KeyMapping OPEN_INVENTORY = new KeyMapping("key.thickskullneoforge.open_inventory", GLFW.GLFW_KEY_E, "key.categories.inventory") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			// This part only works reliably when no GUI is open (vanilla keymapping handling)
			if (isDownOld != isDown && isDown) {
				OPEN_INVENTORY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - OPEN_INVENTORY_LASTPRESS);
				if (Minecraft.getInstance().player != null) {
					ClientPacketDistributor.sendToServer(new OpenInventoryMessage(1, dt));
					OpenInventoryMessage.pressAction(Minecraft.getInstance().player, 1, dt);
				}
			}
			isDownOld = isDown;
		}
	};

	private static long OPEN_INVENTORY_LASTPRESS = 0;

	// --- Added: separate tracking for when ANY GUI screen is open ---
	private static boolean OPEN_INVENTORY_GUI_DOWN = false;
	private static long OPEN_INVENTORY_GUI_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(OPEN_INVENTORY);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			// keep MCreator's original click consumption behavior
			if (Minecraft.getInstance().screen == null) {
				OPEN_INVENTORY.consumeClick();

				// if we just closed a GUI while the key was down, reset GUI-state
				OPEN_INVENTORY_GUI_DOWN = false;
			}
		}

		// --- Added: handle the keybind while a Screen (GUI) is open ---
		@SubscribeEvent
		public static void onScreenKeyPressed(ScreenEvent.KeyPressed.Pre event) {
			if (Minecraft.getInstance().player == null) return;

			// Only care while a GUI is actually open
			if (Minecraft.getInstance().screen == null) return;

			var input = InputConstants.getKey(event.getKeyCode(), event.getScanCode());

			// Match the *current* user keybind (respects rebinding)
			if (input.equals(OPEN_INVENTORY.getKey()) && !OPEN_INVENTORY_GUI_DOWN) {
				OPEN_INVENTORY_GUI_DOWN = true;
				OPEN_INVENTORY_GUI_LASTPRESS = System.currentTimeMillis();
			}
		}

		@SubscribeEvent
		public static void onScreenKeyReleased(ScreenEvent.KeyReleased.Pre event) {
			if (Minecraft.getInstance().player == null) return;

			// Only care while a GUI is actually open
			if (Minecraft.getInstance().screen == null) return;

			var input = InputConstants.getKey(event.getKeyCode(), event.getScanCode());

			if (input.equals(OPEN_INVENTORY.getKey()) && OPEN_INVENTORY_GUI_DOWN) {
				OPEN_INVENTORY_GUI_DOWN = false;

				int dt = (int) (System.currentTimeMillis() - OPEN_INVENTORY_GUI_LASTPRESS);
				ClientPacketDistributor.sendToServer(new OpenInventoryMessage(1, dt));
				OpenInventoryMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
		}
	}
}