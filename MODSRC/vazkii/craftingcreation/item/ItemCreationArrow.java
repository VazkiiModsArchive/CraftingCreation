package vazkii.craftingcreation.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemCreationArrow extends ItemCraftingCreation implements IMark {

	public ItemCreationArrow(int par1) {
		super(par1);
		setMaxStackSize(8);
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Value: " + getValue(par1ItemStack));
	}

	@Override
	public String getMarker(ItemStack stack) {
		return "Arrow";
	}

	@Override
	public int getValue(ItemStack stack) {
		return stack.stackSize;
	}

}
