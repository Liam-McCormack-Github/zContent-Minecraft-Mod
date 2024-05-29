package com.zcontent.init;

import com.google.gson.JsonObject;
import com.zcontent.config.ConfigLoader;
import com.zcontent.items.*;
import com.zcontent.items.tools.*;
import com.zcontent.util.JsonHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;


public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<Item>();

    //Materials ("material_stainless", 3, 1561, 8.0F, 3.0F, 10);
    public static final ToolMaterial MATERIAL_STAINLESS = EnumHelper.addToolMaterial("material_stainless", 3, 8192, 18.0F, 7.0F, 75);
    public static final ToolMaterial MATERIAL_SILVER_OBSIDIAN = EnumHelper.addToolMaterial("material_silver_obsidian", 3, 1561, 8.0F, 3.0F, 75);
    public static final ToolMaterial MATERIAL_MASTER = EnumHelper.addToolMaterial("material_master", 3, 100, 12.0F, 96.0F, 250);
    public static final ToolMaterial MATERIAL_ELEMENTAL = EnumHelper.addToolMaterial("material_elemental", 3, 10, 12.0F, 7.0F, 25);
    public static final ToolMaterial MATERIAL_MASTER_BASE = EnumHelper.addToolMaterial("material_master_base", 3, 10, 12.0F, 7.0F, 25);

    //Items
    public static final Item machineframe_1 = new ItemBase("machineframe_1", CreativeTabs.MATERIALS);
    public static final Item machineframe_2 = new ItemBase("machineframe_2", CreativeTabs.MATERIALS);
    public static final Item machineframe_3 = new ItemBase("machineframe_3", CreativeTabs.MATERIALS);
    public static final Item machineframe = new ItemBase("machineframe", CreativeTabs.MATERIALS);

    public static final Item red_compound = new ItemBase("red_compound", CreativeTabs.MATERIALS);
    public static final Item blue_compound = new ItemBase("blue_compound", CreativeTabs.MATERIALS);
    public static final Item red_alloy_ingot = new ItemBase("red_alloy_ingot", CreativeTabs.MATERIALS);
    public static final Item blue_alloy_ingot = new ItemBase("blue_alloy_ingot", CreativeTabs.MATERIALS);
    public static final Item purple_alloy_ingot = new ItemBase("purple_alloy_ingot", CreativeTabs.MATERIALS);
    public static final Item graphite_ingot = new ItemBase("graphite_ingot", CreativeTabs.MATERIALS);
    public static final Item zinc_ingot = new ItemBase("zinc_ingot", CreativeTabs.MATERIALS);
    public static final Item manganese_ingot = new ItemBase("manganese_ingot", CreativeTabs.MATERIALS);
    public static final Item chrome_ingot = new ItemBase("chrome_ingot", CreativeTabs.MATERIALS);
    public static final Item brass_ingot = new ItemBase("brass_ingot", CreativeTabs.MATERIALS);
    public static final Item nichrome_ingot = new ItemBase("nichrome_ingot", CreativeTabs.MATERIALS);
    public static final Item galvanized_steel_ingot = new ItemBase("galvanized_steel_ingot", CreativeTabs.MATERIALS);
    public static final Item stainless_steel_ingot = new ItemBase("stainless_steel_ingot", CreativeTabs.MATERIALS);
    public static final Item carbon_ingot = new ItemBase("carbon_ingot", CreativeTabs.MATERIALS);
    public static final Item hot_iron_ingot = new ItemBase("hot_iron_ingot", CreativeTabs.MATERIALS);
    public static final Item cold_iron_ingot = new ItemBase("cold_iron_ingot", CreativeTabs.MATERIALS);
    public static final Item ardite_ingot = new ItemBase("ardite_ingot", CreativeTabs.MATERIALS);
    public static final Item cobalt_ingot = new ItemBase("cobalt_ingot", CreativeTabs.MATERIALS);
    public static final Item manyullyn_ingot = new ItemBase("manyullyn_ingot", CreativeTabs.MATERIALS);
    public static final Item terraglaz_ingot = new ItemBase("terraglaz_ingot", CreativeTabs.MATERIALS);
    public static final Item evil_terraglaz_ingot = new ItemBase("evil_terraglaz_ingot", CreativeTabs.MATERIALS);
    public static final Item redstone_ball = new ItemBase("redstone_ball", CreativeTabs.MATERIALS);
    public static final Item substrate = new ItemBase("substrate", CreativeTabs.MATERIALS);
    public static final Item polyethylene = new ItemBase("polyethylene", CreativeTabs.MATERIALS);
    public static final Item biofuel = new ItemBase("biofuel", CreativeTabs.MATERIALS);
    public static final Item blue_mat_dust = new ItemBase("blue_mat_dust", CreativeTabs.MATERIALS);
    public static final Item purple_mat_dust = new ItemBase("purple_mat_dust", CreativeTabs.MATERIALS);
    public static final Item meteor_dust = new ItemBase("meteor_dust", CreativeTabs.MATERIALS);
    public static final Item et_frag = new ItemBase("et_frag", CreativeTabs.MATERIALS);
    public static final Item shaped_emerald = new ItemBase("shaped_emerald", CreativeTabs.MATERIALS);
    public static final Item sulfur_crystal = new ItemBase("sulfur_crystal", CreativeTabs.MATERIALS);
    public static final Item animal_bones = new ItemBase("animal_bones", CreativeTabs.MATERIALS);
    public static final Item vial = new ItemBase("vial", CreativeTabs.MATERIALS);
    public static final Item angel_wing = new ItemBase("angel_wing", CreativeTabs.MATERIALS);
    public static final Item bat_wing = new ItemBase("bat_wing", CreativeTabs.MATERIALS);
    public static final Item gold_feather = new ItemBase("gold_feather", CreativeTabs.MATERIALS);
    public static final Item wither_bone = new ItemBase("wither_bone", CreativeTabs.MATERIALS);
    public static final Item collector_star = new ItemBase("collector_star", CreativeTabs.MATERIALS);
    public static final Item collector_dark = new ItemBase("collector_dark", CreativeTabs.MATERIALS);
    public static final Item collector_red = new ItemBase("collector_red", CreativeTabs.MATERIALS);
    public static final Item black_gem = new ItemBase("black_gem", CreativeTabs.MATERIALS);
    public static final Item blue_gem = new ItemBase("blue_gem", CreativeTabs.MATERIALS);
    public static final Item green_gem = new ItemBase("green_gem", CreativeTabs.MATERIALS);
    public static final Item indigo_gem = new ItemBase("indigo_gem", CreativeTabs.MATERIALS);
    public static final Item orange_gem = new ItemBase("orange_gem", CreativeTabs.MATERIALS);
    public static final Item red_gem = new ItemBase("red_gem", CreativeTabs.MATERIALS);
    public static final Item violet_gem = new ItemBase("violet_gem", CreativeTabs.MATERIALS);
    public static final Item white_gem = new ItemBase("white_gem", CreativeTabs.MATERIALS);
    public static final Item yellow_gem = new ItemBase("yellow_gem", CreativeTabs.MATERIALS);
    public static final Item wood_plate = new ItemBase("wood_plate", CreativeTabs.MATERIALS);
    public static final Item extended_tier1 = new ItemBase("extended_tier1", CreativeTabs.MATERIALS);
    public static final Item extended_tier2 = new ItemBase("extended_tier2", CreativeTabs.MATERIALS);
    public static final Item extended_tier3 = new ItemBase("extended_tier3", CreativeTabs.MATERIALS);
    public static final Item extended_tier4 = new ItemBase("extended_tier4", CreativeTabs.MATERIALS);
    public static final Item mold = new ItemBase("mold", CreativeTabs.MATERIALS);
    public static final Item mold_proc = new ItemBase("mold_proc", CreativeTabs.MATERIALS);
    public static final Item carbon_fragment = new ItemBase("carbon_fragment", CreativeTabs.MATERIALS);
    public static final Item carbon_mesh = new ItemBase("carbon_mesh", CreativeTabs.MATERIALS);
    public static final Item carbon_panel = new ItemBase("carbon_panel", CreativeTabs.MATERIALS);
    public static final Item ancientdebris_chunk = new ItemBase("ancientdebris_chunk", CreativeTabs.MATERIALS);
    public static final Item andesite_chunk = new ItemBase("andesite_chunk", CreativeTabs.MATERIALS);
    public static final Item basalt_chunk = new ItemBase("basalt_chunk", CreativeTabs.MATERIALS);
    public static final Item clay_chunk = new ItemBase("clay_chunk", CreativeTabs.MATERIALS);
    public static final Item dirt_chunk = new ItemBase("dirt_chunk", CreativeTabs.MATERIALS);
    public static final Item diorite_chunk = new ItemBase("diorite_chunk", CreativeTabs.MATERIALS);
    public static final Item end_chunk = new ItemBase("end_chunk", CreativeTabs.MATERIALS);
    public static final Item granite_chunk = new ItemBase("granite_chunk", CreativeTabs.MATERIALS);
    public static final Item gravel_chunk = new ItemBase("gravel_chunk", CreativeTabs.MATERIALS);
    public static final Item jasper_chunk = new ItemBase("jasper_chunk", CreativeTabs.MATERIALS);
    public static final Item limestone_chunk = new ItemBase("limestone_chunk", CreativeTabs.MATERIALS);
    public static final Item marble_chunk = new ItemBase("marble_chunk", CreativeTabs.MATERIALS);
    public static final Item nether_chunk = new ItemBase("nether_chunk", CreativeTabs.MATERIALS);
    public static final Item obsidian_chunk = new ItemBase("obsidian_chunk", CreativeTabs.MATERIALS);
    public static final Item sand_chunk = new ItemBase("sand_chunk", CreativeTabs.MATERIALS);
    public static final Item slate_chunk = new ItemBase("slate_chunk", CreativeTabs.MATERIALS);
    public static final Item soulsand_chunk = new ItemBase("soulsand_chunk", CreativeTabs.MATERIALS);
    public static final Item soulstone_chunk = new ItemBase("soulstone_chunk", CreativeTabs.MATERIALS);
    public static final Item meteor_chunk = new ItemBase("meteor_chunk", CreativeTabs.MATERIALS);
    public static final Item stone_chunk = new ItemBase("stone_chunk", CreativeTabs.MATERIALS);
    public static final Item combiner_core = new ItemBase("combiner_core", CreativeTabs.MATERIALS);
    public static final Item dissolver_core = new ItemBase("dissolver_core", CreativeTabs.MATERIALS);
    public static final Item enderio_speed_upgrade_base = new ItemBase("enderio_speed_upgrade_base", CreativeTabs.MATERIALS);
    public static final Item silicon_boule = new ItemBase("silicon_boule", CreativeTabs.MATERIALS);
    public static final Item silicon_wafer = new ItemBase("silicon_wafer", CreativeTabs.MATERIALS);
    public static final Item transistor = new ItemBase("transistor", CreativeTabs.MATERIALS);
    public static final Item alu = new ItemBase("alu", CreativeTabs.MATERIALS);
    public static final Item cu = new ItemBase("cu", CreativeTabs.MATERIALS);
    public static final Item rawcircuitboard = new ItemBase("rawcircuitboard", CreativeTabs.MATERIALS);
    public static final Item circuitboard = new ItemBase("circuitboard", CreativeTabs.MATERIALS);
    public static final Item printedcircuitboard = new ItemBase("printedcircuitboard", CreativeTabs.MATERIALS);
    public static final Item card = new ItemBase("card", CreativeTabs.MATERIALS);
    public static final Item proc_base = new ItemBase("proc_base", CreativeTabs.MATERIALS);
    public static final Item proc_raw_1 = new ItemBase("proc_raw_1", CreativeTabs.MATERIALS);
    public static final Item proc_raw_2 = new ItemBase("proc_raw_2", CreativeTabs.MATERIALS);
    public static final Item proc_raw_3 = new ItemBase("proc_raw_3", CreativeTabs.MATERIALS);
    public static final Item proc_1 = new ItemBase("proc_1", CreativeTabs.MATERIALS);
    public static final Item proc_2 = new ItemBase("proc_2", CreativeTabs.MATERIALS);
    public static final Item proc_3 = new ItemBase("proc_3", CreativeTabs.MATERIALS);
    public static final Item chip1 = new ItemBase("chip1", CreativeTabs.MATERIALS);
    public static final Item chip2 = new ItemBase("chip2", CreativeTabs.MATERIALS);
    public static final Item chip3 = new ItemBase("chip3", CreativeTabs.MATERIALS);
    public static final Item componentbus1 = new ItemBase("componentbus1", CreativeTabs.MATERIALS);
    public static final Item componentbus2 = new ItemBase("componentbus2", CreativeTabs.MATERIALS);
    public static final Item componentbus3 = new ItemBase("componentbus3", CreativeTabs.MATERIALS);
    public static final Item cpu1 = new ItemBase("cpu1", CreativeTabs.MATERIALS);
    public static final Item cpu2 = new ItemBase("cpu2", CreativeTabs.MATERIALS);
    public static final Item cpu3 = new ItemBase("cpu3", CreativeTabs.MATERIALS);
    public static final Item datacard1 = new ItemBase("datacard1", CreativeTabs.MATERIALS);
    public static final Item datacard2 = new ItemBase("datacard2", CreativeTabs.MATERIALS);
    public static final Item datacard3 = new ItemBase("datacard3", CreativeTabs.MATERIALS);
    public static final Item graphicscard1 = new ItemBase("graphicscard1", CreativeTabs.MATERIALS);
    public static final Item graphicscard2 = new ItemBase("graphicscard2", CreativeTabs.MATERIALS);
    public static final Item graphicscard3 = new ItemBase("graphicscard3", CreativeTabs.MATERIALS);
    public static final Item hdd1 = new ItemBase("hdd1", CreativeTabs.MATERIALS);
    public static final Item hdd2 = new ItemBase("hdd2", CreativeTabs.MATERIALS);
    public static final Item hdd3 = new ItemBase("hdd3", CreativeTabs.MATERIALS);
    public static final Item ram1 = new ItemBase("ram1", CreativeTabs.MATERIALS);
    public static final Item ram2 = new ItemBase("ram2", CreativeTabs.MATERIALS);
    public static final Item ram3 = new ItemBase("ram3", CreativeTabs.MATERIALS);
    public static final Item server1 = new ItemBase("server1", CreativeTabs.MATERIALS);
    public static final Item server2 = new ItemBase("server2", CreativeTabs.MATERIALS);
    public static final Item server3 = new ItemBase("server3", CreativeTabs.MATERIALS);
    public static final Item terminalserver = new ItemBase("terminalserver", CreativeTabs.MATERIALS);
    public static final Item rf_fe_flux_power_energy = new ItemBase("rf_fe_flux_power_energy", CreativeTabs.MATERIALS);
    public static final Item masterswordblade = new ItemBase("masterswordblade", CreativeTabs.MATERIALS);
    public static final Item masterswordcore = new ItemBase("masterswordcore", CreativeTabs.MATERIALS);
    public static final Item masterswordgrip = new ItemBase("masterswordgrip", CreativeTabs.MATERIALS);


    public static final Item magic = new ItemBad("magic", CreativeTabs.MATERIALS);
    public static final Item enricheduranium = new ItemBad("enricheduranium", CreativeTabs.MATERIALS);

    public static final Item coal_tiny_small = new ItemFuel("coal_tiny_small", CreativeTabs.MATERIALS, 200);
    public static final Item charcoal_tiny_small = new ItemFuel("charcoal_tiny_small", CreativeTabs.MATERIALS, 200);

    public static final Item pill_antidote = new ItemAntidote("pill_antidote", CreativeTabs.FOOD, 0, 0.0f, false);

    public static final Item magic_fertilizer = new ItemFertilizer("magic_fertilizer", CreativeTabs.MATERIALS);
    public static final Item withered_bone_meal = new ItemFertilizerWithered("withered_bone_meal", CreativeTabs.MATERIALS);

    public static final Item charged_gunpowder = new ItemGlowing("charged_gunpowder", CreativeTabs.MATERIALS);
    public static final Item halcyon_shard = new ItemGlowing("halcyon_shard", CreativeTabs.MATERIALS);

    public static final Item luck = new ItemGlowing("luck", CreativeTabs.MATERIALS);
    public static final Item nightvision = new ItemGlowing("nightvision", CreativeTabs.MATERIALS);
    public static final Item regeneration = new ItemGlowing("regeneration", CreativeTabs.MATERIALS);
    public static final Item resistance = new ItemGlowing("resistance", CreativeTabs.MATERIALS);
    public static final Item saturation = new ItemGlowing("saturation", CreativeTabs.MATERIALS);
    public static final Item strength = new ItemGlowing("strength", CreativeTabs.MATERIALS);
    public static final Item waterbreathing = new ItemGlowing("waterbreathing", CreativeTabs.MATERIALS);
    public static final Item absorption = new ItemGlowing("absorption", CreativeTabs.MATERIALS);
    public static final Item antidote = new ItemGlowing("antidote", CreativeTabs.MATERIALS);
    public static final Item fireresistance = new ItemGlowing("fireresistance", CreativeTabs.MATERIALS);
    public static final Item glowing = new ItemGlowing("glowing", CreativeTabs.MATERIALS);
    public static final Item haste = new ItemGlowing("haste", CreativeTabs.MATERIALS);
    public static final Item instanthealth = new ItemGlowing("instanthealth", CreativeTabs.MATERIALS);
    public static final Item invisibility = new ItemGlowing("invisibility", CreativeTabs.MATERIALS);
    public static final Item jumpboost = new ItemGlowing("jumpboost", CreativeTabs.MATERIALS);
    public static final Item levitation = new ItemGlowing("levitation", CreativeTabs.MATERIALS);
    public static final Item speed = new ItemGlowing("speed", CreativeTabs.MATERIALS);
    public static final Item thunder = new ItemGlowing("thunder", CreativeTabs.MATERIALS);
    public static final Item paralysis = new ItemGlowing("paralysis", CreativeTabs.MATERIALS);
    public static final Item instantkill = new ItemGlowing("instantkill", CreativeTabs.MATERIALS);
    public static final Item disarm = new ItemGlowing("disarm", CreativeTabs.MATERIALS);
    public static final Item weaken = new ItemGlowing("weaken", CreativeTabs.MATERIALS);
    public static final Item fertilizer = new ItemGlowing("fertilizer", CreativeTabs.MATERIALS);

    public static final Item repairer = new ItemRepair("repairer", CreativeTabs.MATERIALS);


    public static final ItemSword stainless_steel_sword = new ToolSwordWithAttributes("stainless_steel_sword", CreativeTabs.COMBAT, MATERIAL_STAINLESS, 3, 0);
    public static final ItemPickaxe stainless_steel_pick = new ToolPickWithAttributes("stainless_steel_pick", CreativeTabs.TOOLS, MATERIAL_STAINLESS, 3, 0);
    public static final ItemSpade stainless_steel_shovel = new ToolShovelWithAttributes("stainless_steel_shovel", CreativeTabs.TOOLS, MATERIAL_STAINLESS, 3, 0);
    public static final ItemAxe stainless_steel_axe = new ToolAxeWithAttributes("stainless_steel_axe", CreativeTabs.TOOLS, MATERIAL_STAINLESS, 8.0F, -3.0F, 3, 0);

    public static final ItemSword silver_obsidian_sword = new ToolSwordBase("silver_obsidian_sword", CreativeTabs.COMBAT, MATERIAL_SILVER_OBSIDIAN);
    public static final ItemPickaxe silver_obsidian_pick = new ToolPickBase("silver_obsidian_pick", CreativeTabs.TOOLS, MATERIAL_SILVER_OBSIDIAN);
    public static final ItemSpade silver_obsidian_shovel = new ToolShovelBase("silver_obsidian_shovel", CreativeTabs.TOOLS, MATERIAL_SILVER_OBSIDIAN);
    public static final ItemAxe silver_obsidian_axe = new ToolAxeBase("silver_obsidian_axe", CreativeTabs.TOOLS, MATERIAL_SILVER_OBSIDIAN, 8.0F, -3.0F);

    public static final ItemSword firesword = new ToolElementalSword("firesword", CreativeTabs.COMBAT, MATERIAL_ELEMENTAL);
    public static final ItemSword icesword = new ToolElementalSword("icesword", CreativeTabs.COMBAT, MATERIAL_ELEMENTAL);
    public static final ItemSword mastersword1 = new ToolElementalSword("mastersword1", CreativeTabs.COMBAT, MATERIAL_MASTER_BASE);
    public static final ItemSword mastersword2 = new ToolMasterSword("mastersword2", CreativeTabs.COMBAT, MATERIAL_MASTER);

    private static final JsonObject configWand = JsonHelper.getJsonObject(ConfigLoader.getConfig(), "wands");
    private static final JsonObject configExcavation_wand = JsonHelper.getJsonObject(configWand, "excavation_wand");
    private static final JsonObject configWand_1 = JsonHelper.getJsonObject(configWand, "wand_1");
    private static final JsonObject configWand_2 = JsonHelper.getJsonObject(configWand, "wand_2");
    private static final JsonObject configWand_3 = JsonHelper.getJsonObject(configWand, "wand_3");
    private static final JsonObject configWand_4 = JsonHelper.getJsonObject(configWand, "wand_4");

    public static final Item excavation_wand = new ItemWandBase("excavation_wand", CreativeTabs.MATERIALS, JsonHelper.getJsonPrimitiveAsInt(configExcavation_wand, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configExcavation_wand, "rangeBoostOffHand"));
    public static final Item wand_1 = new ItemWandBase("wand_1", CreativeTabs.MATERIALS, JsonHelper.getJsonPrimitiveAsInt(configWand_1, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configWand_1, "rangeBoostOffHand"));
    public static final Item wand_2 = new ItemWandBase("wand_2", CreativeTabs.MATERIALS, JsonHelper.getJsonPrimitiveAsInt(configWand_2, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configWand_2, "rangeBoostOffHand"));
    public static final Item wand_3 = new ItemWandBase("wand_3", CreativeTabs.MATERIALS, JsonHelper.getJsonPrimitiveAsInt(configWand_3, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configWand_3, "rangeBoostOffHand"));
    public static final Item wand_4 = new ItemWandBase("wand_4", CreativeTabs.MATERIALS, JsonHelper.getJsonPrimitiveAsInt(configWand_4, "rangeBoostMainHand"), JsonHelper.getJsonPrimitiveAsInt(configWand_4, "rangeBoostOffHand"));


}
