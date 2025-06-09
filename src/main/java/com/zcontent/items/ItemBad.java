package com.zcontent.items;

import com.zcontent.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBad extends ItemBase implements IHasModel {

    private String tooltip;

    public ItemBad(String name, CreativeTabs creativeTab, String tooltip) {
        super(name, creativeTab);

        this.tooltip = tooltip;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(this.tooltip);
    }


    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
        super.onUpdate(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            EnumHand hand = player.getHeldItem(EnumHand.OFF_HAND).getItem() == this ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
            ItemStack heldStack = player.getHeldItem(hand);
            if (heldStack == stack) {
                player.addPotionEffect(new PotionEffect(MobEffects.POISON, 180, 4, false, false));
                player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 180, 4, false, false));
                player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 180, 4, false, false));
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 180, 4, false, false));
                player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 180, 4, false, false));

            }
        }
    }

}
