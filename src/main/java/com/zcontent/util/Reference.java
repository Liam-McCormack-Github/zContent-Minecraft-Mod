package com.zcontent.util;

import com.zcontent.init.ModItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.FMLInjectionData;

import java.io.File;
import java.util.*;

public class Reference {

    public static final String MOD_ID = "zcontent";
    public static final String NAME = "zContent";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSION = "[1.12.2]";
    public static final String CLIENT_PROXY_CLASS = "com.zcontent.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "com.zcontent.proxy.CommonProxy";

    public static String getGameFolder() {
        return ((File) (FMLInjectionData.data()[6])).getAbsolutePath();
    }

    public static final List<AttributeHelper> EnchAttributes = new ArrayList<>();

    public static final AttributeHelper EnchAttackSpeed = new AttributeHelper(UUID.nameUUIDFromBytes("EnchAttackSpeed".getBytes()), "EnchAttackSpeed", SharedMonsterAttributes.ATTACK_SPEED);
    public static final AttributeHelper EnchAttackDamage = new AttributeHelper(UUID.nameUUIDFromBytes("EnchAttackDamage".getBytes()), "EnchAttackDamage", SharedMonsterAttributes.ATTACK_DAMAGE);
    public static final AttributeHelper EnchArmor = new AttributeHelper(UUID.nameUUIDFromBytes("EnchArmor".getBytes()), "EnchArmor", SharedMonsterAttributes.ARMOR);
    public static final AttributeHelper EnchArmorToughness = new AttributeHelper(UUID.nameUUIDFromBytes("EnchArmorToughness".getBytes()), "EnchArmorToughness", SharedMonsterAttributes.ARMOR_TOUGHNESS);
    public static final AttributeHelper EnchFlySpeed = new AttributeHelper(UUID.nameUUIDFromBytes("EnchFlySpeed".getBytes()), "EnchFlySpeed", SharedMonsterAttributes.FLYING_SPEED);
    public static final AttributeHelper EnchKnockbackResist = new AttributeHelper(UUID.nameUUIDFromBytes("EnchKnockbackResist".getBytes()), "EnchKnockbackResist", SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
    public static final AttributeHelper EnchLuck = new AttributeHelper(UUID.nameUUIDFromBytes("EnchLuck".getBytes()), "EnchLuck", SharedMonsterAttributes.LUCK);
    public static final AttributeHelper EnchMaxHealth = new AttributeHelper(UUID.nameUUIDFromBytes("EnchMaxHealth".getBytes()), "EnchMaxHealth", SharedMonsterAttributes.MAX_HEALTH);
    public static final AttributeHelper EnchMovementSpeed = new AttributeHelper(UUID.nameUUIDFromBytes("EnchMovementSpeed".getBytes()), "EnchMovementSpeed", SharedMonsterAttributes.MOVEMENT_SPEED);

    public static final AttributeHelper EnchSwimSpeed = new AttributeHelper(UUID.nameUUIDFromBytes("EnchSwimSpeed".getBytes()), "EnchSwimSpeed", EntityPlayer.SWIM_SPEED);
    public static final AttributeHelper EnchRange = new AttributeHelper(UUID.nameUUIDFromBytes("EnchRange".getBytes()), "EnchRange", EntityPlayer.REACH_DISTANCE);

}
