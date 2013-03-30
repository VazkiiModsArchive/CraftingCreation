package vazkii.craftingcreation.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import vazkii.craftingcreation.block.TileEntityVault;
import vazkii.craftingcreation.gui.ContainerKiln;
import vazkii.craftingcreation.gui.ContainerVault;
import vazkii.craftingcreation.gui.GuiKiln;
import vazkii.craftingcreation.gui.GuiVault;
import vazkii.craftingcreation.gui.InventoryKiln;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0)
			return new ContainerKiln(player.inventory, new InventoryKiln());
		else return new ContainerVault(player.inventory, (TileEntityVault) world.getBlockTileEntity(x, y, z));
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0)
			return new GuiKiln(player.inventory, new InventoryKiln());
		else return new GuiVault(new ContainerVault(player.inventory, (TileEntityVault) world.getBlockTileEntity(x, y, z)));
	}

}
