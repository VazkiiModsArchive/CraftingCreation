package vazkii.craftingcreation.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import vazkii.craftingcreation.item.ILevelable;

public class GameItemRender implements IItemRenderer {

	RenderItem renderItem = new RenderItem();
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type == ItemRenderType.INVENTORY;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		FontRenderer font = Minecraft.getMinecraft().fontRenderer;
		renderItem.renderItemIntoGUI(font, Minecraft.getMinecraft().renderEngine, item, 0, 0);
		
		font.setUnicodeFlag(true);
		ILevelable itemCC = (ILevelable) item.getItem();
		font.drawStringWithShadow("" + (itemCC.getLevel(item) + 1), 1, 0, 0xFF6666);
		font.setUnicodeFlag(false);
	}

}
