package com.budi.alphabet;

import com.budi.core.budimain;

import net.minecraft.item.Item;

public class wordT extends Item {

    public wordT() {
        this.setCreativeTab(budimain.tabwords);
        this.setTextureName(budimain.MODID + ":" + "wordT");
    }
}