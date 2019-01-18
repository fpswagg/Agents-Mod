package agents.mod.commands;

import java.util.ArrayList;
import java.util.List;

import agents.mod.AgentsMod;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

public class A49Kits implements ICommand {

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "a49";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "< /a49 > To have Agent7's tools";
	}

	@Override
	public List getCommandAliases() {
		List<String>commandAliases = new ArrayList();
		commandAliases.add("a49");
		return commandAliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] strings) {
		if(icommandsender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) icommandsender;
			player.addChatMessage(new ChatComponentText("Here goes your items! "+player.getCommandSenderName()));
			player.inventory.addItemStackToInventory(new ItemStack(Items.golden_sword));
			player.inventory.addItemStackToInventory(new ItemStack(AgentsMod.magma_ingot, 10));
			player.inventory.addItemStackToInventory(new ItemStack(AgentsMod.mask2));
			
		}

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender, String[] strings) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] string, int i) {
		// TODO Auto-generated method stub
		return false;
	}

}
