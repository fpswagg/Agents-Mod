package agents.mod.gui;

import org.lwjgl.opengl.GL11;

import agents.mod.AgentsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class CharacterMenu extends GuiScreen
{
	
	int guiWidth = 248;
	int guiHeight = 165;
	
	String a = "Eye1";
	String b = "Mouth1";
	String c = "Hair1";
	
	GuiButton close;
	GuiButton clear0;
	GuiButton i1;
	GuiButton i2;
	GuiButton i3;
	GuiButton i4;
	GuiButton i5;
	EntityPlayer player;
	
	@Override
	public void drawScreen(int x, int y, float ticks)
    {
		int guiX = (width - guiWidth)/2;
		int guiY = (height - guiHeight)/2;
		
		GL11.glColor4f(1, 1, 1, 1);
		
		mc.renderEngine.bindTexture(new ResourceLocation("asm:textures/gui/as_begin.png"));
		
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		
		fontRendererObj.drawString("Name : [TEST]", guiX + 140,  guiY + 40, 0xFFFFFFFF);
		fontRendererObj.drawString("Clan : [TEST]", guiX + 140,  guiY + 55, 0xFFFFFFFF);
		fontRendererObj.drawString("Form : [TEST]", guiX + 140,  guiY + 70, 0xFFFFFFFF);
		fontRendererObj.drawString("PowerType : [TEST]", guiX + 140,  guiY + 85, 0xFFFFFFFF);
		fontRendererObj.drawString("Timeline : Present", guiX + 140,  guiY + 100, 0xFFFFFFFF);
		fontRendererObj.drawString("Dimension :        ", guiX + 140,  guiY + 115, 0xFFFFFFFF);
		fontRendererObj.drawString("   Overworld (Undo)", guiX + 140,  guiY + 130, 0xFFFFFFFF);
		
		super.drawScreen(x, y, ticks);
    }
	
	@Override
    public void updateScreen() 
	{
		
	}
	
	public boolean doesGuiPauseGame()
    {
        return true;
    }
	
	@Override
	public void initGui() 
	{
		buttonList.clear();
		int guiX = (width - guiWidth)/2;
		int guiY = (height - guiHeight)/2;

		buttonList.add(close = new GuiButton(-1, guiX + 220, guiY + 10, 20, 20, "X"));
		buttonList.add(clear0 = new GuiButton(0, guiX + 75, guiY + 129, 40, 20, "Clear"));
		buttonList.add(i1 = new GuiButton(1, guiX + 68, guiY + 50, 40, 20, a));
		buttonList.add(i2 = new GuiButton(2, guiX + 68, guiY + 71, 40, 20, b));
		buttonList.add(i3 = new GuiButton(3, guiX + 68, guiY + 92, 40, 20, c));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button)
	{
		switch(button.id) {
		case -1:
			mc.displayGuiScreen(null);
			return;
		case 0:
			if(AgentsMod.UNDEFINED_Overlay == false && AgentsMod.Burn_Overlay == false && AgentsMod.Burn_Steam_Overlay == false && AgentsMod.Frost_Overlay == false && AgentsMod.Super_Frost_Overlay == false && AgentsMod.Ultra_Frost_Overlay == false)
			{
				AgentsMod.eye1 = true;
				AgentsMod.eye2 = false;
				AgentsMod.eye3 = false;
				AgentsMod.mouth1 = true;
				AgentsMod.mouth2 = false;
				AgentsMod.hair1 = true;
				AgentsMod.hair2 = false;
				AgentsMod.hair3 = false;
				return;
			}
			
			return;
		case 1:
			if(AgentsMod.eye1 == true && AgentsMod.eye2 == false && AgentsMod.eye3 == false)
			{
				button.displayString = "Eye2";
				AgentsMod.eye1 = false;
				AgentsMod.eye2 = true;
				AgentsMod.eye3 = false;
				return;
			}
			
			if(AgentsMod.eye1 == false && AgentsMod.eye2 == true && AgentsMod.eye3 == false)
			{
				button.displayString = "Eye3";
				AgentsMod.eye1 = false;
				AgentsMod.eye2 = false;
				AgentsMod.eye3 = true;
				return;
			}
			
			if(AgentsMod.eye1 == false && AgentsMod.eye2 == false && AgentsMod.eye3 == true)
			{
				button.displayString = "Eye1";
				AgentsMod.eye1 = true;
				AgentsMod.eye2 = false;
				AgentsMod.eye3 = false;
				return;
			}
			
			return;
		case 2:
			if(AgentsMod.mouth1 == true && AgentsMod.mouth2 == false)
			{
				button.displayString = "Mouth2";
				AgentsMod.mouth1 = false;
				AgentsMod.mouth2 = true;
				return;
			}
			
			if(AgentsMod.mouth1 == false && AgentsMod.mouth2 == true)
			{
				button.displayString = "Mouth1";
				AgentsMod.mouth1 = true;
				AgentsMod.mouth2 = false;
				return;
			}
			
			return;
		case 3:
			if(AgentsMod.hair1 == true && AgentsMod.hair2 == false && AgentsMod.hair3 == false)
			{
				button.displayString = "Hair1";
				AgentsMod.hair1 = false;
				AgentsMod.hair2 = true;
				AgentsMod.hair3 = false;
				return;
			}
			
			if(AgentsMod.hair1 == false && AgentsMod.hair2 == true && AgentsMod.hair3 == false)
			{
				button.displayString = "Hair2";
				AgentsMod.hair1 = false;
				AgentsMod.hair2 = false;
				AgentsMod.hair3 = true;
				return;
			}
			
			if(AgentsMod.hair1 == false && AgentsMod.hair2 == false && AgentsMod.hair3 == true)
			{
				button.displayString = "Hair3";
				AgentsMod.hair1 = true;
				AgentsMod.hair2 = false;
				AgentsMod.hair3 = false;
				return;
			}
		}
		return;
	}
	
	
	@Override
	public void onGuiClosed() 
	{
		return;
	}
}
