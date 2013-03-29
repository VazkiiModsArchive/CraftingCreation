package vazkii.craftingcreation.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemCreationClay extends ItemCraftingCreation implements IMark, ILevelable {

	public ItemCreationClay(int par1) {
		super(par1);
		setHasSubtypes(true);
		setMaxStackSize(1);
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Value: " + getValue(par1ItemStack));
	}
	
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		super.getSubItems(par1, par2CreativeTabs, par3List);
		
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
	}

	@Override
	public int getLevel(ItemStack stack) {
		return stack.getItemDamage();
	}

	@Override
	public String getMarker(ItemStack stack) {
		return "Clay";
	}

	@Override
	public int getValue(ItemStack stack) {
		return (int) (2 * Math.pow(2, (getLevel(stack))));
	}
}
