package com.thewawpro.zcontent.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.thewawpro.zcontent.enchantment.EnchantmentAbsorption;
import com.thewawpro.zcontent.enchantment.EnchantmentAntidote;
import com.thewawpro.zcontent.enchantment.EnchantmentDisarm;
import com.thewawpro.zcontent.enchantment.EnchantmentFireResistance;
import com.thewawpro.zcontent.enchantment.EnchantmentGlowing;
import com.thewawpro.zcontent.enchantment.EnchantmentHaste;
import com.thewawpro.zcontent.enchantment.EnchantmentInstantHealth;
import com.thewawpro.zcontent.enchantment.EnchantmentInstantKill;
import com.thewawpro.zcontent.enchantment.EnchantmentInvisibility;
import com.thewawpro.zcontent.enchantment.EnchantmentJumpBoost;
import com.thewawpro.zcontent.enchantment.EnchantmentLevitation;
import com.thewawpro.zcontent.enchantment.EnchantmentLuck;
import com.thewawpro.zcontent.enchantment.EnchantmentNightVision;
import com.thewawpro.zcontent.enchantment.EnchantmentParalysis;
import com.thewawpro.zcontent.enchantment.EnchantmentRegeneration;
import com.thewawpro.zcontent.enchantment.EnchantmentResistance;
import com.thewawpro.zcontent.enchantment.EnchantmentSaturation;
import com.thewawpro.zcontent.enchantment.EnchantmentSpeed;
import com.thewawpro.zcontent.enchantment.EnchantmentStrength;
import com.thewawpro.zcontent.enchantment.EnchantmentThunder;
import com.thewawpro.zcontent.enchantment.EnchantmentWaterBreathing;
import com.thewawpro.zcontent.enchantment.EnchantmentWeaken;
import com.thewawpro.zcontent.enchantment.EnchantmentFastdraw;
import com.thewawpro.zcontent.enchantment.EnchantmentFaststrike;
import com.thewawpro.zcontent.enchantment.EnchantmentFertilizer;
import com.thewawpro.zcontent.items.ItemWand1;
import com.thewawpro.zcontent.items.ItemWand2;
import com.thewawpro.zcontent.items.ItemWand3;
import com.thewawpro.zcontent.items.ItemWand4;
import com.thewawpro.zcontent.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;


@Mod.EventBusSubscriber(modid=Reference.MOD_ID)
public class ModEnchantments {

	public static final EnumEnchantmentType WAND = EnumHelper.addEnchantmentType("wand", (item)->(item instanceof ItemWand1 || item instanceof ItemWand2 || item instanceof ItemWand3 || item instanceof ItemWand4));
	
	
	public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();

	public static final Enchantment LUCK = new EnchantmentLuck();
	public static final Enchantment NIGHTVISION = new EnchantmentNightVision();
	public static final Enchantment REGENERATION = new EnchantmentRegeneration();
	public static final Enchantment RESISTANCE = new EnchantmentResistance();
	public static final Enchantment SATURATION = new EnchantmentSaturation();
	public static final Enchantment STRENGTH = new EnchantmentStrength();
	public static final Enchantment WATERBREATHING = new EnchantmentWaterBreathing();
	public static final Enchantment ABSORPTION = new EnchantmentAbsorption();
	public static final Enchantment ANTIDOTE = new EnchantmentAntidote();
	public static final Enchantment FIRERESISTANCE = new EnchantmentFireResistance();
	public static final Enchantment GLOWING = new EnchantmentGlowing();
	public static final Enchantment HASTE = new EnchantmentHaste();
	public static final Enchantment INSTANTHEALTH = new EnchantmentInstantHealth();
	public static final Enchantment INVISIBILITY = new EnchantmentInvisibility();
	public static final Enchantment JUMPBOOST = new EnchantmentJumpBoost();
	public static final Enchantment LEVITATION = new EnchantmentLevitation();
	public static final Enchantment SPEED = new EnchantmentSpeed();
	public static final Enchantment THUNDER = new EnchantmentThunder();
	public static final Enchantment PARALYSIS = new EnchantmentParalysis();
	public static final Enchantment INSTANTKILL = new EnchantmentInstantKill();
	public static final Enchantment DISARM = new EnchantmentDisarm();
	public static final Enchantment WEAKEN = new EnchantmentWeaken();
	public static final Enchantment FASTDRAW = new EnchantmentFastdraw();
	public static final Enchantment FASTSTRIKE = new EnchantmentFaststrike();
	public static final Enchantment FERTILIZER = new EnchantmentFertilizer();
	
