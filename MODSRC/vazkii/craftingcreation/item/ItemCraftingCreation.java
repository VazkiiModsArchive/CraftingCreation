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
    public void func_94581_a(IconRegister par1IconRegister) {
        iconIndex = par1IconRegister.func_94245_a("CraftingCreation:" + getUnlocalizedName().replaceAll("item.CrCr_", ""));
    }

}
