package vazkii.craftingcreation.core;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import vazkii.craftingcreation.helper.GameHelper;

public class CommandListTeams extends CommandBase {

	@Override
	public String getCommandName() {
		return "listteams";
	}

	@Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
	
	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		icommandsender.sendChatToPlayer(GameHelper.generatePlayerList(GameHelper.playersInRedTeam, "Players in the Red Team [" + GameHelper.playersInRedTeam.size() + "]: "));
		icommandsender.sendChatToPlayer(GameHelper.generatePlayerList(GameHelper.playersInBlueTeam, "Players in the Blue Team [" + GameHelper.playersInBlueTeam.size() + "]: "));
	}
}
