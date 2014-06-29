package com.budi.core;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockEnderFurnace extends BlockContainer {
	
	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;
	
	private static boolean isBurning;
	private static boolean isBurning2;
	private final Random random = new Random();
	
	protected BlockEnderFurnace(boolean isActive) {
		super(Material.rock);
		isBurning2 = isActive;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister){
		this.blockIcon = iconregister.registerIcon(budimain.MODID + ":" + "FurnaceSide");
		this.front = iconregister.registerIcon(this.isBurning2 ? budimain.MODID + ":" + "FurnaceActive" : budimain.MODID + "FurnaceIdle");
		this.top = iconregister.registerIcon(budimain.MODID + ":" + "FurnaceTop");
	}
	
	public IIcon getIcon(int side, int meta){
		if(side == 1){
			return top;
		} else if(side == 3){
			return front;
		} else{
			return this.blockIcon;
		}
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
                    if (world.isRemote)
                    {
                     return true;
                    }
                    else if (!player.isSneaking())
                    {
                                    TileEntityEnderFurnace tileentitypestle = (TileEntityEnderFurnace)world.getTileEntity(x, y, z);
                                    if (tileentitypestle != null)
                                    {
                                     player.openGui(budimain.instance, budimain.furnaceender, world, (int) player.posX, (int) player.posY, (int) player.posZ);
                                    }
                                    return true;
                    }
      
                    return false;
     
    }
	
	public Item getItemDropped(int par1, Random random, int par3){
		return Item.getItemFromBlock(budimain.BlockEnderFurnaceIdle);
	}
	
	public Item getItem(World world, int par2, int par3, int par4){
		return Item.getItemFromBlock(budimain.BlockEnderFurnaceIdle);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new TileEntityFurnace();
	}
	
	@SideOnly(Side.CLIENT)
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.direction(world, x, y, z);
	}

	private void direction(World world, int x, int y, int z) {
		if(!world.isRemote){
			Block direction = world.getBlock(x, y, z - 1);
			Block direction1 = world.getBlock(x, y, z + 1);
			Block direction2 = world.getBlock(x - 1, y, z);
			Block direction3 = world.getBlock(x + 1, y, z);
			byte byte0 = 3;
			
			if(direction.func_149730_j() && direction.func_149730_j()){
				byte0 = 3;
			}
			if(direction.func_149730_j() && direction.func_149730_j()){
				byte0 = 2;
			}
			if(direction.func_149730_j() && direction.func_149730_j()){
				byte0 = 5;
			}
			if(direction.func_149730_j() && direction.func_149730_j()){
				byte0 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, byte0, 2);
			
		}
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack){
		int direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if(direction == 0){
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(direction == 1){
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if(direction == 2){
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(direction == 3){
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		
		if(itemstack.hasDisplayName()){
			((TileEntityEnderFurnace) world.getTileEntity(x, y, z)).furnaceName(itemstack.getDisplayName());
		}
	}
	
	public static void updateBlockState(boolean burning, World world, int x, int y, int z){
		int direction = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		isBurning = true;
		
		if(burning){
			world.setBlock(x, y, z, budimain.BlockEnderFurnaceActive);
		}else{
			world.setBlock(x, y, z, budimain.BlockEnderFurnaceIdle);
		}
		
		isBurning = false;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
	
		if(tileentity != null){
			tileentity.validate();world.setTileEntity(x, y, z, tileentity);
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block block, int meta){
		if(!isBurning){
			TileEntityEnderFurnace tileentityenderfurnace = (TileEntityEnderFurnace)world.getTileEntity(x, y, z);
			
			if(tileentityenderfurnace != null){
				for(int i = 0; i < tileentityenderfurnace.getSizeInventory(); ++i){
					ItemStack itemstack = tileentityenderfurnace.getStackInSlot(i);
					
					if(itemstack != null){
						float f = this.random.nextFloat() * 0.6F + 0.1F;
						float f1 = this.random.nextFloat() * 0.6F + 0.1F;
						float f2 = this.random.nextFloat() * 0.6F + 0.1F;
						
						while(itemstack.stackSize > 0){
							int j = this.random.nextInt(21) + 10;
							
							if(j > itemstack.stackSize){
								j = itemstack.stackSize;
							}
							
							itemstack.stackSize -= j;
							EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
							
							if(itemstack.hasTagCompound()){
								entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
							}
							
							float f3 = 0.025F;
							entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
							entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
							world.spawnEntityInWorld(entityitem);
						}
					}
				}
				world.func_147453_f(x, y, z, block);
				
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random){
		if(this.isBurning2){
			int direction = world.getBlockMetadata(x, y, z);
			
			float xx = (float) x + 0.5F, yy = (float) y + random.nextFloat() * 6.0F /16.0F, zz = (float) z + 0.5F, xx2 = random.nextFloat() * 0.3F - 0.2F, zz2 = 0.5F;
					
			if(direction == 4){
				world.spawnParticle("smoke", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);	
			} else if(direction == 5){
				world.spawnParticle("smoke", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);	
			} else if(direction == 3){
				world.spawnParticle("smoke", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);	
			} else if(direction == 2){
				world.spawnParticle("smoke", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);	
		}
	}
	
	
	
	
	
	
	
	
}

}
