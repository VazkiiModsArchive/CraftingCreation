package vazkii.craftingcreation.core;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import vazkii.craftingcreation.helper.GameHelper;
import vazkii.craftingcreation.helper.MapGenerator;

public class CommandGameStart extends CommandBase {

	@Override
	public String getCommandName() {
		return "startgame";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(astring.length != 1)
			throw new CommandException("Invalid Syntax, try /startgame <minutes>");
		 if(GameHelper.isGameInProgress())
			 throw new CommandException("There is already a game in progress!");
		
		
		String timeStr = astring[0];
		int time = Integer.parseInt(timeStr);
		
		if(time < 1)
			throw new CommandException("The game must at least last one minute!");
		if(time > 60)
			throw new CommandException("The game can't last more than one hour!");
		
		if(!MapGenerator.mapGenerated)
			throw new CommandException("Can't start the game! Reset the map first using /generatemap <x> <y>");
		
		GameHelper.startGame(time, icommandsender.getCommandSenderName());
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 3;
	}

}
