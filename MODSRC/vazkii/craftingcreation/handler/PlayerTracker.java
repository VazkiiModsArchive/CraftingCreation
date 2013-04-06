package vazkii.craftingcreation.handler;

import net.minecraft.entity.player.EntityPlayer;
import vazkii.craftingcreation.helper.GameHelper;
import cpw.mods.fml.common.IPlayerTracker;

public class PlayerTracker implements IPlayerTracker {

	@Override
	public void onPlayerLogin(EntityPlayer player) { }

	@Override
	public void onPlayerLogout(EntityPlayer player) {
		if(!player.worldObj.isRemote && player.dimension == ConfigurationHandler.dimID)
			GameHelper.removePlayerFromTeams(player.username);
	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) { }

	@Override
	public void onPlayerRespawn(EntityPlayer player) { }
}
