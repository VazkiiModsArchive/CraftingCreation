package vazkii.craftingcreation.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import vazkii.craftingcreation.helper.GameHelper;

public class FriendlyFireHandler {
	
	@ForgeSubscribe
	public void onPlayerDamage(LivingHurtEvent event) {
		if(event.entity.dimension == ConfigurationHandler.dimID 
				&& event.entity instanceof EntityPlayer 
				&& event.source.getEntity() instanceof EntityPlayer 
				&& GameHelper.isGameInProgress()
				&& GameHelper.isPlayerInTeam(true, ((EntityPlayer)event.entity).username)
					== GameHelper.isPlayerInTeam(true, ((EntityPlayer)event.source.getEntity()).username)) {
			event.setCanceled(true);
			if(!event.entity.worldObj.isRemote) {
				((EntityPlayer)event.source.getEntity()).addChatMessage("Don't attack your teammates!");
			}
		}
	}

}
