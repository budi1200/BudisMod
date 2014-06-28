package com.budi.alphabet;

import com.budi.core.budimain;

import net.minecraft.item.Item;

public class wordQ extends Item {

    public wordQ() {
        this.setCreativeTab(budimain.tabwords);
        this.setTextureName(budimain.MODID + ":" + "wordQ");
    }
}