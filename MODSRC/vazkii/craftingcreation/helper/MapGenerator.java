package vazkii.craftingcreation.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

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
import vazkii.craftingcreation.area.AreaTerrainBoulder;
import vazkii.craftingcreation.area.AreaTerrainLavaPit;
import vazkii.craftingcreation.area.AreaTerrainPond;
import vazkii.craftingcreation.area.AreaTerrainTower;
import vazkii.craftingcreation.block.ModBlocks;

public final class MapGenerator {
	
	public static final List<AreaGenerator> MAP_AREAS = new ArrayList();
	
	public static boolean isMapCleared = false;
	
	static {
		MAP_AREAS.add(new AreaClayBoulder());
		MAP_AREAS.add(new AreaClayPit());
		MAP_AREAS.add(new AreaClayTree());
		MAP_AREAS.add(new AreaSacredKiln());
		MAP_AREAS.add(new AreaTerrainBoulder());
		MAP_AREAS.add(new AreaTerrainPond());
		MAP_AREAS.add(new AreaTerrainTower());
		MAP_AREAS.add(new AreaTerrainLavaPit());
	}
	
	private static final String[] MAP = new String[] {
		"1EEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEREEREEREEREEREEAEE",
		"EEKEEEEEEEEEEEEEEEEKEEE",
		"EEEEEREEREEREEREEREEEEE",
		"EEEEEEEEEEEEEEEEEEEKEEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEREEREEREEREEREEREEREE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEREEREEREEREEREEREEREE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEREEREEREEAEEREEREEREE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEREEREEREEREEREEREEREE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEREEREEREEREEREEREEREE",
		"EEEEEEEEEEEEEEEEEEEEEEE",
		"EEAEEREEREEREEREEREEKEE",
		"EEEEEEEEEEEEEEEEEEEEE0E",
		"EEEEEEEEEEEEEEEEEEEEEEE"
	};
	
	public static void generateMap(World world) {
		if(world.isRemote)
			return;
		
		for(int z = 0; z < MAP.length; z++) {
			String str = MAP[z];
			for(int x = 0; x < MAP.length; x++) {
				char c = str.charAt(x);
				generateAt(world, x, z, c);
			}
		}
		isMapCleared = false;
	}
	
	public static  void generateAt(World world, int x, int z, char c) {
		switch(c) {
			case 'E' : return; 
			case 'A' : generateAt(world, x, z, AreaAltar.INSTANCE);
						return;
			case 'K' : generateAt(world, x, z, AreaSacredKiln.INSTANCE);
						return;
			case '0' : generateAt(world, x, z, AreaBlueBase.INSTANCE);
						return;
			case '1' : generateAt(world, x, z, AreaRedBase.INSTANCE);
						return;
			case 'R' : generateRandomAt(world, x, z);
 		}
	}	
	
	public static void generateRandomAt(World world, int x, int z) {
		WeightedRandom random = new WeightedRandom();
		AreaGenerator generator = (AreaGenerator) random.getRandomItem(world.rand, MAP_AREAS);
		generateAt(world, x, z, generator);
	}
	
	public static void generateAt(World world, int x, int z, AreaGenerator generator) {
		CraftingCreation.logger.log(Level.INFO, "Generating " + generator + " @ " + x + ", " + z);
		generator.generate(world, (x * 7) + 2, (z * 7) + 2);
	}
}
