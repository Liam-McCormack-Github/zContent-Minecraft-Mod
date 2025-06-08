package com.zcontent.items;

import com.zcontent.config.Config;
import com.zcontent.util.IHasModel;
import com.zcontent.util.NbtHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWandBlink extends ItemBase implements IHasModel {
    private static final String BLINK_DISTANCE_KEY = "blinkDistance";

    public ItemWandBlink(String name, net.minecraft.creativetab.CreativeTabs creativeTab) {
        super(name, creativeTab);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);

        // Change Blink Distance
        if (player.isSneaking()) {
            if (!world.isRemote) {
                changeBlinkDistance(stack, BLINK_DISTANCE_KEY);
            }
            int currentBlinkDistance = NbtHelper.getInt(stack, BLINK_DISTANCE_KEY);
            if (world.isRemote) {
                int nextBlinkDistance = (currentBlinkDistance + Config.WandBlinkDistanceInterval) % Config.WandBlinkMaxDistance;
                player.sendMessage(new TextComponentString("Set wand blink distance to: " + nextBlinkDistance));
            }
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        }

        // Perform Blink
        if (!world.isRemote) {
            int blinkDistance = NbtHelper.getInt(stack, BLINK_DISTANCE_KEY);
            if (blinkDistance <= 0) {
                return new ActionResult<>(EnumActionResult.PASS, stack);
            }
            Vec3d lookVec = player.getLookVec();
            double startX = player.posX;
            double startY = player.posY + player.getEyeHeight();
            double startZ = player.posZ;

            // Loop backwards from defined distance found in the NBT
            for (int i = blinkDistance; i > 0; i--) {
                double destX = startX + lookVec.x * i;
                double destY = startY + lookVec.y * i;
                double destZ = startZ + lookVec.z * i;

                if (isLocationSafe(world, destX, destY, destZ)) {
                    player.setPositionAndUpdate(destX, destY, destZ);
                    player.fallDistance = 0.0F;
                    player.getCooldownTracker().setCooldown(this,  Config.WandBlinkCooldown);
                    world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    return new ActionResult<>(EnumActionResult.SUCCESS, stack);
                }
            }
        }

        return new ActionResult<>(EnumActionResult.PASS, stack);
    }

    private static void changeBlinkDistance(ItemStack stack, String key) {
        int currentBlinkDistance = NbtHelper.getInt(stack, key);
        int nextBlinkDistance = (currentBlinkDistance + Config.WandBlinkDistanceInterval) % Config.WandBlinkMaxDistance;
        NbtHelper.setInt(stack, key, nextBlinkDistance);
    }

    private boolean isLocationSafe(World world, double x, double y, double z) {
        BlockPos feetPos = new BlockPos(x, y, z);
        BlockPos headPos = new BlockPos(x, y + 1, z);
        boolean isFeetSafe = !world.getBlockState(feetPos).getMaterial().isSolid();
        boolean isHeadSafe = !world.getBlockState(headPos).getMaterial().isSolid();
        return isFeetSafe && isHeadSafe;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        int blinkDistance = NbtHelper.getInt(stack, BLINK_DISTANCE_KEY);
        tooltip.add("Blink distance: " + blinkDistance);
    }
}