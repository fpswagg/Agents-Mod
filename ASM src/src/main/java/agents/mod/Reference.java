package agents.mod;

import agents.mod.commands.A7Kits;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class Reference {
	public static final String MODID = "asm";
	public static final String NAME = "Agents Mod";
	public static final String VERSION = "1.0";
	public static final String CLIENT_PROXY_CLASS = "agents.mod.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "agents.mod.proxy.CommonProxy";
	public static final String Creator = " " + "by" + " " + "Agent7";
	public static final String FULL_VERSION = "Agents Mod 0.6.0 Fix Version" + Creator;

	public static final String SCROLL_ENDER() {
		if (AgentsMod.scrolls == true) {
			if (AgentsMod.scroll() == 1 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Sword";
			}

			if (AgentsMod.scroll() == 2 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Axe";
			}

			if (AgentsMod.scroll() == 3 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Hoe";
			}

			if (AgentsMod.scroll() == 4 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Pickaxe";
			}

			if (AgentsMod.scroll() == 5 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Bread";
			}

			if (AgentsMod.scroll() == 6 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Shield";
			}

			if (AgentsMod.scroll() == 7 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Bow";
			}

			if (AgentsMod.scroll() == 8 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Chestplate";
			}

			if (AgentsMod.scroll() == 9 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Legend";
			}
		}
		return "None";
	}
	
	public static final String SCROLL_DNOMAID() {
		if (AgentsMod.scrolls == true) {
			if (AgentsMod.scroll() == 1 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Sword";
			}

			if (AgentsMod.scroll() == 2 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Axe";
			}

			if (AgentsMod.scroll() == 3 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Hoe";
			}

			if (AgentsMod.scroll() == 4 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Pickaxe";
			}

			if (AgentsMod.scroll() == 5 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Bread";
			}

			if (AgentsMod.scroll() == 6 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Shield";
			}

			if (AgentsMod.scroll() == 7 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Bow";
			}

			if (AgentsMod.scroll() == 8 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Chestplate";
			}

			if (AgentsMod.scroll() == 9 && Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.legend)) {
				return "Legend";
			}
		}
		return "None";
	}

}
