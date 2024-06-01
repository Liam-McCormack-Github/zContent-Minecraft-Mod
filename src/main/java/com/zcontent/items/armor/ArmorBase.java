package com.zcontent.items.armor;

import com.zcontent.Main;
import com.zcontent.init.ModItems;
import com.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public abstract class ArmorBase extends ItemArmor implements IHasModel {
    public ArmorBase(String name, CreativeTabs creativeTab, ArmorMaterial material, int renderIndex, EntityEquipmentSlot slot) {
        super(material, renderIndex, slot);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(creativeTab);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
