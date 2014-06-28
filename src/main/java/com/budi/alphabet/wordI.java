package com.budi.alphabet;

import com.budi.core.budimain;

import net.minecraft.item.Item;

public class wordI extends Item {

    public wordI() {
        this.setCreativeTab(budimain.tabwords);
        this.setTextureName(budimain.MODID + ":" + "wordI");
    }
}
