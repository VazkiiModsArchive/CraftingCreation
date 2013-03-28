package vazkii.craftingcreation.dim;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeCreation extends BiomeGenBase {

	public static BiomeCreation theBiome;
	
	public BiomeCreation(int par1) {
		super(par1);
		setDisableRain();
		setBiomeName("Creation");
        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCaveCreatureList.clear();
	}
	
	@Override
    public int getSkyColorByTemp(float par1) {
        return 0;
    }

}
