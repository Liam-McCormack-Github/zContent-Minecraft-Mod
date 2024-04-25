package com.zcontent.items;

import com.zcontent.Main;
import com.zcontent.init.ModItems;
import com.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAntidote extends ItemFood implements IHasModel {

    public ItemAntidote(String name, int amount, float saturation, boolean isAnimalFood) {
        super(amount, saturation, isAnimalFood);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);
        setAlwaysEdible();

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    protected void onFoodEaten(ItemStack Stack, World World, EntityPlayer Player) {
        if (!World.isRemote) {
            Player.removePotionEffect(MobEffects.POISON);
            Player.removePotionEffect(MobEffects.WEAKNESS);
            Player.removePotionEffect(MobEffects.WITHER);
            Player.removePotionEffect(MobEffects.SLOWNESS);
            Player.removePotionEffect(MobEffects.UNLUCK);
            Player.removePotionEffect(MobEffects.NAUSEA);
            Player.removePotionEffect(MobEffects.BLINDNESS);
            Player.removePotionEffect(MobEffects.HUNGER);
            Player.removePotionEffect(MobEffects.MINING_FATIGUE);
        }
    }
}