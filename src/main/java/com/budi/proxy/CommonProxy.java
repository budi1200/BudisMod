package com.budi.proxy;

public class CommonProxy {

    public void registerRenderers() {
// Nothing here as the server doesn't render graphics or entities!
    }
    public int addArmor(String string) {
        return 0; // don't want to return anything for the server
    }

}