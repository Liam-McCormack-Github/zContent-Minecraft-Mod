package com.zcontent.recipes;


import com.zcontent.init.ModEnchantments;
import com.zcontent.init.ModItems;
import com.zcontent.util.NbtHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RecipeMagicToTome extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        boolean hasMagic = false;
        boolean hasBook = false;

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                if (stack.getItem().equals(ModItems.magic)) {
                    NBTTagCompound tag = stack.getTagCompound();
                    if (tag != null) {
                        if (tag.hasKey("display")) {
                            String displayName = tag.getCompoundTag("display").getString("Name");
                            if (ModEnchantments.enchantmentMap.containsKey(displayName)) {
                                hasMagic = true;
                            } else {
                                hasMagic = false;
                                break;
                            }
                        }
                    }
                } else if (stack.getItem().equals(ModItems.wand_tome) && !hasBook) {
                    hasBook = true;
                } else {
                    return false;
                }
            }
        }
        return hasMagic && hasBook;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack output = ItemStack.EMPTY;

        ArrayList<String> magicsOnStacks = new ArrayList<>();

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                if (stack.getItem().equals(ModItems.magic)) {
                    NBTTagCompound tag = stack.getTagCompound();
                    if (tag != null) {
                        if (tag.hasKey("display")) {
                            String displayName = stack.getTagCompound().getCompoundTag("display").getString("Name");
                            if (ModEnchantments.enchantmentMap.containsKey(displayName)) {
                                magicsOnStacks.add(displayName);
                            }
                        }
                    }
                }
                else if (stack.getItem().equals(ModItems.wand_tome)) {
                    NbtHelper.getStringsFromCustomNbtArray(magicsOnStacks, stack);
                }
            }
        }

        if (!magicsOnStacks.isEmpty()) {
            output = ModItems.wand_tome.getDefaultInstance();
            NBTTagCompound nbt = new NBTTagCompound();
            NBTTagList wandMagics = new NBTTagList();
            for (String magic : magicsOnStacks) {
                if (ModEnchantments.enchantmentMap.containsKey(magic)) {
                    wandMagics.appendTag(new NBTTagString(magic));
                }
            }
            nbt.setTag(ModEnchantments.key, wandMagics);
            output.setTagCompound(nbt);
        }

        /*
        Map<String, Integer> magics = new HashMap<>();

        for (String element : magicsOnStacks) {
            magics.merge(element, 1, Integer::sum);
        }
        */

        return output;
    }



    @Override
    public boolean canFit(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return ModItems.wand_tome.getDefaultInstance();
    }
}

