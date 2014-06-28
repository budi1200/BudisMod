package com.budi.proxy;

import net.minecraft.client.model.ModelBiped;
import cpw.mods.fml.client.registry.RenderingRegistry;
import com.budi.stuff.RandomEntity;
import com.budi.stuff.Render;

public class ClientProxy extends CommonProxy{

    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(RandomEntity.class, new Render(new ModelBiped(), 0.5F));

    }
    @Override
    public int addArmor(String armor) {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }}