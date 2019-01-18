package agents.mod;

import agents.mod.gui.UniformManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class gui0 extends Item{

	public gui0() 
	{
		super();
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		Minecraft.getMinecraft().displayGuiScreen(new UniformManager());
		
		return stack;
	}
	
	
}
