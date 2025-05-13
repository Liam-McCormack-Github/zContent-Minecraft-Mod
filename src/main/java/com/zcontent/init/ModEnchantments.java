package com.zcontent.init;

import com.zcontent.enchantment.*;
import com.zcontent.items.ItemWandEnchantable;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModEnchantments {

    public static final EnumEnchantmentType WAND = EnumHelper.addEnchantmentType("wand", (item) -> (item instanceof ItemWandEnchantable));

    public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();
    public static Map<String, Enchantment> enchantmentMap = new HashMap<>();
    public static final String key = "wandMagics";
    public static final String resurrectionCooldownKey = "resurrectionCooldown";

    public static Enchantment ABSORPTION, FIRERESISTANCE, LUCK, NIGHTVISION, REGENERATION, RESISTANCE, SATURATION, STRENGTH, WATERBREATHING, ANTIDOTE, GLOWING, HASTE, INSTANTHEALTH, INVISIBILITY, JUMPBOOST, LEVITATION, SPEED;
    public static Enchantment THUNDER, PARALYSIS, INSTANTKILL, DISARM, WEAKEN, FERTILIZER, RESURRECTION;
    public static Enchantment ATTRIBUTE_ATTACK_SPEED, ATTRIBUTE_ATTACK_DAMAGE, ATTRIBUTE_ARMOR, ATTRIBUTE_ARMOR_TOUGHNESS, ATTRIBUTE_FLY_SPEED, ATTRIBUTE_KNOCKBACK_RESIST, ATTRIBUTE_LUCK, ATTRIBUTE_MAX_HEALTH, ATTRIBUTE_MOVEMENT_SPEED, ATTRIBUTE_SWIM_SPEED, ATTRIBUTE_RANGE;

    public static void init() {
        ABSORPTION = new EnchantmentBaseWand("Absorption");
        FIRERESISTANCE = new EnchantmentBaseWand("FireResistance");
        LUCK = new EnchantmentBaseWand("Luck");
        NIGHTVISION = new EnchantmentBaseWand("NightVision");
        REGENERATION = new EnchantmentBaseWand("Regeneration");
        RESISTANCE = new EnchantmentBaseWand("Resistance");
        SATURATION = new EnchantmentBaseWand("Saturation");
        STRENGTH = new EnchantmentBaseWand("Strength");
        WATERBREATHING = new EnchantmentBaseWand("WaterBreathing");
        ANTIDOTE = new EnchantmentBaseWand("Antidote");
        GLOWING = new EnchantmentBaseWand("Glowing");
        HASTE = new EnchantmentBaseWand("Haste");
        INSTANTHEALTH = new EnchantmentBaseWand("InstantHealth");
        INVISIBILITY = new EnchantmentBaseWand("Invisibility");
        JUMPBOOST = new EnchantmentBaseWand("JumpBoost");
        LEVITATION = new EnchantmentBaseWand("Levitation");
        SPEED = new EnchantmentBaseWand("Speed");

        THUNDER = new EnchantmentThunder("Thunder");
        PARALYSIS = new EnchantmentParalysis("Paralysis");
        INSTANTKILL = new EnchantmentInstantKill("InstantKill");
        DISARM = new EnchantmentDisarm("Disarm");
        WEAKEN = new EnchantmentWeaken("Weaken");
        FERTILIZER = new EnchantmentFertilizer("Fertilizer");
        RESURRECTION = new EnchantmentResurrection("Resurrection");

        ATTRIBUTE_ATTACK_SPEED = new EnchantmentBaseWand("AttributeAttackSpeed");
        ATTRIBUTE_ATTACK_DAMAGE = new EnchantmentBaseWand("AttributeAttackDamage");
        ATTRIBUTE_ARMOR = new EnchantmentBaseWand("AttributeArmor");
        ATTRIBUTE_ARMOR_TOUGHNESS = new EnchantmentBaseWand("AttributeArmorToughness");
        ATTRIBUTE_FLY_SPEED = new EnchantmentBaseWand("AttributeFlySpeed");
        ATTRIBUTE_KNOCKBACK_RESIST = new EnchantmentBaseWand("AttributeKnockbackResist");
        ATTRIBUTE_LUCK = new EnchantmentBaseWand("AttributeLuck");
        ATTRIBUTE_MAX_HEALTH = new EnchantmentBaseWand("AttributeMaxHealth");
        ATTRIBUTE_MOVEMENT_SPEED = new EnchantmentBaseWand("AttributeMovementSpeed");
        ATTRIBUTE_SWIM_SPEED = new EnchantmentBaseWand("AttributeSwimSpeed");
        ATTRIBUTE_RANGE = new EnchantmentBaseWand("AttributeRange");
    }
}

