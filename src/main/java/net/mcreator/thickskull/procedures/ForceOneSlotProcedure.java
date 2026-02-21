package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.thickskull.configuration.MainConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ForceOneSlotProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		double hotbarSlot = 0;
		if (MainConfigConfiguration.FORCE_ONE_SLOT.get() == true) {
			LocalPlayer player = Minecraft.getInstance().player;
			if (player == null)
				return;
			hotbarSlot = player.getInventory().getSelectedSlot();;
			if (!(hotbarSlot == 4)) {
				player.getInventory().setSelectedSlot(4);
			}
		}
	}
}