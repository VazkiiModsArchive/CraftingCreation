package vazkii.craftingcreation.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import vazkii.craftingcreation.helper.GameHelper;
import vazkii.craftingcreation.item.ItemCreationTool;
import vazkii.craftingcreation.item.ModItems;

public class BlockCreationClay extends BlockCraftingCreation implements IHUD {

	public BlockCreationClay(int id) {
		super(id, Material.clay);
	}
	
	// 0 - 1, Dirt
	// 1 - 1, Stone
	// 2 - 1, Wood
	// 3 - 2, Dirt
	// 4 - 2, Stone
	// 5 - 2, Wood
	// 6 - 3, Dirt
	// 7 - 3, Stone
	// 8 - 3, Wood
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return ModItems.creationClay.itemID;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return 1;
	}
	
	@Override
	public int damageDropped(int par1) {
		return getLevel(par1);
	}
	
	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta) {
		return canHarvestBlock(player.getCurrentEquippedItem(), meta);
	}
	
	public static boolean canHarvestBlock(ItemStack stack, int meta) {
		int level = getLevel(meta);
		if(level == 0)
			return true;
		
		int type = getType(meta);
		if(stack == null || !(stack.getItem() instanceof ItemCreationTool))
			return false;
		
		ItemCreationTool item = (ItemCreationTool) stack.getItem();
		String itemType = item.getMarker(stack);
		
		if(!((type == 0 && itemType.equals("Shovel")) || (type == 1 && itemType.equals("Pickaxe")) || (type == 2 && itemType.equals("Axe"))))
			return false;
		
		return (item.getLevel(stack) + 1) >= level;
	}
	
	@Override
	public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {
		return false;
	}
	
	public static int getMetaFor(int level, int type) {
		return level * 3 + type;
	}
	
	public static int getLevel(int meta) {
		return meta / 3;
	}
	
	public static int getType(int meta) {
		return meta % 3;
	}
	
	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4) {
		return GameHelper.isGameInProgress() ? (super.getBlockHardness(par1World, par2, par3, par4) * (getLevel(par1World.getBlockMetadata(par2, par3, par4)) + 1) * 2) : -1F; 
	}

	@Override
	public void drawHUD(Minecraft mc, ScaledResolution resolution, int meta, TileEntity tile) {
		int x = resolution.getScaledWidth() / 2 + 12;
		int y = resolution.getScaledHeight() / 2 - 4;
		
		int type = getType(meta);
		int level = getLevel(meta);
		
		ItemStack drawStack = new ItemStack((type == 0 ? ModItems.creationClayShovel : type == 1 ? ModItems.creationClayPick : ModItems.creationClayAxe).itemID, 1, 0);
		
		RenderItem itemRender = new RenderItem();
		
		RenderHelper.enableGUIStandardItemLighting();
		itemRender.renderItemIntoGUI(mc.fontRenderer, mc.renderEngine, drawStack, x, y);
		RenderHelper.disableStandardItemLighting();
		
		GL11.glColor3f(1F, 1F, 1F);
		mc.fontRenderer.drawStringWithShadow((type == 0 ? "Soil" : type == 1 ? "Rock" :  "Wood"), x + 18, y, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("Level " + (level + 1), x + 18, y + 11, 0xFFFFFF);
	}
}
