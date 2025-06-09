package com.zcontent.enchantment;

import com.zcontent.config.Config;
import com.zcontent.init.ModEnchantments;
import com.zcontent.items.ItemWandEnchantable;
import com.zcontent.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;

public class EnchantmentInstantKill extends Enchantment {

    public EnchantmentInstantKill(String name) {
        super(Rarity.VERY_RARE, ModEnchantments.WAND, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
        this.setName(name);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":" + name.toLowerCase()));
        ModEnchantments.ENCHANTMENTS.add(this);
        ModEnchantments.enchantmentMap.put(name, this);
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
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return false;
    }

    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
        if (EnchantmentHelper.getMaxEnchantmentLevel(ModEnchantments.INSTANTKILL, user) > 0 && target instanceof EntityLivingBase) {
            EntityLivingBase victim = (EntityLivingBase) target;
            if (Config.EnchInstantKillNoDrops) {
                victim.setHealth(0);
            } else {
                DamageSource source = DamageSource.causePlayerDamage((EntityPlayer) user);
                victim.attackEntityFrom(source, Float.MAX_VALUE);
            }
        }
    }
}
