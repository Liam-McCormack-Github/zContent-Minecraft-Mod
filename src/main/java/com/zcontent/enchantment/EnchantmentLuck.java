package com.zcontent.enchantment;

import com.zcontent.init.ModEnchantments;
import com.zcontent.items.ItemWandEnchantable;
import com.zcontent.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.Method;

public class EnchantmentLuck extends Enchantment {

    public EnchantmentLuck() {
        super(Rarity.VERY_RARE, ModEnchantments.WAND, new EntityEquipmentSlot[]{});
        this.setName("Luck");
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":luck"));
        ModEnchantments.ENCHANTMENTS.add(this);

    }

    public static void callPrivateMethod(Class theClass, Object obj, String name, String obsName) {
        try {
            Method m = ReflectionHelper.findMethod(theClass, name, obsName);
            if (m != null) {
                m.invoke(obj);
            } else {
            }
        } catch (Exception e) {
        }
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

}
