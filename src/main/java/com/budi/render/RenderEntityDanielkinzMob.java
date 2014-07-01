package com.budi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.budi.core.budimain;
import com.budi.entity.BudiMob;
import com.budi.entity.DanielkinzMob;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntityDanielkinzMob extends RenderLiving
{
    private static final ResourceLocation mobTextures = new ResourceLocation(budimain.MODID + ":textures/entity/DanielkinzMob.png");
    private static final String __OBFID = "CL_00000984";

    public RenderEntityDanielkinzMob(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(DanielkinzMob par1EntityCow)
    {
        return mobTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEntityTexture((DanielkinzMob)par1Entity);
    }
}
