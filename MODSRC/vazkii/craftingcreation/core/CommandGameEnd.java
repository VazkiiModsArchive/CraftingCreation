package vazkii.craftingcreation.core;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import vazkii.craftingcreation.helper.GameHelper;
import vazkii.craftingcreation.helper.MapGenerator;
import vazkii.craftingcreation.network.PacketHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;

public class CommandGameEnd extends CommandBase {

	@Override
	public String getCommandName() {
		return "endgame";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(!GameHelper.isGameInProgress())
			throw new CommandException("There is no game in progress!");
		
		GameHelper.gameTime = 2;
		
		Packet250CustomPayload blueTimePacket = PacketHandler.generateGameStartPacket(GameHelper.gameTime, false);
		Packet250CustomPayload redTimePacket = PacketHandler.generateGameStartPacket(GameHelper.gameTime, true);
		
		for(String s : GameHelper.playersInBlueTeam) {
			EntityPlayerMP player = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(s);
			if(player != null)
				PacketDispatcher.sendPacketToPlayer(blueTimePacket, (Player) player);
		}
		
		for(String s : GameHelper.playersInRedTeam) {
			EntityPlayerMP player = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(s);
			if(player != null)
				PacketDispatcher.sendPacketToPlayer(redTimePacket, (Player) player);
		}
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 3;
	}

}
