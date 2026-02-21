package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.Minecraft;

public class PickupMechanicProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Entity entityLookingAt = null;
		ItemStack currentitem = ItemStack.EMPTY;
		double currentslot = 0;
		LocalPlayer player = Minecraft.getInstance().player;
		if (player == null)
			return;
		currentslot = Minecraft.getInstance().player.getInventory().getSelectedSlot();
		double rayDistance = 20.0;
		Vec3 eyePosition = entity.getEyePosition();
		Vec3 lookVector = entity.getViewVector(1.0F);
		Vec3 reachVector = eyePosition.add(lookVector.scale(rayDistance));
		AABB boundingBox = entity.getBoundingBox().expandTowards(lookVector.scale(rayDistance)).inflate(1.0D);
		EntityHitResult entityHitResult = ProjectileUtil.getEntityHitResult(entity, eyePosition, reachVector, boundingBox, (target) -> !target.isSpectator() && target.isAlive() && target != entity, rayDistance);
		entityLookingAt = null;
		if (entityHitResult != null) {
			entityLookingAt = entityHitResult.getEntity();
		}
		if (currentslot == 4) {
			if (entityLookingAt instanceof ItemEntity) {
				currentitem = (entityLookingAt instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy();
				if (!entityLookingAt.level().isClientSide())
					entityLookingAt.discard();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = currentitem.copy();
					_setstack.setCount(currentitem.getCount());
					_modHandler.setStackInSlot(4, _setstack);
				}
			}
		}
	}
}