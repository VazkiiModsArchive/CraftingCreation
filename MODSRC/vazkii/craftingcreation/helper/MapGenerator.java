package vazkii.craftingcreation.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import cpw.mods.fml.common.network.PacketDispatcher;

import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import vazkii.craftingcreation.CraftingCreation;
import vazkii.craftingcreation.area.AreaAltar;
import vazkii.craftingcreation.area.AreaBlueBase;
import vazkii.craftingcreation.area.AreaClayBoulder;
import vazkii.craftingcreation.area.AreaClayPit;
import vazkii.craftingcreation.area.AreaClayTree;
import vazkii.craftingcreation.area.AreaGenerator;
import vazkii.craftingcreation.area.AreaRedBase;
import vazkii.craftingcreation.area.AreaSacredKiln;
import vazkii.craftingcreation.area.AreaSurroundingWalls;
import vazkii.craftingcreation.area.AreaTerrainBoulder;
import vazkii.craftingcreation.area.AreaTerrainLavaPit;
import vazkii.craftingcreation.area.AreaTerrainPond;
import vazkii.craftingcreation.area.AreaTerrainTower;
import vazkii.craftingcreation.block.ModBlocks;
import vazkii.craftingcreation.handler.ConfigurationHandler;

public final class MapGenerator {
	
	public static final List<AreaGenerator> MAP_AREAS = new ArrayList();
	
	public static boolean mapGenerated = false;
	
	public static int lastMapXRoot;
	public static int lastMapZRoot;
	
	static {
		MAP_AREAS.add(new AreaClayBoulder());
		MAP_AREAS.add(new AreaClayPit());
		MAP_AREAS.add(new AreaClayTree());
		MAP_AREAS.add(new AreaTerrainBoulder());
		MAP_AREAS.add(new AreaTerrainPond());
		MAP_AREAS.add(new AreaTerrainTower());
		MAP_AREAS.add(new AreaTerrainLavaPit());
	}
	
	private static final String[] MAP = new String[] {
		"REEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEKEE0EE0EE0EE0EE0EEAEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EE0EE1EE1EE1EE1EEKEE0EE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EE0EE1EE2EE2EE2EE1EE0EE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EE0EE1EE2EEKEE2EE1EE0EE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EE0EE1EE2EE2EE2EE1EE0EE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EE0EEKEE1EE1EE1EE1EE0EE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEAEE0EE0EE0EE0EE0EEKEE",
		"EEEEEEEEEEEEEEEEEEEEEBE",
		"EEEEEEEEEEEEEEEEEEEEEEE"
	};
	
	public static void generateMap(World world, int xRoot, int zRoot) {
		if(world.isRemote)
			return;
		
		for(int z = 0; z < MAP.length; z++) {
			String str = MAP[z];
			for(int x = 0; x < MAP.length; x++) {
				char c = str.charAt(x);
				generateAt(world, x, z, c, xRoot, zRoot);
			}
		}
		generateAt(world, 0, 0, AreaSurroundingWalls.INSTANCE, xRoot, zRoot);
		
		mapGenerated = true;
		lastMapXRoot = xRoot;
		lastMapZRoot = zRoot;
		
		Packet3Chat packet = new Packet3Chat("A new map has been generated at " + xRoot + ", 10, "  + zRoot);
		PacketDispatcher.sendPacketToAllInDimension(packet, ConfigurationHandler.dimID);
	}
	
	public static  void generateAt(World world, int x, int z, char c, int xRoot, int zRoot) {
		switch(c) {
			case 'E' : return; 
			case 'A' : generateAt(world, x, z, AreaAltar.INSTANCE, xRoot, zRoot);
						return;
			case 'K' : generateAt(world, x, z, AreaSacredKiln.INSTANCE, xRoot, zRoot);
						return;
			case 'B' : generateAt(world, x, z, AreaBlueBase.INSTANCE, xRoot, zRoot);
						return;
			case 'R' : generateAt(world, x, z, AreaRedBase.INSTANCE, xRoot, zRoot);
						return;
			case '0' : generateRandomAt(world, x, z, 0, xRoot, zRoot);
						return;
			case '1' : generateRandomAt(world, x, z, 1, xRoot, zRoot);
						return;
			case '2' : generateRandomAt(world, x, z, 2, xRoot, zRoot);
						return;
 		}
	}	
	
	public static void generateRandomAt(World world, int x, int z, int level, int xRoot, int zRoot) {
		AreaGenerator.currentClayLevel = level;
		
		WeightedRandom random = new WeightedRandom();
		AreaGenerator generator = (AreaGenerator) random.getRandomItem(world.rand, MAP_AREAS);
		generateAt(world, x, z, generator, xRoot, zRoot);
	}
	
	public static void generateAt(World world, int x, int z, AreaGenerator generator, int xRoot, int zRoot) {
		CraftingCreation.logger.log(Level.INFO, "Generating " + generator + " @ " + x + ", " + z);
		generator.generate(world, xRoot + (x * 7) + 2, zRoot + (z * 7) + 2);
	}
}
