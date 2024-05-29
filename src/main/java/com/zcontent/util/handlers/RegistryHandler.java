package com.zcontent.util.handlers;

import com.zcontent.Main;
import com.zcontent.config.ConfigUtils;
import com.zcontent.init.*;
import com.zcontent.util.IHasModel;
import com.zcontent.util.NbtHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Map;


@EventBusSubscriber

public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
        Main.LOGGER.info("Registered items: " + ModItems.ITEMS);

    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
        Main.LOGGER.info("Registered blocks: " + ModBlocks.BLOCKS);

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
        // TODO: this forces compat with JAOPCA, It creates some error logs but I cannot be bothered to fork JAOPCA for this ATM
        // ModOreDictItems.init();

        for (Block block : ModBlocks.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }
        ModOreDictBlocks.init();
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        // Check if the player has an item in their offhand
        if (!event.getPlayer().getHeldItemOffhand().isEmpty()) {

            ItemStack offhandItem = event.getPlayer().getHeldItemOffhand();

            if (offhandItem.getItem() == ModItems.excavation_wand || offhandItem.getItem() == ModItems.wand_1 || offhandItem.getItem() == ModItems.wand_2 || offhandItem.getItem() == ModItems.wand_3 || offhandItem.getItem() == ModItems.wand_4) {

                ConfigUtils.Mode currentMode = ConfigUtils.getMode(NbtHelper.getInt(offhandItem, "mode"));

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

    @SubscribeEvent
    public static void effectFunction(TickEvent.PlayerTickEvent event) {
        applyEffects(event.player, EntityEquipmentSlot.MAINHAND);
        applyEffects(event.player, EntityEquipmentSlot.OFFHAND);
        applyEffects(event.player, EntityEquipmentSlot.HEAD);
        applyEffects(event.player, EntityEquipmentSlot.CHEST);
        applyEffects(event.player, EntityEquipmentSlot.LEGS);
        applyEffects(event.player, EntityEquipmentSlot.FEET);
    }

    private static void applyEffects(EntityPlayer player, EntityEquipmentSlot slot) {
        if (player.hasItemInSlot(slot)) {
            ItemStack item = player.getItemStackFromSlot(slot);
            if (item.isItemEnchanted()) {
                Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(item);
                for (Map.Entry<Enchantment, Integer> entry : enchants.entrySet()) {
                    applyEffect(player, entry.getKey().getName());
                }
            }
        }
    }

    private static void applyEffect(EntityPlayer player, String enchantmentName) {
        switch (enchantmentName) {
            case "enchantment.Levitation":
                player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 2, 9, false, false));
                break;
            case "enchantment.Speed":
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 180, 9, false, false));
                break;
            case "enchantment.JumpBoost":
                player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 180, 2, false, false));
                break;
            case "enchantment.Invisibility":
                player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 180, 0, false, false));
                break;
            case "enchantment.InstantHealth":
                player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 180, 0, false, false));
                break;
            case "enchantment.Haste":
                player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 180, 9, false, false));
                break;
            case "enchantment.Glowing":
                player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 180, 0, false, false));
                break;
            case "enchantment.Absorption":
                player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 180, 9, false, false));
                break;
            case "enchantment.Strength":
                player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 180, 9, false, false));
                break;
            case "enchantment.Saturation":
                player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 180, 0, false, false));
                break;
            case "enchantment.Luck":
                player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 180, 0, false, false));
                break;
            case "enchantment.FireResistance":
                player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 180, 0, false, false));
                break;
            case "enchantment.WaterBreathing":
                player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 180, 0, false, false));
                break;
            case "enchantment.NightVision":
                player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 600, 0, false, false));
                break;
            case "enchantment.Regeneration":
                player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 180, 0, false, false));
                break;
            case "enchantment.Resistance":
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 180, 9, false, false));
                break;
            case "enchantment.Antidote":
                player.removeActivePotionEffect(MobEffects.POISON);
                player.removeActivePotionEffect(MobEffects.WEAKNESS);
                player.removeActivePotionEffect(MobEffects.WITHER);
                player.removeActivePotionEffect(MobEffects.SLOWNESS);
                player.removeActivePotionEffect(MobEffects.UNLUCK);
                player.removeActivePotionEffect(MobEffects.NAUSEA);
                player.removeActivePotionEffect(MobEffects.BLINDNESS);
                player.removeActivePotionEffect(MobEffects.HUNGER);
                player.removeActivePotionEffect(MobEffects.MINING_FATIGUE);
                break;
            default:
                break;
        }
    }

}
