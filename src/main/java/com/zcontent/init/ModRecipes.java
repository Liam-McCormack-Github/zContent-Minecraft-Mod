package com.zcontent.init;

import com.zcontent.recipes.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

import static com.zcontent.util.Reference.MOD_ID;

public class ModRecipes {

    public static final List<IRecipe> RECIPES = new ArrayList<>();

    public static void init() {
        IRecipe magic_to_tome = new RecipeMagicToTome().setRegistryName(new ResourceLocation(MOD_ID, "magic_to_tome_out_with_modified_nbt"));
        RECIPES.add(magic_to_tome);

        IRecipe tome_to_wand1 = new RecipeTomeToEnchantableWand1().setRegistryName(new ResourceLocation(MOD_ID, "tome_to_wand1_out_with_modified_nbt"));
        RECIPES.add(tome_to_wand1);

        IRecipe tome_to_wand2 = new RecipeTomeToEnchantableWand2().setRegistryName(new ResourceLocation(MOD_ID, "tome_to_wand2_out_with_modified_nbt"));
        RECIPES.add(tome_to_wand2);

        IRecipe tome_to_wand3 = new RecipeTomeToEnchantableWand3().setRegistryName(new ResourceLocation(MOD_ID, "tome_to_wand3_out_with_modified_nbt"));
        RECIPES.add(tome_to_wand3);

        IRecipe tome_to_wand4 = new RecipeTomeToEnchantableWand4().setRegistryName(new ResourceLocation(MOD_ID, "tome_to_wand4_out_with_modified_nbt"));
        RECIPES.add(tome_to_wand4);

    }

    public static void initSmelting() {
        /*
        for (ItemStack ore : OreDictionary.getOres("ingotArdite")) {
            if (ore != null) {
                if (ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE) {
                    GameRegistry.addSmelting(ModBlocks.ardite_ore, ore, 1.0F);
                }
            }
        }
        */
        addSmeltingRecipe("ingotArdite", ModBlocks.ardite_ore);
        addSmeltingRecipe("ingotCobalt", ModBlocks.cobalt_ore);
        addSmeltingRecipe("ingotCopper", ModBlocks.copper_ore);
        addSmeltingRecipe("ingotTin", ModBlocks.tin_ore);
        addSmeltingRecipe("ingotAluminum", ModBlocks.aluminum_ore);
        addSmeltingRecipe("ingotLead", ModBlocks.lead_ore);
        addSmeltingRecipe("ingotSilver", ModBlocks.silver_ore);
        addSmeltingRecipe("ingotNickel", ModBlocks.nickel_ore);
        addSmeltingRecipe("ingotTitanium", ModBlocks.titanium_ore);
        addSmeltingRecipe("ingotUranium", ModBlocks.uranium_ore);
        addSmeltingRecipe("ingotPlatinum", ModBlocks.platinum_ore);
        addSmeltingRecipe("ingotIridium", ModBlocks.iridium_ore);
        addSmeltingRecipe("ingotMithril", ModBlocks.mithril_ore);
    }


    private static void addSmeltingRecipe(String oreName, Block oreBlock) {
        for (ItemStack ore : OreDictionary.getOres(oreName)) {
            if (ore != null && (ore.getItemDamage() != -1 || ore.getItemDamage() != OreDictionary.WILDCARD_VALUE)) {
                GameRegistry.addSmelting(oreBlock, ore, 1.0F);
            }
        }
    }
}