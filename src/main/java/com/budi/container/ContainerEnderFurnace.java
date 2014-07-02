package com.budi.container;

import com.budi.tileentity.TileEntityEnderFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerEnderFurnace extends Container {
	
	private TileEntityEnderFurnace fermenter;
	
	public int lastBurnTime;
	public int lastCurrentItemBurnTime;
	public int lastCookTime;

	public ContainerEnderFurnace(InventoryPlayer player, TileEntityEnderFurnace tileentity){
		this.fermenter = tileentity;
		this.addSlotToContainer(new Slot(tileentity, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileentity, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(player.player, tileentity, 2, 116, 35));
		int i;
		
		for(i = 0; i < 3; ++i){
			for(int j = 0; j < 9; ++j){
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(i = 0; i < 9; ++i){
			this.addSlotToContainer(new Slot(player, i , 8 + i * 18 , 142));
		}
	}
	
	public void addCraftingToCrafters(ICrafting craft){
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 0, this.fermenter.cookTime);
		craft.sendProgressBarUpdate(this, 1, this.fermenter.burnTime);
		craft.sendProgressBarUpdate(this, 2, this.fermenter.currentItemBurnTime);
	}

	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); ++i){
			ICrafting craft = (ICrafting) this.crafters.get(i);

			if(this.lastCookTime != this.fermenter.cookTime){
				craft.sendProgressBarUpdate(this, 0, this.fermenter.cookTime);
			}

			if(this.lastBurnTime != this.fermenter.burnTime){
				craft.sendProgressBarUpdate(this, 1, this.fermenter.burnTime);
			}

			if(this.lastCurrentItemBurnTime != this.fermenter.currentItemBurnTime){
				craft.sendProgressBarUpdate(this, 2, this.fermenter.currentItemBurnTime);
			}
		}

		this.lastBurnTime = this.fermenter.burnTime;
		this.lastCookTime = this.fermenter.cookTime;
		this.lastCurrentItemBurnTime = this.fermenter.currentItemBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2){
		if(par1 == 0){
			this.fermenter.cookTime = par2;
		}

		if(par1 == 1){
			this.fermenter.burnTime = par2;
		}

		if(par1 == 2){
			this.fermenter.currentItemBurnTime = par2;
		}
	}
	public ItemStack transferStackInSlot(EntityPlayer player, int clickedSlotNumber){
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(clickedSlotNumber);

		if(slot != null && slot.getHasStack()){
		ItemStack itemstack1 = slot.getStack();
		itemstack = itemstack1.copy();

		if(clickedSlotNumber == 2){
		if(!this.mergeItemStack(itemstack1, 3, 39, true)){
		return null;
		}

		slot.onSlotChange(itemstack1, itemstack);
		}else if(clickedSlotNumber != 1 && clickedSlotNumber != 0){
		if(FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null){
		if(!this.mergeItemStack(itemstack1, 0, 1, false)){
		return null;
		}
		}else if(TileEntityEnderFurnace.isItemFuel(itemstack1)){
		if(!this.mergeItemStack(itemstack1, 1, 2, false)){
		return null;
		}
		}else if(clickedSlotNumber >= 3 && clickedSlotNumber < 30){
		if(!this.mergeItemStack(itemstack1, 30, 39, false)){
		return null;
		}
		}else if(clickedSlotNumber >= 30 && clickedSlotNumber < 39){
		if(!this.mergeItemStack(itemstack1, 3, 30, false)){
		return null;
		}
		}
		}else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
		return null;
		}

		if(itemstack1.stackSize == 0){
		slot.putStack((ItemStack)null);
		}else{
		slot.onSlotChanged();
		}

		if(itemstack1.stackSize == itemstack.stackSize){ 
		return null;
		}

		slot.onPickupFromSlot(player, itemstack1);
		}

		return itemstack;

		}
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.fermenter.isUseableByPlayer(player);
	}

}
