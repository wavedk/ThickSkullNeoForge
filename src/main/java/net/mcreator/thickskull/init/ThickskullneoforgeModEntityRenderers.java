/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thickskull.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.thickskull.client.renderer.TemperateCowCorpseRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class ThickskullneoforgeModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ThickskullneoforgeModEntities.TEMPERATE_COW_CORPSE.get(), TemperateCowCorpseRenderer::new);
	}
}