package com.budi.stuff;

import com.budi.core.budimain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class creativeTab extends CreativeTabs {
   public creativeTab(String tabLabel)
   {
       super(tabLabel);
   }
    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return budimain.enderiumIngot;
    }
}

