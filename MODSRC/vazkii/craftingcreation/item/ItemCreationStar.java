package vazkii.craftingcreation.item;

import vazkii.craftingcreation.handler.ConfigurationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCreationStar extends ItemCraftingCreation {
	
	public ItemCreationStar(int par1) {
		super(par1);
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if(isClear(par3EntityPlayer, par1ItemStack)) {
			par3EntityPlayer.travelToDimension(ConfigurationHandler.dimID);
			par1ItemStack.stackSize--;
		} else par3EntityPlayer.addChatMessage("Please empty your inventory of everything but this item first.");
		
		return par1ItemStack;
	}
	
	public boolean isClear(EntityPlayer player, ItemStack exclusion) {
		InventoryPlayer inv = player.inventory;
		for(int i = 0; i < inv.getSizeInventory(); i++)
			if(!(inv.getStackInSlot(i) == null || inv.getStackInSlot(i) == exclusion))
				return false;
		
		return true;
	}
}
