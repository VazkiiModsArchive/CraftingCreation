package vazkii.craftingcreation.handler;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class ItemNoSmuggleHandler {

	@ForgeSubscribe
	public void onPlayerToss(ItemTossEvent event) {
		if(event.entityItem.dimension == ConfigurationHandler.dimID) {
			ItemStack stack = event.entityItem.getEntityItem();
			event.player.inventory.addItemStackToInventory(stack);
			event.entityItem.setDead();
		}
	}
	
	@ForgeSubscribe
	public void onPlayerInteract(PlayerInteractEvent event) {
		if(event.entityPlayer.dimension == ConfigurationHandler.dimID 
				&& !event.entityPlayer.capabilities.isCreativeMode
				&& event.entityPlayer.getCurrentEquippedItem() != null 
				&& event.entityPlayer.getCurrentEquippedItem().getItem() instanceof ItemBlock 
				&& event.action == Action.RIGHT_CLICK_BLOCK)
			event.setCanceled(true);
	}
}
