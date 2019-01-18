package agents.mod.enders;

import agents.mod.AgentsMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EnderShield extends Item
{
	public static boolean HealthBoost = false;
	
	public EnderShield() 
	{
		
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		super.onUpdate(stack, world, entity, par4, par5);
		EntityPlayer player = (EntityPlayer) entity;
		ItemStack equipped = player.getCurrentEquippedItem();
		if(equipped == stack) {
			HealthBoost = true;
		}
		

		if(equipped != stack) {
			HealthBoost = false;
		}
		
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!player.isSneaking() && HealthBoost == true)
		{
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 3));
		}
		if(player.isSneaking()) {
			return new ItemStack(AgentsMod.legend);
			}
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}
	
}
