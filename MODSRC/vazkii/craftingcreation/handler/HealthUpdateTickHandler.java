package vazkii.craftingcreation.handler;

import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;

import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.WorldServer;
import vazkii.craftingcreation.helper.GameHelper;
import vazkii.craftingcreation.network.PacketHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;

public class HealthUpdateTickHandler implements ITickHandler {

	private static int ticksElapsed = 0;
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) { }

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		++ticksElapsed;

		if(!GameHelper.isGameInProgress() || ticksElapsed % 3 != 0)
			return;
		
		WorldServer world = MinecraftServer.getServer().worldServerForDimension(ConfigurationHandler.dimID); 
		ServerConfigurationManager configManager = MinecraftServer.getServer().getConfigurationManager();
		EntityTracker tracker = world.getEntityTracker();
		
		Set<String> players = new LinkedHashSet(GameHelper.playersInBlueTeam);
		players.addAll(GameHelper.playersInRedTeam);
		
		for(String s : players) {
			EntityPlayerMP player = configManager.getPlayerForUsername(s);
			if(player != null)
				PacketDispatcher.sendPacketToAllInDimension(PacketHandler.generateHealthPacket(player), ConfigurationHandler.dimID);
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.SERVER);
	}

	@Override
	public String getLabel() {
		return "CraftingCreationHealthPacket";
	}

}
