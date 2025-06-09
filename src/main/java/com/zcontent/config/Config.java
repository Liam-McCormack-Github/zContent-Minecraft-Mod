package com.zcontent.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zcontent.util.JsonHelper;

public class Config {

    private static final JsonObject Config = ConfigLoader.getConfig();

    private static final JsonObject Materials = JsonHelper.getJsonObject(Config, "materials");
    private static final JsonObject Fuels = JsonHelper.getJsonObject(Config, "fuels");
    private static final JsonObject Armor = JsonHelper.getJsonObject(Config, "armor");
    private static final JsonObject Tools = JsonHelper.getJsonObject(Config, "tools");
    private static final JsonObject Enchantments = JsonHelper.getJsonObject(Config, "enchantments");
    private static final JsonObject Wands = JsonHelper.getJsonObject(Config, "wands");

    public static final JsonArray WandModes = Wands.getAsJsonArray("modes");
    public static final int NumberOfModes = WandModes.size();

    private static final JsonObject ExcavationWand = JsonHelper.getJsonObject(Wands, "excavation_wand");
    public static final int ExcavationWandRangeBoostMainHand = JsonHelper.getJsonPrimitiveAsInt(ExcavationWand, "rangeBoostMainHand");
    public static final int ExcavationWandRangeBoostOffHand = JsonHelper.getJsonPrimitiveAsInt(ExcavationWand, "rangeBoostOffHand");

    private static final JsonObject BlinkWand = JsonHelper.getJsonObject(Wands, "blink_wand");
    public static final int BlinkWandRangeBoostMainHand = JsonHelper.getJsonPrimitiveAsInt(BlinkWand, "rangeBoostMainHand");
    public static final int BlinkWandRangeBoostOffHand = JsonHelper.getJsonPrimitiveAsInt(BlinkWand, "rangeBoostOffHand");
    public static final int BlinkWandDistanceInterval = JsonHelper.getJsonPrimitiveAsInt(BlinkWand, "distanceInterval");
    public static final int BlinkWandMaxDistance = JsonHelper.getJsonPrimitiveAsInt(BlinkWand, "maxDistance");
    public static final int BlinkWandCooldown = JsonHelper.getJsonPrimitiveAsInt(BlinkWand, "cooldown");


    private static final JsonObject DisplaceWand = JsonHelper.getJsonObject(Wands, "displace_wand");
    public static final int DisplaceWandRangeBoostMainHand = JsonHelper.getJsonPrimitiveAsInt(DisplaceWand, "rangeBoostMainHand");
    public static final int DisplaceWandRangeBoostOffHand = JsonHelper.getJsonPrimitiveAsInt(DisplaceWand, "rangeBoostOffHand");
    public static final int DisplaceWandCooldown = JsonHelper.getJsonPrimitiveAsInt(DisplaceWand, "cooldown");

    private static final JsonObject EnchantableWand1 = JsonHelper.getJsonObject(Wands, "enchantable_wand_1");
    public static final int EnchantableWand1RangeBoostMainHand = JsonHelper.getJsonPrimitiveAsInt(EnchantableWand1, "rangeBoostMainHand");
    public static final int EnchantableWand1RangeBoostOffHand = JsonHelper.getJsonPrimitiveAsInt(EnchantableWand1, "rangeBoostOffHand");

    private static final JsonObject EnchantableWand2 = JsonHelper.getJsonObject(Wands, "enchantable_wand_2");
    public static final int EnchantableWand2RangeBoostMainHand = JsonHelper.getJsonPrimitiveAsInt(EnchantableWand2, "rangeBoostMainHand");
    public static final int EnchantableWand2RangeBoostOffHand = JsonHelper.getJsonPrimitiveAsInt(EnchantableWand2, "rangeBoostOffHand");

    private static final JsonObject EnchantableWand3 = JsonHelper.getJsonObject(Wands, "enchantable_wand_3");
    public static final int EnchantableWand3RangeBoostMainHand = JsonHelper.getJsonPrimitiveAsInt(EnchantableWand3, "rangeBoostMainHand");
    public static final int EnchantableWand3RangeBoostOffHand = JsonHelper.getJsonPrimitiveAsInt(EnchantableWand3, "rangeBoostOffHand");

    private static final JsonObject EnchantableWand4 = JsonHelper.getJsonObject(Wands, "enchantable_wand_4");
    public static final int EnchantableWand4RangeBoostMainHand = JsonHelper.getJsonPrimitiveAsInt(EnchantableWand4, "rangeBoostMainHand");
    public static final int EnchantableWand4RangeBoostOffHand = JsonHelper.getJsonPrimitiveAsInt(EnchantableWand4, "rangeBoostOffHand");

    private static final JsonObject MaterialStainless = JsonHelper.getJsonObject(Materials, "material_stainless");
    public static final int MaterialStainlessHarvestLevel = JsonHelper.getJsonPrimitiveAsInt(MaterialStainless, "harvestLevel");
    public static final int MaterialStainlessMaxUses = JsonHelper.getJsonPrimitiveAsInt(MaterialStainless, "maxUses");
    public static final float MaterialStainlessEfficiency = JsonHelper.getJsonPrimitiveAsFloat(MaterialStainless, "efficiency");
    public static final float MaterialStainlessDamage = JsonHelper.getJsonPrimitiveAsFloat(MaterialStainless, "damage");
    public static final int MaterialStainlessEnchantability = JsonHelper.getJsonPrimitiveAsInt(MaterialStainless, "enchantability");

    private static final JsonObject MaterialSilverObsidian = JsonHelper.getJsonObject(Materials, "material_silver_obsidian");
    public static final int MaterialSilverObsidianHarvestLevel = JsonHelper.getJsonPrimitiveAsInt(MaterialSilverObsidian, "harvestLevel");
    public static final int MaterialSilverObsidianMaxUses = JsonHelper.getJsonPrimitiveAsInt(MaterialSilverObsidian, "maxUses");
    public static final float MaterialSilverObsidianEfficiency = JsonHelper.getJsonPrimitiveAsFloat(MaterialSilverObsidian, "efficiency");
    public static final float MaterialSilverObsidianDamage = JsonHelper.getJsonPrimitiveAsFloat(MaterialSilverObsidian, "damage");
    public static final int MaterialSilverObsidianEnchantability = JsonHelper.getJsonPrimitiveAsInt(MaterialSilverObsidian, "enchantability");

    private static final JsonObject MaterialMaster = JsonHelper.getJsonObject(Materials, "material_master");
    public static final int MaterialMasterHarvestLevel = JsonHelper.getJsonPrimitiveAsInt(MaterialMaster, "harvestLevel");
    public static final int MaterialMasterMaxUses = JsonHelper.getJsonPrimitiveAsInt(MaterialMaster, "maxUses");
    public static final float MaterialMasterEfficiency = JsonHelper.getJsonPrimitiveAsFloat(MaterialMaster, "efficiency");
    public static final float MaterialMasterDamage = JsonHelper.getJsonPrimitiveAsFloat(MaterialMaster, "damage");
    public static final int MaterialMasterEnchantability = JsonHelper.getJsonPrimitiveAsInt(MaterialMaster, "enchantability");

    private static final JsonObject MaterialElemental = JsonHelper.getJsonObject(Materials, "material_elemental");
    public static final int MaterialElementalHarvestLevel = JsonHelper.getJsonPrimitiveAsInt(MaterialElemental, "harvestLevel");
    public static final int MaterialElementalMaxUses = JsonHelper.getJsonPrimitiveAsInt(MaterialElemental, "maxUses");
    public static final float MaterialElementalEfficiency = JsonHelper.getJsonPrimitiveAsFloat(MaterialElemental, "efficiency");
    public static final float MaterialElementalDamage = JsonHelper.getJsonPrimitiveAsFloat(MaterialElemental, "damage");
    public static final int MaterialElementalEnchantability = JsonHelper.getJsonPrimitiveAsInt(MaterialElemental, "enchantability");

    private static final JsonObject MaterialMasterBase = JsonHelper.getJsonObject(Materials, "material_master_base");
    public static final int MaterialMasterBaseHarvestLevel = JsonHelper.getJsonPrimitiveAsInt(MaterialMasterBase, "harvestLevel");
    public static final int MaterialMasterBaseMaxUses = JsonHelper.getJsonPrimitiveAsInt(MaterialMasterBase, "maxUses");
    public static final float MaterialMasterBaseEfficiency = JsonHelper.getJsonPrimitiveAsFloat(MaterialMasterBase, "efficiency");
    public static final float MaterialMasterBaseDamage = JsonHelper.getJsonPrimitiveAsFloat(MaterialMasterBase, "damage");
    public static final int MaterialMasterBaseEnchantability = JsonHelper.getJsonPrimitiveAsInt(MaterialMasterBase, "enchantability");

    private static final JsonObject MaterialNanoArmor = JsonHelper.getJsonObject(Materials, "material_nano_armor");
    public static final int MaterialNanoArmorDurability = JsonHelper.getJsonPrimitiveAsInt(MaterialNanoArmor, "durability");
    public static final int[] MaterialNanoArmorReductionAmounts = JsonHelper.getJsonIntArray(MaterialNanoArmor, "reductionAmounts");
    public static final int MaterialNanoArmorEnchantability = JsonHelper.getJsonPrimitiveAsInt(MaterialNanoArmor, "enchantability");
    public static final float MaterialNanoArmorToughness = JsonHelper.getJsonPrimitiveAsFloat(MaterialNanoArmor, "toughness");

    private static final JsonObject MaterialQuantumArmor = JsonHelper.getJsonObject(Materials, "material_quantum_armor");
    public static final int MaterialQuantumArmorDurability = JsonHelper.getJsonPrimitiveAsInt(MaterialQuantumArmor, "durability");
    public static final int[] MaterialQuantumArmorReductionAmounts = JsonHelper.getJsonIntArray(MaterialQuantumArmor, "reductionAmounts");
    public static final int MaterialQuantumArmorEnchantability = JsonHelper.getJsonPrimitiveAsInt(MaterialQuantumArmor, "enchantability");
    public static final float MaterialQuantumArmorToughness = JsonHelper.getJsonPrimitiveAsFloat(MaterialQuantumArmor, "toughness");

    private static final JsonObject TinyCoal = JsonHelper.getJsonObject(Fuels, "tinyCoal");
    public static final int TinyCoalBurnTime = JsonHelper.getJsonPrimitiveAsInt(TinyCoal, "burnTime");

    private static final JsonObject TinyCharcoal = JsonHelper.getJsonObject(Fuels, "tinyCharcoal");
    public static final int TinyCharcoalBurnTime = JsonHelper.getJsonPrimitiveAsInt(TinyCharcoal, "burnTime");

    private static final JsonObject QuantumHelmet = JsonHelper.getJsonObject(Armor, "quantum_helmet");
    public static final int QuantumHelmetEnergyCapacity = JsonHelper.getJsonPrimitiveAsInt(QuantumHelmet, "energyCapacity");
    public static final int QuantumHelmetEnergyCost = JsonHelper.getJsonPrimitiveAsInt(QuantumHelmet, "energyCost");

    private static final JsonObject QuantumChestplate = JsonHelper.getJsonObject(Armor, "quantum_chestplate");
    public static final int QuantumChestplateEnergyCapacity = JsonHelper.getJsonPrimitiveAsInt(QuantumChestplate, "energyCapacity");
    public static final int QuantumChestplateEnergyCost = JsonHelper.getJsonPrimitiveAsInt(QuantumChestplate, "energyCost");

    private static final JsonObject QuantumLeggings = JsonHelper.getJsonObject(Armor, "quantum_leggings");
    public static final int QuantumLeggingsEnergyCapacity = JsonHelper.getJsonPrimitiveAsInt(QuantumLeggings, "energyCapacity");
    public static final int QuantumLeggingsEnergyCost = JsonHelper.getJsonPrimitiveAsInt(QuantumLeggings, "energyCost");

