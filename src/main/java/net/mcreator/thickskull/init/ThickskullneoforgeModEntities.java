/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thickskull.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.thickskull.entity.TemperateCowCorpseEntity;
import net.mcreator.thickskull.ThickskullneoforgeMod;

@EventBusSubscriber
public class ThickskullneoforgeModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, ThickskullneoforgeMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<TemperateCowCorpseEntity>> TEMPERATE_COW_CORPSE = register("temperate_cow_corpse",
			EntityType.Builder.<TemperateCowCorpseEntity>of(TemperateCowCorpseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(1.4f, 0.6f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ThickskullneoforgeMod.MODID, registryname))));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		TemperateCowCorpseEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TEMPERATE_COW_CORPSE.get(), TemperateCowCorpseEntity.createAttributes().build());
	}
}