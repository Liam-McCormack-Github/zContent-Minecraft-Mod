package com.zcontent.items;

import com.google.common.collect.Multimap;
import com.zcontent.config.Config;
import com.zcontent.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.UUID;

public class ItemWandDisplace extends ItemBase implements IHasModel {
    private final int rangeMainHand;
    private final int rangeOffHand;

    public ItemWandDisplace(String name, net.minecraft.creativetab.CreativeTabs creativeTab, int _rangeMainHand, int _rangeOffHand) {
        super(name, creativeTab);
        setMaxStackSize(1);
        this.rangeMainHand = _rangeMainHand;
        this.rangeOffHand = _rangeOffHand;
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND && this.rangeMainHand > 0) {
            multimap.put(EntityPlayer.REACH_DISTANCE.getName(), new AttributeModifier(UUID.nameUUIDFromBytes("RangeModifier".getBytes()), "Range Modifier", this.rangeMainHand, 0));
        }

        if (equipmentSlot == EntityEquipmentSlot.OFFHAND && this.rangeOffHand > 0) {
            multimap.put(EntityPlayer.REACH_DISTANCE.getName(), new AttributeModifier(UUID.nameUUIDFromBytes("RangeModifier".getBytes()), "Range Modifier", this.rangeOffHand, 0));
        }

        return multimap;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (world.isRemote) {
            return new ActionResult<>(EnumActionResult.PASS, stack);
        }

        if (!player.isSneaking()) {
            return new ActionResult<>(EnumActionResult.PASS, stack);
        }

        RayTraceResult rayTraceResult = this.rayTrace(world, player, true);
        if (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK && player.getCooldownTracker().getCooldown(this, 0.0F) <= 0) {

            BlockPos pos = rayTraceResult.getBlockPos();
            IBlockState blockState = world.getBlockState(pos);
            Block block = blockState.getBlock();

            if (block.getBlockHardness(blockState, world, pos) == -1.0F) {
                return new ActionResult<>(EnumActionResult.FAIL, stack);
            }

            ItemStack dropStack = block.getPickBlock(blockState, rayTraceResult, world, pos, player);
            if (dropStack.isEmpty()) {
                return new ActionResult<>(EnumActionResult.FAIL, stack);
            }

            if (block.hasTileEntity(blockState)) {
                TileEntity tileEntity = world.getTileEntity(pos);
                if (tileEntity != null) {
                    NBTTagCompound teTag = tileEntity.writeToNBT(new NBTTagCompound());
                    dropStack.setTagInfo("BlockEntityTag", teTag);
                    world.removeTileEntity(pos);
                }
            }

            world.playSound(null, pos, SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.BLOCKS, 1.0F, 1.0F);
            player.getCooldownTracker().setCooldown(this, Config.DisplaceWandCooldown);
            world.setBlockToAir(pos);
            world.spawnEntity(new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, dropStack));

            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        }
        return new ActionResult<>(EnumActionResult.PASS, stack);
    }
}