package agents.mod.entity;

import agents.mod.AgentsMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class EntityAgents {
	
	public static void mainRegistry() {
		registerEntity();
	}
	
	public static void registerEntity() 
	{
		createEntity(Enderboy.class, "Enderboy", 0xCC00FF, 0xFF00E1);
		createEntity(Agent7.class, "RedstonerSmith", 0x3F48CC, 0x00A2E8);
		createEntity(BAgent7.class, "BlackAgent7", 0xBF0000, 0x000000);
		createEntity(Agent49.class, "DyllanaSmith", 0x7F7F7F, 0x00A2E8);
		createEntity(Burner.class, "Burner", 0xFF7F27, 0xBF0000);
		createEntity(Wraith.class, "Wraith", 0x493F3F, 0x7A7A7A);
		createEntity(Notch.class, "Notch", 0xB97A57, 0x5A3825);
		createEntity(Herobrine.class, "Herobrine", 0x3F48CC, 0xFFFFFF);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) 
	{
		
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
		EntityRegistry.registerModEntity(entityClass, entityName, randomID, AgentsMod.modInstance, 6400, 1, true);
		EntityRegistry.addSpawn(entityClass, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.sky);
		
		createEgg(randomID, solidColor, spotColor);
	}
	
	private static void createEgg(int randomID, int solidColor, int spotColor) 
	{
		EntityList.entityEggs.put(Integer.valueOf(randomID), new EntityList.EntityEggInfo(randomID, solidColor, spotColor));
	}
	
}
