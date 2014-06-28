package com.budi.alphabet;

import com.budi.core.budimain;

import net.minecraft.item.Item;

public class wordS extends Item {

    public wordS() {
        this.setCreativeTab(budimain.tabwords);
        this.setTextureName(budimain.MODID + ":" + "wordS");
    }
}