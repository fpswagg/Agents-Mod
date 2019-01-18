package agents.mod;

import agents.mod.more.Keybinds;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class CommonHandler
{
	
	@SubscribeEvent
	public void Conditions(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(AgentsMod.Burn_Overlay == true && event.player.isBurning())
		{
			AgentsMod.Burns++;
			event.player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, AgentsMod.Burns * 100, AgentsMod.Burns));
			event.player.addPotionEffect(new PotionEffect(Potion.regeneration.id, AgentsMod.Burns * 100, 10000));
		}
		
		
		return;
	}
}
