"""
Generates the repetitive ItemStack proxy Mixin.
"""

import os

methods = [
    ["private", "updateEmptyState", [], "void"],
    ["public", "isEmpty", [], "boolean"],
    ["public", "split", [("int", "amount")], "net.minecraft.item.ItemStack"],
    ["public", "getItem", [], "net.minecraft.item.Item"],
    ["public", "useOnBlock", [("net.minecraft.item.ItemUsageContext", "context")], "net.minecraft.util.ActionResult"],
    ["public", "isDamageable", [], "boolean"],
    ["public", "getDamage", [], "int"],
    ["public", "damage", [
        ("int", "amount"),
        ("java.util.Random", "random"),
        ("net.minecraft.server.network.ServerPlayerEntity", "player"),
    ], "boolean"],
    ["public", "damage", [
        ("int", "amount"),
        ("net.minecraft.entity.LivingEntity", "entity"),
        ("java.util.function.Consumer", "breakCallback"),
    ], "void"],
    ["public", "isItemBarVisible", [], "boolean"],
    ["public", "getItemBarStep", [], "int"],
    ["public", "getItemBarColor", [], "int"],
    ["public", "isEqual", [("net.minecraft.item.ItemStack", "other")], "boolean"],
    ["public", "toString", [], "java.lang.String"],
    ["public", "hasNbt", [], "boolean"],
    ["public", "getNbt", [], "net.minecraft.nbt.NbtCompound"],
    ["public", "getOrCreateNbt", [], "net.minecraft.nbt.NbtCompound"],
    ["public", "getSubNbt", [("java.lang.String", "key")], "net.minecraft.nbt.NbtCompound"],
    ["public", "getOrCreateSubNbt", [("java.lang.String", "key")], "net.minecraft.nbt.NbtCompound"],
    ["public", "removeSubNbt", [("java.lang.String", "key")], "void"],
    ["public", "getEnchantments", [], "net.minecraft.nbt.NbtList"],
    ["public", "setNbt", [("net.minecraft.nbt.NbtCompound", "newNbt")], "void"],
    ["public", "removeCustomName", [], "void"],
    ["public", "getTooltip", [
        ("net.minecraft.entity.player.PlayerEntity", "player"),
        ("net.minecraft.client.item.TooltipContext", "context"),
    ], "java.util.List"],
    ["private", "getHideFlags", [], "int"],
    ["public", "addEnchantment", [
        ("net.minecraft.enchantment.Enchantment", "enchantment"),
        ("int", "level"),
    ], "void"],
    ["public", "hasEnchantments", [], "boolean"],
    ["public", "getRepairCost", [], "int"],
    ["public", "getAttributeModifiers", [
        ("net.minecraft.entity.EquipmentSlot", "slot"),
    ], "com.google.common.collect.Multimap"],
    ["public", "addAttributeModifier", [
        ("net.minecraft.entity.attribute.EntityAttribute", "attribute"),
        ("net.minecraft.entity.attribute.EntityAttributeModifier", "modifier"),
        ("net.minecraft.entity.EquipmentSlot", "slot"),
    ], "void"],
    ["public", "toHoverableText", [], "net.minecraft.text.Text"],
    ["public", "canDestroy", [
        ("net.minecraft.tag.TagManager", "tagManager"),
        ("net.minecraft.block.pattern.CachedBlockPosition", "pos"),
    ], "boolean"],
    ["public", "canPlaceOn", [
        ("net.minecraft.tag.TagManager", "tagManager"),
        ("net.minecraft.block.pattern.CachedBlockPosition", "pos"),
    ], "boolean"],
    ["public", "getCooldown", [], "int"],
    ["public", "setCooldown", [("int", "cooldown")], "void"],
    ["public", "getCount", [], "int"],
    ["public", "setCount", [("int", "count")], "void"],
    ["public", "increment", [("int", "count")], "void"],
]

header = """
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
"""

footer = """
}
"""


def shortcode_of_type(ty):
    arr = ""

    while ty.endswith("[]"):
        ty = ty[:-2]
        arr = arr + "["

    if ty == "void":
        return arr + "V"
    if ty == "boolean":
        return arr + "Z"
    if ty == "byte":
        return arr + "B"
    if ty == "char":
        return arr + "C"
    if ty == "double":
        return arr + "D"
    if ty == "float":
        return arr + "F"
    if ty == "int":
        return arr + "I"
    if ty == "long":
        return arr + "J"
    if ty == "short":
        return arr + "S"

    return arr + "L" + ty.replace(".", "/") + ";"


def object_of_type(ty):
    if ty == "boolean":
        return "Boolean"
    if ty == "byte":
        return "Byte"
    if ty == "char":
        return "Character"
    if ty == "double":
        return "Double"
    if ty == "float":
        return "Float"
    if ty == "int":
        return "Integer"
    if ty == "long":
        return "Long"
    if ty == "short":
        return "Short"
    return ty


def class_of_path(p):
    return p.split(".")[-1]

def default_of_type(ty):
    if ty == "boolean":
        return "false"
    if ty == "byte":
        return "0"
    if ty == "char":
        return "'\\0'"
    if ty == "double":
        return "0.0"
    if ty == "float":
        return "0.0"
    if ty == "int":
        return "0"
    if ty == "long":
        return "0"
    if ty == "short":
        return "0"
    return "null"

def function_proxy(privacy, name, args, ret):
    if ret == "void":
        callback_info = "CallbackInfo"
        store = ""
        end = "cancel()"
        return_val = ""
    else:
        callback_info = f"CallbackInfoReturnable<{object_of_type(ret)}>"
        store = ret + " res = "
        end = "setReturnValue(res)"
        return_val = f" return {default_of_type(ret)}; "

    args_strs = [x[0] + " " + x[1] for x in args]
    args_list = ", ".join(args_strs)
    args_list_callback = ", ".join(args_strs + [callback_info + " info"])
    args_list_names = ", ".join([x[1] for x in args])

    short_args = "".join([shortcode_of_type(x[0]) for x in args])

    fun = f"""
    @Shadow
	{privacy} {ret} {name}({args_list}) {{{return_val}}}

	@Inject(at = @At("HEAD"), method = "{name}({short_args}){shortcode_of_type(ret)}", cancellable = true)
	private void intendedShadowing{name[0].upper() + name[1:]}({args_list_callback}) {{
		if (this.nbt != null && this.nbt.contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {{
			int shadow = this.nbt.getInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG);
			ItemStack shadowStack = IntendedShadowing.shadowItems.accessShadow(shadow);
			{store}((ItemStackInjectionGen) (Object) shadowStack).{name}({args_list_names});
			info.{end};
		}}
	}}
    """

    return fun


decls = [function_proxy(privacy, name, args, ret)
         for [privacy, name, args, ret] in methods]

res = header + "".join(decls) + footer

output_path = os.path.join(os.path.dirname(os.path.abspath(__file__)), "ItemStackInjectionGen.java")
file = open(output_path, "w")
file.write(res)
file.close()