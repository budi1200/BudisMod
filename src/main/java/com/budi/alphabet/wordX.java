package com.budi.alphabet;

import com.budi.core.budimain;

import net.minecraft.item.Item;

public class wordX extends Item {

    public wordX() {
        this.setCreativeTab(budimain.tabwords);
        this.setTextureName(budimain.MODID + ":" + "wordX");
    }
}