package agents.mod.gui;

import org.lwjgl.opengl.GL11;

import agents.mod.AgentsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class UniformManager extends GuiScreen
{
	
	int guiWidth = 248;
	int guiHeight = 165;

	GuiButton close;
	GuiButton clear0;
	GuiButton i1;
	GuiButton i2;
	GuiButton i3;
	GuiButton i4;
	GuiButton i5;
	EntityPlayer player;
	World worldIn;
	
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
	public void initGui() 
	{
		buttonList.clear();
		int guiX = (width - guiWidth)/2;
		int guiY = (height - guiHeight)/2;
		buttonList.add(close = new GuiButton(-1, guiX + 220, guiY + 10, 20, 20, "X"));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button)
	{
		switch(button.id) {
			case -1:
				mc.displayGuiScreen(null);
				return;
		}
		return;
		
	}
	
}
