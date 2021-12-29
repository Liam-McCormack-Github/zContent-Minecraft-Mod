package com.thewawpro.zcontent.util.handlers;

import com.thewawpro.zcontent.init.ModBlocks;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.oredict.OreDictionary;

@EventBusSubscriber

public class OreDictionaryHandlerBlocks {

	public static void registerOreDictionary( ) {
		OreDictionary.registerOre("oreMeteor", ModBlocks.meteor_block);
		OreDictionary.registerOre("blockXp", ModBlocks.xp_block);
		OreDictionary.registerOre("blockEnder", ModBlocks.ender_block);
		OreDictionary.registerOre("blockOfBones", ModBlocks.bone_block);
		OreDictionary.registerOre("blockOfBonesWithered", ModBlocks.wither_bone_block);
		OreDictionary.registerOre("blockFlint", ModBlocks.flint_block);
		OreDictionary.registerOre("blockGunpowder", ModBlocks.gunpowder_block);
		OreDictionary.registerOre("blockRottenFlesh", ModBlocks.rotten_flesh_block);
		OreDictionary.registerOre("oreArdite", ModBlocks.ardite_ore);
		OreDictionary.registerOre("oreCobalt", ModBlocks.cobalt_ore);
		OreDictionary.registerOre("oreAluminum", ModBlocks.aluminum_ore);
		OreDictionary.registerOre("oreCopper", ModBlocks.copper_ore);
		OreDictionary.registerOre("oreTin", ModBlocks.tin_ore);
		OreDictionary.registerOre("oreLead", ModBlocks.lead_ore);
		OreDictionary.registerOre("oreSilver", ModBlocks.silver_ore);
		OreDictionary.registerOre("oreNickel", ModBlocks.nickel_ore);
		OreDictionary.registerOre("oreTitanium", ModBlocks.titanium_ore);
		OreDictionary.registerOre("oreUranium", ModBlocks.uranium_ore);
		OreDictionary.registerOre("orePlatinum", ModBlocks.platinum_ore);
		OreDictionary.registerOre("oreIridium", ModBlocks.iridium_ore);
		OreDictionary.registerOre("oreMithril", ModBlocks.mithril_ore);
	}
}