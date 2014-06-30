package com.budi.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;


import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public GuiHandler (){

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			TileEntityRedFurnace tileEntityFurnace = (TileEntityRedFurnace) world.getTileEntity(x, y, z);
			return new ContainerRedFurnace(player.inventory, tileEntityFurnace);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			TileEntityRedFurnace tileentityredfurnace = (TileEntityRedFurnace) world.getTileEntity(x, y, z);
			return new GuiRedFurnace(player.inventory, tileentityredfurnace);
		}
		return null;
	}

}