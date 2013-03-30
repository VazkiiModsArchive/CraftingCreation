package vazkii.craftingcreation.core;

import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import vazkii.craftingcreation.client.GameItemRender;
import vazkii.craftingcreation.client.HUD;
import vazkii.craftingcreation.handler.GameCountdownHandler;
import vazkii.craftingcreation.helper.GameHelper;
import vazkii.craftingcreation.item.ModItems;
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
		
		if(time > 10) { // Dirty for for /endgame
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
	}	
}
