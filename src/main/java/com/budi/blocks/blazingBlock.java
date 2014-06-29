package com.budi.blocks;


import java.util.List;

import com.budi.core.budimain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class blazingBlock extends Block {

    public blazingBlock() {
        super(Material.rock);
        this.setCreativeTab(budimain.tabrandom);
        this.setLightLevel(1);
        this.setLightOpacity(5);
    }

    @SideOnly(Side.CLIENT)

    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        blockIcon = p_149651_1_.registerIcon(budimain.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}