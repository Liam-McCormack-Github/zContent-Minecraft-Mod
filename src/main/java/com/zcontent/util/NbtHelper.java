package com.zcontent.util;

import com.zcontent.init.ModEnchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.HashMap;
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

    public static Map<String, Integer> getMagicCounts(ItemStack stack) {
        Map<String, Integer> magicCounts = new HashMap<>();
        if (stack.hasTagCompound()) {
            NBTTagCompound baseTag = stack.getTagCompound();
            assert baseTag != null;

            if (baseTag.hasKey(ModEnchantments.key, Constants.NBT.TAG_COMPOUND)) {
                NBTTagCompound magicsTag = baseTag.getCompoundTag(ModEnchantments.key);
                for (String magicName : magicsTag.getKeySet()) {
                    if (ModEnchantments.enchantmentMap.containsKey(magicName) && magicsTag.hasKey(magicName, Constants.NBT.TAG_INT)) {
                        magicCounts.put(magicName, magicsTag.getInteger(magicName));
                    }
                }
            }
        }
        return magicCounts;
    }

    public static void setMagicCounts(ItemStack stack, Map<String, Integer> magicCounts) {
        validateCompound(stack);
        NBTTagCompound baseTag = stack.getTagCompound();
        assert baseTag != null;

        NBTTagCompound magicsTag = new NBTTagCompound();

        for (Map.Entry<String, Integer> entry : magicCounts.entrySet()) {
            String magicName = entry.getKey();
            Integer count = entry.getValue();
            if (ModEnchantments.enchantmentMap.containsKey(magicName) && count != null && count > 0) {
                magicsTag.setInteger(magicName, count);
            }
        }

        baseTag.setTag(ModEnchantments.key, magicsTag);
    }

    /**
     * @deprecated Reads magics from the old NBTTagList format. Use getMagicCounts for the new format.
     */
    @Deprecated
    public static void getStringsFromCustomNbtArray(ArrayList<String> array, ItemStack stack) {
        NBTTagCompound tag = stack.getTagCompound();
        if (tag != null) {
            if (tag.hasKey(ModEnchantments.key, Constants.NBT.TAG_LIST)) {
                NBTTagList wandMagics = tag.getTagList(ModEnchantments.key, Constants.NBT.TAG_STRING);
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