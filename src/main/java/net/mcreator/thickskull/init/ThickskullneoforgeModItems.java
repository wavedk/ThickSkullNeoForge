/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thickskull.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.thickskull.item.LeatherPouchItem;
import net.mcreator.thickskull.ThickskullneoforgeMod;

import java.util.function.Function;

public class ThickskullneoforgeModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ThickskullneoforgeMod.MODID);
	public static final DeferredItem<Item> TEMPERATE_COW_CORPSE_SPAWN_EGG;
	public static final DeferredItem<Item> LEATHER_POUCH;
	static {
		TEMPERATE_COW_CORPSE_SPAWN_EGG = register("temperate_cow_corpse_spawn_egg", properties -> new SpawnEggItem(ThickskullneoforgeModEntities.TEMPERATE_COW_CORPSE.get(), properties));
		LEATHER_POUCH = register("leather_pouch", LeatherPouchItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		public static void registerItemModelProperties(RegisterRangeSelectItemModelPropertyEvent event) {
			event.register(ResourceLocation.parse("thickskullneoforge:leather_pouch/open"), LeatherPouchItem.OpenProperty.MAP_CODEC);
		}
	}
}