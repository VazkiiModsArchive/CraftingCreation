package vazkii.craftingcreation.core;

import vazkii.craftingcreation.handler.ConfigurationHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.loadConfig(event.getSuggestedConfigurationFile());
	}
	
	public void init(FMLInitializationEvent event) {
		
	}

}
