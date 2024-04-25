package com.zcontent.items;

import com.zcontent.Main;
import com.zcontent.init.ModItems;
import com.zcontent.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class ItemFertilizer extends Item implements IHasModel {

    public ItemFertilizer(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.getBlockState(pos).getBlock() instanceof IGrowable) {
            if (!world.isRemote) {
                boolean hasGrown = false;

                for (int i = 0; i < 100; i++) {
                    Block growable = world.getBlockState(pos).getBlock();

                    if (growable instanceof IGrowable && ((IGrowable) growable).canGrow(world, pos, world.getBlockState(pos), world.isRemote)) {
                        ((IGrowable) growable).grow(world, world.rand, pos, world.getBlockState(pos));
                        hasGrown = true;
                    } else break;
                }

                if (hasGrown) {
                    world.playEvent(2005, pos, 0);
                    return EnumActionResult.SUCCESS;
                }
            }
            player.swingArm(hand);
        }
        return EnumActionResult.PASS;
    }
}
