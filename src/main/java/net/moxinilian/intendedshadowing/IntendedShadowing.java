package net.moxinilian.intendedshadowing;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Pair;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntendedShadowing implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("intended_shadowing");

	public static final String INTENDED_SHADOWING_NBT_TAG = "intended_shadowing_shadow_id";

	public static ShadowMap shadowItems = ShadowMap.empty();

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(CommandManager.literal("shadowify").executes(context -> {
                ServerPlayerEntity player = context.getSource().getPlayer();

				PlayerInventory inventory = player.getInventory();
				int slot = inventory.selectedSlot;
				ItemStack stack = inventory.getStack(slot);
				Pair<ItemStack, ItemStack> stacks = IntendedShadowing.shadowItems.shadowify(stack);

				if (stacks != null) {
					inventory.removeStack(slot);
					inventory.setStack(slot, stacks.getLeft());
					inventory.setStack(inventory.getEmptySlot(), stacks.getRight());

					inventory.markDirty();

					LOGGER.info("inserted stacks");
					LOGGER.info("left: " + ((ItemStackExt) (Object) stacks.getLeft()).getShadowId());
					LOGGER.info("right: " + ((ItemStackExt) (Object) stacks.getRight()).getShadowId());
				} else {
					LOGGER.info("failed to generate stacks");
				}

                return 1;
            }));
        });

		LOGGER.info("Successful load");
	}
}
