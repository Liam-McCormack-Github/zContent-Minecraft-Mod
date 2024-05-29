package com.zcontent.items;

import com.zcontent.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ItemRepair extends ItemGlowing implements IHasModel {

    public ItemRepair(String name, CreativeTabs creativeTab) {
        super(name, creativeTab);

        setMaxStackSize(1);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.hasTagCompound())
            stack.setTagCompound(new NBTTagCompound());

        if (worldIn.isRemote || !(entityIn instanceof EntityPlayer))
            return;

        stack.getTagCompound().setInteger("timer", stack.getTagCompound().getInteger("timer") + 1);

        if (stack.getTagCompound().getInteger("timer") < 1)
            return;

        stack.getTagCompound().setInteger("timer", 0);

        repairAllItems((EntityPlayer) entityIn);
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return 0;
    }

    void repairAllItems(EntityPlayer player) {
        final IItemHandler inv = player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        for (int i = 0; i < inv.getSlots(); i++) {
            final ItemStack invStack = inv.getStackInSlot(i);

            if (invStack.isEmpty() || !invStack.getItem().isRepairable())
                continue;

            if (invStack != player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) && invStack != player.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND) || !player.isSwingInProgress) {
                if (!invStack.getHasSubtypes() && invStack.getMaxDamage() != 0 && invStack.getItemDamage() > 0)
                    invStack.setItemDamage(invStack.getItemDamage() - 100);
            }
        }
    }
}
