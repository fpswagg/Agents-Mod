package agents.mod.commands;

import java.util.ArrayList;
import java.util.List;

import agents.mod.AgentsMod;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

public class Evil1 extends AgentsMod implements ICommand {

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "evillvlup1";
	}

	public int getRequiredPermissionLevel()
    {
        return 2;
    }
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "< /evillvlup1 > Evil level increase of 1";
	}

	@Override
	public List getCommandAliases() {
		List<String>commandAliases = new ArrayList();
		commandAliases.add("evillvlup1");
		return commandAliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] strings) {
		if(icommandsender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) icommandsender;
			evil++;
			player.addChatMessage(new ChatComponentText(player.getCommandSenderName() + "'s evil level set to " + Evil()));
			
		}

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
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
