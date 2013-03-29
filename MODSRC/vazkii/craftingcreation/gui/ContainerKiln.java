package vazkii.craftingcreation.gui;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import vazkii.craftingcreation.item.ILevelable;
import vazkii.craftingcreation.item.IMark;
import vazkii.craftingcreation.item.ItemCreationApple;
import vazkii.craftingcreation.item.ItemCreationArmor;
import vazkii.craftingcreation.item.ItemCreationArrow;
import vazkii.craftingcreation.item.ItemCreationClayBow;
import vazkii.craftingcreation.item.ItemCreationSword;
import vazkii.craftingcreation.item.ItemCreationTool;
import vazkii.craftingcreation.item.ModItems;

public class ContainerKiln extends Container {
	
	InventoryKiln kiln;
	
	public int lastItem;
	public int lastLevel;

	public ContainerKiln(InventoryPlayer playerInv, InventoryKiln kiln) {
		this.kiln = kiln;
		
		addSlotToContainer(new SlotKiln(kiln, this, 0, 16, 102));
		
        for (int i = 0; i < 9; ++i)
            addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 142));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
	
	public static final Item[] stacksForButtons = new Item[] {
		ModItems.creationClayHelmet,
		ModItems.creationClayLeggings,
		ModItems.creationClayChestplate,
		ModItems.creationClayBoots,
		ModItems.creationClaySword,
		ModItems.creationClayShovel,
		ModItems.creationClayBow,
		ModItems.creationClayPick,
		ModItems.creationClayArrow,
		ModItems.creationClayAxe,
		ModItems.creationClayApple
	};
	
	public static ItemStack generateItemStack(Item item, int level) {
		if(item instanceof ItemCreationApple)
			return new ItemStack(item, 1, level);
	
		if(item instanceof ItemCreationArrow)
			return new ItemStack(item, (int) (2 * Math.pow(2, level)));
		
		if(item instanceof ItemCreationArmor) {
			ItemStack stack = new ItemStack(item, 1, 0);
			if(level > 0)
				stack.addEnchantment(Enchantment.protection, level);
			
			return stack;
		}
		
		if(item instanceof ItemCreationTool) {
			ItemStack stack = new ItemStack(item, 1, 0);
			if(level > 0)
				stack.addEnchantment(Enchantment.efficiency, level);
			
			return stack;
		}
		
		if(item instanceof ItemCreationSword) {
			ItemStack stack = new ItemStack(item, 1, 0);
			if(level > 0)
				stack.addEnchantment(Enchantment.sharpness, level);
			
			return stack;
		}
		
		if(item instanceof ItemCreationClayBow) {
			ItemStack stack = new ItemStack(item, 1, 0);
			if(level > 0)
				stack.addEnchantment(Enchantment.power, level);
			
			return stack;
		}
		
		return null;
	}
	
	public static int getItemCost(ItemStack item) {
		if(item == null)
			return 0;
		
		if(item.getItem() instanceof ItemCreationArrow)
			return 1;
		
		if(item.getItem() instanceof ItemCreationApple)
			return 2;
		
		int level = ((ILevelable)item.getItem()).getLevel(item);
		int value = ((IMark)item.getItem()).getValue(item);
		
		int cost = value / ((IMark) ModItems.creationClay).getValue(new ItemStack(ModItems.creationClay, 1, level));
		
		return cost;
	}
	
	public void updateInventory(int item, int level) {
		kiln.setInventorySlotContents(0, generateItemStack(stacksForButtons[item], level));
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		return null;
	}
}
