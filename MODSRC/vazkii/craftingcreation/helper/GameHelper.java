package vazkii.craftingcreation.helper;

import vazkii.craftingcreation.block.ModBlocks;
import vazkii.craftingcreation.handler.ConfigurationHandler;
import net.minecraft.world.World;

public final class GameHelper {
	
	public static final int MAP_SIZE = 23 * 7;
	public static final int MAP_HEIGHT = 12;
	
	private static boolean gameInProgress;
	
	public static boolean isWorldCreation(World world) {
		return true; //world.getWorldInfo().getDimension() == ConfigurationHandler.dimID; TODO Remove always work!!
	}
}
