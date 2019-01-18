package agents.mod.enders;

import agents.mod.AgentsMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class Legend extends ItemArmor {
	public int Cut = 1;
	
	public Legend(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "asm:textures/models/armor/EnderChestplate.png";
    }
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		super.onUpdate(stack, world, entity, par4, par5);
		EntityPlayer player = (EntityPlayer) entity;
		ItemStack equipped = player.getCurrentEquippedItem();
		if(equipped == stack)
		{
			AgentsMod.scrolls = true;
		}
		if(equipped != stack)
		{
			AgentsMod.scrolls = false;
		}
		return;
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		Cut--;
		super.onCreated(stack, world, player);
	}
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
		player.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 5));
    }
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player.isSneaking() && AgentsMod.scroll0 == 1)
		{
			return new ItemStack(AgentsMod.esword);
		}

		if (player.isSneaking() && AgentsMod.scroll0 == 2)
		{
			return new ItemStack(AgentsMod.enderaxe);
		}
		
		if (player.isSneaking() && AgentsMod.scroll0 == 3)
		{
			return new ItemStack(AgentsMod.ehoe);
		}
		
		if (player.isSneaking() && AgentsMod.scroll0 == 4)
		{
			return new ItemStack(AgentsMod.epickaxe);
		}
		
		if (player.isSneaking() && AgentsMod.scroll0 == 5)
		{
			return new ItemStack(AgentsMod.ebread);
		}
		
		if (player.isSneaking() && AgentsMod.scroll0 == 6)
		{
			return new ItemStack(AgentsMod.eshield);
		}
		
		if (player.isSneaking() && AgentsMod.scroll0 == 7)
		{
			return new ItemStack(AgentsMod.ebow);
		}

		if (player.isSneaking() && AgentsMod.scroll0 == 8)
		{
			return new ItemStack(AgentsMod.echest);
		}
		
		if (player.isSneaking() && AgentsMod.scroll0 == 9)
		{
			Cut++;
			player.inventory.addItemStackToInventory(new ItemStack(AgentsMod.legend));
			if(Cut >= 5) 
			{
				player.inventory.clearInventory(AgentsMod.legend, -1);
				Cut = 1;
			}
			return stack;
		}
		
		return stack;
	}
	
}
