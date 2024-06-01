package com.zcontent.enchantment;

import com.zcontent.init.ModEnchantments;
import com.zcontent.items.ItemWandEnchantable;
import com.zcontent.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EnchantmentThunder extends Enchantment {

    public EnchantmentThunder(String name) {
        super(Rarity.VERY_RARE, ModEnchantments.WAND, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
        this.setName(name);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":" + name.toLowerCase()));
        ModEnchantments.ENCHANTMENTS.add(this);
    }

    @Override
    public boolean canApply(ItemStack stack) {
        Item item = stack.getItem();
        return item instanceof ItemWandEnchantable;
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

    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
        user.world.addWeatherEffect(new EntityLightningBolt(user.world, target.posX, target.posY, target.posZ, false));
    }
}
