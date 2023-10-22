package com.thewawpro.zcontent.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes {

	public static void init() {
		//GameRegistry.addSmelting(ModBlocks.ardite_ore, new ItemStack(ModItems.ardite_ingot, 1), 1.0F);
		//GameRegistry.addSmelting(ModBlocks.cobalt_ore, new ItemStack(ModItems.cobalt_ingot, 1), 1.0F);
		for(ItemStack ore : OreDictionary.getOres("ingotArdite"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.ardite_ore, ore, 1.0F);
		         }
		      }
		}
		for(ItemStack ore : OreDictionary.getOres("ingotCobalt"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.cobalt_ore, ore, 1.0F);
		         }
		      }
		}
		for(ItemStack ore : OreDictionary.getOres("ingotCopper"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.copper_ore, ore, 1.0F);
		         }
		      }
		}
		for(ItemStack ore : OreDictionary.getOres("ingotTin"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.tin_ore, ore, 1.0F);
		         }
		      }
		}
		for(ItemStack ore : OreDictionary.getOres("ingotAluminum"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.aluminum_ore, ore, 1.0F);
		         }
		      }
		}
		for(ItemStack ore : OreDictionary.getOres("ingotLead"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.lead_ore, ore, 1.0F);
		         }
		      }
		}
		for(ItemStack ore : OreDictionary.getOres("ingotSilver"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.silver_ore, ore, 1.0F);
		         }
		      }
		}
		for(ItemStack ore : OreDictionary.getOres("ingotNickel"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.nickel_ore, ore, 1.0F);
		         }
		      }
		}
		for(ItemStack ore : OreDictionary.getOres("ingotTitanium"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.titanium_ore, ore, 1.0F);
		         }
		      }
		}
		for(ItemStack ore : OreDictionary.getOres("ingotUranium"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.uranium_ore, ore, 1.0F);
		         }
		      }
		}
		for(ItemStack ore : OreDictionary.getOres("ingotPlatinum"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.platinum_ore, ore, 1.0F);
		         }
		      }
		}
		for(ItemStack ore : OreDictionary.getOres("ingotIridium"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.iridium_ore, ore, 1.0F);
		         }
		      }
		}
		for(ItemStack ore : OreDictionary.getOres("ingotMithril"))
		{
		      if(ore != null)
		      {
		         if(ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)
		         {
		        	 GameRegistry.addSmelting(ModBlocks.mithril_ore, ore, 1.0F);
		         }
		      }
		}
	}
}