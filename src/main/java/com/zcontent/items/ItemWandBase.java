package com.zcontent.items;

import com.google.common.collect.Multimap;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zcontent.config.ConfigLoader;
import com.zcontent.util.IHasModel;
import com.zcontent.util.NbtHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class ItemWandBase extends ItemBase implements IHasModel {
    private final int rangeMainHand;
    private final int rangeOffHand;


    public ItemWandBase(String name, CreativeTabs creativeTab, int _rangeMainHand, int _rangeOffHand) {

        super(name, creativeTab);

        setMaxStackSize(1);

        this.rangeMainHand = _rangeMainHand;
        this.rangeOffHand = _rangeOffHand;
    }

    private static void changeMode(ItemStack stack, String key) {
        int currentMode = NbtHelper.getInt(stack, key);
        int numOfModes = 1;
        JsonObject config = ConfigLoader.getConfig();
        if (config != null) {
            JsonObject wandsConfig = config.getAsJsonObject("wands");
            if (wandsConfig != null) {
                JsonArray modes = wandsConfig.getAsJsonArray("modes");
                numOfModes = modes.size();
            }
        }
        int nextMode = (currentMode + 1) % numOfModes;
        NbtHelper.setInt(stack, key, nextMode);
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

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Mode: " + NbtHelper.getInt(stack, "mode"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (player.isSneaking()) {
            changeMode(stack, "mode");
            int currentMode = NbtHelper.getInt(stack, "mode");
            if (world.isRemote) {
                JsonObject config = ConfigLoader.getConfig();
                if (config != null) {
                    JsonObject wandsConfig = config.getAsJsonObject("wands");
                    if (wandsConfig != null) {
                        JsonArray modes = wandsConfig.getAsJsonArray("modes");

                        StringBuilder modesInfo = new StringBuilder("Changed Wand Mode to: \n");
                        JsonObject modeObject = modes.get(currentMode).getAsJsonObject();
                        modesInfo.append(currentMode).append("\n");
                        modesInfo.append("    Block List: ").append(modeObject.getAsJsonArray("blockList").toString()).append("\n");
                        modesInfo.append("    Is Blacklist: ").append(modeObject.get("isBlacklist").getAsBoolean()).append("\n");

                        player.sendMessage(new TextComponentString(modesInfo.toString()));
                    }
                }
            }
            return new ActionResult<>(EnumActionResult.PASS, stack);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}

