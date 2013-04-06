package vazkii.craftingcreation.block;

import net.minecraft.tileentity.TileEntity;

public class TileEntityBaseBeacon extends TileEntity {
	
	public boolean isRedTeam() {
		return getBlockMetadata() == 0;
	}
	
    @Override
    public double getMaxRenderDistanceSquared()  {
        return 65536;
    }
}
