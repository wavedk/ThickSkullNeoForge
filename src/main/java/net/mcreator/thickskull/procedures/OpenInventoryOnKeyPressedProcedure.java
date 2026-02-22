package net.mcreator.thickskull.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thickskull.network.ThickskullneoforgeModVariables;

public class OpenInventoryOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
			_vars.justClosedInventory = false;
			_vars.markSyncDirty();
		}
	}
}