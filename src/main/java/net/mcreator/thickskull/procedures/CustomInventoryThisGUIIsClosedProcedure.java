package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.thickskull.network.ThickskullneoforgeModVariables;

public class CustomInventoryThisGUIIsClosedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			ItemStack _setstack = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot1.copy();
			_setstack.setCount(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot1.getCount());
			_modHandler.setStackInSlot(9, _setstack);
		}
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			ItemStack _setstack = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot2.copy();
			_setstack.setCount(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot2.getCount());
			_modHandler.setStackInSlot(10, _setstack);
		}
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			ItemStack _setstack = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot3.copy();
			_setstack.setCount(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot3.getCount());
			_modHandler.setStackInSlot(11, _setstack);
		}
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			ItemStack _setstack = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot4.copy();
			_setstack.setCount(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot4.getCount());
			_modHandler.setStackInSlot(12, _setstack);
		}
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			ItemStack _setstack = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot5.copy();
			_setstack.setCount(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot5.getCount());
			_modHandler.setStackInSlot(13, _setstack);
		}
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			ItemStack _setstack = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot6.copy();
			_setstack.setCount(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot6.getCount());
			_modHandler.setStackInSlot(14, _setstack);
		}
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			ItemStack _setstack = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot7.copy();
			_setstack.setCount(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot7.getCount());
			_modHandler.setStackInSlot(15, _setstack);
		}
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			ItemStack _setstack = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot8.copy();
			_setstack.setCount(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot8.getCount());
			_modHandler.setStackInSlot(16, _setstack);
		}
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			ItemStack _setstack = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot9.copy();
			_setstack.setCount(entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES).customInventorySlot9.getCount());
			_modHandler.setStackInSlot(17, _setstack);
		}
	}
}