package com.zcontent.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MeteorBlock extends BlockBase {

    public MeteorBlock(String name, Material material) {
        super(name, material);

        setSoundType(SoundType.STONE);
        setHardness(100.0F);
        setResistance(1200.0F);
        setHarvestLevel("pickaxe", 4);
        setLightLevel(1.0F);
    }

}
