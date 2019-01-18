package agents.mod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class burning_gold_sword extends ItemSword
{

	public burning_gold_sword(ToolMaterial material) {
		super(material);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		super.onUpdate(stack, world, entity, par4, par5);
		EntityPlayer player = (EntityPlayer) entity;
		ItemStack equipped = player.getCurrentEquippedItem();
		if(AgentsMod.Burn == false && AgentsMod.Burn_Steam == false)
		if(equipped == stack) {
			player.setFire(10000);
		}
		
		
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		EntityAnimal liv = (EntityAnimal) entity;
		EntityMob li = (EntityMob) entity;
		liv.setFire(10000);
		li.setFire(10000);
		return super.onLeftClickEntity(stack, player, entity);
	}
}
