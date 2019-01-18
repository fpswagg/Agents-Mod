package agents.mod.enders;

import agents.mod.AgentsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;

public class EnderHoe extends ItemHoe
{
	public EnderHoe(ToolMaterial material) {
		super(material);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(player.isSneaking()) {
			return new ItemStack(AgentsMod.legend);
			}
		return stack;
	}
}
