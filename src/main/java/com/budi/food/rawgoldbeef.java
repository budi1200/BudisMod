package com.budi.food;

import com.budi.core.budimain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

public class rawgoldbeef extends ItemFood {
    public rawgoldbeef(int par1, int par2, boolean par4) {
        super(par1, par2, par4);
        this.setHasSubtypes(true);
        this.setCreativeTab(budimain.tabrandom);
    }
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack) {
        par1ItemStack.setTagInfo("ench", new NBTTagList());
        return true;
    }
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add("You should really cook me! // ITEM IS WIP! //");

    }

    protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
            if (!par2World.isRemote) {
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20, 5));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 1000, 0));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1000, 0));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1000, 0));
            }
        }

    }