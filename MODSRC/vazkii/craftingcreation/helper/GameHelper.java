package vazkii.craftingcreation.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.server.MinecraftServer;
import vazkii.craftingcreation.handler.ConfigurationHandler;
import vazkii.craftingcreation.item.IMark;
import vazkii.craftingcreation.item.ModItems;
import vazkii.craftingcreation.network.PacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class GameHelper {
	
	public static final int MAP_SIZE = 23 * 7;
	public static final int MAP_HEIGHT = 16;
	
	static Set<String> playersInBlueTeam = new TreeSet();
	static Set<String> playersInRedTeam = new TreeSet();
	
	@SideOnly(Side.CLIENT)
	public static boolean isInRedTeam;
	
	public static int gameTime;
	
	public static int redTeamScore;
	public static int blueTeamScore;
	
	public static boolean isGameInProgress() {
		return gameTime > 0;
	}
	
	public static void addPlayerToTeam(boolean redTeam, String username) {
		if(redTeam)
			playersInRedTeam.add(username);
		else playersInBlueTeam.add(username);
		
		Packet3Chat packet = new Packet3Chat("You have been asigned the  " + (redTeam ? "Red" : "Blue") + " team. Have fun!");
		EntityPlayerMP player = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(username);
		if(player != null)
			PacketDispatcher.sendPacketToPlayer(packet, (Player) player);
	}
	
	public static boolean isPlayerInTeam(boolean redTeam, String username) {
		if(redTeam)
			return playersInRedTeam.contains(username);
		else return playersInBlueTeam.contains(username);
	}
	
	public static void clearTeams() {
		playersInRedTeam.clear();
		playersInBlueTeam.clear();
		
		redTeamScore = 0;
		blueTeamScore = 0;
	}
	
	public static void asignTeamForPlayer(String player) {
		int redSize = playersInRedTeam.size();
		int blueSize = playersInBlueTeam.size();
		
		boolean red = redSize <= blueSize;
		addPlayerToTeam(red, player);
	}
	
	public static void modifyScore(boolean redTeam, int modifier) {
		if(redTeam)
			redTeamScore += modifier;
		else blueTeamScore += modifier;
		
		Packet250CustomPayload packet = PacketHandler.generateScorePacket(redTeam, redTeam ? redTeamScore : blueTeamScore);
		for(String s : (redTeam ? playersInRedTeam : playersInBlueTeam)) {
			EntityPlayerMP player = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(s);
			
			if(player != null)
				PacketDispatcher.sendPacketToPlayer(packet, (Player) player);
		}
	}
	
	public static void startGame(int gameTime, String starter) {
		GameHelper.gameTime = (gameTime * 1200);
		Packet3Chat packet = new Packet3Chat("A " +  getGameTimeString() + " game was started by " + starter + ".");
		Packet250CustomPayload blueTimePacket = PacketHandler.generateGameStartPacket(GameHelper.gameTime, false);
		Packet250CustomPayload redTimePacket = PacketHandler.generateGameStartPacket(GameHelper.gameTime, true);

		for(String s : playersInBlueTeam) {
			EntityPlayerMP player = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(s);
			if(player != null)
				PacketDispatcher.sendPacketToPlayer(blueTimePacket, (Player) player);
		}
		
		for(String s : playersInRedTeam) {
			EntityPlayerMP player = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(s);
			if(player != null)
				PacketDispatcher.sendPacketToPlayer(redTimePacket, (Player) player);
		}
		
		PacketDispatcher.sendPacketToAllInDimension(packet, ConfigurationHandler.dimID);
	}
	
	public static void endGame() {
		int winner = 0;
		if(redTeamScore > blueTeamScore)
			winner = 1;
		else if(redTeamScore < blueTeamScore)
			winner = 2;
		
		String winnerStr = winner == 0 ? "Draw" : winner == 1 ? "Win for the Red Team" : "Win for the Blue Team";
		Packet3Chat packet = new Packet3Chat("The game is over. The result was a " + winnerStr + "!");
		Packet3Chat packet1 = new Packet3Chat("- Red Team: " + redTeamScore);
		Packet3Chat packet2 = new Packet3Chat("- Blue Team: " + blueTeamScore);
		Packet3Chat packet3 = new Packet3Chat("Hope you enjoyed the game!");
	
		PacketDispatcher.sendPacketToAllInDimension(packet, ConfigurationHandler.dimID);
		PacketDispatcher.sendPacketToAllInDimension(packet1, ConfigurationHandler.dimID);
		PacketDispatcher.sendPacketToAllInDimension(packet2, ConfigurationHandler.dimID);
		PacketDispatcher.sendPacketToAllInDimension(packet3, ConfigurationHandler.dimID);
		
		MapGenerator.mapGenerated = false;
	}
	
	public static String getGameTimeString() {
		Date date = new Date(gameTime * 50);
		DateFormat format = new SimpleDateFormat("mm:ss");
		return format.format(date);
	}
	
	public static int getTotalValueHeld(EntityPlayer player) {
		InventoryPlayer inv = player.inventory;
		
		int foundValue = 0;
	
		for(int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if(stack != null && stack.getItem() instanceof IMark)
				foundValue += ((IMark)stack.getItem()).getValue(stack);
		}
		
		return foundValue;
	}
	
	public static int getClay(EntityPlayer player, int level) {
		InventoryPlayer inv = player.inventory;
		
		int foundClay = 0;
		
		for(int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if(stack != null && stack.itemID == ModItems.creationClay.itemID && stack.getItemDamage() == level)
				++foundClay;
		}
		
		return foundClay;
	}
}
