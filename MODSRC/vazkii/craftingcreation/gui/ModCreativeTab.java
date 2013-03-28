package vazkii.craftingcreation.gui;

import cpw.mods.fml.common.registry.LanguageRegistry;
import vazkii.craftingcreation.lib.ModConstants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

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
		return Item.clay.itemID; // TODO Mod Clay!
	}

}
