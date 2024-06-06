package com.zcontent.enchantment;

import com.zcontent.init.ModEnchantments;
import com.zcontent.items.ItemWandEnchantable;
import com.zcontent.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnchantmentDisarm extends Enchantment {

    public EnchantmentDisarm(String name) {
        super(Rarity.VERY_RARE, ModEnchantments.WAND, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
        this.setName(name);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":" + name.toLowerCase()));
        ModEnchantments.ENCHANTMENTS.add(this);
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return stack.getItem() instanceof ItemWandEnchantable;
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
