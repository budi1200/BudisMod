package com.budi.blocks;

import com.budi.core.budimain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockHelloWorld extends Block {

    public BlockHelloWorld() {
        super(Material.ground);
        this.setCreativeTab(budimain.tabrandom);

    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        blockIcon = p_149651_1_.registerIcon(budimain.MODID + ":" + this.getUnlocalizedName().substring(5));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return blockIcon;

    }
}