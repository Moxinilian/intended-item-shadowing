package net.moxinilian.intendedshadowing.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.moxinilian.intendedshadowing.IntendedShadowing;
import net.moxinilian.intendedshadowing.ItemStackExt;

@Mixin(ItemStack.class)
public class ItemStackInjection implements ItemStackExt {
    @Shadow
	private NbtCompound nbt;

    @ModifyVariable(method = "areNbtEqual(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;)Z", at = @At("HEAD"), ordinal = 0)
	private static ItemStack intendedShadowingAreNbtEqualArg0(ItemStack i) {
        ItemStackInjection iAccess = (ItemStackInjection) (Object) i;
        if (iAccess.nbt != null && iAccess.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
            int shadow = iAccess.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
            return IntendedShadowing.shadowItems.accessShadow(shadow);
        } else {
            return i;
        }
    }

    @ModifyVariable(method = "areNbtEqual(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;)Z", at = @At("HEAD"), ordinal = 1)
	private static ItemStack intendedShadowingAreNbtEqualArg1(ItemStack i) {
        ItemStackInjection iAccess = (ItemStackInjection) (Object) i;
        if (iAccess.nbt != null && iAccess.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
            int shadow = iAccess.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
            return IntendedShadowing.shadowItems.accessShadow(shadow);
        } else {
            return i;
        }
    }

    @Override
    @Nullable
    public Integer getShadowId() {
        if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
            return this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
        } else {
            return null;
        }
    }

    @Inject(at = @At("RETURN"), method = "copy()Lnet/minecraft/item/ItemStack;")
    private void intendedShadowingCopyReferenceManagement(CallbackInfoReturnable<ItemStack> info) {
        IntendedShadowing.shadowItems.registerNewReference(info.getReturnValue());
    }

    @Inject(at = @At("RETURN"), method = "fromNbt(Lnet/minecraft/nbt/NbtCompound;)Lnet/minecraft/item/ItemStack;")
    private static void intendedShadowingFromNbtRegisterCleaning(CallbackInfoReturnable<ItemStack> info) {
        IntendedShadowing.shadowItems.registerCleaning(info.getReturnValue());
    }
}
