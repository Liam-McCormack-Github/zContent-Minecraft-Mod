package com.zcontent.items.tools;

import com.google.common.collect.Multimap;
import com.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;

import java.util.UUID;

public class ToolShovelWithAttributes extends ToolShovelBase implements IHasModel {

    private final int rangeMainHand;
    private final int rangeOffHand;

    public ToolShovelWithAttributes(String name, CreativeTabs creativeTab, ToolMaterial material, int _rangeMainHand, int _rangeOffHand) {
        super(name, creativeTab, material);

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
}
