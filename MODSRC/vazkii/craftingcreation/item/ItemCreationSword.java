package vazkii.craftingcreation.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemCreationSword extends ItemCraftingCreation implements IMark, ILevelable {

	public ItemCreationSword(int par1) {
		super(par1);
		setMaxDamage(20);
	}
	
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		super.getSubItems(par1, par2CreativeTabs, par3List);
		
		ItemStack lvl1 = new ItemStack(par1, 1, 0);
		lvl1.addEnchantment(Enchantment.sharpness, 1);
		par3List.add(lvl1);
		
		ItemStack lvl2 = new ItemStack(par1, 1, 0);
		lvl2.addEnchantment(Enchantment.sharpness, 2);
		par3List.add(lvl2);
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Value: " + getValue(par1ItemStack));
	}
	
	@Override
	public int getDamageVsEntity(Entity par1Entity) {
		return 4;
	}

	@Override
	public int getLevel(ItemStack stack) {
		return EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, stack);
	}

	@Override
	public String getMarker(ItemStack stack) {
		return "Sword";
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return false;
	}
	
	@Override
	public int getValue(ItemStack stack) {
		return (int) (((getMaxDamage() * Math.pow(2, getLevel(stack))) - (stack.getMaxDamage() - stack.getItemDamage()) * (Math.pow(2, getLevel(stack)))));
	}
}
