package vazkii.craftingcreation.core;

import net.minecraftforge.common.DimensionManager;
import vazkii.craftingcreation.block.ModBlocks;
import vazkii.craftingcreation.dim.BiomeCreation;
import vazkii.craftingcreation.dim.WorldProviderCreation;
import vazkii.craftingcreation.handler.ConfigurationHandler;
import vazkii.craftingcreation.item.ModItems;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

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
		
		initClient();
	}
	
	public void initClient() {
		
	}
	
	public void initDimension() {
		BiomeCreation.theBiome = new BiomeCreation(ConfigurationHandler.biomeID);
		DimensionManager.registerProviderType(ConfigurationHandler.dimID, WorldProviderCreation.class, false);
		DimensionManager.registerDimension(ConfigurationHandler.dimID, ConfigurationHandler.dimID);
	}

}
