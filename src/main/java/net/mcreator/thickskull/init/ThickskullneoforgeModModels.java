/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thickskull.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.thickskull.client.model.Modelleather_pouch;
import net.mcreator.thickskull.client.model.Modeldeadtemperatecow;
import net.mcreator.thickskull.client.model.Modela;
import net.mcreator.thickskull.client.model.ModelCustomModel;

@EventBusSubscriber(Dist.CLIENT)
public class ThickskullneoforgeModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelCustomModel.LAYER_LOCATION, ModelCustomModel::createBodyLayer);
		event.registerLayerDefinition(Modeldeadtemperatecow.LAYER_LOCATION, Modeldeadtemperatecow::createBodyLayer);
		event.registerLayerDefinition(Modela.LAYER_LOCATION, Modela::createBodyLayer);
		event.registerLayerDefinition(Modelleather_pouch.LAYER_LOCATION, Modelleather_pouch::createBodyLayer);
	}
}