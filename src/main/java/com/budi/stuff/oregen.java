package com.budi.stuff;
import java.util.Random;

import com.budi.core.budimain;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
public class oregen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

  /* runs 'generateNether' or 'generateSurface' depending on which dimension you're loading */
        switch(world.provider.dimensionId) {
            case -1: generateNether(world, random, chunkX*16, chunkZ*16);
                break;
            case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
                break;
        }

    }
    public void generateSurface(World world, Random random, int x, int z) {
        this.addOreSpawn(budimain.BlockEnderOre, world, random, x, z, 16, 16, 2, 3, 3, 15);
    }
    public void generateNether(World world, Random random, int x, int z) {

    }

    public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY ){
        for(int i = 0; i < chancesToSpawn; i++){
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY -minY);
            int posZ = blockZPos + random.nextInt(16);
            new WorldGenMinable(block, maxVeinSize).generate(world, random, posX, posY, posZ);
        }
    }

}