	@SubscribeEvent
	public static void effectFunction(PlayerTickEvent event) {
		if(event.player.hasItemInSlot(EntityEquipmentSlot.MAINHAND)) {
			ItemStack item = event.player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
			if(item.isItemEnchanted()) {
				Map<Enchantment, Integer> enchs = EnchantmentHelper.getEnchantments(item);
				for (Entry<Enchantment, Integer> entry : enchs.entrySet()) {
		            if(entry.getKey().getName().contentEquals("enchantment.Levitation")) {event.player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 2, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Speed")) {event.player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.JumpBoost")) {event.player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 180, 2, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Invisibility")) {event.player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.InstantHealth")) {event.player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Haste")) {event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Glowing")) {event.player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Absorption")) {event.player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Strength")) {event.player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Saturation")) {event.player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Luck")) {event.player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.FireResistance")) {event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.WaterBreathing")) {event.player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.NightVision")) {event.player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 600, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Regeneration")) {event.player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Resistance")) {event.player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Antidote")) {
		            	event.player.removeActivePotionEffect(MobEffects.POISON);
						event.player.removeActivePotionEffect(MobEffects.WEAKNESS);
						event.player.removeActivePotionEffect(MobEffects.WITHER);
						event.player.removeActivePotionEffect(MobEffects.SLOWNESS);
						event.player.removeActivePotionEffect(MobEffects.UNLUCK);
						event.player.removeActivePotionEffect(MobEffects.NAUSEA);
						event.player.removeActivePotionEffect(MobEffects.BLINDNESS);
						event.player.removeActivePotionEffect(MobEffects.HUNGER);
						event.player.removeActivePotionEffect(MobEffects.MINING_FATIGUE);}
		    	}
			}
		}
		
		if(event.player.hasItemInSlot(EntityEquipmentSlot.OFFHAND)) {
			ItemStack item = event.player.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);
			if(item.isItemEnchanted()) {
				Map<Enchantment, Integer> enchs = EnchantmentHelper.getEnchantments(item);
				for (Entry<Enchantment, Integer> entry : enchs.entrySet()) {
		            if(entry.getKey().getName().contentEquals("enchantment.Speed")) {event.player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.JumpBoost")) {event.player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 180, 2, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Invisibility")) {event.player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.InstantHealth")) {event.player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Haste")) {event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Glowing")) {event.player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Absorption")) {event.player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Strength")) {event.player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Saturation")) {event.player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Luck")) {event.player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.FireResistance")) {event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.WaterBreathing")) {event.player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.NightVision")) {event.player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 600, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Regeneration")) {event.player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Resistance")) {event.player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Antidote")) {
		            	event.player.removeActivePotionEffect(MobEffects.POISON);
						event.player.removeActivePotionEffect(MobEffects.WEAKNESS);
						event.player.removeActivePotionEffect(MobEffects.WITHER);
						event.player.removeActivePotionEffect(MobEffects.SLOWNESS);
						event.player.removeActivePotionEffect(MobEffects.UNLUCK);
						event.player.removeActivePotionEffect(MobEffects.NAUSEA);
						event.player.removeActivePotionEffect(MobEffects.BLINDNESS);
						event.player.removeActivePotionEffect(MobEffects.HUNGER);
						event.player.removeActivePotionEffect(MobEffects.MINING_FATIGUE);}
		    	}
			}
		}
		
		if(event.player.hasItemInSlot(EntityEquipmentSlot.HEAD)) {
			ItemStack item = event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
			if(item.isItemEnchanted()) {
				Map<Enchantment, Integer> enchs = EnchantmentHelper.getEnchantments(item);
				for (Entry<Enchantment, Integer> entry : enchs.entrySet()) {
		            if(entry.getKey().getName().contentEquals("enchantment.Speed")) {event.player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.JumpBoost")) {event.player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 180, 2, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Invisibility")) {event.player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.InstantHealth")) {event.player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Haste")) {event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Glowing")) {event.player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Absorption")) {event.player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Strength")) {event.player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Saturation")) {event.player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Luck")) {event.player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.FireResistance")) {event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.WaterBreathing")) {event.player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.NightVision")) {event.player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 600, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Regeneration")) {event.player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Resistance")) {event.player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Antidote")) {
		            	event.player.removeActivePotionEffect(MobEffects.POISON);
						event.player.removeActivePotionEffect(MobEffects.WEAKNESS);
						event.player.removeActivePotionEffect(MobEffects.WITHER);
						event.player.removeActivePotionEffect(MobEffects.SLOWNESS);
						event.player.removeActivePotionEffect(MobEffects.UNLUCK);
						event.player.removeActivePotionEffect(MobEffects.NAUSEA);
						event.player.removeActivePotionEffect(MobEffects.BLINDNESS);
						event.player.removeActivePotionEffect(MobEffects.HUNGER);
						event.player.removeActivePotionEffect(MobEffects.MINING_FATIGUE);}
		    	}
			}
		}
		
		if(event.player.hasItemInSlot(EntityEquipmentSlot.CHEST)) {
			ItemStack item = event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
			if(item.isItemEnchanted()) {
				Map<Enchantment, Integer> enchs = EnchantmentHelper.getEnchantments(item);
				for (Entry<Enchantment, Integer> entry : enchs.entrySet()) {
		            if(entry.getKey().getName().contentEquals("enchantment.Speed")) {event.player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.JumpBoost")) {event.player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 180, 2, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Invisibility")) {event.player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.InstantHealth")) {event.player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Haste")) {event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Glowing")) {event.player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Absorption")) {event.player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Strength")) {event.player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Saturation")) {event.player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Luck")) {event.player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.FireResistance")) {event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.WaterBreathing")) {event.player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.NightVision")) {event.player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 600, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Regeneration")) {event.player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Resistance")) {event.player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Antidote")) {
		            	event.player.removeActivePotionEffect(MobEffects.POISON);
						event.player.removeActivePotionEffect(MobEffects.WEAKNESS);
						event.player.removeActivePotionEffect(MobEffects.WITHER);
						event.player.removeActivePotionEffect(MobEffects.SLOWNESS);
						event.player.removeActivePotionEffect(MobEffects.UNLUCK);
						event.player.removeActivePotionEffect(MobEffects.NAUSEA);
						event.player.removeActivePotionEffect(MobEffects.BLINDNESS);
						event.player.removeActivePotionEffect(MobEffects.HUNGER);
						event.player.removeActivePotionEffect(MobEffects.MINING_FATIGUE);}
		    	}
			}
		}
		
		if(event.player.hasItemInSlot(EntityEquipmentSlot.LEGS)) {
			ItemStack item = event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
			if(item.isItemEnchanted()) {
				Map<Enchantment, Integer> enchs = EnchantmentHelper.getEnchantments(item);
				for (Entry<Enchantment, Integer> entry : enchs.entrySet()) {
		            if(entry.getKey().getName().contentEquals("enchantment.Speed")) {event.player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.JumpBoost")) {event.player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 180, 2, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Invisibility")) {event.player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.InstantHealth")) {event.player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Haste")) {event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Glowing")) {event.player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Absorption")) {event.player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Strength")) {event.player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Saturation")) {event.player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Luck")) {event.player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.FireResistance")) {event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.WaterBreathing")) {event.player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.NightVision")) {event.player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 600, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Regeneration")) {event.player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Resistance")) {event.player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Antidote")) {
		            	event.player.removeActivePotionEffect(MobEffects.POISON);
						event.player.removeActivePotionEffect(MobEffects.WEAKNESS);
						event.player.removeActivePotionEffect(MobEffects.WITHER);
						event.player.removeActivePotionEffect(MobEffects.SLOWNESS);
						event.player.removeActivePotionEffect(MobEffects.UNLUCK);
						event.player.removeActivePotionEffect(MobEffects.NAUSEA);
						event.player.removeActivePotionEffect(MobEffects.BLINDNESS);
						event.player.removeActivePotionEffect(MobEffects.HUNGER);
						event.player.removeActivePotionEffect(MobEffects.MINING_FATIGUE);}
		    	}
			}
		}
		
		if(event.player.hasItemInSlot(EntityEquipmentSlot.FEET)) {
			ItemStack item = event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
			if(item.isItemEnchanted()) {
				Map<Enchantment, Integer> enchs = EnchantmentHelper.getEnchantments(item);
				for (Entry<Enchantment, Integer> entry : enchs.entrySet()) {
		            if(entry.getKey().getName().contentEquals("enchantment.Speed")) {event.player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.JumpBoost")) {event.player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 180, 2, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Invisibility")) {event.player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.InstantHealth")) {event.player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Haste")) {event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Glowing")) {event.player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Absorption")) {event.player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Strength")) {event.player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Saturation")) {event.player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Luck")) {event.player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.FireResistance")) {event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.WaterBreathing")) {event.player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.NightVision")) {event.player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 600, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Regeneration")) {event.player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 180, 0, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Resistance")) {event.player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 180, 9, false, false));}
		            if(entry.getKey().getName().contentEquals("enchantment.Antidote")) {
		            	event.player.removeActivePotionEffect(MobEffects.POISON);
						event.player.removeActivePotionEffect(MobEffects.WEAKNESS);
						event.player.removeActivePotionEffect(MobEffects.WITHER);
						event.player.removeActivePotionEffect(MobEffects.SLOWNESS);
						event.player.removeActivePotionEffect(MobEffects.UNLUCK);
						event.player.removeActivePotionEffect(MobEffects.NAUSEA);
						event.player.removeActivePotionEffect(MobEffects.BLINDNESS);
						event.player.removeActivePotionEffect(MobEffects.HUNGER);
						event.player.removeActivePotionEffect(MobEffects.MINING_FATIGUE);}
		    	}
			}
		}
	}
}

