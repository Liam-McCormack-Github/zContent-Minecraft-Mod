package com.zcontent.items;

import com.google.common.collect.Multimap;
import com.zcontent.Main;
import com.zcontent.init.ModItems;
import com.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

import java.util.UUID;

public class ItemWand1 extends Item implements IHasModel {

    public static UUID MOD_UUID = UUID.nameUUIDFromBytes("RangeModifier".getBytes());

    public ItemWand1(String name) {

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
            multimap.put(EntityPlayer.REACH_DISTANCE.getName(), new AttributeModifier(MOD_UUID, "Range Modifier", 10, 0));
        }

        if (equipmentSlot == EntityEquipmentSlot.OFFHAND) {
            multimap.put(EntityPlayer.REACH_DISTANCE.getName(), new AttributeModifier(MOD_UUID, "Range Modifier", 5, 0));
        }

        return multimap;
    }

}
