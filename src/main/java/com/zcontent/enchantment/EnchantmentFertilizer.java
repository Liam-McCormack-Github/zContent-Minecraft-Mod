package com.zcontent.enchantment;

import com.zcontent.init.ModEnchantments;
import com.zcontent.items.ItemWand1;
import com.zcontent.items.ItemWand2;
import com.zcontent.items.ItemWand3;
import com.zcontent.items.ItemWand4;
import com.zcontent.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EnchantmentFertilizer extends Enchantment {

    public EnchantmentFertilizer() {
        super(Rarity.VERY_RARE, ModEnchantments.WAND, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
        this.setName("Fertilizer");
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":fertilizer"));
        ModEnchantments.ENCHANTMENTS.add(this);
    }

    @SubscribeEvent
    public static void rightClick(PlayerInteractEvent.RightClickBlock e) {
        ItemStack s = e.getItemStack();
        int nbLevel = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.FERTILIZER, s);
        if (!e.getEntityPlayer().isSneaking() && nbLevel > 0 && ItemDye.applyBonemeal(s.copy(), e.getWorld(), e.getPos(), e.getEntityPlayer(), e.getHand())) {
            s.damageItem(6 - nbLevel, e.getEntityPlayer());
            e.setCanceled(true);
            e.setCancellationResult(EnumActionResult.SUCCESS);
        }
    }

    @Override
    public boolean canApply(ItemStack stack) {
        Item item = stack.getItem();
        return (item instanceof ItemWand1 || item instanceof ItemWand2 || item instanceof ItemWand3 || item instanceof ItemWand4);
    }

    @Override
    public boolean isAllowedOnBooks() {

        return true;
    }

    @Override
    public int getMinEnchantability(int level) {
        return 500;
    }

    @Override
    public int getMaxEnchantability(int level) {
        return 1000;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isCurse() {

        return true;
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return this != ench;
    }
}
