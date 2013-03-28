package vazkii.craftingcreation.helper;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.World;
import vazkii.craftingcreation.area.AreaClayBoulder;
import vazkii.craftingcreation.area.AreaClayPit;
import vazkii.craftingcreation.area.AreaClayTree;
import vazkii.craftingcreation.area.AreaGenerator;
import vazkii.craftingcreation.area.AreaSacredKiln;
import vazkii.craftingcreation.area.AreaTerrainBoulder;
import vazkii.craftingcreation.area.AreaTerrainPond;
import vazkii.craftingcreation.area.AreaTerrainTower;

public final class MapGenerator {
	
	public static final List<AreaGenerator> MAP_AREAS = new ArrayList();
	
	static {
		MAP_AREAS.add(new AreaClayBoulder());
		MAP_AREAS.add(new AreaClayPit());
		MAP_AREAS.add(new AreaClayTree());
		MAP_AREAS.add(new AreaSacredKiln());
		MAP_AREAS.add(new AreaTerrainBoulder());
		MAP_AREAS.add(new AreaTerrainPond());
		MAP_AREAS.add(new AreaTerrainTower());
	}
	
	public void generateMap(World world) {
		if(!GameHelper.isWorldCreation(world))
			return;
	}
	
}
