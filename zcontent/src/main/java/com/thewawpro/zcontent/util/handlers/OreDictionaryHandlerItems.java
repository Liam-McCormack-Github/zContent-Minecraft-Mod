package com.thewawpro.zcontent.util.handlers;

import com.thewawpro.zcontent.init.ModItems;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.oredict.OreDictionary;

@EventBusSubscriber

public class OreDictionaryHandlerItems {

	public static void registerOreDictionary( ) {
		OreDictionary.registerOre("gemCrystalBlack", ModItems.black_gem);
		OreDictionary.registerOre("gemCrystalBlue", ModItems.blue_gem);
		OreDictionary.registerOre("gemCrystalGreen", ModItems.green_gem);
		OreDictionary.registerOre("gemCrystalIndigo", ModItems.indigo_gem);
		OreDictionary.registerOre("gemCrystalOrange", ModItems.orange_gem);
		OreDictionary.registerOre("gemCrystalRed", ModItems.red_gem);
		OreDictionary.registerOre("gemCrystalViolet", ModItems.violet_gem);
		OreDictionary.registerOre("gemCrystalWhite", ModItems.white_gem);
		OreDictionary.registerOre("gemCrystalYellow", ModItems.yellow_gem);
		OreDictionary.registerOre("ingotEvilTerraglaz", ModItems.evil_terraglaz_ingot);
		OreDictionary.registerOre("ingotTerraglaz", ModItems.terraglaz_ingot);
		OreDictionary.registerOre("ingotGraphite", ModItems.graphite_ingot);
		OreDictionary.registerOre("ingotCarbon", ModItems.carbon_ingot);
		OreDictionary.registerOre("ingotElectroFluxAlloy", ModItems.purple_alloy_ingot);
		OreDictionary.registerOre("ingotElectrotineAlloy", ModItems.blue_alloy_ingot);
		OreDictionary.registerOre("ingotFluxAlloy", ModItems.red_alloy_ingot);
		OreDictionary.registerOre("ingotColdiron", ModItems.cold_iron_ingot);
		OreDictionary.registerOre("ingotCobalt", ModItems.cobalt_ingot);
		OreDictionary.registerOre("ingotArdite", ModItems.ardite_ingot);
		OreDictionary.registerOre("ingotBrass", ModItems.brass_ingot);
		OreDictionary.registerOre("ingotManyullyn", ModItems.manyullyn_ingot);
		OreDictionary.registerOre("ingotNichrome", ModItems.nichrome_ingot);
		OreDictionary.registerOre("ingotGalvanizedsteel", ModItems.galvanized_steel_ingot);
		OreDictionary.registerOre("ingotStainlesssteel", ModItems.stainless_steel_ingot);
		OreDictionary.registerOre("dustElectroFlux", ModItems.purple_mat_dust);
		OreDictionary.registerOre("dustElectrotine", ModItems.blue_mat_dust);
		OreDictionary.registerOre("plateWood", ModItems.wood_plate);
		OreDictionary.registerOre("matChunkAncientdebris", ModItems.ancientdebris_chunk);
		OreDictionary.registerOre("matChunkAndesite", ModItems.andesite_chunk);
		OreDictionary.registerOre("matChunkBasalt", ModItems.basalt_chunk);
		OreDictionary.registerOre("matChunkClay", ModItems.clay_chunk);
		OreDictionary.registerOre("matChunkDirt", ModItems.dirt_chunk);
		OreDictionary.registerOre("matChunkDiorite", ModItems.diorite_chunk);
		OreDictionary.registerOre("matChunkEndStone", ModItems.end_chunk);
		OreDictionary.registerOre("matChunkGranite", ModItems.granite_chunk);
		OreDictionary.registerOre("matChunkLimestone", ModItems.limestone_chunk);
		OreDictionary.registerOre("matChunkMarble", ModItems.marble_chunk);
		OreDictionary.registerOre("matChunkNetherrack", ModItems.nether_chunk);
		OreDictionary.registerOre("matChunkSand", ModItems.sand_chunk);
		OreDictionary.registerOre("matChunkMeteor", ModItems.meteor_chunk);
		OreDictionary.registerOre("matChunkStone", ModItems.stone_chunk);
		OreDictionary.registerOre("matChunkGravel", ModItems.gravel_chunk);
		OreDictionary.registerOre("matChunkJasper", ModItems.jasper_chunk);
		OreDictionary.registerOre("matChunkSlate", ModItems.slate_chunk);
		OreDictionary.registerOre("matChunkSoulStone", ModItems.soulstone_chunk);
		OreDictionary.registerOre("matChunkSoulSand", ModItems.soulsand_chunk);
		OreDictionary.registerOre("matChunkObsidian", ModItems.obsidian_chunk);
		OreDictionary.registerOre("dustMeteor", ModItems.meteor_dust);
		OreDictionary.registerOre("crystalSulfuric", ModItems.sulfur_crystal);
		OreDictionary.registerOre("boneWithered", ModItems.wither_bone);
	}
}