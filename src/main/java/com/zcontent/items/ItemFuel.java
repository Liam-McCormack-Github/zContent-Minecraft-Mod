package com.zcontent.items;

import com.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ItemFuel extends ItemBase implements IHasModel {

    private final int burnTime;

    public ItemFuel(String name, CreativeTabs creativeTab, int _burnTime) {
        super(name, creativeTab);

        this.burnTime = _burnTime;
    }

    public int getItemBurnTime(ItemStack itemStack) {
        return this.burnTime;
    }

}
