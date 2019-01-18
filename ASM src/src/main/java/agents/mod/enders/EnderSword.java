package agents.mod.enders;

import agents.mod.AgentsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class EnderSword extends ItemSword {

	public EnderSword(ToolMaterial material) {
		super(material);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(player.isSneaking()) {
			return new ItemStack(AgentsMod.legend);
			}
		return stack;
	}
}
