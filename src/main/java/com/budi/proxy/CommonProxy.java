package com.budi.proxy;


import com.budi.core.TileEntityEnderFurnace;
import com.budi.core.budimain;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void registerRenderers() {
// Nothing here as the server doesn't render graphics or entities!
    }
    public int addArmor(String string) {
        return 0; // don't want to return anything for the server
    }
    public void registerTileEntities(){
    GameRegistry.registerTileEntity(TileEntityEnderFurnace.class, budimain.MODID + "TileEntityEnderFurnace");
    }

}