    private static final JsonObject QuantumBoots = JsonHelper.getJsonObject(Armor, "quantum_boots");
    public static final int QuantumBootsEnergyCapacity = JsonHelper.getJsonPrimitiveAsInt(QuantumBoots, "energyCapacity");
    public static final int QuantumBootsEnergyCost = JsonHelper.getJsonPrimitiveAsInt(QuantumBoots, "energyCost");

    private static final JsonObject StainlessSteelSword = JsonHelper.getJsonObject(Tools, "stainless_steel_sword");
    public static final int StainlessSteelSwordRangeBoostMainHand = JsonHelper.getJsonPrimitiveAsInt(StainlessSteelSword, "rangeBoostMainHand");
    public static final int StainlessSteelSwordRangeBoostOffHand = JsonHelper.getJsonPrimitiveAsInt(StainlessSteelSword, "rangeBoostOffHand");

    private static final JsonObject StainlessSteelPick = JsonHelper.getJsonObject(Tools, "stainless_steel_pick");
    public static final int StainlessSteelPickRangeBoostMainHand = JsonHelper.getJsonPrimitiveAsInt(StainlessSteelPick, "rangeBoostMainHand");
    public static final int StainlessSteelPickRangeBoostOffHand = JsonHelper.getJsonPrimitiveAsInt(StainlessSteelPick, "rangeBoostOffHand");

    private static final JsonObject StainlessSteelShovel = JsonHelper.getJsonObject(Tools, "stainless_steel_shovel");
    public static final int StainlessSteelShovelRangeBoostMainHand = JsonHelper.getJsonPrimitiveAsInt(StainlessSteelShovel, "rangeBoostMainHand");
    public static final int StainlessSteelShovelRangeBoostOffHand = JsonHelper.getJsonPrimitiveAsInt(StainlessSteelShovel, "rangeBoostOffHand");

    private static final JsonObject StainlessSteelAxe = JsonHelper.getJsonObject(Tools, "stainless_steel_axe");
    public static final int StainlessSteelAxeRangeBoostMainHand = JsonHelper.getJsonPrimitiveAsInt(StainlessSteelAxe, "rangeBoostMainHand");
    public static final int StainlessSteelAxeRangeBoostOffHand = JsonHelper.getJsonPrimitiveAsInt(StainlessSteelAxe, "rangeBoostOffHand");
    public static final int StainlessSteelAxeDamage = JsonHelper.getJsonPrimitiveAsInt(StainlessSteelAxe, "damage");
    public static final int StainlessSteelAxeSpeed = JsonHelper.getJsonPrimitiveAsInt(StainlessSteelAxe, "speed");

    private static final JsonObject SilverObsidianAxe = JsonHelper.getJsonObject(Tools, "silver_obsidian_axe");
    public static final int SilverObsidianAxeDamage = JsonHelper.getJsonPrimitiveAsInt(SilverObsidianAxe, "damage");
    public static final int SilverObsidianAxeSpeed = JsonHelper.getJsonPrimitiveAsInt(SilverObsidianAxe, "speed");

