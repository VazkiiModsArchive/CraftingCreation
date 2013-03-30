package vazkii.craftingcreation.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

import org.lwjgl.opengl.GL11;

public class GuiVault extends GuiContainer {

	public GuiVault(Container par1Container) {
		super(par1Container);
		ySize += 20;
	}

    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        this.fontRenderer.drawString("Sacred Vault", 8, 6, 4210752);
        this.fontRenderer.drawString("Inventory", 8, ySize - 96 + 2, 4210752);
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.func_98187_b("/gui/container.png");
        int k = (width - xSize) / 2;
        int l = (height - ySize) / 2;
        drawTexturedModalRect(k, l, 0, 0, xSize, 4 * 18 + 17);
        drawTexturedModalRect(k, l + 4 * 18 + 17, 0, 126, xSize, 96);		
	}

}
