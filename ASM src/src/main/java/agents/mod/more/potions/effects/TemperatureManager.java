package agents.mod.more.potions.effects;

import agents.mod.AgentsMod;

public class TemperatureManager extends AgentsMod
{
	
	public static int Temperature()
	{
		if(Burn_Overlay == true)
			return 10;
		
		if(Burn_Steam_Overlay == true)
			return 25;
		
		if(Frost_Overlay == true)
			return -10;
		
		if(Super_Frost_Overlay == true)
			return -25;
		
		if(Ultra_Frost_Overlay == true)
			return -100;
		
		return 37;
	}
	
	public static int UndefinedTemp()
	{
		return Temperature() * 10000;
	}
	
	public static String ExpressedTemperature()
	{
		if(UNDEFINED_Overlay == true || UNDEFINED_Overlay2 == true)
			return UndefinedTemp() + "°C";
		return Temperature() + "°C";
	}
	
	
}
