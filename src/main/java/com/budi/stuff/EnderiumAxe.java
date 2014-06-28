package com.budi.stuff;

import com.budi.core.budimain;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class EnderiumAxe extends ItemAxe
{
    public EnderiumAxe(ToolMaterial material)
    {
        super(material);
        this.setCreativeTab(budimain.tabrandom);
    }
}
