package agents.mod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DrumStick extends ItemFood
{

	public DrumStick(int heal, float AmountOfHeartX2, boolean isFavouriteToWolves) {
		super(heal, AmountOfHeartX2, isFavouriteToWolves);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) 
	{
		super.onEaten(stack, world, player);
		player.inventory.addItemStackToInventory(new ItemStack(AgentsMod.drumStick0));
		return stack;
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		super.onCreated(stack, world, player);
		player.inventory.addItemStackToInventory(new ItemStack(AgentsMod.chicken0, 6));
	}
}
