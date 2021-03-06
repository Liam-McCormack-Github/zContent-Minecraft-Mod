package com.thewawpro.zcontent.enchantment;


import com.thewawpro.zcontent.Main;
import com.thewawpro.zcontent.init.ModEnchantments;
import com.thewawpro.zcontent.items.ItemWand1;
import com.thewawpro.zcontent.items.ItemWand2;
import com.thewawpro.zcontent.items.ItemWand3;
import com.thewawpro.zcontent.items.ItemWand4;
import com.thewawpro.zcontent.util.Reference;
import com.thewawpro.zcontent.util.GlobalVars;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Method;

import static com.thewawpro.zcontent.init.ModEnchantments.*;
import static net.minecraft.enchantment.EnchantmentHelper.*;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)

public class EnchantmentFastdraw extends Enchantment {

	public EnchantmentFastdraw() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.BOW, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
		this.setName("Fastdraw");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":fastdraw"));
		ModEnchantments.ENCHANTMENTS.add(this);
	}

	@Override
	public boolean canApply(ItemStack stack) {
		Item item = stack.getItem();
		return true && (item instanceof ItemBow);
	}
	
	@Override
	public boolean isAllowedOnBooks() {

		return true;
	}

	@Override
	public int getMinEnchantability(int level) {

		return 5 + (level - 1) * 10;
	}

	@Override
	public int getMaxEnchantability(int level) {

		return getMinEnchantability(level) + 50;
	}

    @Override
    public int getMaxLevel() {
        return 5;
    }
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return canApply(stack);
	}

	@Override
    protected boolean canApplyTogether(Enchantment ench) {
        return this != ench;
    }

	private static Method m = ObfuscationReflectionHelper.findMethod(EntityLivingBase.class,"func_184608_ct",Void.TYPE);

	@SubscribeEvent
	public static void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
	if (event.getEntity() instanceof EntityPlayer) {
	  EntityPlayer player = (EntityPlayer) event.getEntity();
	  ItemStack heldItem = player.getHeldItem(EnumHand.MAIN_HAND);
	  if (!(heldItem.getItem() instanceof ItemBow)) heldItem = player.getHeldItem(EnumHand.OFF_HAND);
	  if (!(heldItem.getItem() instanceof ItemBow) || getMaxEnchantmentLevel(ModEnchantments.FASTDRAW, player) <= 0)
		return;
	  if (player.isHandActive()) {
		for (int i = 0; i < getMaxEnchantmentLevel(ModEnchantments.FASTDRAW, player); i++) {
		  tickHeldBow(player);
		}
	  }
	}
  }
  //borrowed from cyclic
  //player.updateActiveHand();//BUT its protected bahhhh
  private static void tickHeldBow(EntityPlayer player) {
	try {
	  m.invoke(player);
	}
	catch (Exception e) {
	  assert true;
	}
  }
	
	
}
