package vazkii.craftingcreation.handler;

import vazkii.craftingcreation.gui.ContainerKiln;
import vazkii.craftingcreation.gui.GuiKiln;
import vazkii.craftingcreation.gui.InventoryKiln;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0)
			return new ContainerKiln(player.inventory, new InventoryKiln());
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0)
			return new GuiKiln(player.inventory, new InventoryKiln());
		
		return null;
	}

}
