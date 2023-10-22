package com.thewawpro.zcontent.items;

import com.thewawpro.zcontent.Main;
import com.thewawpro.zcontent.init.ModItems;
import com.thewawpro.zcontent.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ItemRepair extends Item implements IHasModel {

	public ItemRepair(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
		if(!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		
		if(worldIn.isRemote || !(entityIn instanceof EntityPlayer))
			return;
		
		stack.getTagCompound().setInteger("timer", stack.getTagCompound().getInteger("timer") + 1);
		
		if(stack.getTagCompound().getInteger("timer") < 1)
			return;
		
		stack.getTagCompound().setInteger("timer", 0);
		
		repairAllItems((EntityPlayer)entityIn);
	}
	
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 0;
    }
	
	void repairAllItems(EntityPlayer player)
	{
		final IItemHandler inv = player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		for(int i = 0; i < inv.getSlots(); i++)
		{
			final ItemStack invStack = inv.getStackInSlot(i);

			if(invStack.isEmpty() || !invStack.getItem().isRepairable())
				continue;

			if(invStack != player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) && invStack != player.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND) || !player.isSwingInProgress)
			{
				if(!invStack.getHasSubtypes() && invStack.getMaxDamage() != 0 && invStack.getItemDamage() > 0)
					invStack.setItemDamage(invStack.getItemDamage() - 100);
			}
		}
	}

	
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

}
