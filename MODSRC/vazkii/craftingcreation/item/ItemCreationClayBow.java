package vazkii.craftingcreation.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemCreationClayBow extends ItemCreationClay implements IMark, ILevelable {

	public ItemCreationClayBow(int par1) {
		super(par1);
		setMaxDamage(24);
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Value: " + getValue(par1ItemStack));
	}
	
	@Override
	public String getMarker(ItemStack stack) {
		return "Bow";
	}

}
