package vazkii.craftingcreation.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import vazkii.craftingcreation.gui.ContainerKiln;
import vazkii.craftingcreation.lib.ModConstants;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		try {
			DataInputStream stream = new DataInputStream(new ByteArrayInputStream(packet.data));
			boolean timePacket = stream.readBoolean();
			
			if(timePacket) {
				// TODO time packet
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
	
	public static Packet250CustomPayload generateKilnPacket(int item, int level) {
		try {
			Packet250CustomPayload packet = new Packet250CustomPayload();
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			DataOutputStream data = new DataOutputStream(byteStream);
			
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
}