    private static final JsonObject EnchLevitation = JsonHelper.getJsonObject(Enchantments, "Levitation");
    private static final JsonObject EnchSpeed = JsonHelper.getJsonObject(Enchantments, "Speed");
    private static final JsonObject EnchJumpBoost = JsonHelper.getJsonObject(Enchantments, "JumpBoost");
    private static final JsonObject EnchInvisibility = JsonHelper.getJsonObject(Enchantments, "Invisibility");
    private static final JsonObject EnchInstantHealth = JsonHelper.getJsonObject(Enchantments, "InstantHealth");
    private static final JsonObject EnchHaste = JsonHelper.getJsonObject(Enchantments, "Haste");
    private static final JsonObject EnchGlowing = JsonHelper.getJsonObject(Enchantments, "Glowing");
    private static final JsonObject EnchAbsorption = JsonHelper.getJsonObject(Enchantments, "Absorption");
    private static final JsonObject EnchStrength = JsonHelper.getJsonObject(Enchantments, "Strength");
    private static final JsonObject EnchSaturation = JsonHelper.getJsonObject(Enchantments, "Saturation");
    private static final JsonObject EnchLuck = JsonHelper.getJsonObject(Enchantments, "Luck");
    private static final JsonObject EnchFireResistance = JsonHelper.getJsonObject(Enchantments, "FireResistance");
    private static final JsonObject EnchWaterBreathing = JsonHelper.getJsonObject(Enchantments, "WaterBreathing");
    private static final JsonObject EnchNightVision = JsonHelper.getJsonObject(Enchantments, "NightVision");
    private static final JsonObject EnchRegeneration = JsonHelper.getJsonObject(Enchantments, "Regeneration");
    private static final JsonObject EnchResistance = JsonHelper.getJsonObject(Enchantments, "Resistance");
    private static final JsonObject EnchAttributeAttackSpeed = JsonHelper.getJsonObject(Enchantments, "AttributeAttackSpeed");
    private static final JsonObject EnchAttributeAttackDamage = JsonHelper.getJsonObject(Enchantments, "AttributeAttackDamage");
    private static final JsonObject EnchAttributeArmor = JsonHelper.getJsonObject(Enchantments, "AttributeArmor");
    private static final JsonObject EnchAttributeArmorToughness = JsonHelper.getJsonObject(Enchantments, "AttributeArmorToughness");
    private static final JsonObject EnchAttributeFlySpeed = JsonHelper.getJsonObject(Enchantments, "AttributeFlySpeed");
    private static final JsonObject EnchAttributeKnockbackResist = JsonHelper.getJsonObject(Enchantments, "AttributeKnockbackResist");
    private static final JsonObject EnchAttributeLuck = JsonHelper.getJsonObject(Enchantments, "AttributeLuck");
    private static final JsonObject EnchAttributeMaxHealth = JsonHelper.getJsonObject(Enchantments, "AttributeMaxHealth");
    private static final JsonObject EnchAttributeMovementSpeed = JsonHelper.getJsonObject(Enchantments, "AttributeMovementSpeed");
    private static final JsonObject EnchAttributeSwimSpeed = JsonHelper.getJsonObject(Enchantments, "AttributeSwimSpeed");
    private static final JsonObject EnchAttributeRange = JsonHelper.getJsonObject(Enchantments, "AttributeRange");
    private static final JsonObject EnchResurrection = JsonHelper.getJsonObject(Enchantments, "Resurrection");
    private static final JsonObject EnchInstantKill = JsonHelper.getJsonObject(Enchantments, "InstantKill");

    public static final int EnchLevitationDuration = JsonHelper.getJsonPrimitiveAsInt(EnchLevitation, "duration");
    public static final int EnchSpeedDuration = JsonHelper.getJsonPrimitiveAsInt(EnchSpeed, "duration");
    public static final int EnchJumpBoostDuration = JsonHelper.getJsonPrimitiveAsInt(EnchJumpBoost, "duration");
    public static final int EnchInvisibilityDuration = JsonHelper.getJsonPrimitiveAsInt(EnchInvisibility, "duration");
    public static final int EnchInstantHealthDuration = JsonHelper.getJsonPrimitiveAsInt(EnchInstantHealth, "duration");
    public static final int EnchHasteDuration = JsonHelper.getJsonPrimitiveAsInt(EnchHaste, "duration");
    public static final int EnchGlowingDuration = JsonHelper.getJsonPrimitiveAsInt(EnchGlowing, "duration");
    public static final int EnchAbsorptionDuration = JsonHelper.getJsonPrimitiveAsInt(EnchAbsorption, "duration");
    public static final int EnchStrengthDuration = JsonHelper.getJsonPrimitiveAsInt(EnchStrength, "duration");
    public static final int EnchSaturationDuration = JsonHelper.getJsonPrimitiveAsInt(EnchSaturation, "duration");
    public static final int EnchLuckDuration = JsonHelper.getJsonPrimitiveAsInt(EnchLuck, "duration");
    public static final int EnchFireResistanceDuration = JsonHelper.getJsonPrimitiveAsInt(EnchFireResistance, "duration");
    public static final int EnchWaterBreathingDuration = JsonHelper.getJsonPrimitiveAsInt(EnchWaterBreathing, "duration");
    public static final int EnchNightVisionDuration = JsonHelper.getJsonPrimitiveAsInt(EnchNightVision, "duration");
    public static final int EnchRegenerationDuration = JsonHelper.getJsonPrimitiveAsInt(EnchRegeneration, "duration");
    public static final int EnchResistanceDuration = JsonHelper.getJsonPrimitiveAsInt(EnchResistance, "duration");

