package vazkii.craftingcreation.dim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bouncycastle.util.Arrays;

import vazkii.craftingcreation.block.ModBlocks;
import vazkii.craftingcreation.handler.ConfigurationHandler;
import vazkii.craftingcreation.helper.MapGenerator;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.gen.structure.MapGenStructure;

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
		
        for (int k = 0; k < 7; ++k) {
            int l = k >> 4;
            ExtendedBlockStorage extendedblockstorage = chunk.getBlockStorageArray()[l];

            if (extendedblockstorage == null) {
                extendedblockstorage = new ExtendedBlockStorage(k, !world.provider.hasNoSky);
                chunk.getBlockStorageArray()[l] = extendedblockstorage;
            }

            for (int i1 = 0; i1 < 16; ++i1)
                for (int j1 = 0; j1 < 16; ++j1) {
                    extendedblockstorage.setExtBlockID(i1, k & 15, j1, (k < 7 ? ModBlocks.creationClay.blockID : 0) & 255);
                    extendedblockstorage.setExtBlockMetadata(i1, k & 15, j1, 0);
                }
        }

        chunk.generateSkylightMap();
        byte[] abyte = chunk.getBiomeArray();
        Arrays.fill(abyte, (byte) ConfigurationHandler.biomeID);

        chunk.generateSkylightMap();
        return chunk;
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
		return true;
	}

	@Override
	public String makeString() {
		return "Plane of Creation";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i, int j, int k) {
		return new ArrayList();
	}

	@Override
	public ChunkPosition findClosestStructure(World world, String s, int i, int j, int k) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int i, int j) {
		// NO-OP
	}
}
