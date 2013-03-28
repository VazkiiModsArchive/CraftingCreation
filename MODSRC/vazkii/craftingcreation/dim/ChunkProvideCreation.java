package vazkii.craftingcreation.dim;

import java.util.List;

import vazkii.craftingcreation.block.ModBlocks;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProvideCreation implements IChunkProvider {

	World world;
	
	public ChunkProvideCreation(World world) {
		this.world = world;
	}
	
	@Override
	public boolean chunkExists(int i, int j) {
		return false;
	}

	@Override
	public Chunk provideChunk(int i, int j) {
		Chunk chunk = new Chunk(world, i, j);
		generateChunk(chunk);
		return chunk;
	}
	
	public void generateChunk(Chunk chunk) {
		for(int y = 0; y < 256; y++) {
			for(int x = 0; x < 16; x++)
				for(int z = 0; z < 16; z++)
					chunk.setBlockIDWithMetadata(x, y, z, ModBlocks.invisibleWall.blockID, 0);
		}
	}

	@Override
	public Chunk loadChunk(int i, int j) {
		return provideChunk(i, j);
	}

	@Override
	public void populate(IChunkProvider ichunkprovider, int i, int j) {
		// NO-OP
	}

	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return false;
	}

	@Override
	public String makeString() {
		return "Plane of Creation";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i, int j, int k) {
		return null;
	}

	@Override
	public ChunkPosition findClosestStructure(World world, String s, int i, int j, int k) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 20;
	}

	@Override
	public void recreateStructures(int i, int j) {
		// NO-OP
	}

}
