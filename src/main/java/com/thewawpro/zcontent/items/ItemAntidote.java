package com.thewawpro.zcontent.items;

import java.util.List;

import com.thewawpro.zcontent.Main;
import com.thewawpro.zcontent.init.ModItems;
import com.thewawpro.zcontent.util.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAntidote extends ItemFood implements IHasModel {
	
	public ItemAntidote(String name, int amount, float saturation, boolean isAnimalFood) 
	{
		super(amount, saturation, isAnimalFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.FOOD);
	    setAlwaysEdible();
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	  
	@Override
	protected void onFoodEaten(ItemStack Stack, World World, EntityPlayer Player)
	{
	  if (!World.isRemote)
	  {
		Player.removePotionEffect(MobEffects.POISON);
		Player.removePotionEffect(MobEffects.WEAKNESS);
		Player.removePotionEffect(MobEffects.WITHER);
		Player.removePotionEffect(MobEffects.SLOWNESS);
		Player.removePotionEffect(MobEffects.UNLUCK);
		Player.removePotionEffect(MobEffects.NAUSEA);
		Player.removePotionEffect(MobEffects.BLINDNESS);
		Player.removePotionEffect(MobEffects.HUNGER);
		Player.removePotionEffect(MobEffects.MINING_FATIGUE);
	  }
	}
}