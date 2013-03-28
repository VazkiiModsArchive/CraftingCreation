package vazkii.craftingcreation.block;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockBeacon extends BlockCraftingCreation {

	public BlockBeacon(int id) {
		super(id, Material.rock);
		setBlockUnbreakable();
	}
	
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		super.getSubBlocks(par1, par2CreativeTabs, par3List);
        par3List.add(new ItemStack(par1, 1, 1));
	}
	
	@Override
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return par2 == 0 ? BlockPortal.redIcon : BlockPortal.blueIcon;
	}

}
