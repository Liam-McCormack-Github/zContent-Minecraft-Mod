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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnchantmentDisarm extends Enchantment {

    public EnchantmentDisarm() {
        super(Rarity.VERY_RARE, ModEnchantments.WAND, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
        this.setName("Disarm");
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":disarm"));
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
        if ((EnchantmentHelper.getMaxEnchantmentLevel(ModEnchantments.DISARM, user) > 0 && target instanceof EntityLivingBase)) {
            World world = user.world;
            BlockPos pos = user.getPosition();
            EntityLivingBase victim = (EntityLivingBase) target;
            ItemStack stack = victim.getHeldItemMainhand();
            victim.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);
            EntityItem itemStack = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(itemStack);
        }
        if ((EnchantmentHelper.getMaxEnchantmentLevel(ModEnchantments.DISARM, user) > 0 && target instanceof EntityLivingBase)) {
            World world = user.world;
            BlockPos pos = user.getPosition();
            EntityLivingBase victim = (EntityLivingBase) target;
            ItemStack stack = victim.getHeldItemOffhand();
            victim.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, ItemStack.EMPTY);
            EntityItem itemStack = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(itemStack);
        }
    }
}
