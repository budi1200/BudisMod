package com.budi.tools;

import com.budi.core.budimain;
import com.budi.stuff.budioptool;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

public class EnderOpTool extends budioptool
{
    public EnderOpTool(ToolMaterial material)
    {
        super(material);
        this.setCreativeTab(budimain.tabrandom);
    }
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack) {
        par1ItemStack.setTagInfo("ench", new NBTTagList());
        return true;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
        super.onUpdate(stack, world, entity, par4, par5);
        EntityPlayer player = (EntityPlayer) entity;
        ItemStack equipped = player.getCurrentEquippedItem();
        if(equipped != null && equipped == stack)   {
            player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 5, 1));
        }
    }
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add("You really shouldn't use me for killing!");

    }
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 3));
        return true;
    }

}
