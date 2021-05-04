package com.thewawpro.zcontent.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class XpBlock extends BlockBase {

	public XpBlock(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.SLIME);
		setLightLevel(1.0F);
	}

}
