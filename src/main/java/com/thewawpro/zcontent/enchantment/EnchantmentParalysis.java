package com.thewawpro.zcontent.enchantment;

import com.thewawpro.zcontent.Main;
import com.thewawpro.zcontent.init.ModEnchantments;
import com.thewawpro.zcontent.items.ItemWand1;
import com.thewawpro.zcontent.items.ItemWand2;
import com.thewawpro.zcontent.items.ItemWand3;
import com.thewawpro.zcontent.items.ItemWand4;
import com.thewawpro.zcontent.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class EnchantmentParalysis extends Enchantment {

	public EnchantmentParalysis() {
		super(Rarity.VERY_RARE, ModEnchantments.WAND, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
		this.setName("Paralysis");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":paralysis"));
		ModEnchantments.ENCHANTMENTS.add(this);
	}

	@Override
	public boolean canApply(ItemStack stack) {
		Item item = stack.getItem();
		return true && (item instanceof ItemWand1 || item instanceof ItemWand2 || item instanceof ItemWand3 || item instanceof ItemWand4);
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
    protected boolean canApplyTogether(Enchantment ench)
    {
        return this != ench;
    }
	
    @Override
    public void onEntityDamaged(EntityLivingBase player, Entity target, int level)  {

        if (EnchantmentHelper.getMaxEnchantmentLevel(ModEnchantments.PARALYSIS, player) > 0 && target instanceof EntityLivingBase && player instanceof EntityPlayer){
            ((EntityLivingBase)target).
                    addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 600, 128));
            ((EntityLivingBase)target).
                    addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 600, 5));

        }
    }	
}
