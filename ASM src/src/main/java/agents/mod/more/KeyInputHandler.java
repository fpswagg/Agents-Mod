package agents.mod.more;

import agents.mod.AgentsMod;
import agents.mod.Hoody7;
import agents.mod.more.potions.effects.Fire;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.util.EnumHelper;

public class KeyInputHandler {
	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		
		if(Minecraft.getMinecraft().gameSettings.isKeyDown(Keybinds.fly)) {
			Minecraft.getMinecraft().thePlayer.setPositionAndUpdate(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY + 0.1, Minecraft.getMinecraft().thePlayer.posZ);
			
		}
		if (Keybinds.next.isPressed()) {
			AgentsMod.scroll0++;
		}

		if (Keybinds.previous.isPressed()) {
			AgentsMod.scroll0--;
		}

		if (Keybinds.Toggle_Scroll.isPressed()) {
			if (AgentsMod.Scroll == true) {
				AgentsMod.Scroll = false;
			}

			if (AgentsMod.Scroll == false) {
				AgentsMod.Scroll = true;
			}
		}

		if (Keybinds.accessory.isPressed()) {
			if(Accessory.Has())
				Accessory.RemoveAll();
		}
		
		if(AgentsMod.BloodedHand == true)
		{}
		
		if (Keybinds.action.isPressed()) {
			if(AgentsMod.Frost == true || AgentsMod.Ultra_Frost == true || AgentsMod.Super_Frost == true)
			{
				Minecraft.getMinecraft().thePlayer.inventory.addItemStackToInventory(new ItemStack(AgentsMod.red));
			}
			
			if(AgentsMod.Burn == true || AgentsMod.Burn_Steam == true)
			{
				if(Minecraft.getMinecraft().thePlayer.inventory.hasItem(Items.golden_sword))
				{
					Minecraft.getMinecraft().thePlayer.inventory.clearInventory(Items.golden_sword, -1);
					Minecraft.getMinecraft().thePlayer.inventory.addItemStackToInventory(new ItemStack(AgentsMod.burning_gold_sword));
					
				}
			}
		}

		if (Keybinds.action2.isPressed()) {

		}

		if (Keybinds.action3.isPressed()) {

		}

		if (Keybinds.choose.isPressed()) {
			if (AgentsMod.scroll() == 1 && AgentsMod.Frost == true && AgentsMod.Frost_Overlay == false) {
				AgentsMod.Frost_Overlay = true;
				return;
			}

			if (AgentsMod.scroll() == 1 && AgentsMod.Frost == true && AgentsMod.Frost_Overlay == true) {
				AgentsMod.Frost_Overlay = false;
				return;
			}

			if (AgentsMod.scroll() == 1 && AgentsMod.Burn == true && AgentsMod.Burn_Overlay == true) {
				AgentsMod.Burn_Overlay = false;
				return;
			}

			if (AgentsMod.scroll() == 1 && AgentsMod.Burn == true && AgentsMod.Burn_Overlay == false) {
				AgentsMod.Burn_Overlay = true;
				return;
			}

			if (AgentsMod.scroll() == 1 && AgentsMod.Super_Frost == true && AgentsMod.Super_Frost_Overlay == true) {
				AgentsMod.Super_Frost_Overlay = false;
				return;
			}

			if (AgentsMod.scroll() == 2 && AgentsMod.Super_Frost == true && AgentsMod.Super_Frost_Overlay == false) {
				AgentsMod.Super_Frost_Overlay = true;
				return;
			}

			if (AgentsMod.scroll() == 1 && AgentsMod.Burn_Steam == true && AgentsMod.Burn_Steam_Overlay == true) {
				AgentsMod.Burn_Steam_Overlay = false;
				return;
			}

			if (AgentsMod.scroll() == 2 && AgentsMod.Burn_Steam == true && AgentsMod.Burn_Steam_Overlay == false) {
				AgentsMod.Burn_Overlay = true;
				return;
			}

			if (AgentsMod.scroll() == 1 && AgentsMod.Ultra_Frost == true && AgentsMod.Ultra_Frost_Overlay == true) {
				AgentsMod.Ultra_Frost_Overlay = false;
				return;
			}

			if (AgentsMod.scroll() == 1 && AgentsMod.UNDEFINED == true && AgentsMod.UNDEFINED_Overlay == true
					&& AgentsMod.UNDEFINED_Overlay2 == true) {
				AgentsMod.UNDEFINED_Overlay = false;
				AgentsMod.UNDEFINED_Overlay2 = false;
				return;
			}

			if (AgentsMod.scroll() == 1 && AgentsMod.UNDEFINED == true && AgentsMod.UNDEFINED_Overlay == false
					&& AgentsMod.UNDEFINED_Overlay2 == false) {
				AgentsMod.UNDEFINED_Overlay = true;
				AgentsMod.UNDEFINED_Overlay2 = true;
				return;
			}
			
			if (AgentsMod.scrollred == true) {
				if (Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.red)) {
					Minecraft.getMinecraft().thePlayer.inventory.clearInventory(AgentsMod.red, -1);
					Minecraft.getMinecraft().thePlayer.inventory.addItemStackToInventory(new ItemStack(AgentsMod.red0));
				}
				return;
			}
			
		}
		
		if (Hoody7.on == true && !Minecraft.getMinecraft().thePlayer.inventory.hasItem(AgentsMod.hoody)) {
			Hoody7.on = false;
		}
		
		if(AgentsMod.Burn == true && AgentsMod.Frost == true)
		{
			AgentsMod.Frost = false;
			AgentsMod.Frost_Overlay = false;
			AgentsMod.Ultra_Frost = false;
			AgentsMod.Ultra_Frost_Overlay = false;
			AgentsMod.Super_Frost = false;
			AgentsMod.Super_Frost_Overlay = false;
		}
		
		if(AgentsMod.evil == 0)
		{
			AgentsMod.Evil1 = false;
			AgentsMod.Evil1_Overlay = false;
			AgentsMod.Evil2 = false;
			AgentsMod.Evil2_Overlay = false;
			AgentsMod.Evil3 = false;
			AgentsMod.Evil3_Overlay = false;
		}

		if(AgentsMod.evil == 1)
		{
			AgentsMod.Evil1 = true;
			AgentsMod.Evil1_Overlay = true;
			AgentsMod.Evil2 = false;
			AgentsMod.Evil2_Overlay = false;
			AgentsMod.Evil3 = false;
			AgentsMod.Evil3_Overlay = false;
		}

		if(AgentsMod.evil == 2)
		{
			AgentsMod.Evil1 = false;
			AgentsMod.Evil1_Overlay = false;
			AgentsMod.Evil2 = true;
			AgentsMod.Evil2_Overlay = true;
			AgentsMod.Evil3 = false;
			AgentsMod.Evil3_Overlay = false;
		}

		if(AgentsMod.evil == 3)
		{
			AgentsMod.Evil1 = false;
			AgentsMod.Evil1_Overlay = false;
			AgentsMod.Evil2 = false;
			AgentsMod.Evil2_Overlay = false;
			AgentsMod.Evil3 = true;
			AgentsMod.Evil3_Overlay = true;
		}

		if(AgentsMod.evil > 3)
		{
			AgentsMod.evil = 3;
		}
		
		if(AgentsMod.evil < 0) 
		{
			AgentsMod.evil = 0;
		}
		return;
	}
}
