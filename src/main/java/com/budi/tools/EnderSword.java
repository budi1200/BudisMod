package com.budi.tools;

import com.budi.core.budimain;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EnderSword extends ItemSword {
    public EnderSword(ToolMaterial material) {
        super(material);
        this.setCreativeTab(budimain.tabrandom);
    }

    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 2));
        return true;
    }
}
