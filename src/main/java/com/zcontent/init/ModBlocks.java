package com.zcontent.init;

import com.zcontent.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<>();

    public static Block xp_block, meteor_block, ender_block, iron_stone, flint_block, wither_bone_block, bone_block, gunpowder_block, rotten_flesh_block, ardite_ore, cobalt_ore, aluminum_ore, copper_ore, tin_ore, lead_ore, silver_ore, nickel_ore, uranium_ore, titanium_ore, platinum_ore, iridium_ore, mithril_ore;

    public static void init() {
        xp_block = new BlockBase("xp_block", Material.SPONGE, SoundType.SLIME).setLightLevel(1.0F);

        meteor_block = new BlockBase("meteor_block", Material.ROCK, SoundType.STONE).setHardness(100.0F).setResistance(1200.0F).setLightLevel(1.0F);
        meteor_block.setHarvestLevel("pickaxe", 4);

        ender_block = new BlockBase("ender_block", Material.IRON, SoundType.METAL).setHardness(5.0F).setResistance(6.0F).setLightLevel(1.0F);
        ender_block.setHarvestLevel("pickaxe", 2);

        iron_stone = new BlockBase("iron_stone", Material.ANVIL, SoundType.STONE).setHardness(4.0F).setResistance(5.0F);;
        iron_stone.setHarvestLevel("pickaxe", 1);

        flint_block = new BlockBase("flint_block", Material.ROCK, SoundType.STONE).setHardness(4.0F).setResistance(5.0F);;
        flint_block.setHarvestLevel("pickaxe", 1);

        wither_bone_block = new BlockBase("wither_bone_block", Material.GOURD, SoundType.STONE).setHardness(4.0F).setResistance(5.0F);;
        wither_bone_block.setHarvestLevel("pickaxe", 1);

        bone_block = new BlockBase("bone_block", Material.GOURD, SoundType.STONE).setHardness(4.0F).setResistance(5.0F);;
        bone_block.setHarvestLevel("pickaxe", 1);

        gunpowder_block = new BlockBase("gunpowder_block", Material.CLOTH, SoundType.STONE).setHardness(4.0F).setResistance(5.0F);;
        gunpowder_block.setHarvestLevel("pickaxe", 1);

        rotten_flesh_block = new BlockBase("rotten_flesh_block", Material.CLOTH, SoundType.CLOTH).setHardness(4.0F).setResistance(5.0F);;
        rotten_flesh_block.setHarvestLevel("pickaxe", 1);

        ardite_ore = new BlockBase("ardite_ore", Material.ROCK, SoundType.STONE).setHardness(5.0F).setResistance(1200.0F);
        ardite_ore.setHarvestLevel("pickaxe", 4);

        cobalt_ore = new BlockBase("cobalt_ore", Material.ROCK, SoundType.STONE).setHardness(5.0F).setResistance(1200.0F);
        cobalt_ore.setHarvestLevel("pickaxe", 4);

        aluminum_ore = new BlockBase("aluminum_ore", Material.ROCK, SoundType.STONE).setHardness(4.0F).setResistance(5.0F);;
        aluminum_ore.setHarvestLevel("pickaxe", 1);

        copper_ore = new BlockBase("copper_ore", Material.ROCK, SoundType.STONE).setHardness(4.0F).setResistance(5.0F);;
        copper_ore.setHarvestLevel("pickaxe", 1);

        tin_ore = new BlockBase("tin_ore", Material.ROCK, SoundType.STONE).setHardness(4.0F).setResistance(5.0F);;
        tin_ore.setHarvestLevel("pickaxe", 1);

        lead_ore = new BlockBase("lead_ore", Material.ROCK, SoundType.STONE).setHardness(3.0F).setResistance(1.0F);
        lead_ore.setHarvestLevel("pickaxe", 2);

        silver_ore = new BlockBase("silver_ore", Material.ROCK, SoundType.STONE).setHardness(3.0F).setResistance(1.0F);
        silver_ore.setHarvestLevel("pickaxe", 2);

        nickel_ore = new BlockBase("nickel_ore", Material.ROCK, SoundType.STONE).setHardness(3.0F).setResistance(1.0F);
        nickel_ore.setHarvestLevel("pickaxe", 2);

        uranium_ore = new BlockBase("uranium_ore", Material.ROCK, SoundType.STONE).setHardness(3.0F).setResistance(1.0F);
        uranium_ore.setHarvestLevel("pickaxe", 2);

        titanium_ore = new BlockBase("titanium_ore", Material.ROCK, SoundType.STONE).setHardness(5.0F).setResistance(1200.0F);
        titanium_ore.setHarvestLevel("pickaxe", 4);

        platinum_ore = new BlockBase("platinum_ore", Material.ROCK, SoundType.STONE).setHardness(5.0F).setResistance(1200.0F);
        platinum_ore.setHarvestLevel("pickaxe", 4);

        iridium_ore = new BlockBase("iridium_ore", Material.ROCK, SoundType.STONE).setHardness(5.0F).setResistance(1200.0F);
        iridium_ore.setHarvestLevel("pickaxe", 4);

        mithril_ore = new BlockBase("mithril_ore", Material.ROCK, SoundType.STONE).setHardness(5.0F).setResistance(1200.0F);
        mithril_ore.setHarvestLevel("pickaxe", 4);

    }
}
