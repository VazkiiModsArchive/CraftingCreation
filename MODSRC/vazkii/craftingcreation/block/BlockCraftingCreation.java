package vazkii.craftingcreation.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import vazkii.craftingcreation.gui.ModCreativeTab;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockCraftingCreation extends Block {
	
	public BlockCraftingCreation(int id, Material mat) {
		super(id, mat);
		if(!skipCreativeRegister())
			setCreativeTab(ModCreativeTab.theTab);
		
		GameRegistry.registerBlock(this);
	}
	
	public boolean skipCreativeRegister() {
		return false;
	}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister){
        blockIcon = par1IconRegister.registerIcon("CraftingCreation:" + getUnlocalizedName().replaceAll("tile.CrCr_", ""));
    }
}
