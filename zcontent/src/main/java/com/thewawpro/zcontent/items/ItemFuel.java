package com.thewawpro.zcontent.items;

import com.thewawpro.zcontent.Main;
import com.thewawpro.zcontent.init.ModItems;
import com.thewawpro.zcontent.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFuel extends Item implements IHasModel {

	public ItemFuel(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
	}
	
	public int getItemBurnTime(ItemStack itemStack)
	{
		return 200;
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
