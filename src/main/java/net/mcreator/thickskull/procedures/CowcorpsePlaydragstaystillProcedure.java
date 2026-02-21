package net.mcreator.thickskull.procedures;

import net.minecraft.world.entity.Entity;

public class CowcorpsePlaydragstaystillProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.isVehicle()) {
			return true;
		}
		return false;
	}
}