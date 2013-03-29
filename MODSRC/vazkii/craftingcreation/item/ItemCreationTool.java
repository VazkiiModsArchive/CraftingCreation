package vazkii.craftingcreation.item;

import java.util.List;

import vazkii.craftingcreation.block.BlockCreationClay;
import vazkii.craftingcreation.block.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCreationTool extends ItemCraftingCreation implements ILevelable, IMark {

	public int toolType;
	
	public ItemCreationTool(int par1, int par2) {
		super(par1);
		this.toolType = par2;
		setMaxDamage(16);
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
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Value: " + getValue(par1ItemStack));
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving) {
		par1ItemStack.damageItem(1, par7EntityLiving);
		if(par1ItemStack.getItemDamage() == (getMaxDamage() - 1))
			par1ItemStack.damageItem(1, par7EntityLiving);

		return true;
	}
	
	@Override
	public float getStrVsBlock(ItemStack itemstack, Block block, int metadata) {
		return block instanceof BlockCreationClay && BlockCreationClay.canHarvestBlock(itemstack, metadata) ? (3F + getLevel(itemstack) - (BlockCreationClay.getLevel(metadata))) : 1F;
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

	@Override
	public int getValue(ItemStack stack) {
		return (int) (((getMaxDamage() * Math.pow(2, getLevel(stack))) - Math.min(getMaxDamage() - 1, stack.getItemDamage()) * Math.pow(2, (getLevel(stack)))));
	}
}
