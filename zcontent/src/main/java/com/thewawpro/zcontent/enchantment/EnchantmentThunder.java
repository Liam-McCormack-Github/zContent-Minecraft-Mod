package com.thewawpro.zcontent.enchantment;

import com.thewawpro.zcontent.Main;
import com.thewawpro.zcontent.init.ModEnchantments;
import com.thewawpro.zcontent.items.ItemWand1;
import com.thewawpro.zcontent.items.ItemWand2;
import com.thewawpro.zcontent.items.ItemWand3;
import com.thewawpro.zcontent.items.ItemWand4;
import com.thewawpro.zcontent.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EnchantmentThunder extends Enchantment {

	public EnchantmentThunder() {
		super(Rarity.VERY_RARE, ModEnchantments.WAND, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
		this.setName("Thunder");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":thunder"));
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

	public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
		user.world.addWeatherEffect(new EntityLightningBolt(user.world, target.posX, target.posY, target.posZ, false));
	}	
}
