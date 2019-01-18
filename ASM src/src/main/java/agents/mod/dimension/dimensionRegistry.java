package agents.mod.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;

public class dimensionRegistry 
{
	public static void mainRegistry() 
	{
		registerDimension();
	}
	
	public static final int dimensionId = -2;
	
	public static void registerDimension() 
	{
		DimensionManager.registerProviderType(dimensionId, WorldProviderBeta.class, false);
		DimensionManager.registerDimension(dimensionId, dimensionId);
	}
}
