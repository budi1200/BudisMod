package com.budi.stuff;

import com.budi.core.budimain;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class Render extends RenderBiped {

    private static final ResourceLocation textureLocation = new ResourceLocation(budimain.MODID + ":" + "textures/models/entityTest.png");

    public Render(ModelBiped model, float shadowSize) {
        super(model, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return textureLocation;
    }
}