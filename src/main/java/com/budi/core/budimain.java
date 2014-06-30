package com.budi.core;

import com.budi.alphabet.*;
import com.budi.armor.enderArmor;
import com.budi.blocks.*;
import com.budi.food.*;
import com.budi.items.LolItem;
import com.budi.items.enderiumIngot;
import com.budi.items.enderiumdust;
import com.budi.items.rawenderium;
import com.budi.proxy.CommonProxy;
import com.budi.stuff.*;
import com.budi.tools.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Random;

@Mod(modid = budimain.MODID, version = budimain.VERSION, name = budimain.name)
public class budimain
{
	public static final String MODID = "budimod", name = "BudiMod!";
    public static final String VERSION = "5.0";
    
    @Instance("budimod")
    public static budimain instance;
    
    @SidedProxy(clientSide="com.budi.proxy.ClientProxy", serverSide ="com.budi.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    public void registerBlock(Block block, String name){
    	GameRegistry.registerBlock(block, block.getUnlocalizedName());
    	LanguageRegistry.addName(block, name);
    }

    // creative tab
    public static CreativeTabs tabrandom = new creativeTab("Budis Stuff");
    public static CreativeTabs tabwords = new wordsTab("Budis Words");
    // blocks

    public static Block BlockLol;
    public static Block BlockHelloWorld;
    public static Block BlockEnderOre;
    public static Block BlockBlaze;
    public static Block BlockEnder;
    public static Block BlockNetherStar;
    public static Block BlockEnderTorch;
    public static final int guiEnderFurnace = 0;
    public static Block BlockEnderFurnaceIdle;
    public static Block BlockEnderFurnaceActive;

    // items
    public static Item LolItem;
    public static Item pickaxeEnder;
    public static Item shovelEnder;
    public static Item axeEnder;
    public static Item enderiumIngot;
    public static Item enderiumdust;
    public static Item rawenderium;
    public static Item swordEnder;
    public static Item superoptool;
    public static Item Goldbeef;
    public static Item RawGoldBeef;

    public static Item helmetender;
    public static Item chestplateender;
    public static Item leggingsender;
    public static Item bootsender;
    public static oregen oregen = new oregen();
    
    
    // abeceda wooo

    public static Item wordA;
    public static Item wordB;
    public static Item wordC;
    public static Item wordD;
    public static Item wordE;
    public static Item wordF;
    public static Item wordG;
    public static Item wordH;
    public static Item wordI;
    public static Item wordJ;
    public static Item wordK;
    public static Item wordL;
    public static Item wordM;
    public static Item wordN;
    public static Item wordO;
    public static Item wordP;
    public static Item wordQ;
    public static Item wordR;
    public static Item wordS;
    public static Item wordT;
    public static Item wordU;
    public static Item wordV;
    public static Item wordW;
    public static Item wordX;
    public static Item wordY;
    public static Item wordZ;
    // adds material
    public static final Item.ToolMaterial enderium = EnumHelper.addToolMaterial("enderium", 3, 10000, 30.0F, 5.0F, 30);
    public static final Item.ToolMaterial oprock = EnumHelper.addToolMaterial("oprock", 3, 100000, 1000.0F, 0.1F, 0);
    public static ItemArmor.ArmorMaterial enderArmor = EnumHelper.addArmorMaterial("enderium", 66, new int[] {3, 9, 6, 3}, 30);
    //entity
    @Mod.EventHandler

    public void preInt(FMLPreInitializationEvent event)
    {
    	proxy.registerRenderers();
    	proxy.registerTileEntities();
    }
    public static void registerEntity(Class entityClass, String name)
    {
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        long seed = name.hashCode();
        Random rand = new Random(seed);
        int primaryColor = rand.nextInt() * 16777215;
        int secondaryColor = rand.nextInt() * 16777215;
        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
        EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
        EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }

    // add blocks/items/entity's
    @EventHandler
    public void init(FMLInitializationEvent event){
    proxy.registerRenderers();
    NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    GameRegistry.registerTileEntity(TileEntityEnderFurnace.class, "tileentityenderfurnace");
        // Blocks
        //ender ore
        BlockEnderOre = new BlockEnderOre(Material.rock).setBlockName("BlockEnderOre").setCreativeTab(tabrandom);
        GameRegistry.registerBlock(BlockEnderOre, "BlockEnderOre");

        // lol block:D

        BlockLol = new BlockLol().setBlockName("BlockLol").setHardness(3F).setResistance(50F);
        BlockLol.setHarvestLevel("pickaxe", 3);
        GameRegistry.registerBlock(BlockLol, BlockLol.getUnlocalizedName().substring(5));

        //Hello World block

        BlockHelloWorld = new BlockHelloWorld().setBlockName("BlockHelloWorld").setHardness(0.0F);
        GameRegistry.registerBlock(BlockHelloWorld, BlockHelloWorld.getUnlocalizedName().substring(5));
        //blazing block

        BlockBlaze = new BlockBlaze().setBlockName("BlockBlaze").setHardness(4F).setResistance(20F);
        GameRegistry.registerBlock(BlockBlaze, BlockBlaze.getUnlocalizedName().substring(5));


        // ender block

        BlockEnder = new BlockEnder().setBlockName("BlockEnder").setHardness(5F).setResistance(20F);
        GameRegistry.registerBlock(BlockEnder, BlockEnder.getUnlocalizedName().substring(5));


        // NETHER STAR BLOCK WOOOO

        BlockNetherStar = new BlockNetherStar().setBlockName("BlockNetherStar").setHardness(7F).setResistance(50F).setStepSound(Block.soundTypeMetal);
        GameRegistry.registerBlock(BlockNetherStar, BlockNetherStar.getUnlocalizedName().substring(5));
        
        // furnace       
        BlockEnderFurnaceIdle = new BlockEnderFurnace(false).setBlockName("BlockEnderFurnaceIdle").setHardness(3.5F).setCreativeTab(budimain.tabrandom);
        GameRegistry.registerBlock(BlockEnderFurnaceIdle, "BlockEnderFurnaceIdle");
        
        BlockEnderFurnaceActive = new BlockEnderFurnace(true).setBlockName("BlockEnderFurnaceActive").setHardness(3.5F).setLightOpacity((int) 0.8F);
        GameRegistry.registerBlock(BlockEnderFurnaceActive, "BlockEnderFurnaceActive"); 
        // Items


        // enderium dust

        enderiumdust = new enderiumdust().setUnlocalizedName("enderiumdust").setTextureName(budimain.MODID + ":" + "enderiumdust");
        GameRegistry.registerItem(enderiumdust, enderiumdust.getUnlocalizedName().substring(5));

        // raw enderium

        rawenderium = new rawenderium().setUnlocalizedName("rawenderium").setTextureName(budimain.MODID + ":" + "rawenderium");
        GameRegistry.registerItem(rawenderium, rawenderium.getUnlocalizedName().substring(5));

        //enderium ingot

        enderiumIngot = new enderiumIngot().setUnlocalizedName("enderiumIngot").setTextureName(budimain.MODID + ":" + "enderiumIngot");
        GameRegistry.registerItem(enderiumIngot, enderiumIngot.getUnlocalizedName().substring(5));

        // lol item:D

        LolItem = new LolItem().setUnlocalizedName("LolItem").setTextureName(budimain.MODID + ":" + "LolItem");
        GameRegistry.registerItem(LolItem, LolItem.getUnlocalizedName().substring(5));

        // Enderium Pickaxe

        pickaxeEnder = new EnderPickaxe(enderium).setUnlocalizedName("pickaxeEnder").setTextureName(budimain.MODID + ":" + "pickaxeEnder");
        GameRegistry.registerItem(pickaxeEnder, "pickaxeEnder");

        // enderium shovel

        shovelEnder = new EnderShovel(enderium).setUnlocalizedName("shovelEnder").setTextureName(budimain.MODID + ":" + "shovelEnder");
        GameRegistry.registerItem(shovelEnder, "shovelEnder");
        // enderium axe

        axeEnder = new EnderAxe(enderium).setUnlocalizedName("axeEnder").setTextureName(budimain.MODID + ":"	+ "axeEnder");
        GameRegistry.registerItem(axeEnder, "axeEnder");

        // enderium sword

        swordEnder = new EnderSword(enderium).setUnlocalizedName("swordEnder").setTextureName(budimain.MODID + ":" + "swordEnder");
        GameRegistry.registerItem(swordEnder, "swordEnder");

        // super op tool
        superoptool = new EnderOpTool(oprock).setUnlocalizedName("superoptool").setTextureName(budimain.MODID + ":" + "superoptool");
        GameRegistry.registerItem(superoptool, superoptool.getUnlocalizedName().substring(5));

        // test entity

        registerEntity(RandomEntity.class, "EntityTest");

        //generation

        GameRegistry.registerWorldGenerator(oregen, 1);

        // supertorch
        BlockEnderTorch = new BlockEnderTorch().setBlockName("BlockEnderTorch").setHardness(0F).setResistance(20F);
        GameRegistry.registerBlock(BlockEnderTorch, BlockEnderTorch.getUnlocalizedName().substring(5));

        // gold beef
        Goldbeef = new Goldbeef(5000, 10, false).setUnlocalizedName("Goldbeef").setTextureName(budimain.MODID + ":" + "Goldbeef");
        GameRegistry.registerItem(Goldbeef, Goldbeef.getUnlocalizedName().substring(5));
        
        RawGoldBeef = new rawgoldbeef(5000, 10, false).setUnlocalizedName("RawGoldbeef").setTextureName(budimain.MODID + ":" + "RawGoldbeef");
        GameRegistry.registerItem(RawGoldBeef, RawGoldBeef.getUnlocalizedName().substring(5));

        // ABECEDA WOO

        wordA = new wordA().setUnlocalizedName("wordA");
        GameRegistry.registerItem(wordA, wordA.getUnlocalizedName().substring(5));

        wordB = new wordB().setUnlocalizedName("wordB");
        GameRegistry.registerItem(wordB, wordB.getUnlocalizedName().substring(5));

        wordC = new wordC().setUnlocalizedName("wordC");
        GameRegistry.registerItem(wordC, wordC.getUnlocalizedName().substring(5));

        wordD = new wordD().setUnlocalizedName("wordD");
        GameRegistry.registerItem(wordD, wordD.getUnlocalizedName().substring(5));

        wordE = new wordE().setUnlocalizedName("wordE");
        GameRegistry.registerItem(wordE, wordE.getUnlocalizedName().substring(5));

        wordF = new wordF().setUnlocalizedName("wordF");
        GameRegistry.registerItem(wordF, wordF.getUnlocalizedName().substring(5));

        wordG = new wordG().setUnlocalizedName("wordG");
        GameRegistry.registerItem(wordG, wordG.getUnlocalizedName().substring(5));

        wordH = new wordH().setUnlocalizedName("wordH");
        GameRegistry.registerItem(wordH, wordH.getUnlocalizedName().substring(5));

        wordI = new wordI().setUnlocalizedName("wordI");
        GameRegistry.registerItem(wordI, wordI.getUnlocalizedName().substring(5));

        wordJ = new wordJ().setUnlocalizedName("wordJ");
        GameRegistry.registerItem(wordJ, wordJ.getUnlocalizedName().substring(5));

        wordK = new wordK().setUnlocalizedName("wordK");
        GameRegistry.registerItem(wordK, wordK.getUnlocalizedName().substring(5));

        wordL = new wordL().setUnlocalizedName("wordL");
        GameRegistry.registerItem(wordL, wordL.getUnlocalizedName().substring(5));

        wordM = new wordM().setUnlocalizedName("wordM");
        GameRegistry.registerItem(wordM, wordM.getUnlocalizedName().substring(5));

        wordN = new wordN().setUnlocalizedName("wordN");
        GameRegistry.registerItem(wordN, wordN.getUnlocalizedName().substring(5));

        wordO = new wordO().setUnlocalizedName("wordO");
        GameRegistry.registerItem(wordO, wordO.getUnlocalizedName().substring(5));

        wordP = new wordP().setUnlocalizedName("wordP");
        GameRegistry.registerItem(wordP, wordP.getUnlocalizedName().substring(5));

        wordQ = new wordQ().setUnlocalizedName("wordQ");
        GameRegistry.registerItem(wordQ, wordQ.getUnlocalizedName().substring(5));

        wordR = new wordR().setUnlocalizedName("wordR");
        GameRegistry.registerItem(wordR, wordR.getUnlocalizedName().substring(5));

        wordS = new wordS().setUnlocalizedName("wordS");
        GameRegistry.registerItem(wordS, wordS.getUnlocalizedName().substring(5));

        wordT = new wordT().setUnlocalizedName("wordT");
        GameRegistry.registerItem(wordT, wordT.getUnlocalizedName().substring(5));

        wordU = new wordU().setUnlocalizedName("wordU");
        GameRegistry.registerItem(wordU, wordU.getUnlocalizedName().substring(5));

        wordV = new wordV().setUnlocalizedName("wordV");
        GameRegistry.registerItem(wordV, wordV.getUnlocalizedName().substring(5));

        wordW = new wordW().setUnlocalizedName("wordW");
        GameRegistry.registerItem(wordW, wordW.getUnlocalizedName().substring(5));

        wordX = new wordX().setUnlocalizedName("wordX");
        GameRegistry.registerItem(wordX, wordX.getUnlocalizedName().substring(5));

        wordY = new wordY().setUnlocalizedName("wordY");
        GameRegistry.registerItem(wordY, wordY.getUnlocalizedName().substring(5));

        wordZ = new wordZ().setUnlocalizedName("wordZ");
        GameRegistry.registerItem(wordZ, wordZ.getUnlocalizedName().substring(5));

        // armor
        int renderEnderArmor = proxy.addArmor("ender");

        helmetender = new enderArmor(enderArmor, renderEnderArmor, 0).setUnlocalizedName("helmetender").setCreativeTab(budimain.tabrandom);
        GameRegistry.registerItem(helmetender, "helmetender");
        chestplateender = new enderArmor(enderArmor, renderEnderArmor, 1).setUnlocalizedName("chestplateender").setCreativeTab(budimain.tabrandom);
        GameRegistry.registerItem(chestplateender, "chestplateender");
        leggingsender = new enderArmor(enderArmor, renderEnderArmor, 2).setUnlocalizedName("leggingsender").setCreativeTab(budimain.tabrandom);
        GameRegistry.registerItem(leggingsender, "leggingsender");
        bootsender = new enderArmor(enderArmor, renderEnderArmor, 3).setUnlocalizedName("bootsender").setCreativeTab(budimain.tabrandom);
        GameRegistry.registerItem(bootsender, "bootsender");
        // Recepies
        GameRegistry.addShapelessRecipe(new ItemStack(Items.blaze_rod, 4), new ItemStack(budimain.BlockBlaze));
        GameRegistry.addShapelessRecipe(new ItemStack(budimain.BlockBlaze, 1), new ItemStack(Items.blaze_rod), new ItemStack(Items.blaze_rod), new ItemStack(Items.blaze_rod), new ItemStack(Items.blaze_rod));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl, 4), new ItemStack(budimain.BlockEnder));
        GameRegistry.addShapelessRecipe(new ItemStack(budimain.BlockEnder, 1), new ItemStack(Items.ender_pearl), new ItemStack(Items.ender_pearl), new ItemStack(Items.ender_pearl), new ItemStack(Items.ender_pearl));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.nether_star, 4), new ItemStack(budimain.BlockNetherStar));
        GameRegistry.addShapelessRecipe(new ItemStack(budimain.BlockNetherStar, 1), new ItemStack(Items.nether_star), new ItemStack(Items.nether_star), new ItemStack(Items.nether_star), new ItemStack(Items.nether_star));
        GameRegistry.addSmelting(budimain.BlockEnderOre, new ItemStack(budimain.enderiumdust), 0.8F);
        GameRegistry.addShapelessRecipe(new ItemStack(budimain.rawenderium, 1), new ItemStack(budimain.enderiumdust), Items.diamond, Items.gold_ingot, Items.iron_ingot, Items.ender_pearl);
        GameRegistry.addSmelting(budimain.rawenderium, new ItemStack(budimain.enderiumIngot), 1.0F);
        GameRegistry.addRecipe(new ItemStack(budimain.pickaxeEnder, 1), new Object[]{ "XXX", " C ", " # ", ('X'), enderiumIngot, ('#'), Items.diamond, ('C'), Items.diamond_pickaxe});
        GameRegistry.addRecipe(new ItemStack(budimain.superoptool, 1), new Object[]{ "XCX", "YOY", " P ", ('X'), enderiumIngot, ('C'), pickaxeEnder, ('Y'), Blocks.redstone_block, ('O'), Items.nether_star, ('P'), Items.diamond});
        GameRegistry.addRecipe(new ItemStack(budimain.swordEnder, 1), new Object[]{ "WEW", " E ", " S ", ('W'), new ItemStack(Items.skull, 1, 1), ('E'), enderiumIngot, ('S'), Items.diamond_sword});
        GameRegistry.addRecipe(new ItemStack(budimain.axeEnder, 1), new Object[]{ "EE ", "SE ", " A ", ('E'), enderiumIngot, ('S'), Items.spider_eye, ('A'), Items.diamond_axe});
        GameRegistry.addRecipe(new ItemStack(budimain.shovelEnder, 1), new Object[]{ " E ", " E ", " S ", ('E'), enderiumIngot, ('S'), Items.diamond_shovel});
        GameRegistry.addRecipe(new ItemStack(budimain.BlockEnderFurnaceIdle, 1), new Object[]{ "EEE", "E E", "EFE", ('E'), enderiumIngot, ('F'), Blocks.furnace});
        
        GameRegistry.addRecipe(new ItemStack(budimain.helmetender, 1), new Object[]{ "EHE", "E E", "   ", ('E'), enderiumIngot, ('H'), Items.diamond_helmet});
        GameRegistry.addRecipe(new ItemStack(budimain.chestplateender, 1), new Object[]{ "E E", "ECE", "EEE", ('E'), enderiumIngot, ('C'), Items.diamond_chestplate});
        GameRegistry.addRecipe(new ItemStack(budimain.leggingsender, 1), new Object[]{ "ELE", "E E", "E E", ('E'), enderiumIngot, ('L'), Items.diamond_leggings});
        GameRegistry.addRecipe(new ItemStack(budimain.bootsender, 1), new Object[]{ "   ", "EBE", "E E", ('E'), enderiumIngot, ('B'), Items.diamond_boots});
    }













}
