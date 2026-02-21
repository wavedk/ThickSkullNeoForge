/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thickskull.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;

import net.mcreator.thickskull.ThickskullneoforgeMod;

import java.util.function.Function;

public class ThickskullneoforgeModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ThickskullneoforgeMod.MODID);
	public static final DeferredItem<Item> TEMPERATE_COW_CORPSE_SPAWN_EGG;
	static {
		TEMPERATE_COW_CORPSE_SPAWN_EGG = register("temperate_cow_corpse_spawn_egg", properties -> new SpawnEggItem(ThickskullneoforgeModEntities.TEMPERATE_COW_CORPSE.get(), properties));
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}
}