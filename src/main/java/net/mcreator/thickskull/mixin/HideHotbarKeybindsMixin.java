package net.mcreator.thickskull.mixin;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.options.controls.KeyBindsList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyBindsList.class)
public abstract class HideHotbarKeybindsMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void thickskull$hideHotbarAndInventory(CallbackInfo ci) {
        KeyBindsList self = (KeyBindsList) (Object) this;

        self.children().removeIf(entry -> {
            if (entry instanceof KeyBindsList.KeyEntry keyEntry) {
                KeyMapping km = ((KeyBindsListKeyEntryAccessorMixin) keyEntry).thickskull$getKey();
                String name = km.getName(); // translation key, e.g. "key.hotbar.1", "key.inventory"

                if (name == null) return false;

                // Hide hotbar selectors + inventory keybind entry
                return name.startsWith("key.hotbar.") || name.equals("key.inventory");
            }
            return false;
        });
    }
}