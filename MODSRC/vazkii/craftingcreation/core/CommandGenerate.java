package vazkii.craftingcreation.core;

import vazkii.craftingcreation.handler.ConfigurationHandler;
import vazkii.craftingcreation.helper.MapGenerator;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommandGenerate extends CommandBase {

	@Override
	public String getCommandName() {
		return "generate";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(icommandsender instanceof EntityPlayer) {
			int dim = ((EntityPlayer)icommandsender).dimension;
			if(dim != ConfigurationHandler.dimID)
				return;
			
			if(astring.length != 2)
				return;
			
			int x = Integer.parseInt(astring[0]);
			int z = Integer.parseInt(astring[1]);
			
			MapGenerator.generateMap(((EntityPlayer)icommandsender).worldObj, x, z);
		}
	}

}
