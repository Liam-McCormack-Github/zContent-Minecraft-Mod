package com.zcontent.enchantment;

import com.zcontent.init.ModEnchantments;
import com.zcontent.items.ItemWand1;
import com.zcontent.items.ItemWand2;
import com.zcontent.items.ItemWand3;
import com.zcontent.items.ItemWand4;
import com.zcontent.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class EnchantmentInstantKill extends Enchantment {

    public EnchantmentInstantKill() {
        super(Rarity.VERY_RARE, ModEnchantments.WAND, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
        this.setName("InstantKill");
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":instantkill"));
        ModEnchantments.ENCHANTMENTS.add(this);
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

    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
        if (EnchantmentHelper.getMaxEnchantmentLevel(ModEnchantments.INSTANTKILL, user) > 0 && target instanceof EntityLivingBase) {

            EntityLivingBase victim = (EntityLivingBase) target;
            victim.setHealth(0);
        }
    }

    public void drops(LivingDropsEvent entity) throws Exception {
        Entity attacker = entity.getSource().getTrueSource();
        if (attacker instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) attacker;
            if (player.world.isRemote) return;
            int instaKill = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.INSTANTKILL, player.getHeldItemMainhand());
            if (instaKill > 0 && !(entity.getEntityLiving() instanceof EntityPlayer)) {
                int items = 0;
                for (EntityItem i : entity.getDrops())
                    items += i.getItem().getCount();
                if (items > 0) entity.getDrops().clear();
            }
        }
    }
}
