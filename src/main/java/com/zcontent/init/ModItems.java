package com.zcontent.init;

import com.google.gson.JsonObject;
import com.zcontent.config.ConfigLoader;
import com.zcontent.items.*;
import com.zcontent.items.armor.ArmorNano;
import com.zcontent.items.armor.ArmorQuantum;
import com.zcontent.items.tools.*;
import com.zcontent.util.JsonHelper;
import com.zcontent.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;


public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<Item>();

    // Materials ("material_stainless", 3, 1561, 8.0F, 3.0F, 10);
    private static final JsonObject configMaterials = JsonHelper.getJsonObject(ConfigLoader.getConfig(), "materials");
    private static final JsonObject configMaterial_stainless = JsonHelper.getJsonObject(configMaterials, "material_stainless");
    private static final JsonObject configMaterial_silver_obsidian = JsonHelper.getJsonObject(configMaterials, "material_silver_obsidian");
    private static final JsonObject configMaterial_master = JsonHelper.getJsonObject(configMaterials, "material_master");
    private static final JsonObject configMaterial_elemental = JsonHelper.getJsonObject(configMaterials, "material_elemental");
    private static final JsonObject configMaterial_master_base = JsonHelper.getJsonObject(configMaterials, "material_master_base");
    private static final JsonObject configFuels = JsonHelper.getJsonObject(ConfigLoader.getConfig(), "fuels");
    private static final JsonObject configTinyCoal = JsonHelper.getJsonObject(configFuels, "tinyCoal");
    private static final JsonObject configTinyCharcoal = JsonHelper.getJsonObject(configFuels, "tinyCharcoal");
    private static final JsonObject configTools = JsonHelper.getJsonObject(ConfigLoader.getConfig(), "tools");
    private static final JsonObject configStainless_steel_sword = JsonHelper.getJsonObject(configTools, "stainless_steel_sword");
    private static final JsonObject configStainless_steel_pick = JsonHelper.getJsonObject(configTools, "stainless_steel_pick");
    private static final JsonObject configStainless_steel_shovel = JsonHelper.getJsonObject(configTools, "stainless_steel_shovel");
    private static final JsonObject configStainless_steel_axe = JsonHelper.getJsonObject(configTools, "stainless_steel_axe");
    private static final JsonObject configSilver_obsidian_axe = JsonHelper.getJsonObject(configTools, "silver_obsidian_axe");
    private static final JsonObject configWands = JsonHelper.getJsonObject(ConfigLoader.getConfig(), "wands");
    private static final JsonObject configExcavation_wand = JsonHelper.getJsonObject(configWands, "excavation_wand");
    private static final JsonObject configWand_1 = JsonHelper.getJsonObject(configWands, "wand_1");
    private static final JsonObject configWand_2 = JsonHelper.getJsonObject(configWands, "wand_2");
    private static final JsonObject configWand_3 = JsonHelper.getJsonObject(configWands, "wand_3");
    private static final JsonObject configWand_4 = JsonHelper.getJsonObject(configWands, "wand_4");

    public static ToolMaterial MATERIAL_STAINLESS, MATERIAL_SILVER_OBSIDIAN, MATERIAL_MASTER, MATERIAL_ELEMENTAL, MATERIAL_MASTER_BASE;

    public static ArmorMaterial MATERIAL_NANO_ARMOR, MATERIAL_QUANTUM_ARMOR;

    public static Item machineframe_1, machineframe_2, machineframe_3, machineframe, red_compound, blue_compound, red_alloy_ingot, blue_alloy_ingot, purple_alloy_ingot, graphite_ingot, zinc_ingot, manganese_ingot, chrome_ingot, brass_ingot, nichrome_ingot, galvanized_steel_ingot, stainless_steel_ingot, carbon_ingot, hot_iron_ingot, cold_iron_ingot, ardite_ingot, cobalt_ingot, manyullyn_ingot, terraglaz_ingot, evil_terraglaz_ingot, redstone_ball, substrate, polyethylene, biofuel, blue_mat_dust, purple_mat_dust, meteor_dust, et_frag, shaped_emerald, sulfur_crystal, animal_bones, vial, angel_wing, bat_wing, gold_feather, wither_bone, collector_star, collector_dark, collector_red, black_gem, blue_gem, green_gem, indigo_gem, orange_gem, red_gem, violet_gem, white_gem, yellow_gem, wood_plate, extended_tier1, extended_tier2, extended_tier3, extended_tier4, mold, mold_proc, coal_ball, compact_coal_ball, coal_chunk, carbon_fragment, carbon_mesh, carbon_panel, ancientdebris_chunk, andesite_chunk, basalt_chunk, clay_chunk, dirt_chunk, diorite_chunk, end_chunk, granite_chunk, gravel_chunk, jasper_chunk, limestone_chunk, marble_chunk, nether_chunk, obsidian_chunk, sand_chunk, slate_chunk, soulsand_chunk, soulstone_chunk, meteor_chunk, stone_chunk, combiner_core, dissolver_core, enderio_speed_upgrade_base, silicon_boule, silicon_wafer, transistor, alu, cu, rawcircuitboard, circuitboard, printedcircuitboard, card, proc_base, proc_raw_1, proc_raw_2, proc_raw_3, proc_1, proc_2, proc_3, chip1, chip2, chip3, componentbus1, componentbus2, componentbus3, cpu1, cpu2, cpu3, datacard1, datacard2, datacard3, graphicscard1, graphicscard2, graphicscard3, hdd1, hdd2, hdd3, ram1, ram2, ram3, server1, server2, server3, terminalserver, rf_fe_flux_power_energy, masterswordblade, masterswordcore, masterswordgrip, magic, enricheduranium, coal_tiny_small, charcoal_tiny_small, pill_antidote, magic_fertilizer, withered_bone_meal, charged_gunpowder, halcyon_shard, luck, nightvision, regeneration, resistance, saturation, strength, waterbreathing, absorption, antidote, fireresistance, glowing, haste, instanthealth, invisibility, jumpboost, levitation, speed, thunder, paralysis, instantkill, disarm, weaken, fertilizer, repairer, excavation_wand, wand_1, wand_2, wand_3, wand_4;

    public static ItemSword stainless_steel_sword, firesword, icesword, mastersword1, mastersword2, silver_obsidian_sword;

    public static ItemSpade stainless_steel_shovel, silver_obsidian_shovel;

    public static ItemPickaxe stainless_steel_pick, silver_obsidian_pick;

    public static ItemAxe stainless_steel_axe, silver_obsidian_axe;

    public static ItemArmor nano_helmet, nano_chestplate, nano_leggings, nano_boots, quantum_helmet, quantum_chestplate, quantum_leggings, quantum_boots;


    public static void init() {
        // Tools
        MATERIAL_STAINLESS = EnumHelper.addToolMaterial("material_stainless", JsonHelper.getJsonPrimitiveAsInt(configMaterial_stainless, "harvestLevel"), JsonHelper.getJsonPrimitiveAsInt(configMaterial_stainless, "maxUses"), JsonHelper.getJsonPrimitiveAsFloat(configMaterial_stainless, "efficiency"), JsonHelper.getJsonPrimitiveAsFloat(configMaterial_stainless, "damage"), JsonHelper.getJsonPrimitiveAsInt(configMaterial_stainless, "enchantability"));
        MATERIAL_SILVER_OBSIDIAN = EnumHelper.addToolMaterial("material_silver_obsidian", JsonHelper.getJsonPrimitiveAsInt(configMaterial_silver_obsidian, "harvestLevel"), JsonHelper.getJsonPrimitiveAsInt(configMaterial_silver_obsidian, "maxUses"), JsonHelper.getJsonPrimitiveAsFloat(configMaterial_silver_obsidian, "efficiency"), JsonHelper.getJsonPrimitiveAsFloat(configMaterial_silver_obsidian, "damage"), JsonHelper.getJsonPrimitiveAsInt(configMaterial_silver_obsidian, "enchantability"));
        MATERIAL_MASTER = EnumHelper.addToolMaterial("material_master", JsonHelper.getJsonPrimitiveAsInt(configMaterial_master, "harvestLevel"), JsonHelper.getJsonPrimitiveAsInt(configMaterial_master, "maxUses"), JsonHelper.getJsonPrimitiveAsFloat(configMaterial_master, "efficiency"), JsonHelper.getJsonPrimitiveAsFloat(configMaterial_master, "damage"), JsonHelper.getJsonPrimitiveAsInt(configMaterial_master, "enchantability"));
        MATERIAL_ELEMENTAL = EnumHelper.addToolMaterial("material_elemental", JsonHelper.getJsonPrimitiveAsInt(configMaterial_elemental, "harvestLevel"), JsonHelper.getJsonPrimitiveAsInt(configMaterial_elemental, "maxUses"), JsonHelper.getJsonPrimitiveAsFloat(configMaterial_elemental, "efficiency"), JsonHelper.getJsonPrimitiveAsFloat(configMaterial_elemental, "damage"), JsonHelper.getJsonPrimitiveAsInt(configMaterial_elemental, "enchantability"));
        MATERIAL_MASTER_BASE = EnumHelper.addToolMaterial("material_master_base", JsonHelper.getJsonPrimitiveAsInt(configMaterial_master_base, "harvestLevel"), JsonHelper.getJsonPrimitiveAsInt(configMaterial_master_base, "maxUses"), JsonHelper.getJsonPrimitiveAsFloat(configMaterial_master_base, "efficiency"), JsonHelper.getJsonPrimitiveAsFloat(configMaterial_master_base, "damage"), JsonHelper.getJsonPrimitiveAsInt(configMaterial_master_base, "enchantability"));
        // Armour
        MATERIAL_NANO_ARMOR = EnumHelper.addArmorMaterial("material_nano_armour", Reference.MOD_ID + ":nano", 2000, new int[]{12, 24, 32, 12}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F);
        MATERIAL_QUANTUM_ARMOR = EnumHelper.addArmorMaterial("material_quantum_armour", Reference.MOD_ID + ":quantum", 100, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0f);

        MATERIAL_NANO_ARMOR.setRepairItem(new ItemStack(ModItems.carbon_panel, 1));

        // Items
        machineframe_1 = new ItemBase("machineframe_1", CreativeTabs.MATERIALS);
        machineframe_2 = new ItemBase("machineframe_2", CreativeTabs.MATERIALS);
        machineframe_3 = new ItemBase("machineframe_3", CreativeTabs.MATERIALS);
        machineframe = new ItemBase("machineframe", CreativeTabs.MATERIALS);
        red_compound = new ItemBase("red_compound", CreativeTabs.MATERIALS);
        blue_compound = new ItemBase("blue_compound", CreativeTabs.MATERIALS);
        red_alloy_ingot = new ItemBase("red_alloy_ingot", CreativeTabs.MATERIALS);
        blue_alloy_ingot = new ItemBase("blue_alloy_ingot", CreativeTabs.MATERIALS);
        purple_alloy_ingot = new ItemBase("purple_alloy_ingot", CreativeTabs.MATERIALS);
        graphite_ingot = new ItemBase("graphite_ingot", CreativeTabs.MATERIALS);
        zinc_ingot = new ItemBase("zinc_ingot", CreativeTabs.MATERIALS);
        manganese_ingot = new ItemBase("manganese_ingot", CreativeTabs.MATERIALS);
        chrome_ingot = new ItemBase("chrome_ingot", CreativeTabs.MATERIALS);
        brass_ingot = new ItemBase("brass_ingot", CreativeTabs.MATERIALS);
        nichrome_ingot = new ItemBase("nichrome_ingot", CreativeTabs.MATERIALS);
        galvanized_steel_ingot = new ItemBase("galvanized_steel_ingot", CreativeTabs.MATERIALS);
        stainless_steel_ingot = new ItemBase("stainless_steel_ingot", CreativeTabs.MATERIALS);
        carbon_ingot = new ItemBase("carbon_ingot", CreativeTabs.MATERIALS);
        hot_iron_ingot = new ItemBase("hot_iron_ingot", CreativeTabs.MATERIALS);
        cold_iron_ingot = new ItemBase("cold_iron_ingot", CreativeTabs.MATERIALS);
        ardite_ingot = new ItemBase("ardite_ingot", CreativeTabs.MATERIALS);
        cobalt_ingot = new ItemBase("cobalt_ingot", CreativeTabs.MATERIALS);
        manyullyn_ingot = new ItemBase("manyullyn_ingot", CreativeTabs.MATERIALS);
        terraglaz_ingot = new ItemBase("terraglaz_ingot", CreativeTabs.MATERIALS);
        evil_terraglaz_ingot = new ItemBase("evil_terraglaz_ingot", CreativeTabs.MATERIALS);
        redstone_ball = new ItemBase("redstone_ball", CreativeTabs.MATERIALS);
        substrate = new ItemBase("substrate", CreativeTabs.MATERIALS);
        polyethylene = new ItemBase("polyethylene", CreativeTabs.MATERIALS);
        biofuel = new ItemBase("biofuel", CreativeTabs.MATERIALS);
        blue_mat_dust = new ItemBase("blue_mat_dust", CreativeTabs.MATERIALS);
        purple_mat_dust = new ItemBase("purple_mat_dust", CreativeTabs.MATERIALS);
        meteor_dust = new ItemBase("meteor_dust", CreativeTabs.MATERIALS);
        et_frag = new ItemBase("et_frag", CreativeTabs.MATERIALS);
        shaped_emerald = new ItemBase("shaped_emerald", CreativeTabs.MATERIALS);
        sulfur_crystal = new ItemBase("sulfur_crystal", CreativeTabs.MATERIALS);
        animal_bones = new ItemBase("animal_bones", CreativeTabs.MATERIALS);
        vial = new ItemBase("vial", CreativeTabs.MATERIALS);
        angel_wing = new ItemBase("angel_wing", CreativeTabs.MATERIALS);
        bat_wing = new ItemBase("bat_wing", CreativeTabs.MATERIALS);
        gold_feather = new ItemBase("gold_feather", CreativeTabs.MATERIALS);
        wither_bone = new ItemBase("wither_bone", CreativeTabs.MATERIALS);
        collector_star = new ItemBase("collector_star", CreativeTabs.MATERIALS);
        collector_dark = new ItemBase("collector_dark", CreativeTabs.MATERIALS);
        collector_red = new ItemBase("collector_red", CreativeTabs.MATERIALS);
        black_gem = new ItemBase("black_gem", CreativeTabs.MATERIALS);
        blue_gem = new ItemBase("blue_gem", CreativeTabs.MATERIALS);
        green_gem = new ItemBase("green_gem", CreativeTabs.MATERIALS);
        indigo_gem = new ItemBase("indigo_gem", CreativeTabs.MATERIALS);
        orange_gem = new ItemBase("orange_gem", CreativeTabs.MATERIALS);
        red_gem = new ItemBase("red_gem", CreativeTabs.MATERIALS);
        violet_gem = new ItemBase("violet_gem", CreativeTabs.MATERIALS);
        white_gem = new ItemBase("white_gem", CreativeTabs.MATERIALS);
        yellow_gem = new ItemBase("yellow_gem", CreativeTabs.MATERIALS);
        wood_plate = new ItemBase("wood_plate", CreativeTabs.MATERIALS);
        extended_tier1 = new ItemBase("extended_tier1", CreativeTabs.MATERIALS);
        extended_tier2 = new ItemBase("extended_tier2", CreativeTabs.MATERIALS);
        extended_tier3 = new ItemBase("extended_tier3", CreativeTabs.MATERIALS);
        extended_tier4 = new ItemBase("extended_tier4", CreativeTabs.MATERIALS);
        mold = new ItemBase("mold", CreativeTabs.MATERIALS).setMaxStackSize(1);
        mold_proc = new ItemBase("mold_proc", CreativeTabs.MATERIALS).setMaxStackSize(1);
        coal_ball = new ItemBase("coal_ball", CreativeTabs.MATERIALS);
        compact_coal_ball = new ItemBase("compact_coal_ball", CreativeTabs.MATERIALS);
        coal_chunk = new ItemBase("coal_chunk", CreativeTabs.MATERIALS);
        carbon_fragment = new ItemBase("carbon_fragment", CreativeTabs.MATERIALS);
        carbon_mesh = new ItemBase("carbon_mesh", CreativeTabs.MATERIALS);
        carbon_panel = new ItemBase("carbon_panel", CreativeTabs.MATERIALS);
        ancientdebris_chunk = new ItemBase("ancientdebris_chunk", CreativeTabs.MATERIALS);
        andesite_chunk = new ItemBase("andesite_chunk", CreativeTabs.MATERIALS);
        basalt_chunk = new ItemBase("basalt_chunk", CreativeTabs.MATERIALS);
        clay_chunk = new ItemBase("clay_chunk", CreativeTabs.MATERIALS);
        dirt_chunk = new ItemBase("dirt_chunk", CreativeTabs.MATERIALS);
        diorite_chunk = new ItemBase("diorite_chunk", CreativeTabs.MATERIALS);
        end_chunk = new ItemBase("end_chunk", CreativeTabs.MATERIALS);
        granite_chunk = new ItemBase("granite_chunk", CreativeTabs.MATERIALS);
        gravel_chunk = new ItemBase("gravel_chunk", CreativeTabs.MATERIALS);
        jasper_chunk = new ItemBase("jasper_chunk", CreativeTabs.MATERIALS);
        limestone_chunk = new ItemBase("limestone_chunk", CreativeTabs.MATERIALS);
        marble_chunk = new ItemBase("marble_chunk", CreativeTabs.MATERIALS);
        nether_chunk = new ItemBase("nether_chunk", CreativeTabs.MATERIALS);
        obsidian_chunk = new ItemBase("obsidian_chunk", CreativeTabs.MATERIALS);
        sand_chunk = new ItemBase("sand_chunk", CreativeTabs.MATERIALS);
        slate_chunk = new ItemBase("slate_chunk", CreativeTabs.MATERIALS);
        soulsand_chunk = new ItemBase("soulsand_chunk", CreativeTabs.MATERIALS);
        soulstone_chunk = new ItemBase("soulstone_chunk", CreativeTabs.MATERIALS);
        meteor_chunk = new ItemBase("meteor_chunk", CreativeTabs.MATERIALS);
        stone_chunk = new ItemBase("stone_chunk", CreativeTabs.MATERIALS);
        combiner_core = new ItemBase("combiner_core", CreativeTabs.MATERIALS);
        dissolver_core = new ItemBase("dissolver_core", CreativeTabs.MATERIALS);
        enderio_speed_upgrade_base = new ItemBase("enderio_speed_upgrade_base", CreativeTabs.MATERIALS);
        silicon_boule = new ItemBase("silicon_boule", CreativeTabs.MATERIALS);
        silicon_wafer = new ItemBase("silicon_wafer", CreativeTabs.MATERIALS);
        transistor = new ItemBase("transistor", CreativeTabs.MATERIALS);
        alu = new ItemBase("alu", CreativeTabs.MATERIALS);
        cu = new ItemBase("cu", CreativeTabs.MATERIALS);
        rawcircuitboard = new ItemBase("rawcircuitboard", CreativeTabs.MATERIALS);
        circuitboard = new ItemBase("circuitboard", CreativeTabs.MATERIALS);
        printedcircuitboard = new ItemBase("printedcircuitboard", CreativeTabs.MATERIALS);
        card = new ItemBase("card", CreativeTabs.MATERIALS);
        proc_base = new ItemBase("proc_base", CreativeTabs.MATERIALS);
        proc_raw_1 = new ItemBase("proc_raw_1", CreativeTabs.MATERIALS);
        proc_raw_2 = new ItemBase("proc_raw_2", CreativeTabs.MATERIALS);
        proc_raw_3 = new ItemBase("proc_raw_3", CreativeTabs.MATERIALS);
        proc_1 = new ItemBase("proc_1", CreativeTabs.MATERIALS);
        proc_2 = new ItemBase("proc_2", CreativeTabs.MATERIALS);
        proc_3 = new ItemBase("proc_3", CreativeTabs.MATERIALS);
        chip1 = new ItemBase("chip1", CreativeTabs.MATERIALS);
        chip2 = new ItemBase("chip2", CreativeTabs.MATERIALS);
        chip3 = new ItemBase("chip3", CreativeTabs.MATERIALS);
        componentbus1 = new ItemBase("componentbus1", CreativeTabs.MATERIALS);
        componentbus2 = new ItemBase("componentbus2", CreativeTabs.MATERIALS);
        componentbus3 = new ItemBase("componentbus3", CreativeTabs.MATERIALS);
        cpu1 = new ItemBase("cpu1", CreativeTabs.MATERIALS);
        cpu2 = new ItemBase("cpu2", CreativeTabs.MATERIALS);
        cpu3 = new ItemBase("cpu3", CreativeTabs.MATERIALS);
        datacard1 = new ItemBase("datacard1", CreativeTabs.MATERIALS);
        datacard2 = new ItemBase("datacard2", CreativeTabs.MATERIALS);
        datacard3 = new ItemBase("datacard3", CreativeTabs.MATERIALS);
        graphicscard1 = new ItemBase("graphicscard1", CreativeTabs.MATERIALS);
        graphicscard2 = new ItemBase("graphicscard2", CreativeTabs.MATERIALS);
        graphicscard3 = new ItemBase("graphicscard3", CreativeTabs.MATERIALS);
        hdd1 = new ItemBase("hdd1", CreativeTabs.MATERIALS);
        hdd2 = new ItemBase("hdd2", CreativeTabs.MATERIALS);
        hdd3 = new ItemBase("hdd3", CreativeTabs.MATERIALS);
        ram1 = new ItemBase("ram1", CreativeTabs.MATERIALS);
        ram2 = new ItemBase("ram2", CreativeTabs.MATERIALS);
        ram3 = new ItemBase("ram3", CreativeTabs.MATERIALS);
        server1 = new ItemBase("server1", CreativeTabs.MATERIALS);
        server2 = new ItemBase("server2", CreativeTabs.MATERIALS);
        server3 = new ItemBase("server3", CreativeTabs.MATERIALS);
        terminalserver = new ItemBase("terminalserver", CreativeTabs.MATERIALS);
        rf_fe_flux_power_energy = new ItemBase("rf_fe_flux_power_energy", CreativeTabs.MATERIALS);

        masterswordblade = new ItemBase("masterswordblade", CreativeTabs.MATERIALS).setMaxStackSize(1);
        masterswordcore = new ItemBase("masterswordcore", CreativeTabs.MATERIALS).setMaxStackSize(1);
        masterswordgrip = new ItemBase("masterswordgrip", CreativeTabs.MATERIALS).setMaxStackSize(1);
        // Bad
        magic = new ItemBad("magic", CreativeTabs.MATERIALS);
        enricheduranium = new ItemBad("enricheduranium", CreativeTabs.MATERIALS);
        // Fuels
        coal_tiny_small = new ItemFuel("coal_tiny_small", CreativeTabs.MATERIALS, JsonHelper.getJsonPrimitiveAsInt(configTinyCoal, "burnTime"));
        charcoal_tiny_small = new ItemFuel("charcoal_tiny_small", CreativeTabs.MATERIALS, JsonHelper.getJsonPrimitiveAsInt(configTinyCharcoal, "burnTime"));
        // Food
        pill_antidote = new ItemAntidote("pill_antidote", CreativeTabs.FOOD, 0, 0.0f, false);
        // Fertilizer
        magic_fertilizer = new ItemFertilizer("magic_fertilizer", CreativeTabs.MATERIALS);
        withered_bone_meal = new ItemFertilizerWithered("withered_bone_meal", CreativeTabs.MATERIALS);
        // Shiny base
        charged_gunpowder = new ItemGlowing("charged_gunpowder", CreativeTabs.MATERIALS);
        halcyon_shard = new ItemGlowing("halcyon_shard", CreativeTabs.MATERIALS);
        // Shiny enchant tomes
        luck = new ItemGlowing("luck", CreativeTabs.MATERIALS);
        nightvision = new ItemGlowing("nightvision", CreativeTabs.MATERIALS);
        regeneration = new ItemGlowing("regeneration", CreativeTabs.MATERIALS);
        resistance = new ItemGlowing("resistance", CreativeTabs.MATERIALS);
        saturation = new ItemGlowing("saturation", CreativeTabs.MATERIALS);
        strength = new ItemGlowing("strength", CreativeTabs.MATERIALS);
        waterbreathing = new ItemGlowing("waterbreathing", CreativeTabs.MATERIALS);
        absorption = new ItemGlowing("absorption", CreativeTabs.MATERIALS);
        antidote = new ItemGlowing("antidote", CreativeTabs.MATERIALS);
        fireresistance = new ItemGlowing("fireresistance", CreativeTabs.MATERIALS);
        glowing = new ItemGlowing("glowing", CreativeTabs.MATERIALS);
        haste = new ItemGlowing("haste", CreativeTabs.MATERIALS);
        instanthealth = new ItemGlowing("instanthealth", CreativeTabs.MATERIALS);
        invisibility = new ItemGlowing("invisibility", CreativeTabs.MATERIALS);
        jumpboost = new ItemGlowing("jumpboost", CreativeTabs.MATERIALS);
        levitation = new ItemGlowing("levitation", CreativeTabs.MATERIALS);
        speed = new ItemGlowing("speed", CreativeTabs.MATERIALS);
        thunder = new ItemGlowing("thunder", CreativeTabs.MATERIALS);
        paralysis = new ItemGlowing("paralysis", CreativeTabs.MATERIALS);
        instantkill = new ItemGlowing("instantkill", CreativeTabs.MATERIALS);
        disarm = new ItemGlowing("disarm", CreativeTabs.MATERIALS);
        weaken = new ItemGlowing("weaken", CreativeTabs.MATERIALS);
        fertilizer = new ItemGlowing("fertilizer", CreativeTabs.MATERIALS);
        // Repair gem
        repairer = new ItemRepair("repairer", CreativeTabs.MATERIALS);
        // Tools
        stainless_steel_sword = new ToolSwordWithAttributes("stainless_steel_sword", CreativeTabs.COMBAT, MATERIAL_STAINLESS, JsonHelper.getJsonPrimitiveAsInt(configStainless_steel_sword, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configStainless_steel_sword, "rangeBoostOffHand"));
        stainless_steel_pick = new ToolPickWithAttributes("stainless_steel_pick", CreativeTabs.TOOLS, MATERIAL_STAINLESS, JsonHelper.getJsonPrimitiveAsInt(configStainless_steel_pick, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configStainless_steel_pick, "rangeBoostOffHand"));
        stainless_steel_shovel = new ToolShovelWithAttributes("stainless_steel_shovel", CreativeTabs.TOOLS, MATERIAL_STAINLESS, JsonHelper.getJsonPrimitiveAsInt(configStainless_steel_shovel, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configStainless_steel_shovel, "rangeBoostOffHand"));
        stainless_steel_axe = new ToolAxeWithAttributes("stainless_steel_axe", CreativeTabs.TOOLS, MATERIAL_STAINLESS, JsonHelper.getJsonPrimitiveAsFloat(configStainless_steel_axe, "damage"), JsonHelper.getJsonPrimitiveAsFloat(configStainless_steel_axe, "speed"), JsonHelper.getJsonPrimitiveAsInt(configStainless_steel_axe, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configStainless_steel_axe, "rangeBoostOffHand"));
        silver_obsidian_sword = new ToolSwordBase("silver_obsidian_sword", CreativeTabs.COMBAT, MATERIAL_SILVER_OBSIDIAN);
        silver_obsidian_pick = new ToolPickBase("silver_obsidian_pick", CreativeTabs.TOOLS, MATERIAL_SILVER_OBSIDIAN);
        silver_obsidian_shovel = new ToolShovelBase("silver_obsidian_shovel", CreativeTabs.TOOLS, MATERIAL_SILVER_OBSIDIAN);
        silver_obsidian_axe = new ToolAxeBase("silver_obsidian_axe", CreativeTabs.TOOLS, MATERIAL_SILVER_OBSIDIAN, JsonHelper.getJsonPrimitiveAsFloat(configSilver_obsidian_axe, "damage"), JsonHelper.getJsonPrimitiveAsFloat(configSilver_obsidian_axe, "speed"));
        firesword = new ToolElementalSword("firesword", CreativeTabs.COMBAT, MATERIAL_ELEMENTAL);
        icesword = new ToolElementalSword("icesword", CreativeTabs.COMBAT, MATERIAL_ELEMENTAL);
        mastersword1 = new ToolSwordBase("mastersword1", CreativeTabs.COMBAT, MATERIAL_MASTER_BASE);
        mastersword2 = new ToolMasterSword("mastersword2", CreativeTabs.COMBAT, MATERIAL_MASTER);
        // Armour
        nano_helmet = new ArmorNano("nano_helmet", CreativeTabs.COMBAT, MATERIAL_NANO_ARMOR, 1, EntityEquipmentSlot.HEAD);
        nano_chestplate = new ArmorNano("nano_chestplate", CreativeTabs.COMBAT, MATERIAL_NANO_ARMOR, 1, EntityEquipmentSlot.CHEST);
        nano_leggings = new ArmorNano("nano_leggings", CreativeTabs.COMBAT, MATERIAL_NANO_ARMOR, 2, EntityEquipmentSlot.LEGS);
        nano_boots = new ArmorNano("nano_boots", CreativeTabs.COMBAT, MATERIAL_NANO_ARMOR, 1, EntityEquipmentSlot.FEET);
        quantum_helmet = new ArmorQuantum("quantum_helmet", CreativeTabs.COMBAT, MATERIAL_QUANTUM_ARMOR, 1, EntityEquipmentSlot.HEAD, 2500000, 10000);
        quantum_chestplate = new ArmorQuantum("quantum_chestplate", CreativeTabs.COMBAT, MATERIAL_QUANTUM_ARMOR, 1, EntityEquipmentSlot.CHEST, 2500000, 10000);
        quantum_leggings = new ArmorQuantum("quantum_leggings", CreativeTabs.COMBAT, MATERIAL_QUANTUM_ARMOR, 2, EntityEquipmentSlot.LEGS, 2500000, 10000);
        quantum_boots = new ArmorQuantum("quantum_boots", CreativeTabs.COMBAT, MATERIAL_QUANTUM_ARMOR, 1, EntityEquipmentSlot.FEET, 2500000, 10000);
        // Wands
        excavation_wand = new ItemWandBase("excavation_wand", CreativeTabs.MATERIALS, JsonHelper.getJsonPrimitiveAsInt(configExcavation_wand, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configExcavation_wand, "rangeBoostOffHand"));
        wand_1 = new ItemWandBase("wand_1", CreativeTabs.MATERIALS, JsonHelper.getJsonPrimitiveAsInt(configWand_1, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configWand_1, "rangeBoostOffHand"));
        wand_2 = new ItemWandBase("wand_2", CreativeTabs.MATERIALS, JsonHelper.getJsonPrimitiveAsInt(configWand_2, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configWand_2, "rangeBoostOffHand"));
        wand_3 = new ItemWandBase("wand_3", CreativeTabs.MATERIALS, JsonHelper.getJsonPrimitiveAsInt(configWand_3, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configWand_3, "rangeBoostOffHand"));
        wand_4 = new ItemWandBase("wand_4", CreativeTabs.MATERIALS, JsonHelper.getJsonPrimitiveAsInt(configWand_4, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configWand_4, "rangeBoostOffHand"));
    }
}
