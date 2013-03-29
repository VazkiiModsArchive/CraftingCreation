package vazkii.craftingcreation.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;

public class GuiButtonItem extends GuiButton {

	ItemStack item;
	
	public final int index;
	
	public GuiButtonItem(int par1, int par2, int par3, ItemStack stack, int index) {
		super(par1, par2, par3, 20, 20, "");
		item = stack;
		this.index = index;
	}
	
	@Override
	public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
		super.drawButton(par1Minecraft, par2, par3);
		
		RenderItem render = new RenderItem();
		RenderHelper.enableStandardItemLighting();
		render.renderItemIntoGUI(par1Minecraft.fontRenderer, par1Minecraft.renderEngine, item, xPosition + 2, yPosition + 1);
		RenderHelper.disableStandardItemLighting();
	}

}
