package agents.mod.more;

import org.lwjgl.input.Keyboard;

import agents.mod.AgentsMod;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Keybinds 
{
	public static KeyBinding next;
	public static KeyBinding previous;
	public static KeyBinding Toggle_Scroll;
	public static KeyBinding accessory;
	public static KeyBinding choose;
	public static KeyBinding action;
	public static KeyBinding action2;
	public static KeyBinding action3;
	public static KeyBinding fly;
	
	public static void register()
	{
		next = new KeyBinding("key.next.desc", Keyboard.KEY_NONE, "key.agentsmod.category");
		previous = new KeyBinding("key.previous.desc", Keyboard.KEY_NONE, "key.agentsmod.category");
		Toggle_Scroll = new KeyBinding("key.toggle_scroll.desc", Keyboard.KEY_NONE, "key.agentsmodbonus.category");
		accessory = new KeyBinding("key.accessory.desc", Keyboard.KEY_NONE, "key.agentsmodbonus.category");
		choose = new KeyBinding("key.transform.desc", Keyboard.KEY_NONE, "key.agentsmod.category");
		action = new KeyBinding("key.action.desc", Keyboard.KEY_NONE, "key.agentsmod.category");
		action2 = new KeyBinding("key.action2.desc", Keyboard.KEY_NONE, "key.agentsmod.category");
		action3 = new KeyBinding("key.action3.desc", Keyboard.KEY_NONE, "key.agentsmod.category");
		fly = new KeyBinding("key.fly.desc", Keyboard.KEY_NONE, "key.agentsmod.category");
		
		ClientRegistry.registerKeyBinding(next);
		ClientRegistry.registerKeyBinding(previous);
		ClientRegistry.registerKeyBinding(Toggle_Scroll);
		ClientRegistry.registerKeyBinding(accessory);
		ClientRegistry.registerKeyBinding(choose);
		ClientRegistry.registerKeyBinding(action);
		ClientRegistry.registerKeyBinding(action2);
		ClientRegistry.registerKeyBinding(action3);
		ClientRegistry.registerKeyBinding(fly);
		
	}
}
