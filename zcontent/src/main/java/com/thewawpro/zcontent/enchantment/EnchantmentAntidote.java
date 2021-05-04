package com.thewawpro.zcontent.enchantment;

import com.thewawpro.zcontent.Main;
import com.thewawpro.zcontent.init.ModEnchantments;
import com.thewawpro.zcontent.items.ItemWand1;
import com.thewawpro.zcontent.items.ItemWand2;
import com.thewawpro.zcontent.items.ItemWand3;
import com.thewawpro.zcontent.items.ItemWand4;
import com.thewawpro.zcontent.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EnchantmentAntidote extends Enchantment {

	public EnchantmentAntidote() {
		super(Rarity.VERY_RARE, ModEnchantments.WAND, new EntityEquipmentSlot[] {});
		this.setName("Antidote");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":antidote"));
		ModEnchantments.ENCHANTMENTS.add(this);
	}

	@Override
	public boolean canApply(ItemStack stack) {
		Item item = stack.getItem();
		return true && (item instanceof ItemWand1 || item instanceof ItemWand2 || item instanceof ItemWand3 || item instanceof ItemWand4);
	}

	@Override
	public boolean isCurse() {
		return true;
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
    protected boolean canApplyTogether(Enchantment ench) {
        return this != ench;
    }
}
