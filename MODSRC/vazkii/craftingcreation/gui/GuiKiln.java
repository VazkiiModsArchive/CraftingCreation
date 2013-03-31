package vazkii.craftingcreation.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import vazkii.craftingcreation.helper.GameHelper;
import vazkii.craftingcreation.network.PacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;

public class GuiKiln extends GuiContainer {

	InventoryPlayer inv;
	InventoryKiln kiln;
	
	int item = 0;
	int level = 0;
	
	public GuiKiln(InventoryPlayer inv, InventoryKiln kiln) {
		super(new ContainerKiln(inv, kiln));
		this.inv = inv;
		this.kiln = kiln;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
		
        int index = 0;
        
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 3; j++) {
				int x = xStart + 28 + (i * 25);
				int y = yStart + (j == 2 ? 58 : (8 + 23 * j));
				
				GuiButton button = j != 2 ? new GuiButtonItem((j * 5) + i, x, y, new ItemStack(ContainerKiln.stacksForButtons[index]), index)
									: i > 0 && i < 4 ? new GuiButton((j * 5) + i, x, y, 20, 20, "" + i)
									: i == 0 ? new GuiButtonItem((j * 5) + i, x, y, new ItemStack(ContainerKiln.stacksForButtons[10]), 10)
									: null;
				
				if(button != null)
					buttonList.add(button);
				
				if(j != 2)
					index++;
			}
		
		sendPacket();
	}
	
	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if(par1GuiButton instanceof GuiButtonItem) {
			int index = ((GuiButtonItem)par1GuiButton).index;
			item = index;
		} else {
			String id = par1GuiButton.displayString;
			int index = Integer.parseInt(id);
			level = (index - 1);
		}
		
		sendPacket();
	}
	
	public void sendPacket() {
		PacketDispatcher.sendPacketToServer(PacketHandler.generateKilnPacket(item, level));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture("/mods/CraftingCreation/kilnGui.png");
        int k = (width - xSize) / 2;
        int l = (height - ySize) / 2;
        drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
        
        ItemStack stack = kiln.getStackInSlot(0);
        
        if(stack != null) {
    		int cost = ContainerKiln.getItemCost(stack);
    		int held = GameHelper.getClay(mc.thePlayer, level);
    		
            drawCenteredString(fontRenderer, "Level: " + (level + 1) , k + 89, l + 92, 0xFFFFFF);
            drawCenteredString(fontRenderer, "Required: " + cost , k + 89, l + 102, (cost > held ? 0xFF7D7D : 0xFFFFFF));
            drawCenteredString(fontRenderer, "Held: " + held , k + 89, l + 112, (cost > held ? 0xFF7D7D : 0xFFFFFF));
        }
	}

}
