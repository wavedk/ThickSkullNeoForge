package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.thickskull.configuration.MainConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DropItemsIfNotInCustomInventoryProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		return execute(null, world, x, y, z, entity);
	}

	private static boolean execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		ItemStack currentItem = ItemStack.EMPTY;
		double currentSlot = 0;
		if (MainConfigConfiguration.FORCE_ONE_SLOT.get()) {
			currentSlot = 18;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1 ? _modHandler1.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler4 ? _modHandler4.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 19;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler8 ? _modHandler8.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler11 ? _modHandler11.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 20;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler15 ? _modHandler15.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler18 ? _modHandler18.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 21;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler22 ? _modHandler22.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler25 ? _modHandler25.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 22;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler29 ? _modHandler29.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler32 ? _modHandler32.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 23;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler36 ? _modHandler36.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler39 ? _modHandler39.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 24;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler43 ? _modHandler43.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler46 ? _modHandler46.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 25;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler50 ? _modHandler50.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler53 ? _modHandler53.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 26;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler57 ? _modHandler57.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler60 ? _modHandler60.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 27;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler64 ? _modHandler64.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler67 ? _modHandler67.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 28;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler71 ? _modHandler71.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler74 ? _modHandler74.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 29;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler78 ? _modHandler78.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler81 ? _modHandler81.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 30;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler85 ? _modHandler85.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler88 ? _modHandler88.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 31;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler92 ? _modHandler92.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler95 ? _modHandler95.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 32;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler99 ? _modHandler99.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler102 ? _modHandler102.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 33;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler106 ? _modHandler106.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler109 ? _modHandler109.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 34;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler113 ? _modHandler113.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler116 ? _modHandler116.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
			currentSlot = 35;
			if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler120 ? _modHandler120.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
				currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler123 ? _modHandler123.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = ItemStack.EMPTY.copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot((int) currentSlot, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				return true;
			}
		}
		return true;
	}
}