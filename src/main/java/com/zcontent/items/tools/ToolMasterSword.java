package com.zcontent.items.tools;

import com.google.common.collect.Multimap;
import com.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;

import java.util.UUID;

public class ToolMasterSword extends ToolSwordBase implements IHasModel {

    public ToolMasterSword(String name, CreativeTabs creativeTab, ToolMaterial material) {
        super(name, creativeTab, material);

    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> modifiers = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            modifiers.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(UUID.nameUUIDFromBytes("AttackSpeed".getBytes()), "Attack Speed Modifier", 8.4, 0));
        }

        return modifiers;
    }
}