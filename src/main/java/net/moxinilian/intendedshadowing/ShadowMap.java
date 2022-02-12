package net.moxinilian.intendedshadowing;

import java.io.File;
import java.io.IOException;
import java.lang.ref.Cleaner;
import java.util.HashMap;
import java.util.Map.Entry;

import org.jetbrains.annotations.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Pair;

public class ShadowMap {
    public static class InvalidShadowMapVersion extends Exception {
    }

    private static class ShadowStack {
        public int references;
        public ItemStack stack;

        ShadowStack(int references, ItemStack stack) {
            this.references = references;
            this.stack = stack;
        }
    }

    public static final int VERSION = 0;

    private static final byte NBT_COMPOUND_TYPE = 10;

    HashMap<Integer, ShadowStack> shadowItems;
    int nextSlot;
    Cleaner referenceCleaner;

    private ShadowMap(int nextSlot, HashMap<Integer, ShadowStack> shadowItems) {
        this.nextSlot = nextSlot;
        this.shadowItems = shadowItems;
        this.referenceCleaner = Cleaner.create();
    }

    public static ShadowMap empty() {
        return new ShadowMap(0, new HashMap<>());
    }

    public static ShadowMap loadFrom(File inpFile) throws InvalidShadowMapVersion, IOException {
        NbtCompound data = NbtIo.read(inpFile);

        int version = data.getInt("version");

        if (version != VERSION) {
            throw new InvalidShadowMapVersion();
        }

        int nextSlot = data.getInt("nextSlot");
        HashMap<Integer, ShadowStack> shadowItems = new HashMap<>();

        for (NbtElement item : data.getList("shadowItems", NBT_COMPOUND_TYPE)) {
            NbtCompound itemCompound = (NbtCompound) item;
            int id = itemCompound.getInt("id");
            int references = itemCompound.getInt("refs");
            ItemStack stack = ItemStack.fromNbt(itemCompound.getCompound("stack"));
            shadowItems.put(id, new ShadowStack(references, stack));
        }

        return new ShadowMap(nextSlot, shadowItems);
    }

    public void writeTo(File outFile) throws IOException {
        NbtCompound data = new NbtCompound();

        data.putInt("version", VERSION);
        data.putInt("nextSlot", this.nextSlot);
        NbtList shadowItems = new NbtList();

        for (Entry<Integer, ShadowStack> item : this.shadowItems.entrySet()) {
            NbtCompound itemCompound = new NbtCompound();
            itemCompound.putInt("id", item.getKey());
            itemCompound.putInt("refs", item.getValue().references);
            NbtCompound stackCompound = new NbtCompound();
            item.getValue().stack.writeNbt(stackCompound);
            itemCompound.put("stack", stackCompound);
            shadowItems.add(itemCompound);
        }

        data.put("shadowItems", shadowItems);
        NbtIo.write(data, outFile);
    }

    @Nullable
    public Pair<ItemStack, ItemStack> shadowify(ItemStack stack) {
        if (stack.getNbt() != null && stack.getNbt().contains(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG)) {
            return null;
        }

        while (this.shadowItems.containsKey(this.nextSlot)) {
            this.nextSlot += 1;
        }

        this.shadowItems.put(this.nextSlot, new ShadowStack(0, stack));

        ItemStack newStack = stack.copy();

        newStack.getOrCreateNbt().putInt(IntendedShadowing.INTENDED_SHADOWING_NBT_TAG, this.nextSlot);
        this.nextSlot += 1;

        this.registerNewReference(newStack);
        return new Pair<>(newStack, newStack.copy());
    }

    @Nullable
    public ItemStack accessShadow(int id) {
        ShadowStack stack = this.shadowItems.get(id);
        return (stack == null ? null : stack.stack);
    }

    public void dropReference(int id) {
        ShadowStack stack = this.shadowItems.get(id);
        if (stack != null) {
            stack.references -= 1;

            if (stack.references <= 0) {
                this.shadowItems.remove(id);
            }
        }
    }

    public void registerNewReference(ItemStack stack) {
        Integer stackId = ((ItemStackExt) (Object) stack).getShadowId();
        if (stackId != null) {
            this.shadowItems.get(stackId).references += 1;
            this.referenceCleaner.register(stack, new ReferenceDropper(stackId));
        }
    }

    public void registerCleaning(ItemStack stack) {
        Integer stackId = ((ItemStackExt) (Object) stack).getShadowId();
        if (stackId != null) {
            this.referenceCleaner.register(stack, new ReferenceDropper(stackId));
        }
    }

    private class ReferenceDropper implements Runnable {
        int toDrop;

        public ReferenceDropper(int toDrop) {
            this.toDrop = toDrop;
        }

        @Override
        public void run() {
            dropReference(toDrop);
        }
    }
}
