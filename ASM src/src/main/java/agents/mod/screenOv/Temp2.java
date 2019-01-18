package agents.mod.screenOv;

import agents.mod.AgentsMod;
import agents.mod.more.potions.effects.TemperatureManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class Temp2 extends Gui
{
	public Temp2(Minecraft mc) 
	{
		ScaledResolution scaled = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		
		int width = scaled.getScaledWidth();
		int height = scaled.getScaledHeight();
		if(TemperatureManager.Temperature() > 37)
			drawCenteredString(mc.fontRenderer, TemperatureManager.ExpressedTemperature(), width - 16, (height / 15) - 4, Integer.parseInt("ED1C24", 16));
		if(TemperatureManager.Temperature() < 37)
			drawCenteredString(mc.fontRenderer, TemperatureManager.ExpressedTemperature(), width - 16, (height / 15) - 4, Integer.parseInt("00A2E8", 16));
	}
	
}
