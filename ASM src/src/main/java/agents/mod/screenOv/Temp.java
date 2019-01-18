package agents.mod.screenOv;

import agents.mod.AgentsMod;
import agents.mod.more.potions.effects.TemperatureManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class Temp extends Gui
{
	public Temp(Minecraft mc) 
	{
		ScaledResolution scaled = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		
		int width = scaled.getScaledWidth();
		int height = scaled.getScaledHeight();
		if(TemperatureManager.Temperature() == 37)
			drawCenteredString(mc.fontRenderer, TemperatureManager.ExpressedTemperature(), width - 16, (height / 15) - 4, Integer.parseInt("DDDDDD", 16));
	}
	
}
