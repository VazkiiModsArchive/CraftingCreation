package vazkii.craftingcreation.block;

import net.minecraft.block.material.Material;

public class BlockCreationChest extends BlockCraftingCreation {

	public BlockCreationChest(int id) {
		super(id, Material.rock);
		setBlockUnbreakable();
	}

}
