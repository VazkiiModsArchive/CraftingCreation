package vazkii.craftingcreation.core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import vazkii.craftingcreation.block.TileEntityBaseBeacon;
import vazkii.craftingcreation.client.GameItemRender;
import vazkii.craftingcreation.client.HUD;
import vazkii.craftingcreation.client.HealthBarRenderer;
import vazkii.craftingcreation.client.TileRenderBaseBeacon;
import vazkii.craftingcreation.handler.GameCountdownHandler;
import vazkii.craftingcreation.helper.GameHelper;
import vazkii.craftingcreation.item.ModItems;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {

	@Override
	public void initTickHandler() {
		TickRegistry.registerTickHandler(new HUD(), Side.CLIENT);
		TickRegistry.registerTickHandler(new GameCountdownHandler(), Side.CLIENT);
	}
	
	@Override
	public void recieveTimePacket(int time, boolean redTeam) {
		GameHelper.gameTime = time;
		GameHelper.isInRedTeam = redTeam;
		
		if(time > 10) { // Dirty trick for /endgame
			GameHelper.redTeamScore = 0;
			GameHelper.blueTeamScore = 0;
		}
	}
	
	@Override
	public void recieveScorePacket(int score, boolean redTeam) {
		if(redTeam)
			GameHelper.redTeamScore = score;
		else GameHelper.blueTeamScore = score;
	}
	
	@Override
	public void recieveHealthPacket(int id, int health, boolean redTeam) {
		Entity entity = ((WorldClient) Minecraft.getMinecraft().theWorld).getEntityByID(id);
		if(entity != null && entity instanceof EntityPlayer) {
			((EntityPlayer)entity).setEntityHealth(health);
			GameHelper.addPlayerToTeam(redTeam, ((EntityPlayer)entity).username);
		}
	}
	
	@Override
	public void initClient() {
		IItemRenderer renderer = new GameItemRender();
		
		MinecraftForgeClient.registerItemRenderer(ModItems.creationClay.itemID, renderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.creationClaySword.itemID, renderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.creationClayPick.itemID, renderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.creationClayShovel.itemID, renderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.creationClayAxe.itemID, renderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.creationClayBow.itemID, renderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.creationClayApple.itemID, renderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.creationClayHelmet.itemID, renderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.creationClayChestplate.itemID, renderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.creationClayLeggings.itemID, renderer);
		MinecraftForgeClient.registerItemRenderer(ModItems.creationClayBoots.itemID, renderer);
		
		MinecraftForge.EVENT_BUS.register(new HealthBarRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBaseBeacon.class, new TileRenderBaseBeacon());
	}	
}
