package com.budi.blocks;

import java.util.Random;

import com.budi.core.budimain;
import com.budi.tileentity.TileEntityEnderFurnace;

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
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEnderFurnace extends BlockContainer {
	
	private static boolean isBurning;
	private final boolean isBurning2;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	@SideOnly(Side.CLIENT)
	private IIcon iconBottom;
	
	private static boolean keepInventory;
	private Random rand = new Random();

	public BlockEnderFurnace(boolean isActive) {
		super(Material.iron);;
		setHardness(3.5F);
		isBurning2 = isActive;
		if (this.isBurning2){
			this.setLightLevel(0.9F);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister) {
		this.blockIcon = iconregister.registerIcon(budimain.MODID + ":FurnaceSide");
		this.iconFront = iconregister.registerIcon(this.isBurning2 ? budimain.MODID + ":FurnaceActive" : budimain.MODID + ":FurnaceIdle");
		this.iconTop = iconregister.registerIcon(budimain.MODID + ":FurnaceTop");
		this.iconBottom = iconregister.registerIcon(budimain.MODID + ":FurnaceTop");
	}

	public IIcon getIcon(int side, int meta) {
		if (side == 1) {
			return iconTop;
		} else if (side == 3) {
			return iconFront;
		} else if (side == 0) {
			return iconBottom;
		}else{
			return this.blockIcon;
		}
	}
	
	public Item getItemDropped(int i, Random random, int j) {
		return Item.getItemFromBlock(budimain.BlockEnderFurnaceIdle);
	}
	
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z) {
		if(!world.isRemote){
			Block b1 = world.getBlock(x, y, z - 1);
			Block b2 = world.getBlock(x, y, z + 1);
			Block b3 = world.getBlock(x - 1, y, z);
			Block b4 = world.getBlock(x + 1, y, z);
			
			byte b0 = 3;
			
			if(b1.func_149730_j() && !b2.func_149730_j()){
				b0 = 3;
			}
			if(b2.func_149730_j() && !b1.func_149730_j()){
				b0 = 2;
			}
			if(b3.func_149730_j() && !b4.func_149730_j()){
				b0 = 5;
			}
			if(b4.func_149730_j() && !b3.func_149730_j()){
				b0 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
		
	}

	@Override
	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9) {
	if (!player.isSneaking()) {
	player.openGui(budimain.instance, budimain.guiEnderFurnace, var1, var2, var3, var4);
	return true;
	} else {
	return false;
	}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityEnderFurnace();
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if (this.isBurning2) {
			int direction = world.getBlockMetadata(x, y, z);

			float xx = (float) x + 0.5F, yy = (float) y + random.nextFloat() * 15.0F / 16.0F, zz = (float) z + 0.5F, xx2 = random.nextFloat() * 0.6F - 0.3F, zz2 = 0.52F;
            
            if (direction == 4)
            {
                world.spawnParticle("portal", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("portal", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("portal", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("portal", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("portal", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("portal", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("portal", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("portal", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("portal", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("portal", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("portal", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("portal", (double)(xx - zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            }
            else if (direction == 5)
            {
            	world.spawnParticle("portal", (double)(xx + zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + zz2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            }
            else if (direction == 2)
            {
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz - xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz - xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz - xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz - xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz - xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz - xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz - xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz - xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz - xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz - xx2), 0.0D, 0.0D, 0.0D);
            }
            else if (direction == 3)
            {
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("portal", (double)(xx + xx2), (double)yy, (double)(zz + xx2), 0.0D, 0.0D, 0.0D);
            }
		}
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack){
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if(l == 0){
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(l == 1){
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if(l == 2){
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(l == 3){
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		if(itemstack.hasDisplayName()){
			//((TileEntityEnderFurnace)world.getTileEntity(x, y, z).setGuiDisplayName(itemstack.getDisplayName());
		}
	}
	
	
	public static void updateBlockState(boolean burning, World world, int x, int y, int z) {
		int direction = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		isBurning = true;

		if (burning) {
			world.setBlock(x, y, z, budimain.BlockEnderFurnaceActive);
		} else {
			world.setBlock(x, y, z, budimain.BlockEnderFurnaceIdle);
		}

		isBurning = false;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);

		if (tileentity != null) {
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (!isBurning) {
			TileEntityEnderFurnace tileentityenderfurnace = (TileEntityEnderFurnace) world.getTileEntity(x, y, z);

			if (tileentityenderfurnace != null) {
				for (int i = 0; i < tileentityenderfurnace.getSizeInventory(); ++i) {
					ItemStack itemstack = tileentityenderfurnace.getStackInSlot(i);

					if (itemstack != null) {
						float f = this.rand.nextFloat() * 0.6F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.6F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.6F + 0.1F;

						while (itemstack.stackSize > 0) {
							int j = this.rand.nextInt(21) + 10;

							if (j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}

							itemstack.stackSize -= j;
							EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) {
								entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
							}

							float f3 = 0.025F;
							entityitem.motionX = (double) ((float) this.rand.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.rand.nextGaussian() * f3 + 0.1F);
							entityitem.motionZ = (double) ((float) this.rand.nextGaussian() * f3);
							world.spawnEntityInWorld(entityitem);
						}
					}
				}
				world.func_147453_f(x, y, z, block);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}
	
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(budimain.BlockEnderFurnaceIdle);
	}
}