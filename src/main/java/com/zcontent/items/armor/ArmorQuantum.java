package com.zcontent.items.armor;

import com.google.common.collect.Multimap;
import com.zcontent.capability.EnergyCapabilityItemStack;
import com.zcontent.init.ModItems;
import com.zcontent.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class ArmorQuantum extends ArmorBase implements IHasModel, ISpecialArmor {

    public static final ISpecialArmor.ArmorProperties QUANTUM = new ArmorProperties(0, 0.20D, Integer.MAX_VALUE);
    public final int energyCost;
    private final int energyCapacity;
    public double absorbRatio = 1.0E7D;
    public int energyPerDamage = 20000;

    public ArmorQuantum(String name, CreativeTabs creativeTab, ArmorMaterial material, int renderIndex, EntityEquipmentSlot slot, int energyCapacity, int energyCost) {
        super(name, creativeTab, material, renderIndex, slot);

        this.energyCapacity = energyCapacity;
        this.energyCost = energyCost;


    }

    protected int getEnergyPerDamage(ItemStack stack) {

        int unbreakingLevel = MathHelper.clamp(EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, stack), 0, 256);
        return energyPerDamage * (5 - unbreakingLevel) / 5;
    }

    protected int getBaseAbsorption() {

        return 20;
    }

    protected int getAbsorptionRatio() {

        switch (armorType) {
            case HEAD:
                return 15;
            case CHEST:
                return 40;
            case LEGS:
                return 30;
            case FEET:
                return 15;
            default:
                return 0;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        IEnergyStorage storage = stack.getCapability(CapabilityEnergy.ENERGY, null);
        tooltip.add("Energy: " + storage.getEnergyStored() + "/" + storage.getMaxEnergyStored());
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot equipmentSlot, ItemStack stack) {
        Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(equipmentSlot, stack);

        IEnergyStorage energy = stack.getCapability(CapabilityEnergy.ENERGY, null);
        if (energy.getEnergyStored() >= getEnergyPerDamage(stack)) {
            //  (equipmentSlot == EntityEquipmentSlot.LEGS && stack.getItem() instanceof ArmorQuantum)
            if (stack.getItem() == ModItems.quantum_leggings && equipmentSlot == EntityEquipmentSlot.LEGS) {
                modifiers.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(UUID.nameUUIDFromBytes("QuantumMovementSpeed".getBytes()), "Speed boost", 0.8, 1));
            }

            if (stack.getItem() == ModItems.quantum_chestplate && equipmentSlot == EntityEquipmentSlot.CHEST) {
                modifiers.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(UUID.nameUUIDFromBytes("QuantumAttackSpeed".getBytes()), "Attack Speed Modifier", 3.4, 0));
            }
        }
        return modifiers;
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (world.isRemote) return;
        IEnergyStorage energy = stack.getCapability(CapabilityEnergy.ENERGY, null);
        if (energy.getEnergyStored() >= getEnergyPerDamage(stack)) {
            if (stack.getItem() == ModItems.quantum_boots) {
                player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 260, 3, true, false));
            }
            if (stack.getItem() == ModItems.quantum_leggings) {
                // player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 260, 4, true, false));
            }
            if (stack.getItem() == ModItems.quantum_chestplate) {
                // player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 260, 4, true, false));
            }
            if (stack.getItem() == ModItems.quantum_helmet) {
                player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 260, 0, true, false));
            }
        }
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0xD01010;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack item) {
        IEnergyStorage storage = item.getCapability(CapabilityEnergy.ENERGY, null);
        double energy = storage.getEnergyStored();
        return 1 - energy / storage.getMaxEnergyStored();
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new EnergyCapabilityItemStack(stack, this.energyCapacity);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 0;
    }

    @Override
    public boolean isDamaged(ItemStack stack) {
        return true;
    }


    @Override
    public ArmorProperties getProperties(EntityLivingBase player, @Nonnull ItemStack stack, DamageSource source, double damage, int slot) {

        IEnergyStorage energy = stack.getCapability(CapabilityEnergy.ENERGY, null);

        if ("quantum".equals(source.damageType)) {
            return QUANTUM;
        } else if (source.isUnblockable()) {
            int absorbMax = getEnergyPerDamage(stack) > 0 ? 25 * energy.getEnergyStored() / getEnergyPerDamage(stack) : 0;
            return new ArmorProperties(0, absorbRatio * 3 * 0.025, absorbMax);
        }
        int absorbMax = getEnergyPerDamage(stack) > 0 ? 25 * energy.getEnergyStored() / getEnergyPerDamage(stack) : 0;
        return new ArmorProperties(0, absorbRatio * 3 * 0.05, absorbMax);
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, @Nonnull ItemStack stack, int slot) {
        IEnergyStorage energy = stack.getCapability(CapabilityEnergy.ENERGY, null);

        if (energy.getEnergyStored() >= getEnergyPerDamage(stack)) {
            return Math.min(getBaseAbsorption(), 20) * getAbsorptionRatio() / 100;
        }
        return 0;
    }


    @Override
    public void damageArmor(EntityLivingBase entity, @Nonnull ItemStack stack, DamageSource source, int damage, int slot) {
        if (source.isFireDamage() || source.damageType.equals("darkness")) {
            return;
        }

        IEnergyStorage energy = stack.getCapability(CapabilityEnergy.ENERGY, null);


        if (source.damageType.equals("quantum")) {
            boolean p = source.getTrueSource() == null;

            energy.receiveEnergy(damage * (p ? energyPerDamage / 2 : getEnergyPerDamage(stack)), false);

        } else {
            energy.extractEnergy(damage * getEnergyPerDamage(stack), false);
        }
    }
}
