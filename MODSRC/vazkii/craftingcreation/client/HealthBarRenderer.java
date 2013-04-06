package vazkii.craftingcreation.client;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustrum;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import vazkii.craftingcreation.helper.GameHelper;

public class HealthBarRenderer {
	
	@ForgeSubscribe
	public void onRenderWorldLast(RenderWorldLastEvent event) {
		Minecraft mc = Minecraft.getMinecraft();

		if (!Minecraft.isGuiEnabled() || !GameHelper.isGameInProgress()) 
			return;

		EntityLiving cameraEntity = mc.renderViewEntity;
		Vec3 renderingVector = cameraEntity.getPosition(event.partialTicks);
		Frustrum frustrum = new Frustrum();

		double viewX = cameraEntity.lastTickPosX + (cameraEntity.posX - cameraEntity.lastTickPosX) * event.partialTicks;
		double viewY = cameraEntity.lastTickPosY + (cameraEntity.posY - cameraEntity.lastTickPosY) * event.partialTicks;
		double viewZ = cameraEntity.lastTickPosZ + (cameraEntity.posZ - cameraEntity.lastTickPosZ) * event.partialTicks;
		frustrum.setPosition(viewX, viewY, viewZ);

		List<EntityPlayer> players = mc.theWorld.playerEntities;
		
		for (EntityPlayer entity : players)
			if (entity != null && 
				entity instanceof EntityLiving && 
				entity.isInRangeToRenderVec3D(renderingVector) && 
				(entity.ignoreFrustumCheck || 
						frustrum.isBoundingBoxInFrustum(entity.boundingBox)) && 
				entity.isEntityAlive()) 
				renderHealthBar(entity, event.partialTicks, cameraEntity);
	}

	public void renderHealthBar(EntityPlayer entity, float partialTicks, Entity viewPoint) {
		float distance = entity.getDistanceToEntity(viewPoint);
		if (distance > 20 || !entity.canEntityBeSeen(viewPoint) || !(entity instanceof EntityPlayer)) 
			return;
		
		double x = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * partialTicks;
		double y = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * partialTicks;
		double z = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * partialTicks;

		float scale = 0.026666672F;
		int maxHealth = entity.getMaxHealth();
		int health = entity.getHealth();
		boolean redTeam = GameHelper.isPlayerInTeam(true, entity.username);

		GL11.glPushMatrix();
		GL11.glTranslatef((float) (x - RenderManager.renderPosX), (float) (y - RenderManager.renderPosY + ((entity == Minecraft.getMinecraft().thePlayer) ? 0.5 : (entity.height + 0.3))), (float) (z - RenderManager.renderPosZ));
		GL11.glRotatef(-RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(RenderManager.instance.playerViewX, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(-scale, -scale, scale);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDepthMask(false);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA(0, 0, 0, 255);
		tessellator.addVertex(-maxHealth - 3, -1, 0.0D);
		tessellator.addVertex(-maxHealth - 1, 3, 0.0D);
		tessellator.addVertex(maxHealth + 3, 3, 0.0D);
		tessellator.addVertex(maxHealth + 1, -1, 0.0D);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA(63, 63, 63, 255);
		tessellator.addVertex(-maxHealth - 1, 0, 0.0D);
		tessellator.addVertex(-maxHealth, 2, 0.0D);
		tessellator.addVertex(maxHealth + 1, 2, 0.0D);
		tessellator.addVertex(maxHealth, 0, 0.0D);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA(redTeam ? 255 : 63, 63, !redTeam ? 255 : 63, 255);
		tessellator.addVertex(-maxHealth - 1, 0, 0.0D);
		tessellator.addVertex(-maxHealth, 2, 0.0D);
		tessellator.addVertex(health * 2 - maxHealth + 1, 2, 0.0D);
		tessellator.addVertex(health * 2 - maxHealth, 0, 0.0D);
		tessellator.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();
	}

}
