package vazkii.craftingcreation.core;

import vazkii.craftingcreation.helper.GameHelper;
import vazkii.craftingcreation.helper.MapGenerator;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandGameStart extends CommandBase {

	@Override
	public String getCommandName() {
		return "startgame";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(astring.length != 1 || GameHelper.isGameInProgress())
			return;
		
		String timeStr = astring[0];
		int time = Integer.parseInt(timeStr);
		if(!MapGenerator.mapGenerated) {
			icommandsender.sendChatToPlayer("Can't start the game! Reset the map first using /generatemap <x> <y>");
			return;
		}
		
		GameHelper.startGame(time, icommandsender.getCommandSenderName());
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 3;
	}

}
