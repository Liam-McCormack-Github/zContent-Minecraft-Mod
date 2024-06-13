package com.zcontent.util;


import com.zcontent.init.ModEnchantments;
import com.zcontent.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.ArrayList;
import java.util.Map;

public class NbtHelper {
    public static void setInt(ItemStack stack, String key, int value) {
        validateCompound(stack);
        assert stack.getTagCompound() != null;
        stack.getTagCompound().setInteger(key, value);
    }

    public static int getInt(ItemStack stack, String key) {
        if (stack.hasTagCompound()) {
            assert stack.getTagCompound() != null;
            return stack.getTagCompound().getInteger(key);
        } else {
            return 0;
        }
    }

    public static void validateCompound(ItemStack stack) {
        if (!stack.hasTagCompound()) {
            NBTTagCompound tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }
    }

    public static void getStringsFromCustomNbtArray(ArrayList<String> array, ItemStack stack) {
        NBTTagCompound tag = stack.getTagCompound();
        if (tag != null) {
            if (tag.hasKey(ModEnchantments.key, 9)) {
                NBTTagList wandMagics = stack.getTagCompound().getTagList(ModEnchantments.key, 8);
                for (int i = 0; i < wandMagics.tagCount(); i++) {
                    String nameOfMagic = wandMagics.getStringTagAt(i);
                    if (ModEnchantments.enchantmentMap.containsKey(nameOfMagic)) {
                        array.add(nameOfMagic);
                    }
                }
            }
        }
    }
}
