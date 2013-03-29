package vazkii.craftingcreation.item;

import static vazkii.craftingcreation.handler.ConfigurationHandler.*;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.item.Item;

public final class ModItems {

	// TODO Other things!
	
	public static Item creationStar;
	
	public static void initItems() {
		creationStar = new ItemCreationStar(itemIDCreationStar).setUnlocalizedName("CrCr_creationStar");
	}
	
	public static void nameItems() {
		LanguageRegistry.addName(creationStar, "Star of Creation");
	}
}
