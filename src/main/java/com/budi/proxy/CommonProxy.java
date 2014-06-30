package com.budi.proxy;


import com.budi.core.TileEntityRedFurnace;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void registerRenderers() {
    }
    public int addArmor(String string) {
        return 0; 
    }
	public void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntityRedFurnace.class, "TileEntityRedFurnace");
	}

}