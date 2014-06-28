package com.budi.armor;

import com.budi.core.budimain;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class enderArmor extends ItemArmor {
    private String [] armourTypes = new String [] {"helmetender", "chestplateender", "leggingsender", "bootsender"};

    public enderArmor(ArmorMaterial armorMaterial, int renderIndex, int armourType){
        super(armorMaterial, renderIndex, armourType);
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer){
        if(stack.getItem().equals(budimain.helmetender)|| stack.getItem().equals(budimain.chestplateender)|| stack.getItem().equals(budimain.bootsender)){
        return "budimod:textures/armor/ender_1.png";
        }

        if (stack.getItem().equals(budimain.leggingsender)){
            return "budimod:textures/armor/ender_2.png";
        }
        else return null;
    }
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 50, 4));
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 5));
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 50, 2));
    }
    @Override
    public void registerIcons(IIconRegister reg){
        if(this == budimain.helmetender)
            this.itemIcon = reg.registerIcon("budimod:helmetender");
        if(this == budimain.chestplateender)
            this.itemIcon = reg.registerIcon("budimod:chestplateender");
        if(this == budimain.leggingsender)
            this.itemIcon = reg.registerIcon("budimod:leggingsender");
        if(this == budimain.bootsender)
            this.itemIcon = reg.registerIcon("budimod:bootsender");
    }
}
