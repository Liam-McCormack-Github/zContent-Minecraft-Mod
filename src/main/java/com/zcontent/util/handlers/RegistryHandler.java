package com.zcontent.util.handlers;

import com.zcontent.config.ConfigUtils;
import com.zcontent.helpers.NBTHelper;
import com.zcontent.init.ModBlocks;
import com.zcontent.init.ModEnchantments;
import com.zcontent.init.ModItems;
import com.zcontent.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@EventBusSubscriber

public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onEnchantmentRegister(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().registerAll(ModEnchantments.ENCHANTMENTS.toArray(new Enchantment[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ModItems.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }

        for (Block block : ModBlocks.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        // Check if the player has an item in their offhand
        if (!event.getPlayer().getHeldItemOffhand().isEmpty()) {

            ItemStack offhandItem = event.getPlayer().getHeldItemOffhand();

            if (offhandItem.getItem() == ModItems.excavation_wand) {

                ConfigUtils.Mode currentMode = ConfigUtils.getMode(NBTHelper.getInt(offhandItem, "mode"));

                if (currentMode != null) {

                    IBlockState state = event.getState();
                    Block block = state.getBlock();

                    if (currentMode.isBlacklist && currentMode.blockList.contains(block)) {
                        event.setCanceled(true);
                        event.getPlayer().sendMessage(new TextComponentString("Cannot mine this block, due to current wand mode!"));
                    } else if (!currentMode.isBlacklist && !currentMode.blockList.contains(block)) {
                        event.setCanceled(true);
                        event.getPlayer().sendMessage(new TextComponentString("Cannot mine this block, due to current wand mode!"));
                    }
                }
            }
        }
    }

}
