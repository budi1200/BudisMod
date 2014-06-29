package com.budi.items;

import com.budi.core.budimain;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class enderiumIngot extends Item{

    public enderiumIngot() {
        this.setCreativeTab(budimain.tabrandom);
    }
}