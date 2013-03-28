package vazkii.craftingcreation.helper;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;
import vazkii.craftingcreation.area.AreaAltar;
import vazkii.craftingcreation.area.AreaBlueBase;
import vazkii.craftingcreation.area.AreaClayBoulder;
import vazkii.craftingcreation.area.AreaClayPit;
import vazkii.craftingcreation.area.AreaClayTree;
import vazkii.craftingcreation.area.AreaGenerator;
import vazkii.craftingcreation.area.AreaRedBase;
import vazkii.craftingcreation.area.AreaSacredKiln;
import vazkii.craftingcreation.area.AreaTerrainBoulder;
import vazkii.craftingcreation.area.AreaTerrainPond;
import vazkii.craftingcreation.area.AreaTerrainTower;
import vazkii.craftingcreation.block.ModBlocks;

public final class MapGenerator {
	
	public static final List<AreaGenerator> MAP_AREAS = new ArrayList();
	
	public static boolean isMapCleared = false; // TODO Keep as true
	
	static {
		MAP_AREAS.add(new AreaClayBoulder());
		MAP_AREAS.add(new AreaClayPit());
		MAP_AREAS.add(new AreaClayTree());
		MAP_AREAS.add(new AreaSacredKiln());
		MAP_AREAS.add(new AreaTerrainBoulder());
		MAP_AREAS.add(new AreaTerrainPond());
		MAP_AREAS.add(new AreaTerrainTower());
	}
	
	private static final String[] MAP = new String[] {
		"1EEEEEEEEEEEEEEEEEEEEEE",
		"EEEEEREEREEREEREEREEAEE",
		"EEEKEEEEEEEEEEEEEEEKEEE",
		"EEREEREEREEREEREEREEEEE",
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
		"EEEKEEEEEEEEEEEEEEEEEEE",
		"EEAEEREEREEREEREEREEEEE",
		"EEEEEEEEEEEEEEEEEEEEE0E",
		"EEEEEEEEEEEEEEEEEEEEEEE"
	};
	
	public static void clearMap(World world) {
		if(!GameHelper.isWorldCreation(world) || isMapCleared)
			return;
		
		for(int y = 62; y < (64/* + GameHelper.MAP_HEIGHT*/); y++) 
			for(int x = 0; x < GameHelper.MAP_SIZE; x++)
				for(int z = 0; z < GameHelper.MAP_SIZE; z++) {
					int id = y > 64 ? 0 : ModBlocks.creationClay.blockID;
					world.setBlockAndMetadataWithNotify(x, y, z, id, 0, 3);
				}
		isMapCleared = true;
	}
	
	public static void generateMap(World world) {
		if(!GameHelper.isWorldCreation(world))
			return;
		
		System.out.println("generateTime!");
		clearMap(world);
		
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
		generator.generate(world, x * 7, z * 7);
	}
}
