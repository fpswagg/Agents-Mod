package agents.mod.enders;

import agents.mod.AgentsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnderPickaxe extends ItemPickaxe
{

	public EnderPickaxe(ToolMaterial mat) {
		super(mat);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(player.isSneaking()) {
			return new ItemStack(AgentsMod.legend);
			}
		return stack;
	}
	
}
