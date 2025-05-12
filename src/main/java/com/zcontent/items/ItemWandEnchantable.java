package com.zcontent.items;

import com.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ItemWandEnchantable extends ItemWandBase implements IHasModel {
    public ItemWandEnchantable(String name, CreativeTabs creativeTab, int _rangeMainHand, int _rangeOffHand) {
        super(name, creativeTab, _rangeMainHand, _rangeOffHand);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public int getItemEnchantability() {
        return 0;
    }
}

