package vazkii.craftingcreation.block;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

public interface IHUD {
	
	public void drawHUD(Minecraft mc, int x, int y, int meta, TileEntity tile);

}
