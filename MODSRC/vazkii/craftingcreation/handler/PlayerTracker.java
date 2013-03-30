package vazkii.craftingcreation.handler;

import vazkii.craftingcreation.helper.GameHelper;
import vazkii.craftingcreation.helper.MapGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.IPlayerTracker;

public class PlayerTracker implements IPlayerTracker {

	@Override
	public void onPlayerLogin(EntityPlayer player) {
		if(!player.worldObj.isRemote && player.dimension == ConfigurationHandler.dimID)
			GameHelper.asignTeamForPlayer(player.username);
	}

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
