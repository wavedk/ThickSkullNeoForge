/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thickskull.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.thickskull.client.gui.CustomInventoryScreen;

@EventBusSubscriber(Dist.CLIENT)
public class ThickskullneoforgeModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(ThickskullneoforgeModMenus.CUSTOM_INVENTORY.get(), CustomInventoryScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}