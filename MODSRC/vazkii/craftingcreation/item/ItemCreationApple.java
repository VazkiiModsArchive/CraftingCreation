package vazkii.craftingcreation.item;

import java.util.List;

import vazkii.craftingcreation.gui.ModCreativeTab;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCreationApple extends ItemFood implements IMark, ILevelable {

	public ItemCreationApple(int par1) {
		super(par1 - 256, 5, 0.2F, false);
		setCreativeTab(ModCreativeTab.theTab);
		setHasSubtypes(true);
		setMaxStackSize(1);
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Value: " + getValue(par1ItemStack));
	}
	
	@Override
    public void func_94581_a(IconRegister par1IconRegister) {
        iconIndex = par1IconRegister.func_94245_a("CraftingCreation:" + getUnlocalizedName().replaceAll("item.CrCr_", ""));
    }
	
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		super.getSubItems(par1, par2CreativeTabs, par3List);
		
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
	}
	
	@Override
	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
		
		int level = getLevel(par1ItemStack);
		if(level > 0)
			par3EntityPlayer.getFoodStats().addStats(level * 3, (level * 0.1F));
	}

	@Override
	public int getLevel(ItemStack stack) {
		return stack.getItemDamage();
	}

	@Override
	public String getMarker(ItemStack stack) {
		return "Apple";
	}
	
	@Override
	public int getValue(ItemStack stack) {
		return (int) (4 * Math.pow(2, getLevel(stack)));
	}

}