    public static final int EnchLevitationMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchLevitation, "multiplier");
    public static final int EnchSpeedMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchSpeed, "multiplier");
    public static final int EnchJumpBoostMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchJumpBoost, "multiplier");
    public static final int EnchInvisibilityMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchInvisibility, "multiplier");
    public static final int EnchInstantHealthMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchInstantHealth, "multiplier");
    public static final int EnchHasteMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchHaste, "multiplier");
    public static final int EnchGlowingMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchGlowing, "multiplier");
    public static final int EnchAbsorptionMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchAbsorption, "multiplier");
    public static final int EnchStrengthMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchStrength, "multiplier");
    public static final int EnchSaturationMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchSaturation, "multiplier");
    public static final int EnchLuckMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchLuck, "multiplier");
    public static final int EnchFireResistanceMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchFireResistance, "multiplier");
    public static final int EnchWaterBreathingMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchWaterBreathing, "multiplier");
    public static final int EnchNightVisionMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchNightVision, "multiplier");
    public static final int EnchRegenerationMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchRegeneration, "multiplier");
    public static final int EnchResistanceMultiplier = JsonHelper.getJsonPrimitiveAsInt(EnchResistance, "multiplier");

    public static final int EnchLevitationBase = JsonHelper.getJsonPrimitiveAsInt(EnchLevitation, "base");
    public static final int EnchSpeedBase = JsonHelper.getJsonPrimitiveAsInt(EnchSpeed, "base");
    public static final int EnchJumpBoostBase = JsonHelper.getJsonPrimitiveAsInt(EnchJumpBoost, "base");
    public static final int EnchInvisibilityBase = JsonHelper.getJsonPrimitiveAsInt(EnchInvisibility, "base");
    public static final int EnchInstantHealthBase = JsonHelper.getJsonPrimitiveAsInt(EnchInstantHealth, "base");
    public static final int EnchHasteBase = JsonHelper.getJsonPrimitiveAsInt(EnchHaste, "base");
    public static final int EnchGlowingBase = JsonHelper.getJsonPrimitiveAsInt(EnchGlowing, "base");
    public static final int EnchAbsorptionBase = JsonHelper.getJsonPrimitiveAsInt(EnchAbsorption, "base");
    public static final int EnchStrengthBase = JsonHelper.getJsonPrimitiveAsInt(EnchStrength, "base");
    public static final int EnchSaturationBase = JsonHelper.getJsonPrimitiveAsInt(EnchSaturation, "base");
    public static final int EnchLuckBase = JsonHelper.getJsonPrimitiveAsInt(EnchLuck, "base");
    public static final int EnchFireResistanceBase = JsonHelper.getJsonPrimitiveAsInt(EnchFireResistance, "base");
    public static final int EnchWaterBreathingBase = JsonHelper.getJsonPrimitiveAsInt(EnchWaterBreathing, "base");
    public static final int EnchNightVisionBase = JsonHelper.getJsonPrimitiveAsInt(EnchNightVision, "base");
    public static final int EnchRegenerationBase = JsonHelper.getJsonPrimitiveAsInt(EnchRegeneration, "base");
    public static final int EnchResistanceBase = JsonHelper.getJsonPrimitiveAsInt(EnchResistance, "base");

    public static final double EnchAttributeAttackSpeedBase = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeAttackSpeed, "base");
    public static final double EnchAttributeAttackDamageBase = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeAttackDamage, "base");
    public static final double EnchAttributeArmorBase = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeArmor, "base");
    public static final double EnchAttributeArmorToughnessBase = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeArmorToughness, "base");
    public static final double EnchAttributeFlySpeedBase = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeFlySpeed, "base");
    public static final double EnchAttributeKnockbackResistBase = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeKnockbackResist, "base");
    public static final double EnchAttributeLuckBase = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeLuck, "base");
    public static final double EnchAttributeMaxHealthBase = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeMaxHealth, "base");
    public static final double EnchAttributeMovementSpeedBase = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeMovementSpeed, "base");
    public static final double EnchAttributeSwimSpeedBase = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeSwimSpeed, "base");
    public static final double EnchAttributeRangeBase = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeRange, "base");

    public static final double EnchAttributeAttackSpeedModifier = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeAttackSpeed, "modifier");
    public static final double EnchAttributeAttackDamageModifier = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeAttackDamage, "modifier");
    public static final double EnchAttributeArmorModifier = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeArmor, "modifier");
    public static final double EnchAttributeArmorToughnessModifier = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeArmorToughness, "modifier");
    public static final double EnchAttributeFlySpeedModifier = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeFlySpeed, "modifier");
    public static final double EnchAttributeKnockbackResistModifier = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeKnockbackResist, "modifier");
    public static final double EnchAttributeLuckModifier = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeLuck, "modifier");
    public static final double EnchAttributeMaxHealthModifier = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeMaxHealth, "modifier");
    public static final double EnchAttributeMovementSpeedModifier = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeMovementSpeed, "modifier");
    public static final double EnchAttributeSwimSpeedModifier = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeSwimSpeed, "modifier");
    public static final double EnchAttributeRangeModifier = JsonHelper.getJsonPrimitiveAsDouble(EnchAttributeRange, "modifier");

    public static final int EnchAttributeAttackSpeedOperator = JsonHelper.getJsonPrimitiveAsInt(EnchAttributeAttackSpeed, "operator");
    public static final int EnchAttributeAttackDamageOperator = JsonHelper.getJsonPrimitiveAsInt(EnchAttributeAttackDamage, "operator");
    public static final int EnchAttributeArmorOperator = JsonHelper.getJsonPrimitiveAsInt(EnchAttributeArmor, "operator");
    public static final int EnchAttributeArmorToughnessOperator = JsonHelper.getJsonPrimitiveAsInt(EnchAttributeArmorToughness, "operator");
    public static final int EnchAttributeFlySpeedOperator = JsonHelper.getJsonPrimitiveAsInt(EnchAttributeFlySpeed, "operator");
    public static final int EnchAttributeKnockbackResistOperator = JsonHelper.getJsonPrimitiveAsInt(EnchAttributeKnockbackResist, "operator");
    public static final int EnchAttributeLuckOperator = JsonHelper.getJsonPrimitiveAsInt(EnchAttributeLuck, "operator");
    public static final int EnchAttributeMaxHealthOperator = JsonHelper.getJsonPrimitiveAsInt(EnchAttributeMaxHealth, "operator");
    public static final int EnchAttributeMovementSpeedOperator = JsonHelper.getJsonPrimitiveAsInt(EnchAttributeMovementSpeed, "operator");
    public static final int EnchAttributeSwimSpeedOperator = JsonHelper.getJsonPrimitiveAsInt(EnchAttributeSwimSpeed, "operator");
    public static final int EnchAttributeRangeOperator = JsonHelper.getJsonPrimitiveAsInt(EnchAttributeRange, "operator");

    public static final long EnchResurrectionCooldown = JsonHelper.getJsonPrimitiveAsLong(EnchResurrection, "cooldown");
    public static final boolean EnchInstantKillNoDrops = JsonHelper.getJsonPrimitiveAsBoolean(EnchInstantKill, "noDrops");
}
