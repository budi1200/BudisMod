package com.budi.tools;

import com.budi.core.budimain;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EnderiumPickaxe extends ItemPickaxe
{
    public EnderiumPickaxe(ToolMaterial material)
    {
        super(material);
        this.setCreativeTab(budimain.tabrandom);
    }
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 3));
        return true;
    }
}