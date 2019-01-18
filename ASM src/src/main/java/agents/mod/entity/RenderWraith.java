package agents.mod.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderWraith extends RenderBiped{

	public RenderWraith(ModelBiped model, float shadowSize)
	{
		super(model, shadowSize);
	}
	
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation("asm:textures/entity/fwraith.png");
		
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float rotationPitch)
	{
		super.doRender((EntityLiving)entity, x, y, z, rotationYaw, rotationPitch);
	}

}
