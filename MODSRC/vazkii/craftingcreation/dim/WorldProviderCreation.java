package vazkii.craftingcreation.dim;

import vazkii.craftingcreation.helper.GameHelper;
import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderCreation extends WorldProvider {

	@Override
	public String getDimensionName() {
		return "Plane of Creation";
	}
	
	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProvideCreation(worldObj);
	}
	
	@Override
    public float calculateCelestialAngle(long par1, float par3) {
        return 0.0F;
    }
	
	@Override
    public float[] calcSunriseSunsetColors(float par1, float par2) {
        return null;
    }
	
	@Override
    public boolean isSkyColored() {
        return true;
    }
	
	@Override
    public boolean isSurfaceWorld() {
        return false;
    }
	
	@Override
	public float getCloudHeight() {
		return 8F;
	}
	
	@Override
    public boolean canCoordinateBeSpawn(int par1, int par2)  {
        int k = this.worldObj.getFirstUncoveredBlock(par1, par2);
        return k == 0 ? false : Block.blocksList[k].blockMaterial.blocksMovement();
    }
	
	@Override
    public ChunkCoordinates getEntrancePortalLocation() {
        return new ChunkCoordinates(0, 0, 0);
    }
	
	@Override
    public int getAverageGroundLevel() {
        return 64;
    }
	
	@Override
    public boolean doesXZShowFog(int par1, int par2) {
        return true;
    }
	
	@Override
	public int getActualHeight() {
		return 7 + GameHelper.MAP_HEIGHT;
	}

}
