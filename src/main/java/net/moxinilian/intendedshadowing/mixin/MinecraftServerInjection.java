package net.moxinilian.intendedshadowing.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.server.MinecraftServer;
import net.moxinilian.intendedshadowing.IntendedShadowing;

@Mixin(MinecraftServer.class)
public class MinecraftServerInjection {
    @Inject(at = @At("HEAD"), method = "save(ZZZ)Z")
    private void intendedShadowingSave(boolean suppressLogs, boolean flush, boolean force, CallbackInfoReturnable<Boolean> info) {
        IntendedShadowing.LOGGER.info("Saved world");
    }
}
