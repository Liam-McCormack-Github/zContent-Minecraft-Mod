package com.zcontent.util;


import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

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
}
