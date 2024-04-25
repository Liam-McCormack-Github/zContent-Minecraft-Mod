package com.zcontent.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class OreHeavy extends BlockBase {

    public OreHeavy(String name, Material material) {
        super(name, material);

        setSoundType(SoundType.STONE);
        setHardness(5.0F);
        setResistance(1200.0F);
        setHarvestLevel("pickaxe", 4);
    }

}
