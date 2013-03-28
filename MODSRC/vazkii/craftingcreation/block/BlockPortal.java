package vazkii.craftingcreation.block;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockPortal extends BlockCraftingCreation {

	public static Icon redIcon;
	public static Icon blueIcon;
	
	public BlockPortal(int id) {
		super(id, Material.glass);
		setBlockUnbreakable();
	}
	
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		super.getSubBlocks(par1, par2CreativeTabs, par3List);
        par3List.add(new ItemStack(par1, 1, 1));
	}
	
	@Override
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return par2 == 0 ? redIcon : blueIcon;
	}
	
	@Override
    public void func_94332_a(IconRegister par1IconRegister){
        redIcon = par1IconRegister.func_94245_a("CraftingCreation:" + "portalRed");
        blueIcon = par1IconRegister.func_94245_a("CraftingCreation:" + "portalBlue");
    }	
	
	@Override
    public int getRenderBlockPass() {
        return 1;
    }
	
	@Override
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }
}
