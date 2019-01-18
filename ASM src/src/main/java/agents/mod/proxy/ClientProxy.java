package agents.mod.proxy;

import agents.mod.AgentsMod;
import agents.mod.entity.Agent49;
import agents.mod.entity.Agent7;
import agents.mod.entity.BAgent7;
import agents.mod.entity.Burner;
import agents.mod.entity.Enderboy;
import agents.mod.entity.Herobrine;
import agents.mod.entity.Notch;
import agents.mod.entity.RenderAgent491;
import agents.mod.entity.RenderAgent492;
import agents.mod.entity.RenderAgent71;
import agents.mod.entity.RenderAgent72;
import agents.mod.entity.RenderEnder1;
import agents.mod.entity.RenderHerobrine;
import agents.mod.entity.RenderNotch;
import agents.mod.entity.RenderWraith;
import agents.mod.entity.Wraith;
import agents.mod.playOv.PlayerSkin1;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ClientProxy extends CommonProxy
{
	int ModEntityId;
	int ModEntityId2;
	int ModEntityId3;
	int ModEntityId4;
	int ModEntityId5;
	int ModEntityId6;
	int ModEntityId7;
	int ModEntityId8;
	
	@Override
	public void registerRenderers()
	{
			RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new PlayerSkin1());
		
		RenderingRegistry.registerEntityRenderingHandler(Enderboy.class, new RenderEnder1(new ModelBiped(), 1));
		RenderingRegistry.registerEntityRenderingHandler(Agent7.class, new RenderAgent71(new ModelBiped(), 1));
		RenderingRegistry.registerEntityRenderingHandler(BAgent7.class, new RenderAgent72(new ModelBiped(), 1));
		RenderingRegistry.registerEntityRenderingHandler(Wraith.class, new RenderWraith(new ModelBiped(), 1));
		RenderingRegistry.registerEntityRenderingHandler(Agent49.class, new RenderAgent491(new ModelBiped(), 1));
		RenderingRegistry.registerEntityRenderingHandler(Burner.class, new RenderAgent492(new ModelBiped(), 1));
		RenderingRegistry.registerEntityRenderingHandler(Notch.class, new RenderNotch(new ModelBiped(), 1));
		RenderingRegistry.registerEntityRenderingHandler(Herobrine.class, new RenderHerobrine(new ModelBiped(), 1));
	}
	
	@Override
	public void registerEntities()
	{
		
	}
}
