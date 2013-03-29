package vazkii.craftingcreation.dim;

import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterCreation extends Teleporter {

	public TeleporterCreation(WorldServer par1WorldServer) {
		super(par1WorldServer);
	}
	
	@Override
	public boolean placeInExistingPortal(Entity par1Entity, double par2, double par4, double par6, float par8) {
        par1Entity.setLocationAndAngles(5, 10, 5, par1Entity.rotationYaw, par1Entity.rotationPitch);
        return true;
	}
}
