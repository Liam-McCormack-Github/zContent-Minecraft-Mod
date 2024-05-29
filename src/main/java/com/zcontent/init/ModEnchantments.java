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
    public static final Enchantment FERTILIZER = new EnchantmentFertilizer();
    public static final Enchantment FASTDRAW = new EnchantmentFastdraw();
    public static final Enchantment FASTSTRIKE = new EnchantmentFaststrike();

}

