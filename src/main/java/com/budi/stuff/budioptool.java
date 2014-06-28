package com.budi.stuff;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import com.google.common.collect.Sets;

public class budioptool extends ItemTool
{
    private static final Set field_150915_c = Sets.newHashSet(new Block[] {Blocks.glass, Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.dirt, Blocks.netherrack, Blocks.obsidian, Blocks.gravel, Blocks.grass, Blocks.sand, Blocks.nether_brick, Blocks.nether_brick_fence, Blocks.cobblestone_wall, Blocks.nether_brick_stairs, Blocks.packed_ice});
    private static final String __OBFID = "CL_00000053";

    protected budioptool(Item.ToolMaterial p_i45347_1_)
    {
        super(2.0F, p_i45347_1_, field_150915_c);
    }

}

