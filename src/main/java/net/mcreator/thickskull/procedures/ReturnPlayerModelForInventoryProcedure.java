package net.mcreator.thickskull.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnPlayerModelForInventoryProcedure {
	public static Entity execute(Entity entity) {
		if (entity == null)
			return null;
		return entity;
	}
}