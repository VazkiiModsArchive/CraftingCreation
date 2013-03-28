package vazkii.craftingcreation.helper;

import vazkii.craftingcreation.block.ModBlocks;
import vazkii.craftingcreation.handler.ConfigurationHandler;
import net.minecraft.world.World;

public final class GameHelper {
	
	private static final int MAP_SIZE = 23 * 7;
	private static final int MAP_HEIGHT = 50;
	
	private static boolean gameInProgress;
	
	public static boolean isWorldCreation(World world) {
		return world.getWorldInfo().getDimension() == ConfigurationHandler.dimID;
	}
	
	
	public void clearMap(World world) {
		if(!isWorldCreation(world))
			return;
		
		for(int y = 48; y < (64 + MAP_HEIGHT); y++) 
			for(int x = 0; x < MAP_SIZE; x++)
				for(int z = 0; z < MAP_SIZE; z++) {
					int id = y > 64 ? 0 : ModBlocks.creationClay.blockID;
					world.setBlockAndMetadataWithNotify(x, y, z, id, 0, 3);
				}
	}
}
