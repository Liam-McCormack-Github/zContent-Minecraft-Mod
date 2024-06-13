package com.zcontent.recipes;


import com.zcontent.Main;
import com.zcontent.init.ModEnchantments;
import com.zcontent.init.ModItems;
import com.zcontent.util.NbtHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.*;

public class RecipeTomeToWand1 extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    private static final Item thisWand = ModItems.wand_1;
    
    
    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        boolean hasTome = false;
        boolean hasWand = false;

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                if (stack.getItem().equals(ModItems.wand_tome) && !hasTome) {
                    ArrayList<String> magicsOnStacks = new ArrayList<>();
                    NbtHelper.getStringsFromCustomNbtArray(magicsOnStacks, stack);
                    for (String nameOfMagic : magicsOnStacks) {
                        if (ModEnchantments.enchantmentMap.containsKey(nameOfMagic)) {
                            hasTome = true;
                        } else {
                            hasTome = false;
                            break;
                        }
                    }
                } else if (stack.getItem().equals(thisWand) && !hasWand) {
                    hasWand = true;
                } else {
                    return false;
                }
            }
        }
        return hasTome && hasWand;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack output = ItemStack.EMPTY;

        ArrayList<String> magicsOnStacks = new ArrayList<>();

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                if (stack.getItem().equals(ModItems.wand_tome)) {
                    NbtHelper.getStringsFromCustomNbtArray(magicsOnStacks, stack);
                } else if (stack.getItem().equals(thisWand)) {
                    NbtHelper.getStringsFromCustomNbtArray(magicsOnStacks, stack);
                }
            }
        }



        if (!magicsOnStacks.isEmpty()) {
            output = thisWand.getDefaultInstance();
            NBTTagCompound nbt = new NBTTagCompound();
            NBTTagList wandMagics = new NBTTagList();
            for (String magic : magicsOnStacks) {
                if (ModEnchantments.enchantmentMap.containsKey(magic)) {
                    wandMagics.appendTag(new NBTTagString(magic));
                }
            }
            nbt.setTag(ModEnchantments.key, wandMagics);
            output.setTagCompound(nbt);

            // Add Enchants
            Map<String, Integer> magics = new HashMap<>();
            for (String element : magicsOnStacks) {
                magics.merge(element, 1, Integer::sum);
            }
            for (Map.Entry<String, Integer> entry : magics.entrySet()) {
                Enchantment enchantment = ModEnchantments.enchantmentMap.get(entry.getKey());
                output.addEnchantment(enchantment, entry.getValue());
            }

        }
        return output;
    }

    @Override
    public boolean canFit(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return thisWand.getDefaultInstance();
    }
}

