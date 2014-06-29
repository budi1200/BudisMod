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

public class LolBlock extends Block {

    public LolBlock() {
        super(Material.ground);
        this.setCreativeTab(budimain.tabrandom);

    }

    @SideOnly(Side.CLIENT)

    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        blockIcon = p_149651_1_.registerIcon(budimain.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}