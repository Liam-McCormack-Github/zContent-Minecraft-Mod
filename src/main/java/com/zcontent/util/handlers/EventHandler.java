package com.zcontent.util.handlers;

import com.zcontent.config.ConfigUtils;
import com.zcontent.init.ModEnchantments;
import com.zcontent.init.ModItems;
import com.zcontent.items.armor.ArmorQuantum;
import com.zcontent.util.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.*;

import static com.zcontent.capability.EnergyCapabilityItemStack.NBTENERGY;
import static com.zcontent.init.ModEnchantments.resurrectionCooldownKey;

import com.zcontent.config.Config;


@EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void rightClick(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        int level = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.FERTILIZER, stack);
        if (!event.getEntityPlayer().isSneaking() && level > 0 && ItemDye.applyBonemeal(stack.copy(), event.getWorld(), event.getPos(), event.getEntityPlayer(), event.getHand())) {
            event.setCanceled(true);
            event.setCancellationResult(EnumActionResult.SUCCESS);
        }
    }


    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        final Set<Item> VALID_WANDS = new HashSet<>(Arrays.asList(ModItems.excavation_wand, ModItems.wand_1, ModItems.wand_2, ModItems.wand_3, ModItems.wand_4));

        if (event.getPlayer().getHeldItemMainhand().isEmpty() && event.getPlayer().getHeldItemOffhand().isEmpty()) {
            return;
        }

        ItemStack heldItem = event.getPlayer().getHeldItemMainhand();
        ItemStack offhandItem = event.getPlayer().getHeldItemOffhand();

        ConfigUtils.Mode currentMode;

        if (VALID_WANDS.contains(heldItem.getItem())) {
            currentMode = ConfigUtils.getMode(NbtHelper.getInt(heldItem, "mode"));
        } else if (VALID_WANDS.contains(offhandItem.getItem())) {
            currentMode = ConfigUtils.getMode(NbtHelper.getInt(offhandItem, "mode"));
        } else {
            return;
        }

        if (currentMode == null) {
            return;
        }

        IBlockState state = event.getState();
        Block block = state.getBlock();

        if (currentMode.isBlacklist && currentMode.blockList.contains(block)) {
            event.setCanceled(true);
            event.getPlayer().sendMessage(new TextComponentString("Cannot mine this block, due to current wand mode!"));
        } else if (!currentMode.isBlacklist && !currentMode.blockList.contains(block)) {
            event.setCanceled(true);
            event.getPlayer().sendMessage(new TextComponentString("Cannot mine this block, due to current wand mode!"));
        }
    }


    /*
    player.getAttributeMap().getAttributeInstance(modifier.affectedAttribute).applyModifier(new AttributeModifier(modifier.id, 				modifier.name, 				modifier.getValue() * amount, 				modifier.getOperation()));
    */
    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event) {
        if (!(event.getEntityLiving() instanceof EntityPlayer) || event.isCanceled() || event.getAmount() <= 0) {
            return;
        }
        EntityPlayer player = (EntityPlayer) event.getEntityLiving();

        boolean quantum = true;
        for (ItemStack stack : player.getArmorInventoryList()) {
            if (stack.isEmpty() || !(stack.getItem() instanceof ArmorQuantum)) {
                quantum = false;
                break;
            } else {
                if (stack.getTagCompound().getInteger(NBTENERGY) == 0) {
                    quantum = false;
                    break;
                }
            }
        }
        if (quantum) {
            if (event.getSource().isFireDamage()) {
                event.setCanceled(true);
                event.getEntityLiving().extinguish();
            }

            if (event.getSource().damageType.equals("darkness")) {
                event.setCanceled(true);
            }
        }
    }




    @SubscribeEvent
    public static void onPlayerDeathAttempt(LivingDeathEvent event) {
        if (!(event.getEntityLiving() instanceof EntityPlayer)) {
            return;
        }

        EntityLivingBase entity = event.getEntityLiving();

        if (entity.world.isRemote) {
            return;
        }

        EntityPlayer player = (EntityPlayer) entity;

        NBTTagCompound playerData = player.getEntityData();
        long currentTime = player.world.getTotalWorldTime();

        if (playerData.hasKey(resurrectionCooldownKey)) {
            long cooldownEndTime = playerData.getLong(resurrectionCooldownKey);
            if (currentTime < cooldownEndTime) {
                long remainingTicks = cooldownEndTime - currentTime;
                double remainingSeconds = remainingTicks / 20.0;
                player.sendMessage(new TextComponentString(TextFormatting.YELLOW + "Resurrection enchantment is on cooldown for " +
                        String.format("%.1f", remainingSeconds) + " seconds."));
                return;
            } else {
                playerData.removeTag(resurrectionCooldownKey);
            }
        }

        if (event.getSource().canHarmInCreative()) {
            return;
        }

        boolean hasResurrectionEnchantment = false;
        int enchantmentLevel = 0;

        ItemStack itemMainHand = player.getHeldItemMainhand();
        if (!itemMainHand.isEmpty()) {
            int level = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.RESURRECTION, itemMainHand);
            if (level > 0) {
                hasResurrectionEnchantment = true;
                enchantmentLevel = level;
            }
        }

        ItemStack itemOffHand = player.getHeldItemOffhand();
        if (!itemOffHand.isEmpty() && !hasResurrectionEnchantment) {
            int level = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.RESURRECTION, itemOffHand);
            if (level > 0) {
                hasResurrectionEnchantment = true;
                enchantmentLevel = level;
            }
        }

        if (!hasResurrectionEnchantment) {
            for (ItemStack armorStack : player.inventory.armorInventory) {
                if (!armorStack.isEmpty()) {
                    int level = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.RESISTANCE, armorStack);
                    if (level > 0) {
                        hasResurrectionEnchantment = true;
                        enchantmentLevel = level;
                        break;
                    }
                }
            }
        }

        if (hasResurrectionEnchantment) {
            event.setCanceled(true);

            float maxPlayerHealth = player.getMaxHealth();
            // Calculate health percentage (level 10 = 100%, level 1 = 10%, etc.)
            float healthPercentage = Math.min(enchantmentLevel, 10) / 10.0f;
            float newHealth = maxPlayerHealth * healthPercentage;
            player.setHealth(newHealth);
            player.clearActivePotions();

            player.world.setEntityState(player, (byte) 35);
            playerData.setLong(resurrectionCooldownKey, currentTime + Config.EnchResurrectionCooldown);

            double cooldownSeconds = Config.EnchResurrectionCooldown / 20.0;
            player.sendMessage(new TextComponentString(TextFormatting.GREEN + "Your Resurrection enchantment protected you! It is now on cooldown for " +
                    String.format("%.1f", cooldownSeconds) + " seconds."));

        }
    }


    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntityLiving() instanceof EntityCreeper) {
            EntityCreeper creeper = (EntityCreeper) event.getEntityLiving();
            World world = creeper.getEntityWorld();

            if (creeper.getPowered()) {
                int gunpowderAmount = 0;
                Iterator<EntityItem> iterator = event.getDrops().iterator();
                while (iterator.hasNext()) {
                    EntityItem droppedEntityItem = iterator.next();
                    ItemStack droppedItemStack = droppedEntityItem.getItem();

                    if (droppedItemStack.getItem() == Items.GUNPOWDER) {
                        gunpowderAmount += droppedItemStack.getCount();
                        iterator.remove();
                    }
                }

                if (gunpowderAmount > 0) {
                    double x = creeper.posX;
                    double y = creeper.posY;
                    double z = creeper.posZ;

                    ItemStack chargedGunpowderDrop = new ItemStack(ModItems.charged_gunpowder, gunpowderAmount);

                    event.getDrops().add(new EntityItem(world, x, y, z, chargedGunpowderDrop));
                }
            }
        }
    }


    @SubscribeEvent
    public static void effectFunction(TickEvent.PlayerTickEvent event) {
        applyEffects(event.player);
        flightEnchantment(event.player);
    }

    private static void flightEnchantment(EntityPlayer player) {
        ItemStack mainhand = player.getHeldItemMainhand();
        ItemStack offhand = player.getHeldItemOffhand();
        ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        ItemStack feet = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
        ItemStack head = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        ItemStack legs = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);

        int level = 0;

        level += EnchantmentHelper.getEnchantmentLevel(ModEnchantments.FLIGHT, mainhand);
        level += EnchantmentHelper.getEnchantmentLevel(ModEnchantments.FLIGHT, offhand);
        level += EnchantmentHelper.getEnchantmentLevel(ModEnchantments.FLIGHT, chest);
        level += EnchantmentHelper.getEnchantmentLevel(ModEnchantments.FLIGHT, feet);
        level += EnchantmentHelper.getEnchantmentLevel(ModEnchantments.FLIGHT, head);
        level += EnchantmentHelper.getEnchantmentLevel(ModEnchantments.FLIGHT, legs);

        if ((player.capabilities.isCreativeMode) || (player.isSpectator()) || level > 0) {
            player.capabilities.allowFlying = true;
        } else {
            player.capabilities.allowFlying = false;
            player.capabilities.isFlying = false;
        }
    }

    private static void applyEffects(EntityPlayer player) {
        EnchHelper enchLevitationHelper = new EnchHelper(false, 1);
        EnchHelper enchSpeedHelper = new EnchHelper(false, 1);
        EnchHelper enchJumpBoostHelper = new EnchHelper(false, 1);
        EnchHelper enchInvisibilityHelper = new EnchHelper(false, 1);
        EnchHelper enchInstantHealthHelper = new EnchHelper(false, 1);
        EnchHelper enchHasteHelper = new EnchHelper(false, 1);
        EnchHelper enchGlowingHelper = new EnchHelper(false, 1);
        EnchHelper enchAbsorptionHelper = new EnchHelper(false, 1);
        EnchHelper enchStrengthHelper = new EnchHelper(false, 1);
        EnchHelper enchSaturationHelper = new EnchHelper(false, 1);
        EnchHelper enchLuckHelper = new EnchHelper(false, 1);
        EnchHelper enchFireResistanceHelper = new EnchHelper(false, 1);
        EnchHelper enchWaterBreathingHelper = new EnchHelper(false, 1);
        EnchHelper enchNightVisionHelper = new EnchHelper(false, 1);
        EnchHelper enchRegenerationHelper = new EnchHelper(false, 1);
        EnchHelper enchResistanceHelper = new EnchHelper(false, 1);
        EnchHelper enchAntidoteHelper = new EnchHelper(false, 1);

        EnchHelper enchAttributeAttackSpeedHelper = new EnchHelper(false, 1);
        EnchHelper enchAttributeAttackDamageHelper = new EnchHelper(false, 1);
        EnchHelper enchAttributeArmorHelper = new EnchHelper(false, 1);
        EnchHelper enchAttributeArmorToughnessHelper = new EnchHelper(false, 1);
        EnchHelper enchAttributeFlySpeedHelper = new EnchHelper(false, 1);
        EnchHelper enchAttributeKnockbackResistHelper = new EnchHelper(false, 1);
        EnchHelper enchAttributeLuckHelper = new EnchHelper(false, 1);
        EnchHelper enchAttributeMaxHealthHelper = new EnchHelper(false, 1);
        EnchHelper enchAttributeMovementSpeedHelper = new EnchHelper(false, 1);
        EnchHelper enchAttributeSwimSpeedHelper = new EnchHelper(false, 1);
        EnchHelper enchAttributeRangeHelper = new EnchHelper(false, 1);

        for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
            if (player.hasItemInSlot(slot)) {
                ItemStack item = player.getItemStackFromSlot(slot);
                if (item.isItemEnchanted()) {
                    Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(item);
                    for (Map.Entry<Enchantment, Integer> entry : enchants.entrySet()) {
                        Enchantment enchantment = entry.getKey();
                        int level = entry.getValue();

                        if (enchantment == ModEnchantments.LEVITATION && slot == EntityEquipmentSlot.MAINHAND) {
                            enchLevitationHelper.has = true;
                            enchLevitationHelper.level = level;
                        } else if (enchantment == ModEnchantments.ANTIDOTE) {
                            enchAntidoteHelper.has = true;
                            enchAntidoteHelper.level = level;
                        }  else if (enchantment == ModEnchantments.SPEED) {
                            enchSpeedHelper.has = true;
                            enchSpeedHelper.level = level;
                        } else if (enchantment == ModEnchantments.JUMPBOOST) {
                            enchJumpBoostHelper.has = true;
                            enchJumpBoostHelper.level = level;
                        } else if (enchantment == ModEnchantments.INVISIBILITY) {
                            enchInvisibilityHelper.has = true;
                            enchInvisibilityHelper.level = level;
                        } else if (enchantment == ModEnchantments.INSTANTHEALTH) {
                            enchInstantHealthHelper.has = true;
                            enchInstantHealthHelper.level = level;
                        } else if (enchantment == ModEnchantments.HASTE) {
                            enchHasteHelper.has = true;
                            enchHasteHelper.level = level;
                        } else if (enchantment == ModEnchantments.GLOWING) {
                            enchGlowingHelper.has = true;
                            enchGlowingHelper.level = level;
                        } else if (enchantment == ModEnchantments.ABSORPTION) {
                            enchAbsorptionHelper.has = true;
                            enchAbsorptionHelper.level = level;
                        } else if (enchantment == ModEnchantments.STRENGTH) {
                            enchStrengthHelper.has = true;
                            enchStrengthHelper.level = level;
                        } else if (enchantment == ModEnchantments.SATURATION) {
                            enchSaturationHelper.has = true;
                            enchSaturationHelper.level = level;
                        } else if (enchantment == ModEnchantments.LUCK) {
                            enchLuckHelper.has = true;
                            enchLuckHelper.level = level;
                        } else if (enchantment == ModEnchantments.FIRERESISTANCE) {
                            enchFireResistanceHelper.has = true;
                            enchFireResistanceHelper.level = level;
                        } else if (enchantment == ModEnchantments.WATERBREATHING) {
                            enchWaterBreathingHelper.has = true;
                            enchWaterBreathingHelper.level = level;
                        } else if (enchantment == ModEnchantments.NIGHTVISION) {
                            enchNightVisionHelper.has = true;
                            enchNightVisionHelper.level = level;
                        } else if (enchantment == ModEnchantments.REGENERATION) {
                            enchRegenerationHelper.has = true;
                            enchRegenerationHelper.level = level;
                        } else if (enchantment == ModEnchantments.RESISTANCE) {
                            enchResistanceHelper.has = true;
                            enchResistanceHelper.level = level;
                        } else if (enchantment == ModEnchantments.ATTRIBUTE_ATTACK_SPEED) {
                            enchAttributeAttackSpeedHelper.has = true;
                            enchAttributeAttackSpeedHelper.level = level;
                        } else if (enchantment == ModEnchantments.ATTRIBUTE_ATTACK_DAMAGE) {
                            enchAttributeAttackDamageHelper.has = true;
                            enchAttributeAttackDamageHelper.level = level;
                        } else if (enchantment == ModEnchantments.ATTRIBUTE_ARMOR) {
                            enchAttributeArmorHelper.has = true;
                            enchAttributeArmorHelper.level = level;
                        } else if (enchantment == ModEnchantments.ATTRIBUTE_ARMOR_TOUGHNESS) {
                            enchAttributeArmorToughnessHelper.has = true;
                            enchAttributeArmorToughnessHelper.level = level;
                        } else if (enchantment == ModEnchantments.ATTRIBUTE_FLY_SPEED) {
                            enchAttributeFlySpeedHelper.has = true;
                            enchAttributeFlySpeedHelper.level = level;
                        } else if (enchantment == ModEnchantments.ATTRIBUTE_KNOCKBACK_RESIST) {
                            enchAttributeKnockbackResistHelper.has = true;
                            enchAttributeKnockbackResistHelper.level = level;
                        } else if (enchantment == ModEnchantments.ATTRIBUTE_LUCK) {
                            enchLuckHelper.has = true;
                            enchLuckHelper.level = level;
                        } else if (enchantment == ModEnchantments.ATTRIBUTE_MAX_HEALTH) {
                            enchAttributeMaxHealthHelper.has = true;
                            enchAttributeMaxHealthHelper.level = level;
                        } else if (enchantment == ModEnchantments.ATTRIBUTE_MOVEMENT_SPEED) {
                            enchAttributeMovementSpeedHelper.has = true;
                            enchAttributeMovementSpeedHelper.level = level;
                        } else if (enchantment == ModEnchantments.ATTRIBUTE_SWIM_SPEED) {
                            enchAttributeSwimSpeedHelper.has = true;
                            enchAttributeSwimSpeedHelper.level = level;
                        } else if (enchantment == ModEnchantments.ATTRIBUTE_RANGE) {
                            enchAttributeRangeHelper.has = true;
                            enchAttributeRangeHelper.level = level;
                        }
                    }
                }
            }
        }

        if (enchLevitationHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, Config.EnchLevitationDuration, ((Config.EnchLevitationMultiplier * enchLevitationHelper.level) - 1) + Config.EnchLevitationBase, false, false));
        }
        if (enchSpeedHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.SPEED, Config.EnchSpeedDuration, ((Config.EnchSpeedMultiplier * enchSpeedHelper.level) - 1) + Config.EnchSpeedBase, false, false));
        }
        if (enchJumpBoostHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, Config.EnchJumpBoostDuration, ((Config.EnchJumpBoostMultiplier * enchJumpBoostHelper.level) - 1) + Config.EnchJumpBoostBase, false, false));
        }
        if (enchInvisibilityHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, Config.EnchInvisibilityDuration, ((Config.EnchInvisibilityMultiplier * enchInvisibilityHelper.level) - 1) + Config.EnchInvisibilityBase, false, false));
        }
        if (enchInstantHealthHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, Config.EnchInstantHealthDuration, ((Config.EnchInstantHealthMultiplier * enchInstantHealthHelper.level) - 1) + Config.EnchInstantHealthBase, false, false));
        }
        if (enchHasteHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.HASTE, Config.EnchHasteDuration, ((Config.EnchHasteMultiplier * enchHasteHelper.level) - 1) + Config.EnchHasteBase, false, false));
        }
        if (enchGlowingHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, Config.EnchGlowingDuration, ((Config.EnchGlowingMultiplier * enchGlowingHelper.level) - 1) + Config.EnchGlowingBase, false, false));
        }
        if (enchAbsorptionHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, Config.EnchAbsorptionDuration, ((Config.EnchAbsorptionMultiplier * enchAbsorptionHelper.level) - 1) + Config.EnchAbsorptionBase, false, false));
        }
        if (enchStrengthHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, Config.EnchStrengthDuration, ((Config.EnchStrengthMultiplier * enchStrengthHelper.level) - 1) + Config.EnchStrengthBase, false, false));
        }
        if (enchSaturationHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, Config.EnchSaturationDuration, ((Config.EnchSaturationMultiplier * enchSaturationHelper.level) - 1) + Config.EnchSaturationBase, false, false));
        }
        if (enchLuckHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.LUCK, Config.EnchLuckDuration, ((Config.EnchLuckMultiplier * enchLuckHelper.level) - 1) + Config.EnchLuckBase, false, false));
        }
        if (enchFireResistanceHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, Config.EnchFireResistanceDuration, ((Config.EnchFireResistanceMultiplier * enchFireResistanceHelper.level) - 1) + Config.EnchFireResistanceBase, false, false));
        }
        if (enchWaterBreathingHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, Config.EnchWaterBreathingDuration, ((Config.EnchWaterBreathingMultiplier * enchWaterBreathingHelper.level) - 1) + Config.EnchWaterBreathingBase, false, false));
        }
        if (enchNightVisionHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, Config.EnchNightVisionDuration, ((Config.EnchNightVisionMultiplier * enchNightVisionHelper.level) - 1) + Config.EnchNightVisionBase, false, false));
        }
        if (enchRegenerationHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, Config.EnchRegenerationDuration, ((Config.EnchRegenerationMultiplier * enchRegenerationHelper.level) - 1) + Config.EnchRegenerationBase, false, false));
        }
        if (enchResistanceHelper.has) {
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, Config.EnchResistanceDuration, ((Config.EnchResistanceMultiplier * enchResistanceHelper.level) - 1) + Config.EnchResistanceBase, false, false));
        }
        if (enchAntidoteHelper.has) {
            player.removeActivePotionEffect(MobEffects.POISON);
            player.removeActivePotionEffect(MobEffects.WEAKNESS);
            player.removeActivePotionEffect(MobEffects.WITHER);
            player.removeActivePotionEffect(MobEffects.SLOWNESS);
            player.removeActivePotionEffect(MobEffects.UNLUCK);
            player.removeActivePotionEffect(MobEffects.NAUSEA);
            player.removeActivePotionEffect(MobEffects.BLINDNESS);
            player.removeActivePotionEffect(MobEffects.HUNGER);
            player.removeActivePotionEffect(MobEffects.MINING_FATIGUE);
        }
        applyOrRemoveAttributeModifier(player, Config.EnchAttributeAttackSpeedBase, Config.EnchAttributeAttackSpeedModifier, Config.EnchAttributeAttackSpeedOperator, enchAttributeAttackSpeedHelper, Reference.EnchAttackSpeed);
        applyOrRemoveAttributeModifier(player, Config.EnchAttributeAttackDamageBase, Config.EnchAttributeAttackDamageModifier, Config.EnchAttributeAttackDamageOperator, enchAttributeAttackDamageHelper, Reference.EnchAttackDamage);
        applyOrRemoveAttributeModifier(player, Config.EnchAttributeArmorBase, Config.EnchAttributeArmorModifier, Config.EnchAttributeArmorOperator, enchAttributeArmorHelper, Reference.EnchArmor);
        applyOrRemoveAttributeModifier(player, Config.EnchAttributeArmorToughnessBase, Config.EnchAttributeArmorToughnessModifier, Config.EnchAttributeArmorToughnessOperator, enchAttributeArmorToughnessHelper, Reference.EnchArmorToughness);
        applyOrRemoveAttributeModifier(player, Config.EnchAttributeFlySpeedBase, Config.EnchAttributeFlySpeedModifier, Config.EnchAttributeFlySpeedOperator, enchAttributeFlySpeedHelper, Reference.EnchFlySpeed);
        applyOrRemoveAttributeModifier(player, Config.EnchAttributeKnockbackResistBase, Config.EnchAttributeKnockbackResistModifier, Config.EnchAttributeKnockbackResistOperator, enchAttributeKnockbackResistHelper, Reference.EnchKnockbackResist);
        applyOrRemoveAttributeModifier(player, Config.EnchAttributeLuckBase, Config.EnchAttributeLuckModifier, Config.EnchAttributeLuckOperator, enchAttributeLuckHelper, Reference.EnchLuck);
        applyOrRemoveAttributeModifier(player, Config.EnchAttributeMaxHealthBase, Config.EnchAttributeMaxHealthModifier, Config.EnchAttributeMaxHealthOperator, enchAttributeMaxHealthHelper, Reference.EnchMaxHealth);
        applyOrRemoveAttributeModifier(player, Config.EnchAttributeMovementSpeedBase, Config.EnchAttributeMovementSpeedModifier, Config.EnchAttributeMovementSpeedOperator, enchAttributeMovementSpeedHelper, Reference.EnchMovementSpeed);
        applyOrRemoveAttributeModifier(player, Config.EnchAttributeSwimSpeedBase, Config.EnchAttributeSwimSpeedModifier, Config.EnchAttributeSwimSpeedOperator, enchAttributeSwimSpeedHelper, Reference.EnchSwimSpeed);
        applyOrRemoveAttributeModifier(player, Config.EnchAttributeRangeBase, Config.EnchAttributeRangeModifier, Config.EnchAttributeRangeOperator, enchAttributeRangeHelper, Reference.EnchRange);

    }

    private static void applyOrRemoveAttributeModifier(EntityPlayer player, double baseValue, double modifierValue, int operator, EnchHelper enchHelper, AttributeHelper attributeHelper) {
        if (enchHelper.has) {
            addAttributeModifier(player, attributeHelper.attribute, new AttributeModifier(attributeHelper.id, attributeHelper.name, (modifierValue * enchHelper.level) + baseValue, operator));
        } else {
            removeAttributeModifiers(player, attributeHelper.attribute, attributeHelper.id);
        }
    }

    private static void addAttributeModifier(EntityPlayer player, IAttribute attribute, AttributeModifier modifier) {
        IAttributeInstance attributeInstance = player.getAttributeMap().getAttributeInstance(attribute);
        if (attributeInstance == null) {
            return;
        }
        AttributeModifier existingModifier = attributeInstance.getModifier(modifier.getID());
        if (existingModifier != null) {
            attributeInstance.removeModifier(existingModifier);
        }
        attributeInstance.applyModifier(modifier);
    }

    private static void removeAttributeModifiers(EntityPlayer player, IAttribute attribute, UUID id) {
        IAttributeInstance attributeInstance = player.getAttributeMap().getAttributeInstance(attribute);
        if (attributeInstance == null) {
            return;
        }
        AttributeModifier existingModifier = attributeInstance.getModifier(id);
        if (existingModifier != null) {
            attributeInstance.removeModifier(existingModifier);
        }
    }
}
