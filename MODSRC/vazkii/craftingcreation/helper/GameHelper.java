package vazkii.craftingcreation.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import vazkii.craftingcreation.item.IMark;
import vazkii.craftingcreation.item.ModItems;

public final class GameHelper {
	
	public static final int MAP_SIZE = 23 * 7;
	public static final int MAP_HEIGHT = 16;
	
	private static boolean gameInProgress;
	
	public static int getTotalValueHeld(EntityPlayer player) {
		InventoryPlayer inv = player.inventory;
		
		int foundValue = 0;
	
		for(int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if(stack != null && stack.getItem() instanceof IMark)
				foundValue += ((IMark)stack.getItem()).getValue(stack);
		}
		
		return foundValue;
	}
	
	public static int getClay(EntityPlayer player, int level) {
		InventoryPlayer inv = player.inventory;
		
		int foundClay = 0;
		
		for(int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if(stack != null && stack.itemID == ModItems.creationClay.itemID && stack.getItemDamage() == level)
				++foundClay;
		}
		
		return foundClay;
	}
}
