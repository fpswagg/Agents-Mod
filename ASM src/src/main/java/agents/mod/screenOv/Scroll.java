package agents.mod.screenOv;

import agents.mod.AgentsMod;
import agents.mod.Reference;
import agents.mod.more.potions.effects.TemperatureManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class Scroll extends Gui
{
	public Scroll(Minecraft mc) 
	{
		ScaledResolution scaled = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		
		int width = scaled.getScaledWidth();
		int height = scaled.getScaledHeight();
		if(AgentsMod.scrolls == true && mc.thePlayer.inventory.hasItem(AgentsMod.legend))
			drawCenteredString(mc.fontRenderer, Reference.SCROLL_ENDER(), width / 2, height - 48, Integer.parseInt("A609A2", 16));
	}
	
}
