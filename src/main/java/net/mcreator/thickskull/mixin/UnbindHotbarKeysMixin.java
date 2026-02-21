package net.mcreator.thickskull.mixin;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Options.class)
public abstract class UnbindHotbarKeysMixin {

    @Shadow public KeyMapping[] keyHotbarSlots;

    // Inventory ("Open/Close Inventory")
    @Shadow public KeyMapping keyInventory;

    @Inject(method = "load", at = @At("TAIL"))
    private void thickskull$unbindHotbarAndInventory(CallbackInfo ci) {
        for (KeyMapping km : keyHotbarSlots) {
            km.setKey(InputConstants.UNKNOWN);
        }

        keyInventory.setKey(InputConstants.UNKNOWN);

        KeyMapping.resetMapping();
        ((Options)(Object)this).save();
    }
}