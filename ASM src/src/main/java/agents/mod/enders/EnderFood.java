package agents.mod.enders;

import agents.mod.AgentsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EnderFood extends ItemFood
{
	private static boolean alwaysEdible = false;

	public EnderFood(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) 
	{
		super.onEaten(stack, world, player);
		int feedinglvl = 0;
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, (feedinglvl * 200) + 100, 1 * (feedinglvl + 1)));
		if(feedinglvl > 10) 
		{
			player.addPotionEffect(new PotionEffect(Potion.harm.id, 100, 1 * (feedinglvl + 1)));
		}
		feedinglvl++;
		return stack;
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (player.canEat(this.alwaysEdible))
        {
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        }
		
		if(player.isSneaking()) {
			return new ItemStack(AgentsMod.legend);
		}
		
		return stack;
	}
	
	@Override
	public ItemFood setAlwaysEdible()
    {
        this.alwaysEdible = true;
        return this;
    }
	
}
