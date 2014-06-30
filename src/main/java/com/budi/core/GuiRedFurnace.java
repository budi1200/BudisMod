package com.budi.core;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiRedFurnace extends GuiContainer {
	
	public static final ResourceLocation bground = new ResourceLocation(budimain.MODID, "textures/gui/GuiFurnace.png");
	
	public TileEntityRedFurnace fermenter;

	public GuiRedFurnace(InventoryPlayer invPlayer, TileEntityRedFurnace tile) {
		super(new ContainerRedFurnace(invPlayer, tile));
		
		this.fermenter = tile;

		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		String name = this.fermenter.hasCustomInventoryName() ? this.fermenter.getInventoryName() : I18n.format(this.fermenter.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
		
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		guiDraw(bground);
		
		if(this.fermenter.isBurning()) {
			int k = this.fermenter.getBurnTimeRemainingScaled(12);
			int j = 40 - k;
			
	        this.drawTexturedModalRect(guiLeft + 56, guiTop + 36 + 12 - k, 176, 12 - k, 14, k + 2);
		}
		
		int k = this.fermenter.getCookProgressScaled(24);
		this.drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 14, k + 1, 16);
	}
	
	protected void guiDraw(ResourceLocation var1) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(var1);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
	}

}
