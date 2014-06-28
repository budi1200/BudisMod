package com.budi.alphabet;

import com.budi.core.budimain;

import net.minecraft.item.Item;

public class wordP extends Item {

    public wordP() {
        this.setCreativeTab(budimain.tabwords);
        this.setTextureName(budimain.MODID + ":" + "wordP");
    }
}