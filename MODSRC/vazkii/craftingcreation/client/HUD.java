package vazkii.craftingcreation.client;

import java.util.EnumSet;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import vazkii.craftingcreation.block.IHUD;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class HUD implements ITickHandler  {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) { }

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		Minecraft mc = Minecraft.getMinecraft();
		MovingObjectPosition blockLooking = mc.objectMouseOver;
		
		if(mc.theWorld != null && blockLooking != null && mc.currentScreen == null) {
			int id = mc.theWorld.getBlockId(blockLooking.blockX, blockLooking.blockY, blockLooking.blockZ);
			if(id != 0) {
				Block block = Block.blocksList[id];
				if(block instanceof IHUD) {
					IHUD hud = (IHUD) block;
					
					ScaledResolution res = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
					int meta = mc.theWorld.getBlockMetadata(blockLooking.blockX, blockLooking.blockY, blockLooking.blockZ);
					TileEntity tile = mc.theWorld.getBlockTileEntity(blockLooking.blockX, blockLooking.blockY, blockLooking.blockZ);
					
					hud.drawHUD(mc, res, meta, tile);
				}
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.RENDER);
	}

	@Override
	public String getLabel() {
		return "CraftingCreationHUD";
	}

}
