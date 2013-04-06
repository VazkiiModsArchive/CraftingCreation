package vazkii.craftingcreation.core;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.craftingcreation.block.ModBlocks;
import vazkii.craftingcreation.handler.ConfigurationHandler;
import vazkii.craftingcreation.helper.MapGenerator;

public class CommandGenerate extends CommandBase {

	@Override
	public String getCommandName() {
		return "generatemap";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(icommandsender instanceof EntityPlayer) {
			int dim = ((EntityPlayer)icommandsender).dimension;
			if(dim != ConfigurationHandler.dimID)
				throw new CommandException("You must be in the Plane of Creation to generate a Map!");
			
			if(astring.length != 2)
				throw new CommandException("Invalid Syntax, try /generatemap <x> <z>");
			
			int x = Integer.parseInt(astring[0]);
			int z = Integer.parseInt(astring[1]);
			
			if(((EntityPlayer)icommandsender).worldObj.getBlockId(x + 1, 10, z + 1) == ModBlocks.invisibleWall.blockID)
				throw new CommandException("There is already a Game Map there!");
			
			MapGenerator.generateMap(((EntityPlayer)icommandsender).worldObj, x, z);
		} else throw new CommandException("Only Players can Generate a Map!");
	}

}
