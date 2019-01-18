package agents.mod.commands;

import java.util.ArrayList;
import java.util.List;

import agents.mod.AgentsMod;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;

public class UNDEFINED implements ICommand {

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "3002601";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		// TODO Auto-generated method stub
		return " ";
	}

	@Override
	public List getCommandAliases() {
		List<String>commandAliases = new ArrayList();
		commandAliases.add("3002601");
		return commandAliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] strings) {
		if(icommandsender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) icommandsender;
			player.addChatMessage(new ChatComponentText("denifednu si " + player.getCommandSenderName()));
			AgentsMod.UNDEFINED = true;
			AgentsMod.UNDEFINED_Overlay = true;
			AgentsMod.UNDEFINED_Overlay2 = true;
		}

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
		if(AgentsMod.UND == true)
			return true;
		return false;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		// TODO Auto-generated method stub
		return false;
	}

}
