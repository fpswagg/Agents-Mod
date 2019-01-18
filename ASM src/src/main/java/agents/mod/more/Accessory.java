package agents.mod.more;

import agents.mod.AgentsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class Accessory {
	
	public static boolean Has()
	{
		if(AgentsMod.BloodedHand == true)
			return true;
		return false;
	}
	
	public static void RemoveAll()
	{
		if(AgentsMod.BloodedHand == true) {
			Minecraft.getMinecraft().thePlayer.inventory.addItemStackToInventory(new ItemStack(AgentsMod.blood));
			AgentsMod.BloodedHand = false;
		}
	}
	
}
