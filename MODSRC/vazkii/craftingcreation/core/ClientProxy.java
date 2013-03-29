package vazkii.craftingcreation.core;

import vazkii.craftingcreation.client.GameItemRender;
import vazkii.craftingcreation.item.ModItems;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

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
