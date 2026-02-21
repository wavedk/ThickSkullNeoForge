package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.thickskull.init.ThickskullneoforgeModMenus;

public class CustomInventoryThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu) {
			ItemStack _setstack3 = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler2 ? _modHandler2.getStackInSlot(9).copy() : ItemStack.EMPTY).copy();
			_setstack3.setCount((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler0 ? _modHandler0.getStackInSlot(9).copy() : ItemStack.EMPTY).getCount());
			_menu.getSlots().get(1).set(_setstack3);
			ItemStack _setstack7 = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler6 ? _modHandler6.getStackInSlot(10).copy() : ItemStack.EMPTY).copy();
			_setstack7.setCount((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler4 ? _modHandler4.getStackInSlot(10).copy() : ItemStack.EMPTY).getCount());
			_menu.getSlots().get(2).set(_setstack7);
			ItemStack _setstack11 = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler10 ? _modHandler10.getStackInSlot(11).copy() : ItemStack.EMPTY).copy();
			_setstack11.setCount((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler8 ? _modHandler8.getStackInSlot(11).copy() : ItemStack.EMPTY).getCount());
			_menu.getSlots().get(3).set(_setstack11);
			ItemStack _setstack15 = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler14 ? _modHandler14.getStackInSlot(12).copy() : ItemStack.EMPTY).copy();
			_setstack15.setCount((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler12 ? _modHandler12.getStackInSlot(12).copy() : ItemStack.EMPTY).getCount());
			_menu.getSlots().get(4).set(_setstack15);
			ItemStack _setstack19 = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler18 ? _modHandler18.getStackInSlot(13).copy() : ItemStack.EMPTY).copy();
			_setstack19.setCount((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler16 ? _modHandler16.getStackInSlot(13).copy() : ItemStack.EMPTY).getCount());
			_menu.getSlots().get(5).set(_setstack19);
			ItemStack _setstack23 = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler22 ? _modHandler22.getStackInSlot(14).copy() : ItemStack.EMPTY).copy();
			_setstack23.setCount((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler20 ? _modHandler20.getStackInSlot(14).copy() : ItemStack.EMPTY).getCount());
			_menu.getSlots().get(6).set(_setstack23);
			ItemStack _setstack27 = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler26 ? _modHandler26.getStackInSlot(15).copy() : ItemStack.EMPTY).copy();
			_setstack27.setCount((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler24 ? _modHandler24.getStackInSlot(15).copy() : ItemStack.EMPTY).getCount());
			_menu.getSlots().get(7).set(_setstack27);
			ItemStack _setstack31 = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler30 ? _modHandler30.getStackInSlot(16).copy() : ItemStack.EMPTY).copy();
			_setstack31.setCount((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler28 ? _modHandler28.getStackInSlot(16).copy() : ItemStack.EMPTY).getCount());
			_menu.getSlots().get(8).set(_setstack31);
			ItemStack _setstack35 = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler34 ? _modHandler34.getStackInSlot(17).copy() : ItemStack.EMPTY).copy();
			_setstack35.setCount((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler32 ? _modHandler32.getStackInSlot(17).copy() : ItemStack.EMPTY).getCount());
			_menu.getSlots().get(9).set(_setstack35);
			ItemStack _setstack39 = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler38 ? _modHandler38.getStackInSlot(4).copy() : ItemStack.EMPTY).copy();
			_setstack39.setCount((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler36 ? _modHandler36.getStackInSlot(4).copy() : ItemStack.EMPTY).getCount());
			_menu.getSlots().get(0).set(_setstack39);
			_player.containerMenu.broadcastChanges();
		}
	}
}