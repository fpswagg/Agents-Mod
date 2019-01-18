package agents.mod.more.potions.effects;

import agents.mod.AgentsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class Fire extends TemperatureManager
{
	public static void PotionEffect(EntityPlayer player)
	{
		if(Burn == false)
		{
			Burn = true;
			Burn_Overlay = true;
			return;
		}
		return;
	}
	
	public static boolean Heat()
	{
		if(Burn_Steam == true)
		{
			return true;
		}
		
		if(Burn == true)
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean Stabilize()
	{
		if(Burn_Steam == true && Burn == false)
		{
			Burn = true;
			return true;
		}
		
		return false;
	}

	public static void Effect()
	{
		Minecraft.getMinecraft().thePlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1, 10000));
		Minecraft.getMinecraft().thePlayer.setFire(100);
	}
	
}
