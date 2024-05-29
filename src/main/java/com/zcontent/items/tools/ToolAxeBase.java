package com.zcontent.items.tools;

import com.zcontent.Main;
import com.zcontent.init.ModItems;
import com.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ToolAxeBase extends ItemAxe implements IHasModel {

    public ToolAxeBase(String name, CreativeTabs creativeTab, ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
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
