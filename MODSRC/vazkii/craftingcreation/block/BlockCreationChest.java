package vazkii.craftingcreation.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import vazkii.craftingcreation.CraftingCreation;
import vazkii.craftingcreation.gui.ModCreativeTab;
import vazkii.craftingcreation.helper.GameHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockCreationChest extends BlockContainer {

	public BlockCreationChest(int id) {
		super(id, Material.rock);
		setBlockUnbreakable();
		setCreativeTab(ModCreativeTab.theTab);
		GameRegistry.registerBlock(this);
	}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister){
        blockIcon = par1IconRegister.registerIcon("CraftingCreation:" + getUnlocalizedName().replaceAll("tile.CrCr_", ""));
    }
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if(GameHelper.isGameInProgress()) {
			if(!par1World.isRemote)
				par5EntityPlayer.openGui(CraftingCreation.instance, 1, par1World, par2, par3, par4);
		} else if(par1World.isRemote)
			par5EntityPlayer.addChatMessage("The Vault can not be accessed while there isn't a game in progress for security measures.");
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityVault();
	}

}
