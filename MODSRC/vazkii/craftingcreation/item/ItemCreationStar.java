package vazkii.craftingcreation.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import vazkii.craftingcreation.dim.TeleporterCreation;
import vazkii.craftingcreation.handler.ConfigurationHandler;

public class ItemCreationStar extends ItemCraftingCreation {
	
	public ItemCreationStar(int par1) {
		super(par1);
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if(isClear(par3EntityPlayer, par1ItemStack)) {
			if(travelToDimension(par3EntityPlayer))
				par1ItemStack.stackSize--;
		} else if(!par2World.isRemote) par3EntityPlayer.addChatMessage("Please empty your inventory of everything but this item first.");
		
		return par1ItemStack;
	}
	
    public boolean travelToDimension(EntityLiving entity) {
        if (!entity.worldObj.isRemote && !entity.isDead) {
        	entity.worldObj.theProfiler.startSection("changeDimension");
            MinecraftServer minecraftserver = MinecraftServer.getServer();
            int j = entity.dimension;
            if(j != 0)
            	return false;
            
            int dim = ConfigurationHandler.dimID;
            WorldServer worldserver = minecraftserver.worldServerForDimension(j);
            WorldServer worldserver1 = minecraftserver.worldServerForDimension(dim);
            entity.dimension = dim;
            entity.worldObj.removeEntity(entity);
            entity.isDead = false;
            entity.worldObj.theProfiler.startSection("reposition");
            minecraftserver.getConfigurationManager().transferEntityToWorld(entity, j, worldserver, worldserver1, new TeleporterCreation(worldserver1));
            entity.worldObj.theProfiler.endStartSection("reloading");
            Entity entity1 = EntityList.createEntityByName(EntityList.getEntityString(entity), worldserver1);

            if (entity1 != null) {
                entity1.copyDataFrom(entity, true);
                worldserver1.spawnEntityInWorld(entity1);
            }

            entity.isDead = true;
            entity.worldObj.theProfiler.endSection();
            worldserver.resetUpdateEntityTick();
            worldserver1.resetUpdateEntityTick();
            entity.worldObj.theProfiler.endSection();
        }
        
        return true;
    }
	
	public boolean isClear(EntityPlayer player, ItemStack exclusion) {
		InventoryPlayer inv = player.inventory;
		for(int i = 0; i < inv.getSizeInventory(); i++)
			if(!(inv.getStackInSlot(i) == null || inv.getStackInSlot(i) == exclusion))
				return false;
		
		return true;
	}
}
