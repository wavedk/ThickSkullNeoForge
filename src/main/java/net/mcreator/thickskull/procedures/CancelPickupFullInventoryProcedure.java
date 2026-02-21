package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.util.TriState;

import net.mcreator.thickskull.configuration.MainConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CancelPickupFullInventoryProcedure {
	@SubscribeEvent
	public static void onPickup(ItemEntityPickupEvent.Pre event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		if (MainConfigConfiguration.FORCE_RIGHT_CLICK_PICKUP.get()) {
			if (event instanceof ItemEntityPickupEvent.Pre _event)
				_event.setCanPickup(TriState.FALSE);
		}
	}
}