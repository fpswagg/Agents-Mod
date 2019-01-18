package agents.mod.more.clans;

import agents.mod.AgentsMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class Clan extends AgentsMod
{
	NBTTagCompound nbt = new NBTTagCompound();
	public static String clanName;
	
	public void OnUpdate(EntityPlayer player, Entity entity, World worldIn, Clan clan) {}
	
	public String specialWord(EntityPlayer player, Entity entity, World worldIn, Clan clan)
	{
		return null;
	}
	
	public void setName(String name)
	{
		nbt.setString("", clanName);
		
	}
	
}
