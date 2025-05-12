package com.zcontent.recipes;

import com.zcontent.init.ModEnchantments;
import com.zcontent.init.ModItems;
import com.zcontent.util.NbtHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.HashMap;
import java.util.Map;

public class RecipeMagicToTome extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        boolean hasValidMagicItem = false;
        boolean hasTome = false;
        int itemCount = 0;

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                itemCount++;
                if (stack.getItem().equals(ModItems.magic)) {
                    NBTTagCompound tag = stack.getTagCompound();
                    if (tag != null && tag.hasKey("display", 10)) { // 10 = TAG_Compound
                        String displayName = tag.getCompoundTag("display").getString("Name");
                        if (ModEnchantments.enchantmentMap.containsKey(displayName)) {
                            if (!hasValidMagicItem) {
                                hasValidMagicItem = true;
                            } else {
                                return false; // Only allow one magic item per craft
                            }
                        } else {
                            return false; // Invalid magic item name
                        }
                    } else {
                        return false; // Magic item lacks required display NBT
                    }
                } else if (stack.getItem().equals(ModItems.wand_tome)) {
                    if (!hasTome) {
                        hasTome = true;
                    } else {
                        return false; // Only allow one tome per craft
                    }
                } else {
                    return false; // Found an invalid item in the grid
                }
            }
        }
        return hasValidMagicItem && hasTome && itemCount == 2;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack output = ItemStack.EMPTY;
        Map<String, Integer> combinedMagics = new HashMap<>();
        String magicToAdd = null;

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                if (stack.getItem().equals(ModItems.magic)) {
                    NBTTagCompound tag = stack.getTagCompound();
                    if (tag != null && tag.hasKey("display", 10)) {
                        String displayName = tag.getCompoundTag("display").getString("Name");
                        if (ModEnchantments.enchantmentMap.containsKey(displayName)) {
                            magicToAdd = displayName;
                        }
                    }
                } else if (stack.getItem().equals(ModItems.wand_tome)) {
                    combinedMagics.putAll(NbtHelper.getMagicCounts(stack));
                }
            }
        }

        if (magicToAdd != null) {
            combinedMagics.merge(magicToAdd, 1, Integer::sum);
            output = ModItems.wand_tome.getDefaultInstance();
            NbtHelper.setMagicCounts(output, combinedMagics);
        }

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