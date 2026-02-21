package net.mcreator.thickskull.client;

import java.util.concurrent.atomic.AtomicBoolean;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;

public final class ThickskullClientScreens {
    private static final AtomicBoolean OPENING = new AtomicBoolean(false);

    private ThickskullClientScreens() {}

    /**
     * Opens vanilla inventory safely (avoids re-entry from KeyMapping.releaseAll()).
     * @param creative If true, tries to open creative inventory when the player is in creative.
     */
    public static void openVanillaInventory(boolean creative) {
        Minecraft mc = Minecraft.getInstance();
        if (mc == null) return;

        // Prevent re-entry caused by screen changes triggering key releases
        if (!OPENING.compareAndSet(false, true)) return;

        // Run later on the client thread (not immediately inside the key release stack)
        mc.execute(() -> {
            try {
                if (mc.player == null) return;

                if (creative && mc.player.isCreative()) {
                    // 1.21.8 constructor: (LocalPlayer, FeatureFlagSet, boolean)
                    mc.setScreen(new CreativeModeInventoryScreen(
                        mc.player,
                        mc.player.level().enabledFeatures(),
                        mc.options.operatorItemsTab().get()
                    ));
                } else {
                    mc.setScreen(new InventoryScreen(mc.player));
                }
            } finally {
                OPENING.set(false);
            }
        });
    }
}