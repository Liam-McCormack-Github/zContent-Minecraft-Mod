package com.thewawpro.zcontent.enchantment;

import java.lang.reflect.Method;

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
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class EnchantmentLuck extends Enchantment {

	public EnchantmentLuck() {
		super(Rarity.VERY_RARE, ModEnchantments.WAND, new EntityEquipmentSlot[] {});
		this.setName("Luck");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":luck"));
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
    protected boolean canApplyTogether(Enchantment ench) {
        return this != ench;
    }
	
	  public static void callPrivateMethod(Class theClass, Object obj, String name, String obsName) {
		    try {
		      Method m = ReflectionHelper.findMethod(theClass, name, obsName);
		      if (m != null) {
		        m.invoke(obj);
		      }
		      else {
		        ;
		      }
		    }
		    catch (Exception e) {
		      ;
		    }
		  }

}
