package vazkii.craftingcreation.block;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.tileentity.TileEntity;

public interface IHUD {
	
	public void drawHUD(Minecraft mc, ScaledResolution resolution, int meta, TileEntity tile);

}
