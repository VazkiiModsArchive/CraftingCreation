package vazkii.craftingcreation.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import vazkii.craftingcreation.gui.ModCreativeTab;

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
    public void func_94332_a(IconRegister par1IconRegister){
        field_94336_cN = par1IconRegister.func_94245_a("CraftingCreation:" + getUnlocalizedName().replaceAll("tile.CrCr_", ""));
    }
}
