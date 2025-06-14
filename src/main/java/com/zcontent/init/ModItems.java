package com.zcontent.init;

import com.zcontent.config.Config;
import com.zcontent.items.*;
import com.zcontent.items.armor.ArmorNano;
import com.zcontent.items.armor.ArmorQuantum;
import com.zcontent.items.tools.*;
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

    public static ToolMaterial MATERIAL_STAINLESS, MATERIAL_SILVER_OBSIDIAN, MATERIAL_MASTER, MATERIAL_ELEMENTAL, MATERIAL_MASTER_BASE;

    public static ArmorMaterial MATERIAL_NANO_ARMOR, MATERIAL_QUANTUM_ARMOR;

    public static Item machineframe_1, machineframe_2, machineframe_3, machineframe, red_compound, blue_compound, red_alloy_ingot, blue_alloy_ingot, purple_alloy_ingot, graphite_ingot, zinc_ingot, manganese_ingot, chrome_ingot, brass_ingot, nichrome_ingot, galvanized_steel_ingot, stainless_steel_ingot, carbon_ingot, hot_iron_ingot, cold_iron_ingot, ardite_ingot, cobalt_ingot, manyullyn_ingot, terraglaz_ingot, evil_terraglaz_ingot, redstone_ball, substrate, polyethylene, biofuel, blue_mat_dust, purple_mat_dust, meteor_dust, et_frag, shaped_emerald, sulfur_crystal, animal_bones, vial, angel_wing, bat_wing, gold_feather, wither_bone, collector_star, collector_dark, collector_red, black_gem, blue_gem, green_gem, indigo_gem, orange_gem, red_gem, violet_gem, white_gem, yellow_gem, wood_plate, extended_tier1, extended_tier2, extended_tier3, extended_tier4, mold, mold_proc, coal_ball, compact_coal_ball, coal_chunk, carbon_fragment, carbon_mesh, carbon_panel, ancientdebris_chunk, andesite_chunk, basalt_chunk, clay_chunk, dirt_chunk, diorite_chunk, end_chunk, granite_chunk, gravel_chunk, jasper_chunk, limestone_chunk, marble_chunk, nether_chunk, obsidian_chunk, sand_chunk, slate_chunk, soulsand_chunk, soulstone_chunk, meteor_chunk, stone_chunk, combiner_core, dissolver_core, enderio_speed_upgrade_base, silicon_boule, silicon_wafer, transistor, alu, cu, rawcircuitboard, circuitboard, printedcircuitboard, card, proc_base, proc_raw_1, proc_raw_2, proc_raw_3, proc_1, proc_2, proc_3, chip1, chip2, chip3, componentbus1, componentbus2, componentbus3, cpu1, cpu2, cpu3, datacard1, datacard2, datacard3, graphicscard1, graphicscard2, graphicscard3, hdd1, hdd2, hdd3, ram1, ram2, ram3, server1, server2, server3, terminalserver, rf_fe_flux_power_energy, masterswordblade, masterswordcore, masterswordgrip, magic, enricheduranium, coal_tiny_small, charcoal_tiny_small, pill_antidote, magic_fertilizer, withered_bone_meal, charged_gunpowder, halcyon_shard, wand_tome, luck, nightvision, regeneration, resistance, saturation, strength, waterbreathing, absorption, antidote, fireresistance, glowing, haste, instanthealth, invisibility, jumpboost, levitation, speed, thunder, paralysis, instantkill, disarm, weaken, fertilizer, repairer, structure_compass, excavation_wand, blink_wand, displace_wand, enchantable_wand_1, enchantable_wand_2, enchantable_wand_3, enchantable_wand_4;

    public static ItemSword stainless_steel_sword, firesword, icesword, mastersword1, mastersword2, silver_obsidian_sword;

    public static ItemSpade stainless_steel_shovel, silver_obsidian_shovel;

    public static ItemPickaxe stainless_steel_pick, silver_obsidian_pick;

    public static ItemAxe stainless_steel_axe, silver_obsidian_axe;

    public static ItemArmor nano_helmet, nano_chestplate, nano_leggings, nano_boots, quantum_helmet, quantum_chestplate, quantum_leggings, quantum_boots;


    public static void init() {
        // Tools
        MATERIAL_STAINLESS = EnumHelper.addToolMaterial("material_stainless", Config.MaterialStainlessHarvestLevel, Config.MaterialStainlessMaxUses, Config.MaterialStainlessEfficiency, Config.MaterialStainlessDamage, Config.MaterialStainlessEnchantability);
        MATERIAL_SILVER_OBSIDIAN = EnumHelper.addToolMaterial("material_silver_obsidian", Config.MaterialSilverObsidianHarvestLevel, Config.MaterialSilverObsidianMaxUses, Config.MaterialSilverObsidianEfficiency, Config.MaterialSilverObsidianDamage, Config.MaterialSilverObsidianEnchantability);
        MATERIAL_MASTER = EnumHelper.addToolMaterial("material_master", Config.MaterialMasterHarvestLevel, Config.MaterialMasterMaxUses, Config.MaterialMasterEfficiency, Config.MaterialMasterDamage, Config.MaterialMasterEnchantability);
        MATERIAL_ELEMENTAL = EnumHelper.addToolMaterial("material_elemental", Config.MaterialElementalHarvestLevel, Config.MaterialElementalMaxUses, Config.MaterialElementalEfficiency, Config.MaterialElementalDamage, Config.MaterialElementalEnchantability);
        MATERIAL_MASTER_BASE = EnumHelper.addToolMaterial("material_master_base", Config.MaterialMasterBaseHarvestLevel, Config.MaterialMasterBaseMaxUses, Config.MaterialMasterBaseEfficiency, Config.MaterialMasterBaseDamage, Config.MaterialMasterBaseEnchantability);

        // Armour
        MATERIAL_NANO_ARMOR = EnumHelper.addArmorMaterial("material_nano_armour", Reference.MOD_ID + ":nano", Config.MaterialNanoArmorDurability, Config.MaterialNanoArmorReductionAmounts, Config.MaterialNanoArmorEnchantability, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.MaterialNanoArmorToughness);
        MATERIAL_QUANTUM_ARMOR = EnumHelper.addArmorMaterial("material_quantum_armour", Reference.MOD_ID + ":quantum", Config.MaterialQuantumArmorDurability, Config.MaterialQuantumArmorReductionAmounts, Config.MaterialQuantumArmorEnchantability, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.MaterialQuantumArmorToughness);
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
        magic = new ItemBad("magic", CreativeTabs.MATERIALS, "Rename this in an Anvil, to the name of a Magic Enchant.\nCombine with a Wand Tome in a Crafting Table.\nThis will add that Magic Enchant the Wand Tome.\nFinally Combine the Wand Tome with a Wand in a Crafting Table.\nThe Wand will now have that Magic Enchantment applied.").setMaxStackSize(1);
        enricheduranium = new ItemBad("enricheduranium", CreativeTabs.MATERIALS, "Radioactive");
        // Fuels
        coal_tiny_small = new ItemFuel("coal_tiny_small", CreativeTabs.MATERIALS, Config.TinyCoalBurnTime);
        charcoal_tiny_small = new ItemFuel("charcoal_tiny_small", CreativeTabs.MATERIALS, Config.TinyCharcoalBurnTime);
        // Food
        pill_antidote = new ItemAntidote("pill_antidote", CreativeTabs.FOOD, 0, 0.0f, false);
        // Fertilizer
        magic_fertilizer = new ItemFertilizer("magic_fertilizer", CreativeTabs.MATERIALS);
        withered_bone_meal = new ItemFertilizerWithered("withered_bone_meal", CreativeTabs.MATERIALS);
        // Shiny base
        charged_gunpowder = new ItemGlowing("charged_gunpowder", CreativeTabs.MATERIALS);
        halcyon_shard = new ItemGlowing("halcyon_shard", CreativeTabs.MATERIALS);
        // Shiny enchant tomes
        wand_tome = new ItemWandTome("wand_tome", CreativeTabs.MATERIALS).setMaxStackSize(1);
        // Repair gem
        repairer = new ItemRepair("repairer", CreativeTabs.MATERIALS);
        // Structure Compass
        structure_compass = new ItemStructureCompass("structure_compass", CreativeTabs.TOOLS);
        // Tools
        stainless_steel_sword = new ToolSwordWithAttributes("stainless_steel_sword", CreativeTabs.COMBAT, MATERIAL_STAINLESS, Config.StainlessSteelSwordRangeBoostMainHand, Config.StainlessSteelSwordRangeBoostOffHand);
        stainless_steel_pick = new ToolPickWithAttributes("stainless_steel_pick", CreativeTabs.TOOLS, MATERIAL_STAINLESS, Config.StainlessSteelPickRangeBoostMainHand, Config.StainlessSteelPickRangeBoostOffHand);
        stainless_steel_shovel = new ToolShovelWithAttributes("stainless_steel_shovel", CreativeTabs.TOOLS, MATERIAL_STAINLESS, Config.StainlessSteelShovelRangeBoostMainHand, Config.StainlessSteelShovelRangeBoostOffHand);
        stainless_steel_axe = new ToolAxeWithAttributes("stainless_steel_axe", CreativeTabs.TOOLS, MATERIAL_STAINLESS, Config.StainlessSteelAxeRangeBoostMainHand, Config.StainlessSteelAxeRangeBoostOffHand, Config.StainlessSteelAxeDamage, Config.StainlessSteelAxeSpeed);
        silver_obsidian_sword = new ToolSwordBase("silver_obsidian_sword", CreativeTabs.COMBAT, MATERIAL_SILVER_OBSIDIAN);
        silver_obsidian_pick = new ToolPickBase("silver_obsidian_pick", CreativeTabs.TOOLS, MATERIAL_SILVER_OBSIDIAN);
        silver_obsidian_shovel = new ToolShovelBase("silver_obsidian_shovel", CreativeTabs.TOOLS, MATERIAL_SILVER_OBSIDIAN);
        silver_obsidian_axe = new ToolAxeBase("silver_obsidian_axe", CreativeTabs.TOOLS, MATERIAL_SILVER_OBSIDIAN, Config.SilverObsidianAxeDamage, Config.SilverObsidianAxeSpeed);
        firesword = new ToolElementalSword("firesword", CreativeTabs.COMBAT, MATERIAL_ELEMENTAL);
        icesword = new ToolElementalSword("icesword", CreativeTabs.COMBAT, MATERIAL_ELEMENTAL);
        mastersword1 = new ToolSwordBase("mastersword1", CreativeTabs.COMBAT, MATERIAL_MASTER_BASE);
        mastersword2 = new ToolMasterSword("mastersword2", CreativeTabs.COMBAT, MATERIAL_MASTER);
        // Armour
        nano_helmet = new ArmorNano("nano_helmet", CreativeTabs.COMBAT, MATERIAL_NANO_ARMOR, 1, EntityEquipmentSlot.HEAD);
        nano_chestplate = new ArmorNano("nano_chestplate", CreativeTabs.COMBAT, MATERIAL_NANO_ARMOR, 1, EntityEquipmentSlot.CHEST);
        nano_leggings = new ArmorNano("nano_leggings", CreativeTabs.COMBAT, MATERIAL_NANO_ARMOR, 2, EntityEquipmentSlot.LEGS);
        nano_boots = new ArmorNano("nano_boots", CreativeTabs.COMBAT, MATERIAL_NANO_ARMOR, 1, EntityEquipmentSlot.FEET);
        quantum_helmet = new ArmorQuantum("quantum_helmet", CreativeTabs.COMBAT, MATERIAL_QUANTUM_ARMOR, 1, EntityEquipmentSlot.HEAD, Config.QuantumHelmetEnergyCapacity, Config.QuantumHelmetEnergyCost);
        quantum_chestplate = new ArmorQuantum("quantum_chestplate", CreativeTabs.COMBAT, MATERIAL_QUANTUM_ARMOR, 1, EntityEquipmentSlot.CHEST, Config.QuantumChestplateEnergyCapacity, Config.QuantumChestplateEnergyCost);
        quantum_leggings = new ArmorQuantum("quantum_leggings", CreativeTabs.COMBAT, MATERIAL_QUANTUM_ARMOR, 2, EntityEquipmentSlot.LEGS, Config.QuantumLeggingsEnergyCapacity, Config.QuantumLeggingsEnergyCost);
        quantum_boots = new ArmorQuantum("quantum_boots", CreativeTabs.COMBAT, MATERIAL_QUANTUM_ARMOR, 1, EntityEquipmentSlot.FEET, Config.QuantumBootsEnergyCapacity, Config.QuantumBootsEnergyCost);
        // Wands
        excavation_wand = new ItemWandBase("excavation_wand", CreativeTabs.TOOLS, Config.ExcavationWandRangeBoostMainHand, Config.ExcavationWandRangeBoostOffHand);
        blink_wand = new ItemWandBlink("blink_wand", CreativeTabs.TOOLS, Config.BlinkWandRangeBoostMainHand, Config.BlinkWandRangeBoostOffHand);
        displace_wand = new ItemWandDisplace("displace_wand", CreativeTabs.TOOLS, Config.DisplaceWandRangeBoostMainHand, Config.DisplaceWandRangeBoostOffHand);
        enchantable_wand_1 = new ItemWandEnchantable("enchantable_wand_1", CreativeTabs.TOOLS, Config.EnchantableWand1RangeBoostMainHand, Config.EnchantableWand1RangeBoostOffHand);
        enchantable_wand_2 = new ItemWandEnchantable("enchantable_wand_2", CreativeTabs.TOOLS, Config.EnchantableWand2RangeBoostMainHand, Config.EnchantableWand2RangeBoostOffHand);
        enchantable_wand_3 = new ItemWandEnchantable("enchantable_wand_3", CreativeTabs.TOOLS, Config.EnchantableWand3RangeBoostMainHand, Config.EnchantableWand3RangeBoostOffHand);
        enchantable_wand_4 = new ItemWandEnchantable("enchantable_wand_4", CreativeTabs.TOOLS, Config.EnchantableWand4RangeBoostMainHand, Config.EnchantableWand4RangeBoostOffHand);
    }
}
