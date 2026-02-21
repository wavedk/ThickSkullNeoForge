/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thickskull.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.thickskull.network.OpenCreativeInventoryMessage;

@EventBusSubscriber(Dist.CLIENT)
public class ThickskullneoforgeModKeyMappings {
	public static final KeyMapping OPEN_CREATIVE_INVENTORY = new KeyMapping("key.thickskullneoforge.open_creative_inventory", GLFW.GLFW_KEY_R, "key.categories.creative") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				OPEN_CREATIVE_INVENTORY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - OPEN_CREATIVE_INVENTORY_LASTPRESS);
				ClientPacketDistributor.sendToServer(new OpenCreativeInventoryMessage(1, dt));
				OpenCreativeInventoryMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long OPEN_CREATIVE_INVENTORY_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(OPEN_CREATIVE_INVENTORY);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				OPEN_CREATIVE_INVENTORY.consumeClick();
			}
		}
	}
}