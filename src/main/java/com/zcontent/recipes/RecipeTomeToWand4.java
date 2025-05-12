package com.zcontent.recipes;

import com.zcontent.init.ModEnchantments;
import com.zcontent.init.ModItems;
import com.zcontent.util.NbtHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.HashMap;
import java.util.Map;

public class RecipeTomeToWand4 extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    private static final Item thisWand = ModItems.wand_4;

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        boolean hasTome = false;
        boolean hasWand = false;
        int itemCount = 0;

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                itemCount++;
                if (stack.getItem().equals(ModItems.wand_tome)) {
                    if (!hasTome) {
                        Map<String, Integer> tomeMagics = NbtHelper.getMagicCounts(stack);
                        if (!tomeMagics.isEmpty()) { // Or check specifically for the NBT tag existence
                            hasTome = true;
                        } else {
                            return false; // Tome doesn't have expected NBT
                        }
                    } else {
                        return false; // Found a second tome
                    }
                } else if (stack.getItem().equals(thisWand)) {
                    if (!hasWand) {
                        hasWand = true;
                    } else {
                        return false; // Found a second wand
                    }
                } else {
                    return false; // Found an invalid item
                }
            }
        }
        return hasTome && hasWand && itemCount == 2;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack output = ItemStack.EMPTY;
        Map<String, Integer> combinedMagics = new HashMap<>();

        ItemStack wandInput = ItemStack.EMPTY;

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                Map<String, Integer> itemMagics = NbtHelper.getMagicCounts(stack);

                for (Map.Entry<String, Integer> entry : itemMagics.entrySet()) {
                    combinedMagics.merge(entry.getKey(), entry.getValue(), Integer::sum);
                }

                if(stack.getItem().equals(thisWand)) {
                    wandInput = stack;
                }
            }
        }

        if (!combinedMagics.isEmpty()) {
            output = thisWand.getDefaultInstance();
            /*
            if (wandInput.hasTagCompound()) {
                NBTTagCompound existingNbt = wandInput.getTagCompound().copy();
                existingNbt.removeTag(ModEnchantments.key); // Remove old/conflicting magic tag before merging
                if (!existingNbt.isEmpty()) {
                    output.setTagCompound(existingNbt);
                }
            }
            */
            NbtHelper.setMagicCounts(output, combinedMagics);
            for (Map.Entry<String, Integer> entry : combinedMagics.entrySet()) {
                Enchantment enchantment = ModEnchantments.enchantmentMap.get(entry.getKey());
                int level = entry.getValue();
                if (enchantment != null && level > 0) {
                    output.addEnchantment(enchantment, level);
                }
            }
        }

        return output; // Return the new wand or ItemStack.EMPTY
    }

    @Override
    public boolean canFit(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public ItemStack getRecipeOutput() {
        // Placeholder output
        return thisWand.getDefaultInstance();
    }
}