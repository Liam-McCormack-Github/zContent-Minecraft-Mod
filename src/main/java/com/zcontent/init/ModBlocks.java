package com.zcontent.init;

import com.zcontent.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static Block xp_block, meteor_block, ender_block, iron_stone, flint_block, wither_bone_block, bone_block, gunpowder_block, rotten_flesh_block, ardite_ore, cobalt_ore, aluminum_ore, copper_ore, tin_ore, lead_ore, silver_ore, nickel_ore, uranium_ore, titanium_ore, platinum_ore, iridium_ore, mithril_ore;

    public static void init() {
        xp_block = new XpBlock("xp_block", Material.SPONGE);
        meteor_block = new MeteorBlock("meteor_block", Material.ROCK);
        ender_block = new EnderBlock("ender_block", Material.IRON);
        iron_stone = new OreLight("iron_stone", Material.ANVIL);
        flint_block = new OreLight("flint_block", Material.ROCK);
        wither_bone_block = new OreLight("wither_bone_block", Material.GOURD);
        bone_block = new OreLight("bone_block", Material.GOURD);
        gunpowder_block = new OreLight("gunpowder_block", Material.CLOTH);
        rotten_flesh_block = new OreLight("rotten_flesh_block", Material.CLOTH);
        ardite_ore = new OreHeavy("ardite_ore", Material.ROCK);
        cobalt_ore = new OreHeavy("cobalt_ore", Material.ROCK);
        aluminum_ore = new OreLight("aluminum_ore", Material.ROCK);
        copper_ore = new OreLight("copper_ore", Material.ROCK);
        tin_ore = new OreLight("tin_ore", Material.ROCK);
        lead_ore = new OreNormal("lead_ore", Material.ROCK);
        silver_ore = new OreNormal("silver_ore", Material.ROCK);
        nickel_ore = new OreNormal("nickel_ore", Material.ROCK);
        uranium_ore = new OreNormal("uranium_ore", Material.ROCK);
        titanium_ore = new OreHeavy("titanium_ore", Material.ROCK);
        platinum_ore = new OreHeavy("platinum_ore", Material.ROCK);
        iridium_ore = new OreHeavy("iridium_ore", Material.ROCK);
        mithril_ore = new OreHeavy("mithril_ore", Material.ROCK);

    }
}
