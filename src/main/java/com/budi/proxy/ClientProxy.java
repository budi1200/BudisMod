package com.budi.proxy;

import net.minecraft.client.model.ModelBiped;

import com.budi.entity.BudiMob;
import com.budi.entity.DanielkinzMob;
import com.budi.model.ModelBudiMob;
import com.budi.model.ModelDanielkinzMob;
import com.budi.render.RenderEntityBudiMob;
import com.budi.render.RenderEntityDanielkinzMob;
import com.budi.stuff.RandomEntity;
import com.budi.stuff.Render;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(RandomEntity.class, new Render(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(BudiMob.class, new RenderEntityBudiMob(new ModelBudiMob(), 0));
        RenderingRegistry.registerEntityRenderingHandler(DanielkinzMob.class, new RenderEntityDanielkinzMob(new ModelDanielkinzMob(), 0));

    }
    @Override
    public int addArmor(String armor) {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }}