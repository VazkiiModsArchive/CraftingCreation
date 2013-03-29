package vazkii.craftingcreation.item;

import net.minecraft.item.ItemStack;

public interface IMark {
	
	public String getMarker(ItemStack stack);
	
	public int getValue(ItemStack stack);

}
