package com.budi.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
	TileEntity tile_entity = world.getTileEntity(x, y, z);
	if (id == budimain.guiID)
	{
	return new ContainerEnderFurnace(player.inventory, (TileEntityEnderFurnace) tile_entity);
	}
	return null;
	}
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
	TileEntity tile_entity = world.getTileEntity(x, y, z);
	if (id == budimain.guiID)
	{
	return new GuiEnderFurnace(player.inventory, (TileEntityEnderFurnace) tile_entity);
	}
	return null;
	}
	}
