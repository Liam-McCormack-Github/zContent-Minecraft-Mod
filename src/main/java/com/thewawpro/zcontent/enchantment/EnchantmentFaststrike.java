package com.thewawpro.zcontent.enchantment;

import com.thewawpro.zcontent.Main;
import com.thewawpro.zcontent.init.ModEnchantments;
import com.thewawpro.zcontent.util.Reference;
import com.thewawpro.zcontent.util.GlobalVars;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static net.minecraft.enchantment.EnchantmentHelper.getMaxEnchantmentLevel;


@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EnchantmentFaststrike extends Enchantment {

	public EnchantmentFaststrike() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
		this.setName("Faststrike");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":faststrike"));
		ModEnchantments.ENCHANTMENTS.add(this);
	}

	@Override
	public boolean canApply(ItemStack stack) {
		Item item = stack.getItem();
		return true && (item instanceof ItemSword);
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

	@SubscribeEvent
	public static void onPlayerUpdate(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;

    if (getMaxEnchantmentLevel(ModEnchantments.FASTSTRIKE, player) <= 0) return;
        int swing = ObfuscationReflectionHelper.getPrivateValue(EntityLivingBase.class,player,"field_184617_aD");
        swing+=getMaxEnchantmentLevel(ModEnchantments.FASTSTRIKE, player);
        ObfuscationReflectionHelper.setPrivateValue(EntityLivingBase.class,player,swing,"field_184617_aD");
    }
}
