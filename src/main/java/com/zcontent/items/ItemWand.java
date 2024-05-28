package com.zcontent.items;

import com.google.common.collect.Multimap;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zcontent.Main;
import com.zcontent.config.ConfigLoader;
import com.zcontent.helpers.NBTHelper;
import com.zcontent.init.ModItems;
import com.zcontent.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class ItemWand extends Item implements IHasModel {

    public static UUID MOD_UUID = UUID.nameUUIDFromBytes("RangeModifier".getBytes());

    public ItemWand(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);
        setMaxStackSize(1);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(EntityPlayer.REACH_DISTANCE.getName(), new AttributeModifier(MOD_UUID, "Range Modifier", 5, 0));
        }
        return multimap;
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Mode: " + NBTHelper.getInt(stack, "mode"));
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (player.isSneaking()) {
            changeMode(stack, "mode");
            int currentMode = NBTHelper.getInt(stack, "mode");
            if (world.isRemote) {
                JsonObject config = ConfigLoader.getConfig();
                if (config != null) {
                    JsonObject wandsConfig = config.getAsJsonObject("wands");
                    if (wandsConfig != null) {
                        JsonArray modes = wandsConfig.getAsJsonArray("modes");

                        StringBuilder modesInfo = new StringBuilder("Wand Modes:\n");
                        JsonObject modeObject = modes.get(currentMode).getAsJsonObject();
                        modesInfo.append("Changed Mode to: ").append(currentMode).append("\n");
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


    private static void changeMode(ItemStack stack, String key) {
        int currentMode = NBTHelper.getInt(stack, key);
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
        NBTHelper.setInt(stack, key, nextMode);
    }
}

