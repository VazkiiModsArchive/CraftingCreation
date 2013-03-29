package vazkii.craftingcreation.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import vazkii.craftingcreation.gui.ModCreativeTab;

public class ItemCreationArmor extends ItemArmor implements IMark, ILevelable {

	public static final EnumArmorMaterial material = EnumHelper.addArmorMaterial("SACRED_CLAY", 64, new int[] { 2, 2, 2, 2}, 0);
	
	public ItemCreationArmor(int par1, int armorType) {
		super(par1 - 256, material, 0, armorType);
		setCreativeTab(ModCreativeTab.theTab);
		setMaxDamage(48);
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Value: " + getValue(par1ItemStack));
	}
	
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		super.getSubItems(par1, par2CreativeTabs, par3List);
		
		ItemStack lvl1 = new ItemStack(par1, 1, 0);
		lvl1.addEnchantment(Enchantment.protection, 1);
		par3List.add(lvl1);
		
		ItemStack lvl2 = new ItemStack(par1, 1, 0);
		lvl2.addEnchantment(Enchantment.protection, 2);
		par3List.add(lvl2);
	}
	
	@Override
    public void func_94581_a(IconRegister par1IconRegister) {
        iconIndex = par1IconRegister.func_94245_a("CraftingCreation:" + getUnlocalizedName().replaceAll("item.CrCr_", ""));
    }

	@Override
	public int getLevel(ItemStack stack) {
		return EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, stack);
	}

	@Override
	public String getMarker(ItemStack stack) {
		return armorType == 0 ? "Helmet" : armorType == 1 ? "Chestplate" : armorType == 2 ? "Leggings" : "Boots";
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return false;
	}
	
	@Override
	public int getValue(ItemStack stack) {
		return (int) ((((getMaxDamage() / 2) * Math.pow(2, getLevel(stack))) -  stack.getItemDamage() * (Math.pow(2, getLevel(stack)))));
	}
}
