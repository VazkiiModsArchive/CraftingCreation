package vazkii.craftingcreation.handler;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.item.ItemTossEvent;

public class ItemNoSmuggleHandler {

	@ForgeSubscribe
	public void onPlayerToss(ItemTossEvent event) {
		if(event.entityItem.dimension == ConfigurationHandler.dimID) {
			event.entityItem.setDead();
			event.player.renderBrokenItemStack(event.entityItem.getEntityItem());
		}
	}
}
