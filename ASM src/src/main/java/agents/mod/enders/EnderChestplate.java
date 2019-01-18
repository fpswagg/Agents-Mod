package agents.mod.enders;

import agents.mod.AgentsMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EnderChestplate extends ItemArmor
{

	public EnderChestplate(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_)
	{
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
		this.setTextureName("asm:echest");
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "asm:textures/models/armor/enderchest.png";
    }
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
		player.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 5));
    }
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(player.isSneaking()) {
			return new ItemStack(AgentsMod.legend);
			}
		return stack;
	}
	
}
