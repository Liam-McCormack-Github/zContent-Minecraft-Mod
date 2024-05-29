package com.zcontent.items.tools;

import com.zcontent.Main;
import com.zcontent.init.ModItems;
import com.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ToolPickBase extends ItemPickaxe implements IHasModel {

    public ToolPickBase(String name, CreativeTabs creativeTab, ToolMaterial material) {
        super(material);
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
