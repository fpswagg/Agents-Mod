package agents.mod;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class Hoody7 extends ItemArmor
{
	public static boolean on = false;
	
	public Hoody7(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "asm:textures/entity/ga7.png";
    }
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		super.onArmorTick(world, player, itemStack);
		if(player.inventory.armorItemInSlot(2) == itemStack)
		{
			on = true;
		}
		return;
	}
	
	@Override
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_,
			boolean p_77663_5_) {
		super.onUpdate(p_77663_1_, p_77663_2_, p_77663_3_, p_77663_4_, p_77663_5_);
		EntityPlayer player = (EntityPlayer) p_77663_3_;
		ItemStack equipped = player.getCurrentEquippedItem();
		if(player.inventory.armorItemInSlot(2) != p_77663_1_)
		{
			on = false;
			return;
		}
		return;
	}
}
