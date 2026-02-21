package net.mcreator.thickskull.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.thickskull.world.inventory.CustomInventoryMenu;
import net.mcreator.thickskull.configuration.MainConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ForceOneSlotHotbar2Procedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		return execute(null, world, x, y, z, entity);
	}

	private static String execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		double currentSlot = 0;
		double currentNumber = 0;
		ItemStack currentItem = ItemStack.EMPTY;
		ItemStack cIN = ItemStack.EMPTY;
		if (MainConfigConfiguration.FORCE_ONE_SLOT.get() == true) {
			if (!(entity instanceof Player _plr1 && _plr1.containerMenu instanceof CustomInventoryMenu)) {
				currentNumber = 5;
				if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler2 ? _modHandler2.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
					currentSlot = 9;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler5 ? _modHandler5.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler6 ? _modHandler6.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler8 ? _modHandler8.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler10 ? _modHandler10.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler13 ? _modHandler13.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler15 ? _modHandler15.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler17 ? _modHandler17.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler18 ? _modHandler18.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 10;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler38 ? _modHandler38.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler39 ? _modHandler39.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler41 ? _modHandler41.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler43 ? _modHandler43.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler46 ? _modHandler46.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler48 ? _modHandler48.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler50 ? _modHandler50.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler51 ? _modHandler51.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 11;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler71 ? _modHandler71.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler72 ? _modHandler72.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler74 ? _modHandler74.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler76 ? _modHandler76.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler79 ? _modHandler79.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler81 ? _modHandler81.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler83 ? _modHandler83.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler84 ? _modHandler84.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 12;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler104 ? _modHandler104.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler105 ? _modHandler105.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler107 ? _modHandler107.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler109 ? _modHandler109.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler112 ? _modHandler112.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler114 ? _modHandler114.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler116 ? _modHandler116.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler117 ? _modHandler117.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 13;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler137 ? _modHandler137.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler138 ? _modHandler138.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler140 ? _modHandler140.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler142 ? _modHandler142.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler145 ? _modHandler145.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler147 ? _modHandler147.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler149 ? _modHandler149.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler150 ? _modHandler150.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 14;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler170 ? _modHandler170.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler171 ? _modHandler171.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler173 ? _modHandler173.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler175 ? _modHandler175.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler178 ? _modHandler178.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler180 ? _modHandler180.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler182 ? _modHandler182.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler183 ? _modHandler183.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 15;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler203 ? _modHandler203.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler204 ? _modHandler204.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler206 ? _modHandler206.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler208 ? _modHandler208.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler211 ? _modHandler211.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler213 ? _modHandler213.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler215 ? _modHandler215.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler216 ? _modHandler216.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 16;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler236 ? _modHandler236.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler237 ? _modHandler237.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler239 ? _modHandler239.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler241 ? _modHandler241.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler244 ? _modHandler244.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler246 ? _modHandler246.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler248 ? _modHandler248.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler249 ? _modHandler249.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 17;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler269 ? _modHandler269.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler270 ? _modHandler270.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler272 ? _modHandler272.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler274 ? _modHandler274.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler277 ? _modHandler277.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler279 ? _modHandler279.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler281 ? _modHandler281.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler282 ? _modHandler282.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 4;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler302 ? _modHandler302.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler303 ? _modHandler303.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler305 ? _modHandler305.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler307 ? _modHandler307.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler310 ? _modHandler310.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler312 ? _modHandler312.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler314 ? _modHandler314.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler315 ? _modHandler315.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler335 ? _modHandler335.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						ItemStack _setstack = ItemStack.EMPTY.copy();
						_setstack.setCount(0);
						_modHandler.setStackInSlot((int) currentNumber, _setstack);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
						entityToSpawn.setPickUpDelay(40);
						_level.addFreshEntity(entityToSpawn);
					}
					return "Done!";
				}
				currentNumber = 6;
				if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler339 ? _modHandler339.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
						.getItem())) {
					currentSlot = 9;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler342 ? _modHandler342.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler343 ? _modHandler343.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler345 ? _modHandler345.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler347 ? _modHandler347.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler350 ? _modHandler350.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler352 ? _modHandler352.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler354 ? _modHandler354.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler355 ? _modHandler355.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 10;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler375 ? _modHandler375.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler376 ? _modHandler376.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler378 ? _modHandler378.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler380 ? _modHandler380.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler383 ? _modHandler383.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler385 ? _modHandler385.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler387 ? _modHandler387.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler388 ? _modHandler388.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 11;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler408 ? _modHandler408.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler409 ? _modHandler409.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler411 ? _modHandler411.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler413 ? _modHandler413.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler416 ? _modHandler416.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler418 ? _modHandler418.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler420 ? _modHandler420.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler421 ? _modHandler421.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 12;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler441 ? _modHandler441.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler442 ? _modHandler442.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler444 ? _modHandler444.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler446 ? _modHandler446.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler449 ? _modHandler449.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler451 ? _modHandler451.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler453 ? _modHandler453.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler454 ? _modHandler454.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 13;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler474 ? _modHandler474.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler475 ? _modHandler475.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler477 ? _modHandler477.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler479 ? _modHandler479.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler482 ? _modHandler482.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler484 ? _modHandler484.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler486 ? _modHandler486.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler487 ? _modHandler487.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 14;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler507 ? _modHandler507.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler508 ? _modHandler508.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler510 ? _modHandler510.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler512 ? _modHandler512.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler515 ? _modHandler515.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler517 ? _modHandler517.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler519 ? _modHandler519.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler520 ? _modHandler520.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 15;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler540 ? _modHandler540.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler541 ? _modHandler541.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler543 ? _modHandler543.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler545 ? _modHandler545.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler548 ? _modHandler548.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler550 ? _modHandler550.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler552 ? _modHandler552.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler553 ? _modHandler553.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 16;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler573 ? _modHandler573.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler574 ? _modHandler574.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler576 ? _modHandler576.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler578 ? _modHandler578.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler581 ? _modHandler581.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler583 ? _modHandler583.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler585 ? _modHandler585.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler586 ? _modHandler586.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 17;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler606 ? _modHandler606.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler607 ? _modHandler607.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler609 ? _modHandler609.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler611 ? _modHandler611.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler614 ? _modHandler614.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler616 ? _modHandler616.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler618 ? _modHandler618.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler619 ? _modHandler619.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 4;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler639 ? _modHandler639.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler640 ? _modHandler640.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler642 ? _modHandler642.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler644 ? _modHandler644.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler647 ? _modHandler647.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler649 ? _modHandler649.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler651 ? _modHandler651.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler652 ? _modHandler652.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler672 ? _modHandler672.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						ItemStack _setstack = ItemStack.EMPTY.copy();
						_setstack.setCount(0);
						_modHandler.setStackInSlot((int) currentNumber, _setstack);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
						entityToSpawn.setPickUpDelay(40);
						_level.addFreshEntity(entityToSpawn);
					}
					return "Done!";
				}
				currentNumber = 7;
				if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler676 ? _modHandler676.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
						.getItem())) {
					currentSlot = 9;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler679 ? _modHandler679.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler680 ? _modHandler680.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler682 ? _modHandler682.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler684 ? _modHandler684.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler687 ? _modHandler687.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler689 ? _modHandler689.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler691 ? _modHandler691.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler692 ? _modHandler692.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 10;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler712 ? _modHandler712.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler713 ? _modHandler713.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler715 ? _modHandler715.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler717 ? _modHandler717.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler720 ? _modHandler720.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler722 ? _modHandler722.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler724 ? _modHandler724.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler725 ? _modHandler725.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 11;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler745 ? _modHandler745.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler746 ? _modHandler746.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler748 ? _modHandler748.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler750 ? _modHandler750.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler753 ? _modHandler753.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler755 ? _modHandler755.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler757 ? _modHandler757.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler758 ? _modHandler758.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 12;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler778 ? _modHandler778.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler779 ? _modHandler779.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler781 ? _modHandler781.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler783 ? _modHandler783.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler786 ? _modHandler786.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler788 ? _modHandler788.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler790 ? _modHandler790.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler791 ? _modHandler791.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 13;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler811 ? _modHandler811.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler812 ? _modHandler812.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler814 ? _modHandler814.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler816 ? _modHandler816.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler819 ? _modHandler819.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler821 ? _modHandler821.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler823 ? _modHandler823.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler824 ? _modHandler824.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 14;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler844 ? _modHandler844.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler845 ? _modHandler845.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler847 ? _modHandler847.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler849 ? _modHandler849.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler852 ? _modHandler852.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler854 ? _modHandler854.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler856 ? _modHandler856.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler857 ? _modHandler857.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 15;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler877 ? _modHandler877.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler878 ? _modHandler878.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler880 ? _modHandler880.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler882 ? _modHandler882.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler885 ? _modHandler885.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler887 ? _modHandler887.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler889 ? _modHandler889.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler890 ? _modHandler890.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 16;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler910 ? _modHandler910.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler911 ? _modHandler911.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler913 ? _modHandler913.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler915 ? _modHandler915.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler918 ? _modHandler918.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler920 ? _modHandler920.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler922 ? _modHandler922.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler923 ? _modHandler923.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 17;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler943 ? _modHandler943.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler944 ? _modHandler944.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler946 ? _modHandler946.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler948 ? _modHandler948.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler951 ? _modHandler951.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler953 ? _modHandler953.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler955 ? _modHandler955.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler956 ? _modHandler956.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 4;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler976 ? _modHandler976.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler977 ? _modHandler977.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler979 ? _modHandler979.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler981 ? _modHandler981.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler984 ? _modHandler984.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler986 ? _modHandler986.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler988 ? _modHandler988.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler989 ? _modHandler989.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1009 ? _modHandler1009.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						ItemStack _setstack = ItemStack.EMPTY.copy();
						_setstack.setCount(0);
						_modHandler.setStackInSlot((int) currentNumber, _setstack);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
						entityToSpawn.setPickUpDelay(40);
						_level.addFreshEntity(entityToSpawn);
					}
					return "Done!";
				}
				currentNumber = 8;
				if (!((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1013 ? _modHandler1013.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
						.getItem())) {
					currentSlot = 9;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1016 ? _modHandler1016.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1017 ? _modHandler1017.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1019 ? _modHandler1019.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1021 ? _modHandler1021.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1024 ? _modHandler1024.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1026 ? _modHandler1026.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1028 ? _modHandler1028.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1029 ? _modHandler1029.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 10;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1049 ? _modHandler1049.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1050 ? _modHandler1050.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1052 ? _modHandler1052.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1054 ? _modHandler1054.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1057 ? _modHandler1057.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1059 ? _modHandler1059.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1061 ? _modHandler1061.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1062 ? _modHandler1062.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 11;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1082 ? _modHandler1082.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1083 ? _modHandler1083.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1085 ? _modHandler1085.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1087 ? _modHandler1087.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1090 ? _modHandler1090.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1092 ? _modHandler1092.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1094 ? _modHandler1094.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1095 ? _modHandler1095.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 12;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1115 ? _modHandler1115.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1116 ? _modHandler1116.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1118 ? _modHandler1118.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1120 ? _modHandler1120.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1123 ? _modHandler1123.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1125 ? _modHandler1125.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1127 ? _modHandler1127.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1128 ? _modHandler1128.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 13;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1148 ? _modHandler1148.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1149 ? _modHandler1149.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1151 ? _modHandler1151.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1153 ? _modHandler1153.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1156 ? _modHandler1156.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1158 ? _modHandler1158.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1160 ? _modHandler1160.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1161 ? _modHandler1161.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 14;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1181 ? _modHandler1181.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1182 ? _modHandler1182.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1184 ? _modHandler1184.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1186 ? _modHandler1186.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1189 ? _modHandler1189.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1191 ? _modHandler1191.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1193 ? _modHandler1193.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1194 ? _modHandler1194.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 15;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1214 ? _modHandler1214.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1215 ? _modHandler1215.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1217 ? _modHandler1217.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1219 ? _modHandler1219.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1222 ? _modHandler1222.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1224 ? _modHandler1224.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1226 ? _modHandler1226.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1227 ? _modHandler1227.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 16;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1247 ? _modHandler1247.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1248 ? _modHandler1248.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1250 ? _modHandler1250.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1252 ? _modHandler1252.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1255 ? _modHandler1255.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1257 ? _modHandler1257.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1259 ? _modHandler1259.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1260 ? _modHandler1260.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 17;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1280 ? _modHandler1280.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1281 ? _modHandler1281.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1283 ? _modHandler1283.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1285 ? _modHandler1285.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1288 ? _modHandler1288.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1290 ? _modHandler1290.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1292 ? _modHandler1292.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1293 ? _modHandler1293.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentSlot = 4;
					if (((entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1313 ? _modHandler1313.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
							.getItem() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1314 ? _modHandler1314.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).getItem()
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1316 ? _modHandler1316.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getMaxStackSize() > 1
							|| (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1318 ? _modHandler1318.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem())
							&& (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1321 ? _modHandler1321.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
									.getCount() <= (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1323 ? _modHandler1323.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY)
											.getMaxStackSize() - 1) {
						currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1325 ? _modHandler1325.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
						cIN = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1326 ? _modHandler1326.getStackInSlot((int) currentSlot).copy() : ItemStack.EMPTY).copy();
						if (currentItem.getItem() == cIN.getItem()) {
							if (currentItem.getCount() + cIN.getCount() > currentItem.getMaxStackSize()) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = currentItem.copy();
									_setstack.setCount(currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount((currentItem.getCount() + cIN.getCount()) - currentItem.getMaxStackSize());
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							} else {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = cIN.copy();
									_setstack.setCount(currentItem.getCount() + cIN.getCount());
									_modHandler.setStackInSlot((int) currentSlot, _setstack);
								}
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									ItemStack _setstack = ItemStack.EMPTY.copy();
									_setstack.setCount(0);
									_modHandler.setStackInSlot((int) currentNumber, _setstack);
								}
							}
						} else {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = currentItem.copy();
								_setstack.setCount(currentItem.getCount());
								_modHandler.setStackInSlot((int) currentSlot, _setstack);
							}
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = ItemStack.EMPTY.copy();
								_setstack.setCount(0);
								_modHandler.setStackInSlot((int) currentNumber, _setstack);
							}
						}
						return "Done!";
					}
					currentItem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1346 ? _modHandler1346.getStackInSlot((int) currentNumber).copy() : ItemStack.EMPTY).copy();
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						ItemStack _setstack = ItemStack.EMPTY.copy();
						_setstack.setCount(0);
						_modHandler.setStackInSlot((int) currentNumber, _setstack);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, currentItem);
						entityToSpawn.setPickUpDelay(40);
						_level.addFreshEntity(entityToSpawn);
					}
					return "Done!";
				}
			}
		}
		return "Done!";
	}
}