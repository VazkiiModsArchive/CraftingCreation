package vazkii.craftingcreation.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryKiln implements IInventory {

	ItemStack stack;
	
	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return stack;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return stack;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		stack = itemstack;
	}

	@Override
	public String getInvName() {
		return "kiln";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void onInventoryChanged() {
		// NO-OP
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void openChest() {
		// NO-OP
	}

	@Override
	public void closeChest() {
		// NO-OP
	}
	
	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		return false;
	}


}
