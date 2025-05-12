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
import java.util.Map;

public class ItemWandTome extends ItemBase implements IHasModel {

    public ItemWandTome(String name, CreativeTabs creativeTab) {
        super(name, creativeTab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        Map<String, Integer> magicCounts = NbtHelper.getMagicCounts(stack);

        if (!magicCounts.isEmpty()) {
            for (Map.Entry<String, Integer> entry : magicCounts.entrySet()) {
                String magicName = entry.getKey();
                int count = entry.getValue();
                tooltip.add(TextFormatting.AQUA + "- " + magicName + (count > 1 ? " x" + count : ""));
            }
        }
    }


    public boolean hasEffect(ItemStack stack) {
        return true;
    }

}
