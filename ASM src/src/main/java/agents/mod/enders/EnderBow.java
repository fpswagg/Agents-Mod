package agents.mod.enders;

import agents.mod.AgentsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class EnderBow extends ItemBow{ 
	
	public static final String a()
	{
		return "asm:ebow";
	}
	
	public EnderBow() 
	{
		super();
		this.setTextureName(a());
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		ArrowNockEvent event = new ArrowNockEvent(player, stack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.arrow))
        {
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        }
        
		if(player.isSneaking()) {
			return new ItemStack(AgentsMod.legend);
			}
		return stack;
	}
}
