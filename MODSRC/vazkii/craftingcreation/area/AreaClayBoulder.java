/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package vazkii.craftingcreation.area;
import net.minecraft.world.World;
import vazkii.craftingcreation.block.ModBlocks;

public class AreaClayBoulder extends AreaGenerator {
	
	public AreaClayBoulder() {
		super(10);
	}

	public void generate(World world, int i, int k) {
		int j = this.j - 1;
		int clayLevel = world.rand.nextInt(5);
		
		world.setBlockAndMetadataWithNotify(i + 0, j + 0, k + 0, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 0, j + 0, k + 1, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 0, j + 0, k + 2, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 0, j + 0, k + 3, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 0, j + 0, k + 4, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 0, j + 0, k + 5, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 0, j + 0, k + 6, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 0, k + 0, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 0, k + 1, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 0, k + 2, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 0, k + 3, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 0, k + 4, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 0, k + 5, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 0, k + 6, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 1, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 1, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 1, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 3, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 3, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 4, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 1, j + 4, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 0, k + 0, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 0, k + 1, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 0, k + 2, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 0, k + 3, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 0, k + 4, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 0, k + 5, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 0, k + 6, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 1, k + 1, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 1, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 1, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 1, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 1, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 2, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 2, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 2, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 3, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 3, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 3, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 3, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 4, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 4, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 4, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 4, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 5, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 2, j + 5, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 0, k + 0, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 0, k + 1, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 0, k + 2, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 0, k + 3, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 0, k + 4, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 0, k + 5, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 0, k + 6, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 1, k + 1, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 1, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 1, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 1, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 1, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 2, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 2, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 2, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 2, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 3, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 3, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 3, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 3, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 4, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 4, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 4, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 5, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 5, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 5, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 3, j + 6, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 0, k + 0, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 0, k + 1, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 0, k + 2, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 0, k + 3, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 0, k + 4, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 0, k + 5, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 0, k + 6, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 1, k + 1, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 1, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 1, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 1, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 1, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 2, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 2, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 2, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 2, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 3, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 3, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 4, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 4, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 5, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 4, j + 5, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 5, j + 0, k + 0, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 5, j + 0, k + 1, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 5, j + 0, k + 2, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 5, j + 0, k + 3, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 5, j + 0, k + 4, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 5, j + 0, k + 5, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 5, j + 0, k + 6, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 5, j + 1, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 5, j + 1, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 5, j + 1, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 5, j + 1, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 5, j + 2, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 3);
		world.setBlockAndMetadataWithNotify(i + 6, j + 0, k + 0, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 6, j + 0, k + 1, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 6, j + 0, k + 2, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 6, j + 0, k + 3, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 6, j + 0, k + 4, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 6, j + 0, k + 5, ModBlocks.creationClay.blockID, 0, 3);
		world.setBlockAndMetadataWithNotify(i + 6, j + 0, k + 6, ModBlocks.creationClay.blockID, 0, 3);
	}
}