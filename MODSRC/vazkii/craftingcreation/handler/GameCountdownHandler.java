package vazkii.craftingcreation.handler;

import java.util.EnumSet;

import vazkii.craftingcreation.helper.GameHelper;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class GameCountdownHandler implements ITickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) { }

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {		
		if(GameHelper.isGameInProgress())
			GameHelper.gameTime--;
		
		if(GameHelper.gameTime == 1)
			GameHelper.endGame();
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT, TickType.SERVER);
	}

	@Override
	public String getLabel() {
		return "CraftingCreationCountdown";
	}

}
