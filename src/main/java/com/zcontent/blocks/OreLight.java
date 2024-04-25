package com.zcontent.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class OreLight extends BlockBase {

    public OreLight(String name, Material material) {
        super(name, material);

        setSoundType(SoundType.STONE);
        setHardness(4.0F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 1);
    }

}
