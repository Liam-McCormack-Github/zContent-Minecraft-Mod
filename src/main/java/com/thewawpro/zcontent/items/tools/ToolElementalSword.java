package com.thewawpro.zcontent.items.tools;

import com.google.common.collect.Multimap;
import com.thewawpro.zcontent.Main;
import com.thewawpro.zcontent.init.ModItems;
import com.thewawpro.zcontent.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSword;

public class ToolElementalSword extends ItemSword implements IHasModel {

	public ToolElementalSword(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
