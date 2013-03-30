package vazkii.craftingcreation.client;

import java.util.EnumSet;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import vazkii.craftingcreation.block.IHUD;
import vazkii.craftingcreation.handler.ConfigurationHandler;
import vazkii.craftingcreation.helper.GameHelper;
import vazkii.craftingcreation.item.ModItems;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class HUD implements ITickHandler  {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) { }

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		Minecraft mc = Minecraft.getMinecraft();
		
		if(!mc.isGuiEnabled())
			return;
		
		ScaledResolution res = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
		MovingObjectPosition blockLooking = mc.objectMouseOver;
		
		if(mc.thePlayer != null && mc.thePlayer.dimension == ConfigurationHandler.dimID && mc.currentScreen == null) {
			if(GameHelper.isGameInProgress()) {
				String time = "Time Remaining: " + GameHelper.getGameTimeString();
				mc.fontRenderer.drawStringWithShadow(time, res.getScaledWidth() / 2 - mc.fontRenderer.getStringWidth(time) / 2, 6, (GameHelper.gameTime >= 1200 ? 0xFFD821 : 0xFF4444));
			
				String score = "Score: " + (GameHelper.isInRedTeam ? GameHelper.redTeamScore : GameHelper.blueTeamScore);
				mc.fontRenderer.drawStringWithShadow(score, res.getScaledWidth() / 2 - mc.fontRenderer.getStringWidth(score) / 2, 16, 0xFFD821);
		
				String bounty = "Your Bounty: " + GameHelper.getTotalValueHeld(mc.thePlayer) + " pt.";
				mc.fontRenderer.drawStringWithShadow(bounty, res.getScaledWidth() / 2 - mc.fontRenderer.getStringWidth(bounty) / 2, res.getScaledHeight() - 72, 0xFFD821);
			
				RenderItem itemRender = new RenderItem();
				int start = res.getScaledHeight() / 2;
				for(int i = 0; i < 3; i++) {
					ItemStack stack = new ItemStack(ModItems.creationClay, 1, i);
					
					RenderHelper.enableStandardItemLighting();
					itemRender.renderItemIntoGUI(mc.fontRenderer, mc.renderEngine, stack, 3, start + 27 * i);
					RenderHelper.disableStandardItemLighting();
					mc.fontRenderer.drawStringWithShadow("Level " + (i + 1), 19, start + 27 * i, 0xFFFFFF);
					mc.fontRenderer.drawStringWithShadow("Held: " + GameHelper.getClay(mc.thePlayer, i), 19, start + 27 * i + 11, 0xFFFFFF);

				}
			}
		}
		
		if(mc.theWorld != null && blockLooking != null && mc.currentScreen == null) {
			int id = mc.theWorld.getBlockId(blockLooking.blockX, blockLooking.blockY, blockLooking.blockZ);
			if(id != 0) {
				Block block = Block.blocksList[id];
				if(block instanceof IHUD) {
					IHUD hud = (IHUD) block;
					
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
