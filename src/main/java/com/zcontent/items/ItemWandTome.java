package com.zcontent.items;

import com.zcontent.init.ModEnchantments;
import com.zcontent.util.IHasModel;
import com.zcontent.util.NbtHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWandTome extends ItemBase implements IHasModel {

    public ItemWandTome(String name, CreativeTabs creativeTab) {
        super(name, creativeTab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        // Check if the stack has a tag compound and if it contains the ModEnchantments.key tag
        if (stack.hasTagCompound() && stack.getTagCompound().hasKey(ModEnchantments.key, 9)) { // 9 is the NBT type for lists
            NBTTagList wandMagics = stack.getTagCompound().getTagList(ModEnchantments.key, 8); // 8 is the NBT type for strings
            // tooltip.add(TextFormatting.GREEN + "Combine With a Wand");
            for (int i = 0; i < wandMagics.tagCount(); i++) {
                tooltip.add(TextFormatting.AQUA + "- " + wandMagics.getStringTagAt(i));
            }
        }
    }


    public boolean hasEffect(ItemStack stack) {
        return true;
    }

}
