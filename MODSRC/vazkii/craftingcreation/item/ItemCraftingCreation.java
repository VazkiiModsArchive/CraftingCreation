package vazkii.craftingcreation.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import vazkii.craftingcreation.gui.ModCreativeTab;

public class ItemCraftingCreation extends Item {

	public ItemCraftingCreation(int par1) {
		super(par1 - 256);
		setCreativeTab(ModCreativeTab.theTab);
	}
	
	@Override
    public void updateIcons(IconRegister par1IconRegister) {
        iconIndex = par1IconRegister.registerIcon("CraftingCreation:" + getUnlocalizedName().replaceAll("item.CrCr_", ""));
    }

}
