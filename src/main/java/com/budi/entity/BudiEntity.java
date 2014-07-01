package com.budi.entity;

import net.minecraft.entity.EntityList;

import com.budi.core.budimain;

import cpw.mods.fml.common.registry.EntityRegistry;

public class BudiEntity {
	public static void budimain(){
		registerEntity();
	}
	
	public static void registerEntity(){
		createEntity(BudiMob.class, "Budi Mob", 0x58B8ED, 0x20E655);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColour, int spotColour){
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, budimain.instance, 64, 1, true);
		createEgg(randomId, solidColour, spotColour);
	}

	private static void createEgg(int randomId, int solidColour, int spotColour) {
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColour, spotColour));
		
		
	}
	
}
