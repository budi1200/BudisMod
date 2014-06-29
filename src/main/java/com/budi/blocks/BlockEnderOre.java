package com.budi.blocks;

import com.budi.core.budimain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockEnderOre extends Block {

    public BlockEnderOre(Material p_i45394_1_) {
        super(p_i45394_1_);
        setHardness(5F);
        setResistance(7.0F);
        setBlockTextureName(budimain.MODID + ":enderore");
    }

}