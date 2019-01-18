package agents.mod.playOv;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import agents.mod.AgentsMod;
import agents.mod.Hoody7;
import agents.mod.Reference;

public class PlayerSkin1 extends RenderPlayer {

	public ResourceLocation EYEOFUNDEFINED = new ResourceLocation("asm:textures/entity/playerOverlayUNDEFINEDEYES.png");
	public ResourceLocation EvilEye1 = new ResourceLocation("asm:textures/entity/playerOverlayORANGEEYES.png");
	public ResourceLocation EvilEye2 = new ResourceLocation("asm:textures/entity/playerOverlayREDEYES.png");
	public ResourceLocation hd7 = new ResourceLocation("asm:textures/entity/ga7_2.png");
	public ResourceLocation blood = new ResourceLocation("asm:textures/entity/blood.png");
	public ModelBiped eye;
	public ModelBiped hd7_ov;
	public ModelBiped hand;

	public PlayerSkin1() {
		super();
		this.mainModel = new ModelBiped(-0.01F);
		this.modelBipedMain = (ModelBiped) this.mainModel;
		this.modelArmorChestplate = new ModelBiped(AgentsMod.ArmorLayer_1);
		this.modelArmor = new ModelBiped(AgentsMod.ArmorLeggingLayer_1);
		this.eye = new ModelBiped(0.0f);
		this.hd7_ov = new ModelBiped(AgentsMod.ArmorLayer_1);
		this.hand = new ModelBiped(0.0f);
	}
	
	@Override
	public void renderModel(EntityLivingBase entity, float par2, float par3, float par4, float par5, float par6,
			float par7) {
		
		super.renderModel(entity, par2, par3, par4, par5, par6, par7);
		
		if (AgentsMod.UNDEFINED_Overlay == true) {
			ModelBiped modelBiped;
			for (int i = 0; i < 4; ++i) {
				modelBiped = this.eye;

				GL11.glColor4f(1, 1, 1, 1);
				this.bindTexture(EYEOFUNDEFINED);
				modelBiped.bipedHead.showModel = i == 0;
				modelBiped.bipedHeadwear.showModel = i == 0;
				modelBiped.bipedBody.showModel = i == 1 || i == 2;
				modelBiped.bipedRightArm.showModel = i == 1;
				modelBiped.bipedLeftArm.showModel = i == 1;
				modelBiped.bipedRightLeg.showModel = i == 2 || i == 3;
				modelBiped.bipedLeftLeg.showModel = i == 2 || i == 3;
				modelBiped.onGround = this.mainModel.onGround;
				modelBiped.isRiding = this.mainModel.isRiding;
				modelBiped.isChild = this.mainModel.isChild;
				if (this.mainModel instanceof ModelBiped) {
					modelBiped.heldItemLeft = ((ModelBiped) this.mainModel).heldItemLeft;
					modelBiped.heldItemRight = ((ModelBiped) this.mainModel).heldItemRight;
					modelBiped.isSneak = ((ModelBiped) this.mainModel).isSneak;
					modelBiped.aimedBow = ((ModelBiped) this.mainModel).aimedBow;
				}
				modelBiped.setLivingAnimations(entity, par2, par3, 0.0F);
				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);

				// Start alpha render
				GL11.glDisable(GL11.GL_LIGHTING);
				this.bindTexture(EYEOFUNDEFINED);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glAlphaFunc(GL11.GL_GREATER, 0.0F);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				float time = entity.ticksExisted / 10.0F;
				float sTime = (float) Math.sin(time) * 0.5F + 0.5F;

				float r = 0.2F * sTime;
				float g = 1.0F * sTime;
				float b = 0.2F * sTime;

				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glColor4f(1, 1, 1, 1);
				GL11.glEnable(GL11.GL_LIGHTING);

			}
		}
		
