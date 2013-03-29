package vazkii.craftingcreation.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemCreationTool extends ItemCraftingCreation implements ILevelable, IMark {

	public int toolType;
	
	public ItemCreationTool(int par1, int par2) {
		super(par1);
		this.toolType = par2;
	}
	
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		super.getSubItems(par1, par2CreativeTabs, par3List);
		
		ItemStack lvl1 = new ItemStack(par1, 1, 0);
		lvl1.addEnchantment(Enchantment.efficiency, 1);
		par3List.add(lvl1);
		
		ItemStack lvl2 = new ItemStack(par1, 1, 0);
		lvl2.addEnchantment(Enchantment.efficiency, 2);
		par3List.add(lvl2);
	}

	@Override
	public String getMarker(ItemStack stack) {
		return toolType == 0 ? "Shovel" : toolType == 1 ? "Pickaxe" : "Axe";
	}

	@Override
	public int getLevel(ItemStack stack) {
		return EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, stack);
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return false;
	}
}
