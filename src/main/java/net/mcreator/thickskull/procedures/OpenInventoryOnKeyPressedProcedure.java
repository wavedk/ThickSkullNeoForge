package net.mcreator.thickskull.procedures;

import net.neoforged.bus.api.Event;

public class OpenInventoryOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("pressed"), false);
	}
}