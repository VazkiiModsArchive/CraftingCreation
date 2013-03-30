package vazkii.craftingcreation.gui;

import vazkii.craftingcreation.item.IMark;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotVault extends Slot {

	public SlotVault(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}

	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		return par1ItemStack.getItem() instanceof IMark;
	}
	
}
