package agents.mod;

import agents.mod.gui.CharacterMenu;
import agents.mod.gui.UniformManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class gui01 extends Item{

	public gui01() 
	{
		super();
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		Minecraft.getMinecraft().displayGuiScreen(new CharacterMenu());
		
		return stack;
	}
	
	
}
