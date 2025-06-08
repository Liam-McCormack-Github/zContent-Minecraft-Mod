package com.zcontent.items;

import com.google.common.collect.Lists;
import com.zcontent.util.IHasModel;
import com.zcontent.util.NbtHelper; // Import the helper class
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemStructureCompass extends ItemBase implements IHasModel {

    // List of structures the compass can locate, taken from the /locate command
    private static final List<String> STRUCTURES = Lists.newArrayList("Stronghold", "Monument", "Village", "Mansion", "EndCity", "Fortress", "Temple", "Mineshaft");

    // NBT keys to store data on the ItemStack
    private static final String NBT_KEY_STRUCTURE_INDEX = "StructureIndex";
    private static final String NBT_KEY_TARGET_X = "TargetX";
    private static final String NBT_KEY_TARGET_Y = "TargetY";
    private static final String NBT_KEY_TARGET_Z = "TargetZ";
    private static final String NBT_KEY_HAS_TARGET = "HasTarget";

    public ItemStructureCompass(String name, CreativeTabs creativeTab) {
        super(name, creativeTab);
        setMaxStackSize(1);

        // This is the crucial part that makes the compass needle work
        this.addPropertyOverride(new ResourceLocation("angle"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            double rotation;
            @SideOnly(Side.CLIENT)
            double rota;
            @SideOnly(Side.CLIENT)
            long lastUpdateTick;

            @Override
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (entityIn == null && !stack.isOnItemFrame()) {
                    return 0.0F;
                }

                boolean isPlayer = entityIn != null;
                Entity entity = isPlayer ? entityIn : stack.getItemFrame();

                if (worldIn == null) {
                    worldIn = entity.world;
                }

                double angle;

                // Check if we have a target and are in the overworld using the helper
                if (worldIn.provider.isSurfaceWorld() && NbtHelper.getBoolean(stack, NBT_KEY_HAS_TARGET)) {
                    double playerYaw = isPlayer ? entity.rotationYaw : getFrameRotation((EntityItemFrame) entity);
                    playerYaw = MathHelper.positiveModulo(playerYaw / 360.0D, 1.0D);

                    double targetAngle = this.getAngleToTarget(worldIn, entity, stack) / (Math.PI * 2D);
                    angle = 0.5D - (playerYaw - 0.25D - targetAngle);
                } else {
                    // If no target or not in overworld, spin randomly
                    angle = Math.random();
                }

                if (isPlayer) {
                    angle = this.wobble(worldIn, angle);
                }

                return MathHelper.positiveModulo((float) angle, 1.0F);
            }

            @SideOnly(Side.CLIENT)
            private double wobble(World world, double angle) {
                if (world.getTotalWorldTime() != this.lastUpdateTick) {
                    this.lastUpdateTick = world.getTotalWorldTime();
                    double d0 = angle - this.rotation;
                    d0 = MathHelper.positiveModulo(d0 + 0.5D, 1.0D) - 0.5D;
                    this.rota += d0 * 0.1D;
                    this.rota *= 0.8D;
                    this.rotation = MathHelper.positiveModulo(this.rotation + this.rota, 1.0D);
                }
                return this.rotation;
            }

            @SideOnly(Side.CLIENT)
            private double getAngleToTarget(World world, Entity entity, ItemStack stack) {
                // Use the helper to get coordinates
                double x = NbtHelper.getInt(stack, NBT_KEY_TARGET_X);
                double z = NbtHelper.getInt(stack, NBT_KEY_TARGET_Z);
                return Math.atan2(z - entity.posZ, x - entity.posX);
            }

            @SideOnly(Side.CLIENT)
            private double getFrameRotation(EntityItemFrame frame) {
                return MathHelper.wrapDegrees(180 + frame.facingDirection.getHorizontalIndex() * 90);
            }
        });
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        // Sneak-Right-Click to cycle through structures
        if (playerIn.isSneaking()) {
            if (!worldIn.isRemote) { // Server side logic
                cycleStructureType(stack);
            }
            playerIn.sendMessage(new TextComponentString("Now locating: " + TextFormatting.AQUA + getStructureName(stack)));
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        }

        // Right-Click to search for the selected structure
        if (!worldIn.isRemote) {
            String structureName = getStructureName(stack);
            BlockPos playerPos = playerIn.getPosition();
            BlockPos structurePos = worldIn.findNearestStructure(structureName, playerPos, false);

            if (structurePos != null) {
                // Use the helper to set NBT data
                NbtHelper.setInt(stack, NBT_KEY_TARGET_X, structurePos.getX());
                NbtHelper.setInt(stack, NBT_KEY_TARGET_Y, structurePos.getY());
                NbtHelper.setInt(stack, NBT_KEY_TARGET_Z, structurePos.getZ());
                NbtHelper.setBoolean(stack, NBT_KEY_HAS_TARGET, true);
                playerIn.sendMessage(new TextComponentString("Found " + structureName + " at: " + structurePos.getX() + ", " + structurePos.getZ()));
            } else {
                // Use the helper to set NBT data
                NbtHelper.setBoolean(stack, NBT_KEY_HAS_TARGET, false);
                playerIn.sendMessage(new TextComponentString(TextFormatting.RED + "Could not find a nearby " + structureName));
            }
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        // Add the currently targeted structure to the tooltip
        tooltip.add(TextFormatting.GRAY + "Locating: " + TextFormatting.GOLD + getStructureName(stack));

        // Use the helper to check for and get NBT data
        if (NbtHelper.getBoolean(stack, NBT_KEY_HAS_TARGET)) {
            int x = NbtHelper.getInt(stack, NBT_KEY_TARGET_X);
            int y = NbtHelper.getInt(stack, NBT_KEY_TARGET_Y);
            int z = NbtHelper.getInt(stack, NBT_KEY_TARGET_Z);
            tooltip.add(TextFormatting.GRAY + "Found at: " + TextFormatting.WHITE + x + ", " + y + ", " + z);
        } else {
            tooltip.add(TextFormatting.GRAY + "Right-click to search");
        }
        tooltip.add(TextFormatting.DARK_GRAY + "Shift-Right-Click to change target");
    }

    private String getStructureName(ItemStack stack) {
        // Use the helper to get the index
        int index = NbtHelper.getInt(stack, NBT_KEY_STRUCTURE_INDEX);
        return STRUCTURES.get(MathHelper.clamp(index, 0, STRUCTURES.size() - 1));
    }

    private void cycleStructureType(ItemStack stack) {
        // Use the helper to get and set the index
        int currentIndex = NbtHelper.getInt(stack, NBT_KEY_STRUCTURE_INDEX);
        int nextIndex = (currentIndex + 1) % STRUCTURES.size();
        NbtHelper.setInt(stack, NBT_KEY_STRUCTURE_INDEX, nextIndex);
        // When cycling, clear the old target
        NbtHelper.setBoolean(stack, NBT_KEY_HAS_TARGET, false);
    }
}