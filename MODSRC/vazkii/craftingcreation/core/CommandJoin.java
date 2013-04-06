package vazkii.craftingcreation.core;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet3Chat;
import vazkii.craftingcreation.handler.ConfigurationHandler;
import vazkii.craftingcreation.helper.GameHelper;
import cpw.mods.fml.common.network.PacketDispatcher;

public class CommandJoin extends CommandBase {

	private final Boolean red;
	
	public CommandJoin(Boolean red) {
		this.red = red;
	}
	
	@Override
	public String getCommandName() {
		return "join" + (red == null ? "team" : red ? "red" : "blue");
	}
	
	@Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if((icommandsender instanceof EntityPlayer)) {
			if(GameHelper.isGameInProgress())
				throw new CommandException("You can't change your team during a game!");
			
			EntityPlayer player = (EntityPlayer)icommandsender;
			int dim = player.dimension;
			if(dim != ConfigurationHandler.dimID)
				throw new CommandException("You must be in the Plane of Creation to join a team!");
			
			if(red == null) {
				if(GameHelper.isPlayerInGame(player.username))
					throw new CommandException("You are already in a team!");
				
				GameHelper.asignTeamForPlayer(player.username);
				
				return;
			}
			
			boolean swap = GameHelper.isPlayerInTeam(!red, player.username);
			
			if(!swap && GameHelper.isPlayerInTeam(red, player.username))
				throw new CommandException("You are already in that team!");
			
			if(swap) {
				Packet3Chat packet = new Packet3Chat(player.username + " left the " + (!red ? "Red" : "Blue") + " team.");
				PacketDispatcher.sendPacketToAllPlayers(packet);
			}
			
			GameHelper.addPlayerToTeam(red, player.username);
			
			Packet3Chat packet = new Packet3Chat("Red Team: " + GameHelper.playersInRedTeam.size() + " players. Blue Team: " + GameHelper.playersInBlueTeam.size() + " players.");
			PacketDispatcher.sendPacketToAllPlayers(packet);
			
		}else throw new CommandException("Only Players can Join Teams!");
	}

}
