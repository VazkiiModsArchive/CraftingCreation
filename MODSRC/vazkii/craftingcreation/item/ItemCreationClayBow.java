package vazkii.craftingcreation.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ItemCreationClayBow extends ItemCreationClay implements IMark, ILevelable {

	public ItemCreationClayBow(int par1) {
		super(par1);
	}
	
	// TODO Enchants!
	
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		super.getSubItems(par1, par2CreativeTabs, par3List);
		
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
	}
	
	@Override
	public String getMarker(ItemStack stack) {
		return "Bow";
	}

}
