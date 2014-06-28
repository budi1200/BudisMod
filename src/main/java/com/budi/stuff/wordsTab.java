package com.budi.stuff;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.budi.core.*;

public class wordsTab extends CreativeTabs {
    public wordsTab(String tabLabel)
    {
        super(tabLabel);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return budimain.wordA;
    }
}