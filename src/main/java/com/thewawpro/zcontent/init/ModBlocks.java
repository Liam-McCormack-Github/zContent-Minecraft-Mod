package com.thewawpro.zcontent.init;

import java.util.ArrayList;
import java.util.List;

import com.thewawpro.zcontent.blocks.BlockBase;
import com.thewawpro.zcontent.blocks.EnderBlock;
import com.thewawpro.zcontent.blocks.MeteorBlock;
import com.thewawpro.zcontent.blocks.OreHeavy;
import com.thewawpro.zcontent.blocks.OreLight;
import com.thewawpro.zcontent.blocks.OreNormal;
import com.thewawpro.zcontent.blocks.XpBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block xp_block = new XpBlock("xp_block", Material.SPONGE);
	public static final Block meteor_block = new MeteorBlock("meteor_block", Material.ROCK);
	public static final Block ender_block = new EnderBlock("ender_block", Material.IRON);
	public static final Block iron_stone = new OreLight("iron_stone", Material.ANVIL);
	public static final Block flint_block = new OreLight("flint_block", Material.ROCK);
	public static final Block wither_bone_block = new OreLight("wither_bone_block", Material.GOURD);
	public static final Block bone_block = new OreLight("bone_block", Material.GOURD);
	public static final Block gunpowder_block = new OreLight("gunpowder_block", Material.CLOTH);
	public static final Block rotten_flesh_block = new OreLight("rotten_flesh_block", Material.CLOTH);
	public static final Block ardite_ore = new OreHeavy("ardite_ore", Material.ROCK);
	public static final Block cobalt_ore = new OreHeavy("cobalt_ore", Material.ROCK);
	public static final Block aluminum_ore = new OreLight("aluminum_ore", Material.ROCK);
	public static final Block copper_ore = new OreLight("copper_ore", Material.ROCK);
	public static final Block tin_ore = new OreLight("tin_ore", Material.ROCK);
	public static final Block lead_ore = new OreNormal("lead_ore", Material.ROCK);
	public static final Block silver_ore = new OreNormal("silver_ore", Material.ROCK);
	public static final Block nickel_ore = new OreNormal("nickel_ore", Material.ROCK);
	public static final Block uranium_ore = new OreNormal("uranium_ore", Material.ROCK);
	public static final Block titanium_ore = new OreHeavy("titanium_ore", Material.ROCK);
	public static final Block platinum_ore = new OreHeavy("platinum_ore", Material.ROCK);
	public static final Block iridium_ore = new OreHeavy("iridium_ore", Material.ROCK);
	public static final Block mithril_ore = new OreHeavy("mithril_ore", Material.ROCK);
}
