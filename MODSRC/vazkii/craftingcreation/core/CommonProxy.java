package vazkii.craftingcreation.core;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import vazkii.craftingcreation.CraftingCreation;
import vazkii.craftingcreation.block.ModBlocks;
import vazkii.craftingcreation.block.TileEntityVault;
import vazkii.craftingcreation.dim.BiomeCreation;
import vazkii.craftingcreation.dim.WorldProviderCreation;
import vazkii.craftingcreation.handler.ConfigurationHandler;
import vazkii.craftingcreation.handler.GameCountdownHandler;
import vazkii.craftingcreation.handler.GuiHandler;
import vazkii.craftingcreation.handler.ItemNoSmuggleHandler;
import vazkii.craftingcreation.handler.PlayerTracker;
import vazkii.craftingcreation.item.ModItems;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.loadConfig(event.getSuggestedConfigurationFile());
	}
	
	public void init(FMLInitializationEvent event) {
		initDimension();
		
		ModBlocks.initBlocks();
		ModItems.initItems();
		
		ModBlocks.nameBlocks();
		ModItems.nameItems();
		
		GameRegistry.registerTileEntity(TileEntityVault.class, "CrCr_TileVault");
		
		initTickHandler();
		
		MinecraftForge.EVENT_BUS.register(new ItemNoSmuggleHandler());
		
		NetworkRegistry.instance().registerGuiHandler(CraftingCreation.instance, new GuiHandler());
		
		GameRegistry.registerPlayerTracker(new PlayerTracker());
		
		initClient();
	}
	
	public void initTickHandler() {
		TickRegistry.registerTickHandler(new GameCountdownHandler(), Side.SERVER);
	}
	
	public void initClient() {
		// NO-OP
	}
	
	public void recieveTimePacket(int time, boolean redTeam) {
		// NO-OP
	}
	
	public void recieveScorePacket(int score, boolean redTeam) {
		// NO-OP
	}
	
	public void initDimension() {
		BiomeCreation.theBiome = new BiomeCreation(ConfigurationHandler.biomeID);
		DimensionManager.registerProviderType(ConfigurationHandler.dimID, WorldProviderCreation.class, false);
		DimensionManager.registerDimension(ConfigurationHandler.dimID, ConfigurationHandler.dimID);
	}

}
