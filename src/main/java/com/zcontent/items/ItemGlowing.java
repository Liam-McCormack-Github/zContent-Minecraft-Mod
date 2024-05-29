package com.zcontent.items;

import com.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ItemGlowing extends ItemBase implements IHasModel {

    public ItemGlowing(String name, CreativeTabs creativeTab) {
        super(name, creativeTab);
    }


    public boolean hasEffect(ItemStack stack) {
        return true;
    }

}