		if (AgentsMod.BloodedHand == true) {
			ModelBiped modelBiped;
			for (int i = 0; i < 4; ++i) {
				modelBiped = this.hand;

				GL11.glColor4f(1, 1, 1, 1);
				this.bindTexture(blood);
				modelBiped.bipedHead.showModel = i == 0;
				modelBiped.bipedHeadwear.showModel = i == 0;
				modelBiped.bipedBody.showModel = i == 1 || i == 2;
				modelBiped.bipedRightArm.showModel = i == 1;
				modelBiped.bipedLeftArm.showModel = i == 1;
				modelBiped.bipedRightLeg.showModel = i == 2 || i == 3;
				modelBiped.bipedLeftLeg.showModel = i == 2 || i == 3;
				modelBiped.onGround = this.mainModel.onGround;
				modelBiped.isRiding = this.mainModel.isRiding;
				modelBiped.isChild = this.mainModel.isChild;
				if (this.mainModel instanceof ModelBiped) {
					modelBiped.heldItemLeft = ((ModelBiped) this.mainModel).heldItemLeft;
					modelBiped.heldItemRight = ((ModelBiped) this.mainModel).heldItemRight;
					modelBiped.isSneak = ((ModelBiped) this.mainModel).isSneak;
					modelBiped.aimedBow = ((ModelBiped) this.mainModel).aimedBow;
				}
				modelBiped.setLivingAnimations(entity, par2, par3, 0.0F);
				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);

				// Start alpha render
				GL11.glDisable(GL11.GL_LIGHTING);
				this.bindTexture(blood);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glAlphaFunc(GL11.GL_GREATER, 0.0F);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				float time = entity.ticksExisted / 10.0F;
				float sTime = (float) Math.sin(time) * 0.5F + 0.5F;

				float r = 0.2F * sTime;
				float g = 1.0F * sTime;
				float b = 0.2F * sTime;

				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glColor4f(1, 1, 1, 1);
				GL11.glEnable(GL11.GL_LIGHTING);

			}
		}
		
		if (AgentsMod.UNDEFINED_Overlay == false && AgentsMod.Evil1_Overlay == true) {
			ModelBiped modelBiped;
			for (int i = 0; i < 4; ++i) {
				modelBiped = this.eye;

				GL11.glColor4f(1, 1, 1, 1);
				this.bindTexture(EvilEye1);
				modelBiped.bipedHead.showModel = i == 0;
				modelBiped.bipedHeadwear.showModel = i == 0;
				modelBiped.bipedBody.showModel = i == 1 || i == 2;
				modelBiped.bipedRightArm.showModel = i == 1;
				modelBiped.bipedLeftArm.showModel = i == 1;
				modelBiped.bipedRightLeg.showModel = i == 2 || i == 3;
				modelBiped.bipedLeftLeg.showModel = i == 2 || i == 3;
				modelBiped.onGround = this.mainModel.onGround;
				modelBiped.isRiding = this.mainModel.isRiding;
				modelBiped.isChild = this.mainModel.isChild;
				if (this.mainModel instanceof ModelBiped) {
					modelBiped.heldItemLeft = ((ModelBiped) this.mainModel).heldItemLeft;
					modelBiped.heldItemRight = ((ModelBiped) this.mainModel).heldItemRight;
					modelBiped.isSneak = ((ModelBiped) this.mainModel).isSneak;
					modelBiped.aimedBow = ((ModelBiped) this.mainModel).aimedBow;
				}
				modelBiped.setLivingAnimations(entity, par2, par3, 0.0F);
				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);

				// Start alpha render
				GL11.glDisable(GL11.GL_LIGHTING);
				this.bindTexture(EvilEye1);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glAlphaFunc(GL11.GL_GREATER, 0.0F);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				float time = entity.ticksExisted / 10.0F;
				float sTime = (float) Math.sin(time) * 0.5F + 0.5F;

				float r = 0.2F * sTime;
				float g = 1.0F * sTime;
				float b = 0.2F * sTime;

				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glColor4f(1, 1, 1, 1);
				GL11.glEnable(GL11.GL_LIGHTING);

			}
		}
		
		if (AgentsMod.UNDEFINED_Overlay == false && AgentsMod.Burn_Overlay == true && AgentsMod.evil == 0) {
			ModelBiped modelBiped;
			for (int i = 0; i < 4; ++i) {
				modelBiped = this.eye;

				GL11.glColor4f(1, 1, 1, 1);
				this.bindTexture(EvilEye1);
				modelBiped.bipedHead.showModel = i == 0;
				modelBiped.bipedHeadwear.showModel = i == 0;
				modelBiped.bipedBody.showModel = i == 1 || i == 2;
				modelBiped.bipedRightArm.showModel = i == 1;
				modelBiped.bipedLeftArm.showModel = i == 1;
				modelBiped.bipedRightLeg.showModel = i == 2 || i == 3;
				modelBiped.bipedLeftLeg.showModel = i == 2 || i == 3;
				modelBiped.onGround = this.mainModel.onGround;
				modelBiped.isRiding = this.mainModel.isRiding;
				modelBiped.isChild = this.mainModel.isChild;
				if (this.mainModel instanceof ModelBiped) {
					modelBiped.heldItemLeft = ((ModelBiped) this.mainModel).heldItemLeft;
					modelBiped.heldItemRight = ((ModelBiped) this.mainModel).heldItemRight;
					modelBiped.isSneak = ((ModelBiped) this.mainModel).isSneak;
					modelBiped.aimedBow = ((ModelBiped) this.mainModel).aimedBow;
				}
				modelBiped.setLivingAnimations(entity, par2, par3, 0.0F);
				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);

				// Start alpha render
				GL11.glDisable(GL11.GL_LIGHTING);
				this.bindTexture(EvilEye1);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glAlphaFunc(GL11.GL_GREATER, 0.0F);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				float time = entity.ticksExisted / 10.0F;
				float sTime = (float) Math.sin(time) * 0.5F + 0.5F;

				float r = 0.2F * sTime;
				float g = 1.0F * sTime;
				float b = 0.2F * sTime;

				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glColor4f(1, 1, 1, 1);
				GL11.glEnable(GL11.GL_LIGHTING);

			}
		}
		
		
		if (AgentsMod.UNDEFINED_Overlay == false && AgentsMod.Evil2_Overlay == true) {
			ModelBiped modelBiped;
			for (int i = 0; i < 4; ++i) {
				modelBiped = this.eye;

				GL11.glColor4f(1, 1, 1, 1);
				this.bindTexture(EvilEye2);
				modelBiped.bipedHead.showModel = i == 0;
				modelBiped.bipedHeadwear.showModel = i == 0;
				modelBiped.bipedBody.showModel = i == 1 || i == 2;
				modelBiped.bipedRightArm.showModel = i == 1;
				modelBiped.bipedLeftArm.showModel = i == 1;
				modelBiped.bipedRightLeg.showModel = i == 2 || i == 3;
				modelBiped.bipedLeftLeg.showModel = i == 2 || i == 3;
				modelBiped.onGround = this.mainModel.onGround;
				modelBiped.isRiding = this.mainModel.isRiding;
				modelBiped.isChild = this.mainModel.isChild;
				if (this.mainModel instanceof ModelBiped) {
					modelBiped.heldItemLeft = ((ModelBiped) this.mainModel).heldItemLeft;
					modelBiped.heldItemRight = ((ModelBiped) this.mainModel).heldItemRight;
					modelBiped.isSneak = ((ModelBiped) this.mainModel).isSneak;
					modelBiped.aimedBow = ((ModelBiped) this.mainModel).aimedBow;
				}
				modelBiped.setLivingAnimations(entity, par2, par3, 0.0F);
				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);

				// Start alpha render
				GL11.glDisable(GL11.GL_LIGHTING);
				this.bindTexture(EvilEye2);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glAlphaFunc(GL11.GL_GREATER, 0.0F);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				float time = entity.ticksExisted / 10.0F;
				float sTime = (float) Math.sin(time) * 0.5F + 0.5F;

				float r = 0.2F * sTime;
				float g = 1.0F * sTime;
				float b = 0.2F * sTime;

				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glColor4f(1, 1, 1, 1);
				GL11.glEnable(GL11.GL_LIGHTING);

			}
		}
		
		if (AgentsMod.UNDEFINED_Overlay == false && AgentsMod.Evil3_Overlay == true) {
			ModelBiped modelBiped;
			for (int i = 0; i < 4; ++i) {
				modelBiped = this.eye;

				GL11.glColor4f(1, 1, 1, 1);
				this.bindTexture(EvilEye2);
				modelBiped.bipedHead.showModel = i == 0;
				modelBiped.bipedHeadwear.showModel = i == 0;
				modelBiped.bipedBody.showModel = i == 1 || i == 2;
				modelBiped.bipedRightArm.showModel = i == 1;
				modelBiped.bipedLeftArm.showModel = i == 1;
				modelBiped.bipedRightLeg.showModel = i == 2 || i == 3;
				modelBiped.bipedLeftLeg.showModel = i == 2 || i == 3;
				modelBiped.onGround = this.mainModel.onGround;
				modelBiped.isRiding = this.mainModel.isRiding;
				modelBiped.isChild = this.mainModel.isChild;
				if (this.mainModel instanceof ModelBiped) {
					modelBiped.heldItemLeft = ((ModelBiped) this.mainModel).heldItemLeft;
					modelBiped.heldItemRight = ((ModelBiped) this.mainModel).heldItemRight;
					modelBiped.isSneak = ((ModelBiped) this.mainModel).isSneak;
					modelBiped.aimedBow = ((ModelBiped) this.mainModel).aimedBow;
				}
				modelBiped.setLivingAnimations(entity, par2, par3, 0.0F);
				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);

				// Start alpha render
				GL11.glDisable(GL11.GL_LIGHTING);
				this.bindTexture(EvilEye2);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glAlphaFunc(GL11.GL_GREATER, 0.0F);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				float time = entity.ticksExisted / 10.0F;
				float sTime = (float) Math.sin(time) * 0.5F + 0.5F;

				float r = 0.2F * sTime;
				float g = 1.0F * sTime;
				float b = 0.2F * sTime;

				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glColor4f(1, 1, 1, 1);
				GL11.glEnable(GL11.GL_LIGHTING);

			}
		}
		
		if (Hoody7.on == true) {
			ModelBiped modelBiped;
			for (int i = 0; i < 4; ++i) {
				modelBiped = this.hd7_ov;

				GL11.glColor4f(1, 1, 1, 1);
				this.bindTexture(hd7);
				modelBiped.bipedHead.showModel = i == 0;
				modelBiped.bipedHeadwear.showModel = i == 0;
				modelBiped.bipedBody.showModel = i == 1 || i == 2;
				modelBiped.bipedRightArm.showModel = i == 1;
				modelBiped.bipedLeftArm.showModel = i == 1;
				modelBiped.bipedRightLeg.showModel = i == 2 || i == 3;
				modelBiped.bipedLeftLeg.showModel = i == 2 || i == 3;
				modelBiped.onGround = this.mainModel.onGround;
				modelBiped.isRiding = this.mainModel.isRiding;
				modelBiped.isChild = this.mainModel.isChild;
				if (this.mainModel instanceof ModelBiped) {
					modelBiped.heldItemLeft = ((ModelBiped) this.mainModel).heldItemLeft;
					modelBiped.heldItemRight = ((ModelBiped) this.mainModel).heldItemRight;
					modelBiped.isSneak = ((ModelBiped) this.mainModel).isSneak;
					modelBiped.aimedBow = ((ModelBiped) this.mainModel).aimedBow;
				}
				modelBiped.setLivingAnimations(entity, par2, par3, 0.0F);
				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);

				// Start alpha render
				GL11.glDisable(GL11.GL_LIGHTING);
				this.bindTexture(hd7);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glAlphaFunc(GL11.GL_GREATER, 0.0F);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				float time = entity.ticksExisted / 10.0F;
				float sTime = (float) Math.sin(time) * 0.5F + 0.5F;

				float r = 0.2F * sTime;
				float g = 1.0F * sTime;
				float b = 0.2F * sTime;

				modelBiped.render(entity, par2, par3, par4, par5, par6, par7);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glColor4f(1, 1, 1, 1);
				GL11.glEnable(GL11.GL_LIGHTING);

			}
		}
		
		
	}
}