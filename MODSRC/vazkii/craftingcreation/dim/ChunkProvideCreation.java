package vazkii.craftingcreation.dim;

import java.util.List;

import org.bouncycastle.util.Arrays;

import vazkii.craftingcreation.block.ModBlocks;
import vazkii.craftingcreation.handler.ConfigurationHandler;

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
		return true;
	}

	@Override
	public Chunk provideChunk(int i, int j) {
		Chunk chunk = new Chunk(world, i, j);
		generateChunk(chunk);
		return chunk;
	}
	
	public void generateChunk(Chunk chunk) {
		byte[] array = new byte[32768];
		Arrays.fill(array, (byte) ConfigurationHandler.biomeID);
		chunk.setBiomeArray(array);
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
		return false;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
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
