package com.zcontent.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;


public class ModOreDictBlocks {

    public static void init() {
        // Block
        OreDictionary.registerOre("oreMeteor", new ItemStack(ModBlocks.meteor_block));
        OreDictionary.registerOre("blockXp", new ItemStack(ModBlocks.xp_block));
        OreDictionary.registerOre("blockEnder", new ItemStack(ModBlocks.ender_block));
        OreDictionary.registerOre("blockOfBones", new ItemStack(ModBlocks.bone_block));
        OreDictionary.registerOre("blockOfBonesWithered", new ItemStack(ModBlocks.wither_bone_block));
        OreDictionary.registerOre("blockFlint", new ItemStack(ModBlocks.flint_block));
        OreDictionary.registerOre("blockGunpowder", new ItemStack(ModBlocks.gunpowder_block));
        OreDictionary.registerOre("blockRottenFlesh", new ItemStack(ModBlocks.rotten_flesh_block));
        OreDictionary.registerOre("oreArdite", new ItemStack(ModBlocks.ardite_ore));
        OreDictionary.registerOre("oreCobalt", new ItemStack(ModBlocks.cobalt_ore));
        OreDictionary.registerOre("oreAluminum", new ItemStack(ModBlocks.aluminum_ore));
        OreDictionary.registerOre("oreAluminium", new ItemStack(ModBlocks.aluminum_ore));
        OreDictionary.registerOre("oreCopper", new ItemStack(ModBlocks.copper_ore));
        OreDictionary.registerOre("oreTin", new ItemStack(ModBlocks.tin_ore));
        OreDictionary.registerOre("oreLead", new ItemStack(ModBlocks.lead_ore));
        OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.silver_ore));
        OreDictionary.registerOre("oreNickel", new ItemStack(ModBlocks.nickel_ore));
        OreDictionary.registerOre("oreTitanium", new ItemStack(ModBlocks.titanium_ore));
        OreDictionary.registerOre("oreUranium", new ItemStack(ModBlocks.uranium_ore));
        OreDictionary.registerOre("orePlatinum", new ItemStack(ModBlocks.platinum_ore));
        OreDictionary.registerOre("oreIridium", new ItemStack(ModBlocks.iridium_ore));
        OreDictionary.registerOre("oreMithril", new ItemStack(ModBlocks.mithril_ore));
        // Items
    }
}