package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.thickskull.network.ThickskullneoforgeModVariables;
import net.mcreator.thickskull.init.ThickskullneoforgeModMenus;

public class CustomInventoryWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			ThickskullneoforgeModVariables.PlayerVariables _vars = entity.getData(ThickskullneoforgeModVariables.PLAYER_VARIABLES);
			_vars.customInventorySlot1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(1).getItem() : ItemStack.EMPTY).copy();
			_vars.customInventorySlot2 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(2).getItem() : ItemStack.EMPTY).copy();
			_vars.customInventorySlot3 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(3).getItem() : ItemStack.EMPTY).copy();
			_vars.customInventorySlot4 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(4).getItem() : ItemStack.EMPTY).copy();
			_vars.customInventorySlot5 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(5).getItem() : ItemStack.EMPTY).copy();
			_vars.customInventorySlot6 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(6).getItem() : ItemStack.EMPTY).copy();
			_vars.customInventorySlot7 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(7).getItem() : ItemStack.EMPTY).copy();
			_vars.customInventorySlot8 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(8).getItem() : ItemStack.EMPTY).copy();
			_vars.customInventorySlot9 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(9).getItem() : ItemStack.EMPTY).copy();
			_vars.hotbarItem = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
			_vars.markSyncDirty();
		}
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
			_setstack.setCount((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ThickskullneoforgeModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount());
			_modHandler.setStackInSlot(4, _setstack);
		}
	}
}