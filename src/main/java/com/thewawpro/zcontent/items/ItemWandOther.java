package com.thewawpro.zcontent.items;

import com.google.common.collect.Multimap;
import com.thewawpro.zcontent.Main;
import com.thewawpro.zcontent.init.ModItems;
import com.thewawpro.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

import java.util.UUID;

public class ItemWandOther extends Item implements IHasModel {

	public ItemWandOther(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		setMaxStackSize(1);
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	public static UUID MOD_UUID = UUID.nameUUIDFromBytes("RangeModifier".getBytes());

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
	{
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

		if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
		{
			multimap.put(EntityPlayer.REACH_DISTANCE.getName(), new AttributeModifier(MOD_UUID, "Range Modifier", 5, 0));
		}

		if (equipmentSlot == EntityEquipmentSlot.OFFHAND)
		{
			multimap.put(EntityPlayer.REACH_DISTANCE.getName(), new AttributeModifier(MOD_UUID, "Range Modifier", 5, 0));
		}
		
		return multimap;
	}

}
