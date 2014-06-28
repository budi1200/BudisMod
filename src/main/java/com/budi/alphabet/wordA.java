package com.budi.alphabet;

import com.budi.core.budimain;

import net.minecraft.item.Item;

public class wordA extends Item {

    public wordA() {
        this.setCreativeTab(budimain.tabwords);
        this.setTextureName(budimain.MODID + ":" + "wordA");
    }
}