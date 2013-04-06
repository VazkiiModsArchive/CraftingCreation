package vazkii.craftingcreation.block;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import vazkii.craftingcreation.gui.ModCreativeTab;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockBeacon extends BlockContainer {

	public BlockBeacon(int id) {
		super(id, Material.rock);
		setCreativeTab(ModCreativeTab.theTab);
		GameRegistry.registerBlock(this);
		setLightValue(1F);
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
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister){
        blockIcon = par1IconRegister.registerIcon("CraftingCreation:" + getUnlocalizedName().replaceAll("tile.CrCr_", ""));
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityBaseBeacon();
	}

}
