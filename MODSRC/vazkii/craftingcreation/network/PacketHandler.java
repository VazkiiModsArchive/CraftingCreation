package vazkii.craftingcreation.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import vazkii.craftingcreation.CraftingCreation;
import vazkii.craftingcreation.gui.ContainerKiln;
import vazkii.craftingcreation.helper.GameHelper;
import vazkii.craftingcreation.lib.ModConstants;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		try {
			DataInputStream stream = new DataInputStream(new ByteArrayInputStream(packet.data));
			boolean gameStartPacket = stream.readBoolean();
			boolean scorePacket = stream.readBoolean();
			boolean healthPacket = stream.readBoolean();
			boolean redTeam = stream.readBoolean();
			
			if(gameStartPacket) {
				int time = stream.readInt();
				CraftingCreation.proxy.recieveTimePacket(time, redTeam);
			} else if(scorePacket) {
				int score = stream.readInt();
				CraftingCreation.proxy.recieveScorePacket(score, redTeam);
			} else if(healthPacket) {
				int id = stream.readInt();
				int hp = stream.readInt();
				CraftingCreation.proxy.recieveHealthPacket(id, hp, redTeam);
			} else if(player instanceof EntityPlayer) {
				EntityPlayer ePlayer = (EntityPlayer)player;
				if(ePlayer.openContainer instanceof ContainerKiln) {
					int item = stream.readInt();
					int level = stream.readInt();
					((ContainerKiln)ePlayer.openContainer).updateInventory(item, level);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Packet250CustomPayload generateGameStartPacket(int time, boolean redTeam) {
		try {
			Packet250CustomPayload packet = new Packet250CustomPayload();
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			DataOutputStream data = new DataOutputStream(byteStream);
			
			data.writeBoolean(true);
			data.writeBoolean(false);
			data.writeBoolean(false);
			data.writeBoolean(redTeam);

			data.writeInt(time);
			
			packet.channel = ModConstants.NETWORK_CHANNEL;
			packet.data = byteStream.toByteArray();
			packet.length = packet.data.length;
			
			return packet;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Packet250CustomPayload generateScorePacket(boolean redTeam, int score) {
		try {
			Packet250CustomPayload packet = new Packet250CustomPayload();
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			DataOutputStream data = new DataOutputStream(byteStream);
			
			data.writeBoolean(false);
			data.writeBoolean(true);
			data.writeBoolean(false);
			data.writeBoolean(redTeam);

			data.writeInt(score);
			
			packet.channel = ModConstants.NETWORK_CHANNEL;
			packet.data = byteStream.toByteArray();
			packet.length = packet.data.length;
			
			return packet;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Packet250CustomPayload generateKilnPacket(int item, int level) {
		try {
			Packet250CustomPayload packet = new Packet250CustomPayload();
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			DataOutputStream data = new DataOutputStream(byteStream);
			
			data.writeBoolean(false);
			data.writeBoolean(false);
			data.writeBoolean(false);
			data.writeBoolean(false);

			data.writeInt(item);
			data.writeInt(level);
			
			packet.channel = ModConstants.NETWORK_CHANNEL;
			packet.data = byteStream.toByteArray();
			packet.length = packet.data.length;
			
			return packet;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Packet250CustomPayload generateHealthPacket(EntityPlayer player) {
		try {
			Packet250CustomPayload packet = new Packet250CustomPayload();
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			DataOutputStream data = new DataOutputStream(byteStream);
			
			data.writeBoolean(false);
			data.writeBoolean(false);
			data.writeBoolean(true);
			data.writeBoolean(GameHelper.isPlayerInTeam(true, player.username));

			data.writeInt(player.entityId);
			data.writeInt(player.getHealth());
			
			packet.channel = ModConstants.NETWORK_CHANNEL;
			packet.data = byteStream.toByteArray();
			packet.length = packet.data.length;
			
			return packet;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
