package com.budi.alphabet;

import com.budi.core.budimain;

import net.minecraft.item.Item;

public class wordL extends Item {

    public wordL() {
        this.setCreativeTab(budimain.tabwords);
        this.setTextureName(budimain.MODID + ":" + "wordL");
    }
}