package agents.mod.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class WorldProviderBeta extends WorldProvider
{
	public void registerWorldChunkManager() 
	{
		
	}
	
	@Override
	public String getDimensionName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean canRespawnHere()
    {
        return true;
    }
	
}
