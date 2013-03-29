package vazkii.craftingcreation.area;

import vazkii.craftingcreation.block.ModBlocks;
import vazkii.craftingcreation.helper.GameHelper;
import net.minecraft.world.World;

public class AreaSurroundingWalls extends AreaGenerator {

	public static final AreaSurroundingWalls INSTANCE = new AreaSurroundingWalls();
	
	public AreaSurroundingWalls() {
		super(0);
	}

	@Override
	public void generate(World world, int i, int k) {
		i -= 1;
		k -= 1;
	
		for(int y = 0; y < GameHelper.MAP_HEIGHT; y++) {
			for(int x = 1; x < GameHelper.MAP_SIZE + 2; x++) {
				world.setBlockAndMetadataWithNotify(i + x, j + y, k, ModBlocks.invisibleWall.blockID, 0, 2);
				world.setBlockAndMetadataWithNotify(i + x, j + y, k + (GameHelper.MAP_SIZE + 1), ModBlocks.invisibleWall.blockID, 0, 2);
			}
			for(int z = 0; z < GameHelper.MAP_SIZE + 1; z++) {
				world.setBlockAndMetadataWithNotify(i, j + y, k + z, ModBlocks.invisibleWall.blockID, 0, 2);
				world.setBlockAndMetadataWithNotify(i + (GameHelper.MAP_SIZE + 1), j + y, k + z, ModBlocks.invisibleWall.blockID, 0, 2);
			}
		}
	}

}
