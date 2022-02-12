
/*********************************************************
    THIS IS GENERATED CODE
    DO NOT MODIFY OR CHANGES WILL BE LOST
    RUN "ItemStackInjectionGen.py" TO REGENERATE
*********************************************************/

package net.moxinilian.intendedshadowing.mixin;

import net.moxinilian.intendedshadowing.IntendedShadowing;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("rawtypes")
@Mixin(ItemStack.class)
public abstract class ItemStackInjectionGen {
	@Shadow
	private NbtCompound nbt;

    @Shadow
	private void updateEmptyState() {}

	@Inject(at = @At("HEAD"), method = "updateEmptyState()V", cancellable = true)
	private void intendedShadowingUpdateEmptyState(CallbackInfo info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			((ItemStackInjectionGen) (Object) shadowStack).updateEmptyState();
			info.cancel();
		}
	}
    
    @Shadow
	public boolean isEmpty() { return false; }

	@Inject(at = @At("HEAD"), method = "isEmpty()Z", cancellable = true)
	private void intendedShadowingIsEmpty(CallbackInfoReturnable<Boolean> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			boolean res = ((ItemStackInjectionGen) (Object) shadowStack).isEmpty();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public net.minecraft.item.ItemStack split(int amount) { return null; }

	@Inject(at = @At("HEAD"), method = "split(I)Lnet/minecraft/item/ItemStack;", cancellable = true)
	private void intendedShadowingSplit(int amount, CallbackInfoReturnable<net.minecraft.item.ItemStack> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			net.minecraft.item.ItemStack res = ((ItemStackInjectionGen) (Object) shadowStack).split(amount);
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public net.minecraft.item.Item getItem() { return null; }

	@Inject(at = @At("HEAD"), method = "getItem()Lnet/minecraft/item/Item;", cancellable = true)
	private void intendedShadowingGetItem(CallbackInfoReturnable<net.minecraft.item.Item> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			net.minecraft.item.Item res = ((ItemStackInjectionGen) (Object) shadowStack).getItem();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public net.minecraft.util.ActionResult useOnBlock(net.minecraft.item.ItemUsageContext context) { return null; }

	@Inject(at = @At("HEAD"), method = "useOnBlock(Lnet/minecraft/item/ItemUsageContext;)Lnet/minecraft/util/ActionResult;", cancellable = true)
	private void intendedShadowingUseOnBlock(net.minecraft.item.ItemUsageContext context, CallbackInfoReturnable<net.minecraft.util.ActionResult> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			net.minecraft.util.ActionResult res = ((ItemStackInjectionGen) (Object) shadowStack).useOnBlock(context);
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public boolean isDamageable() { return false; }

	@Inject(at = @At("HEAD"), method = "isDamageable()Z", cancellable = true)
	private void intendedShadowingIsDamageable(CallbackInfoReturnable<Boolean> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			boolean res = ((ItemStackInjectionGen) (Object) shadowStack).isDamageable();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public int getDamage() { return 0; }

	@Inject(at = @At("HEAD"), method = "getDamage()I", cancellable = true)
	private void intendedShadowingGetDamage(CallbackInfoReturnable<Integer> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			int res = ((ItemStackInjectionGen) (Object) shadowStack).getDamage();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public boolean damage(int amount, java.util.Random random, net.minecraft.server.network.ServerPlayerEntity player) { return false; }

	@Inject(at = @At("HEAD"), method = "damage(ILjava/util/Random;Lnet/minecraft/server/network/ServerPlayerEntity;)Z", cancellable = true)
	private void intendedShadowingDamage(int amount, java.util.Random random, net.minecraft.server.network.ServerPlayerEntity player, CallbackInfoReturnable<Boolean> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			boolean res = ((ItemStackInjectionGen) (Object) shadowStack).damage(amount, random, player);
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public void damage(int amount, net.minecraft.entity.LivingEntity entity, java.util.function.Consumer breakCallback) {}

	@Inject(at = @At("HEAD"), method = "damage(ILnet/minecraft/entity/LivingEntity;Ljava/util/function/Consumer;)V", cancellable = true)
	private void intendedShadowingDamage(int amount, net.minecraft.entity.LivingEntity entity, java.util.function.Consumer breakCallback, CallbackInfo info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			((ItemStackInjectionGen) (Object) shadowStack).damage(amount, entity, breakCallback);
			info.cancel();
		}
	}
    
    @Shadow
	public boolean isItemBarVisible() { return false; }

	@Inject(at = @At("HEAD"), method = "isItemBarVisible()Z", cancellable = true)
	private void intendedShadowingIsItemBarVisible(CallbackInfoReturnable<Boolean> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			boolean res = ((ItemStackInjectionGen) (Object) shadowStack).isItemBarVisible();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public int getItemBarStep() { return 0; }

	@Inject(at = @At("HEAD"), method = "getItemBarStep()I", cancellable = true)
	private void intendedShadowingGetItemBarStep(CallbackInfoReturnable<Integer> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			int res = ((ItemStackInjectionGen) (Object) shadowStack).getItemBarStep();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public int getItemBarColor() { return 0; }

	@Inject(at = @At("HEAD"), method = "getItemBarColor()I", cancellable = true)
	private void intendedShadowingGetItemBarColor(CallbackInfoReturnable<Integer> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			int res = ((ItemStackInjectionGen) (Object) shadowStack).getItemBarColor();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public boolean isEqual(net.minecraft.item.ItemStack other) { return false; }

	@Inject(at = @At("HEAD"), method = "isEqual(Lnet/minecraft/item/ItemStack;)Z", cancellable = true)
	private void intendedShadowingIsEqual(net.minecraft.item.ItemStack other, CallbackInfoReturnable<Boolean> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			boolean res = ((ItemStackInjectionGen) (Object) shadowStack).isEqual(other);
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public java.lang.String toString() { return null; }

	@Inject(at = @At("HEAD"), method = "toString()Ljava/lang/String;", cancellable = true)
	private void intendedShadowingToString(CallbackInfoReturnable<java.lang.String> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			java.lang.String res = ((ItemStackInjectionGen) (Object) shadowStack).toString();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public boolean hasNbt() { return false; }

	@Inject(at = @At("HEAD"), method = "hasNbt()Z", cancellable = true)
	private void intendedShadowingHasNbt(CallbackInfoReturnable<Boolean> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			boolean res = ((ItemStackInjectionGen) (Object) shadowStack).hasNbt();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public net.minecraft.nbt.NbtCompound getNbt() { return null; }

	@Inject(at = @At("HEAD"), method = "getNbt()Lnet/minecraft/nbt/NbtCompound;", cancellable = true)
	private void intendedShadowingGetNbt(CallbackInfoReturnable<net.minecraft.nbt.NbtCompound> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			net.minecraft.nbt.NbtCompound res = ((ItemStackInjectionGen) (Object) shadowStack).getNbt();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public net.minecraft.nbt.NbtCompound getOrCreateNbt() { return null; }

	@Inject(at = @At("HEAD"), method = "getOrCreateNbt()Lnet/minecraft/nbt/NbtCompound;", cancellable = true)
	private void intendedShadowingGetOrCreateNbt(CallbackInfoReturnable<net.minecraft.nbt.NbtCompound> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			net.minecraft.nbt.NbtCompound res = ((ItemStackInjectionGen) (Object) shadowStack).getOrCreateNbt();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public net.minecraft.nbt.NbtCompound getSubNbt(java.lang.String key) { return null; }

	@Inject(at = @At("HEAD"), method = "getSubNbt(Ljava/lang/String;)Lnet/minecraft/nbt/NbtCompound;", cancellable = true)
	private void intendedShadowingGetSubNbt(java.lang.String key, CallbackInfoReturnable<net.minecraft.nbt.NbtCompound> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			net.minecraft.nbt.NbtCompound res = ((ItemStackInjectionGen) (Object) shadowStack).getSubNbt(key);
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public net.minecraft.nbt.NbtCompound getOrCreateSubNbt(java.lang.String key) { return null; }

	@Inject(at = @At("HEAD"), method = "getOrCreateSubNbt(Ljava/lang/String;)Lnet/minecraft/nbt/NbtCompound;", cancellable = true)
	private void intendedShadowingGetOrCreateSubNbt(java.lang.String key, CallbackInfoReturnable<net.minecraft.nbt.NbtCompound> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			net.minecraft.nbt.NbtCompound res = ((ItemStackInjectionGen) (Object) shadowStack).getOrCreateSubNbt(key);
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public void removeSubNbt(java.lang.String key) {}

	@Inject(at = @At("HEAD"), method = "removeSubNbt(Ljava/lang/String;)V", cancellable = true)
	private void intendedShadowingRemoveSubNbt(java.lang.String key, CallbackInfo info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			((ItemStackInjectionGen) (Object) shadowStack).removeSubNbt(key);
			info.cancel();
		}
	}
    
    @Shadow
	public net.minecraft.nbt.NbtList getEnchantments() { return null; }

	@Inject(at = @At("HEAD"), method = "getEnchantments()Lnet/minecraft/nbt/NbtList;", cancellable = true)
	private void intendedShadowingGetEnchantments(CallbackInfoReturnable<net.minecraft.nbt.NbtList> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			net.minecraft.nbt.NbtList res = ((ItemStackInjectionGen) (Object) shadowStack).getEnchantments();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public void setNbt(net.minecraft.nbt.NbtCompound newNbt) {}

	@Inject(at = @At("HEAD"), method = "setNbt(Lnet/minecraft/nbt/NbtCompound;)V", cancellable = true)
	private void intendedShadowingSetNbt(net.minecraft.nbt.NbtCompound newNbt, CallbackInfo info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			((ItemStackInjectionGen) (Object) shadowStack).setNbt(newNbt);
			info.cancel();
		}
	}
    
    @Shadow
	public void removeCustomName() {}

	@Inject(at = @At("HEAD"), method = "removeCustomName()V", cancellable = true)
	private void intendedShadowingRemoveCustomName(CallbackInfo info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			((ItemStackInjectionGen) (Object) shadowStack).removeCustomName();
			info.cancel();
		}
	}
    
    @Shadow
	public java.util.List getTooltip(net.minecraft.entity.player.PlayerEntity player, net.minecraft.client.item.TooltipContext context) { return null; }

	@Inject(at = @At("HEAD"), method = "getTooltip(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/client/item/TooltipContext;)Ljava/util/List;", cancellable = true)
	private void intendedShadowingGetTooltip(net.minecraft.entity.player.PlayerEntity player, net.minecraft.client.item.TooltipContext context, CallbackInfoReturnable<java.util.List> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			java.util.List res = ((ItemStackInjectionGen) (Object) shadowStack).getTooltip(player, context);
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	private int getHideFlags() { return 0; }

	@Inject(at = @At("HEAD"), method = "getHideFlags()I", cancellable = true)
	private void intendedShadowingGetHideFlags(CallbackInfoReturnable<Integer> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			int res = ((ItemStackInjectionGen) (Object) shadowStack).getHideFlags();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public void addEnchantment(net.minecraft.enchantment.Enchantment enchantment, int level) {}

	@Inject(at = @At("HEAD"), method = "addEnchantment(Lnet/minecraft/enchantment/Enchantment;I)V", cancellable = true)
	private void intendedShadowingAddEnchantment(net.minecraft.enchantment.Enchantment enchantment, int level, CallbackInfo info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			((ItemStackInjectionGen) (Object) shadowStack).addEnchantment(enchantment, level);
			info.cancel();
		}
	}
    
    @Shadow
	public boolean hasEnchantments() { return false; }

	@Inject(at = @At("HEAD"), method = "hasEnchantments()Z", cancellable = true)
	private void intendedShadowingHasEnchantments(CallbackInfoReturnable<Boolean> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			boolean res = ((ItemStackInjectionGen) (Object) shadowStack).hasEnchantments();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public int getRepairCost() { return 0; }

	@Inject(at = @At("HEAD"), method = "getRepairCost()I", cancellable = true)
	private void intendedShadowingGetRepairCost(CallbackInfoReturnable<Integer> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			int res = ((ItemStackInjectionGen) (Object) shadowStack).getRepairCost();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public com.google.common.collect.Multimap getAttributeModifiers(net.minecraft.entity.EquipmentSlot slot) { return null; }

	@Inject(at = @At("HEAD"), method = "getAttributeModifiers(Lnet/minecraft/entity/EquipmentSlot;)Lcom/google/common/collect/Multimap;", cancellable = true)
	private void intendedShadowingGetAttributeModifiers(net.minecraft.entity.EquipmentSlot slot, CallbackInfoReturnable<com.google.common.collect.Multimap> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			com.google.common.collect.Multimap res = ((ItemStackInjectionGen) (Object) shadowStack).getAttributeModifiers(slot);
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public void addAttributeModifier(net.minecraft.entity.attribute.EntityAttribute attribute, net.minecraft.entity.attribute.EntityAttributeModifier modifier, net.minecraft.entity.EquipmentSlot slot) {}

	@Inject(at = @At("HEAD"), method = "addAttributeModifier(Lnet/minecraft/entity/attribute/EntityAttribute;Lnet/minecraft/entity/attribute/EntityAttributeModifier;Lnet/minecraft/entity/EquipmentSlot;)V", cancellable = true)
	private void intendedShadowingAddAttributeModifier(net.minecraft.entity.attribute.EntityAttribute attribute, net.minecraft.entity.attribute.EntityAttributeModifier modifier, net.minecraft.entity.EquipmentSlot slot, CallbackInfo info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			((ItemStackInjectionGen) (Object) shadowStack).addAttributeModifier(attribute, modifier, slot);
			info.cancel();
		}
	}
    
    @Shadow
	public net.minecraft.text.Text toHoverableText() { return null; }

	@Inject(at = @At("HEAD"), method = "toHoverableText()Lnet/minecraft/text/Text;", cancellable = true)
	private void intendedShadowingToHoverableText(CallbackInfoReturnable<net.minecraft.text.Text> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			net.minecraft.text.Text res = ((ItemStackInjectionGen) (Object) shadowStack).toHoverableText();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public boolean canDestroy(net.minecraft.tag.TagManager tagManager, net.minecraft.block.pattern.CachedBlockPosition pos) { return false; }

	@Inject(at = @At("HEAD"), method = "canDestroy(Lnet/minecraft/tag/TagManager;Lnet/minecraft/block/pattern/CachedBlockPosition;)Z", cancellable = true)
	private void intendedShadowingCanDestroy(net.minecraft.tag.TagManager tagManager, net.minecraft.block.pattern.CachedBlockPosition pos, CallbackInfoReturnable<Boolean> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			boolean res = ((ItemStackInjectionGen) (Object) shadowStack).canDestroy(tagManager, pos);
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public boolean canPlaceOn(net.minecraft.tag.TagManager tagManager, net.minecraft.block.pattern.CachedBlockPosition pos) { return false; }

	@Inject(at = @At("HEAD"), method = "canPlaceOn(Lnet/minecraft/tag/TagManager;Lnet/minecraft/block/pattern/CachedBlockPosition;)Z", cancellable = true)
	private void intendedShadowingCanPlaceOn(net.minecraft.tag.TagManager tagManager, net.minecraft.block.pattern.CachedBlockPosition pos, CallbackInfoReturnable<Boolean> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			boolean res = ((ItemStackInjectionGen) (Object) shadowStack).canPlaceOn(tagManager, pos);
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public int getCooldown() { return 0; }

	@Inject(at = @At("HEAD"), method = "getCooldown()I", cancellable = true)
	private void intendedShadowingGetCooldown(CallbackInfoReturnable<Integer> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			int res = ((ItemStackInjectionGen) (Object) shadowStack).getCooldown();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public void setCooldown(int cooldown) {}

	@Inject(at = @At("HEAD"), method = "setCooldown(I)V", cancellable = true)
	private void intendedShadowingSetCooldown(int cooldown, CallbackInfo info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			((ItemStackInjectionGen) (Object) shadowStack).setCooldown(cooldown);
			info.cancel();
		}
	}
    
    @Shadow
	public int getCount() { return 0; }

	@Inject(at = @At("HEAD"), method = "getCount()I", cancellable = true)
	private void intendedShadowingGetCount(CallbackInfoReturnable<Integer> info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			int res = ((ItemStackInjectionGen) (Object) shadowStack).getCount();
			info.setReturnValue(res);
		}
	}
    
    @Shadow
	public void setCount(int count) {}

	@Inject(at = @At("HEAD"), method = "setCount(I)V", cancellable = true)
	private void intendedShadowingSetCount(int count, CallbackInfo info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			((ItemStackInjectionGen) (Object) shadowStack).setCount(count);
			info.cancel();
		}
	}
    
    @Shadow
	public void increment(int count) {}

	@Inject(at = @At("HEAD"), method = "increment(I)V", cancellable = true)
	private void intendedShadowingIncrement(int count, CallbackInfo info) {
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			((ItemStackInjectionGen) (Object) shadowStack).increment(count);
			info.cancel();
		}
	}
    
}
