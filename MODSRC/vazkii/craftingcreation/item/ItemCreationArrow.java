package vazkii.craftingcreation.item;

import net.minecraft.item.ItemStack;

public class ItemCreationArrow extends ItemCraftingCreation implements IMark {

	public ItemCreationArrow(int par1) {
		super(par1);
	}

	@Override
	public String getMarker(ItemStack stack) {
		return "Arrow";
	}

}
