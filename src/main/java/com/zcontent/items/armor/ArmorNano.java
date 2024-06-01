package com.zcontent.items.armor;

import com.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ArmorNano extends ArmorBase implements IHasModel {
    public ArmorNano(String name, CreativeTabs creativeTab, ArmorMaterial material, int renderIndex, EntityEquipmentSlot slot) {
        super(name, creativeTab, material, renderIndex, slot);
    }
}
