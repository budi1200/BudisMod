package com.budi.stuff;

import com.budi.core.budimain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class enderore extends Block {

    public enderore(Material p_i45394_1_) {
        super(p_i45394_1_);
        setHardness(5F);
        setResistance(7.0F);
        setBlockTextureName(budimain.MODID + ":enderore");
    }

}