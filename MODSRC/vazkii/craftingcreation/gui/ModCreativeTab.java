package vazkii.craftingcreation.gui;

import net.minecraft.creativetab.CreativeTabs;
import vazkii.craftingcreation.item.ModItems;
import vazkii.craftingcreation.lib.ModConstants;

public class ModCreativeTab extends CreativeTabs {

	public static final ModCreativeTab theTab = new ModCreativeTab();
	
	public ModCreativeTab() {
		super(ModConstants.MOD_ID);
	}
	
	@Override
	public String getTranslatedTabLabel() {
		return ModConstants.MOD_NAME;
	}
	
	@Override
	public int getTabIconItemIndex() {
		return ModItems.creationStar.itemID;
	}

}
