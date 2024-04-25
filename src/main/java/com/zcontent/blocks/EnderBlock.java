package com.zcontent.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnderBlock extends BlockBase {

    public EnderBlock(String name, Material material) {
        super(name, material);

        setSoundType(SoundType.METAL);
        setHardness(5.0F);
        setResistance(6.0F);
        setHarvestLevel("pickaxe", 2);
        setLightLevel(1.0F);
    }

}
