package agents.mod.screenOv;

import agents.mod.AgentsMod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class RenderGuiHandler 
{
	@SubscribeEvent
	public void onRenderGui(RenderGameOverlayEvent.Post event) 
	{
		if(event.type != ElementType.EXPERIENCE)
			return;
		new Temp(Minecraft.getMinecraft());
		new Temp2(Minecraft.getMinecraft());
		if (AgentsMod.Scroll == true)
			new Scroll(Minecraft.getMinecraft());
		
	}
	
}
