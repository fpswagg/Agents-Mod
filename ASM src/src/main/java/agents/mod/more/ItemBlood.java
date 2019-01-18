package agents.mod.more;

import agents.mod.AgentsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlood extends Item
{
	public ItemBlood()
	{
		
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer player) {
		super.onItemRightClick(i, w, player);
		AgentsMod.BloodedHand = true;
		player.inventory.clearInventory(AgentsMod.blood, -1);
		return i;
	}
}
