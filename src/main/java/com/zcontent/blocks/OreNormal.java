package com.zcontent.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class OreNormal extends BlockBase {

    public OreNormal(String name, Material material) {
        super(name, material);

        setSoundType(SoundType.STONE);
        setHardness(3.0F);
        setResistance(1.0F);
        setHarvestLevel("pickaxe", 2);
    }

}
