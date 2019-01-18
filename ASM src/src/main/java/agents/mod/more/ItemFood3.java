package agents.mod.more;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFood3 extends ItemFood
{

	public ItemFood3(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
	}
	
	@Override
	public void onCreated(ItemStack p_77622_1_, World p_77622_2_, EntityPlayer p_77622_3_) {
		p_77622_3_.inventory.addItemStackToInventory(new ItemStack(Items.diamond_sword));
		super.onCreated(p_77622_1_, p_77622_2_, p_77622_3_);
	}
}