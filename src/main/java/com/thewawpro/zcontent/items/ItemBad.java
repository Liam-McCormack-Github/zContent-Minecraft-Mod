package com.thewawpro.zcontent.items;

import com.thewawpro.zcontent.Main;
import com.thewawpro.zcontent.init.ModItems;
import com.thewawpro.zcontent.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemBad extends Item implements IHasModel {

	public ItemBad(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

	
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
		super.onUpdate(stack, world, entity, par4, par5); {
			EntityPlayer player = (EntityPlayer) entity;
			EnumHand hand = player.getHeldItem(EnumHand.OFF_HAND).getItem() == this ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
			ItemStack heldStack = player.getHeldItem(hand);
			if(heldStack == stack) {
				player.addPotionEffect(new PotionEffect(MobEffects.POISON, 180, 4, false, false));
				player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 180, 4, false, false));
				player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 180, 4, false, false));
				player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 180, 4, false, false));
				player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 180, 4, false, false));

			}
		}
	}

}
