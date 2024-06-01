package com.zcontent.init;

import com.zcontent.enchantment.*;
import com.zcontent.items.ItemWandEnchantable;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModEnchantments {

    public static final EnumEnchantmentType WAND = EnumHelper.addEnchantmentType("wand", (item) -> (item instanceof ItemWandEnchantable));

    public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();

    public static Enchantment ABSORPTION, FIRERESISTANCE, LUCK, NIGHTVISION, REGENERATION, RESISTANCE, SATURATION, STRENGTH, WATERBREATHING, ANTIDOTE, GLOWING, HASTE, INSTANTHEALTH, INVISIBILITY, JUMPBOOST, LEVITATION, SPEED;
    public static Enchantment THUNDER, PARALYSIS, INSTANTKILL, DISARM, WEAKEN, FERTILIZER;

    public static void init() {
        ABSORPTION = new EnchantmentBaseWandPotionPlayer("Absorption");
        FIRERESISTANCE = new EnchantmentBaseWandPotionPlayer("FireResistance");
        LUCK = new EnchantmentBaseWandPotionPlayer("Luck");
        NIGHTVISION = new EnchantmentBaseWandPotionPlayer("NightVision");
        REGENERATION = new EnchantmentBaseWandPotionPlayer("Regeneration");
        RESISTANCE = new EnchantmentBaseWandPotionPlayer("Resistance");
        SATURATION = new EnchantmentBaseWandPotionPlayer("Saturation");
        STRENGTH = new EnchantmentBaseWandPotionPlayer("Strength");
        WATERBREATHING = new EnchantmentBaseWandPotionPlayer("WaterBreathing");
        ANTIDOTE = new EnchantmentBaseWandPotionPlayer("Antidote");
        GLOWING = new EnchantmentBaseWandPotionPlayer("Glowing");
        HASTE = new EnchantmentBaseWandPotionPlayer("Haste");
        INSTANTHEALTH = new EnchantmentBaseWandPotionPlayer("InstantHealth");
        INVISIBILITY = new EnchantmentBaseWandPotionPlayer("Invisibility");
        JUMPBOOST = new EnchantmentBaseWandPotionPlayer("JumpBoost");
        LEVITATION = new EnchantmentBaseWandPotionPlayer("Levitation");
        SPEED = new EnchantmentBaseWandPotionPlayer("Speed");

        THUNDER = new EnchantmentThunder("Thunder");
        PARALYSIS = new EnchantmentParalysis("Paralysis");
        INSTANTKILL = new EnchantmentInstantKill("InstantKill");
        DISARM = new EnchantmentDisarm("Disarm");
        WEAKEN = new EnchantmentWeaken("Weaken");
        FERTILIZER = new EnchantmentFertilizer("Fertilizer");
    }
}

