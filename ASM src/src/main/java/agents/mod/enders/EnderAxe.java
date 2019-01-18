package agents.mod.enders;

import agents.mod.AgentsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnderAxe extends ItemAxe {

	public EnderAxe(ToolMaterial material) {
		super(material);
		this.setTextureName("asm:eaxe");
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(player.isSneaking()) {
			return new ItemStack(AgentsMod.legend);
			}
		return stack;
	}
}
