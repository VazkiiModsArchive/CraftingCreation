package vazkii.craftingcreation.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import vazkii.craftingcreation.helper.GameHelper;
import vazkii.craftingcreation.item.IMark;

public class TileEntityVault extends TileEntity implements IInventory {

    private ItemStack[] inventory = new ItemStack[36];
    
    @Override
    public int getSizeInventory() {
        return inventory.length;
    }
    
    @Override
    public ItemStack getStackInSlot(int par1) {
        return inventory[par1];
    }

    @Override
    public ItemStack decrStackSize(int par1, int par2) {
        if (inventory[par1] != null) {
            ItemStack itemstack;

            if (inventory[par1].stackSize <= par2) {
                itemstack = inventory[par1];
                setInventorySlotContents(par1, null);
                onInventoryChanged();
                return itemstack;
            } else {
                itemstack = inventory[par1];

                if (inventory[par1].stackSize == 0)
                    setInventorySlotContents(par1, null);

                onInventoryChanged();
                return itemstack;
            }
        }
        else return null;
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(int par1) {
        if (inventory[par1] != null) {
            ItemStack itemstack = inventory[par1];
            inventory[par1] = null;
            return itemstack;
        } else  return null;
    }
    
    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
    	if(!worldObj.isRemote) {
        	ItemStack currentStack = getStackInSlot(par1);
        	int currentValue = currentStack == null ? 0 : ((IMark) currentStack.getItem()).getValue(currentStack);
        	int newValue = par2ItemStack == null ? 0 : ((IMark) par2ItemStack.getItem()).getValue(par2ItemStack);

        	GameHelper.modifyScore(isRedTeam(), newValue - currentValue);
    	}
    	
        inventory[par1] = par2ItemStack;
        
        if (par2ItemStack != null && par2ItemStack.stackSize > getInventoryStackLimit())
            par2ItemStack.stackSize = getInventoryStackLimit();

        onInventoryChanged();
    }

	@Override
	public String getInvName() {
		return "Sacred Vault";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        inventory = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < inventory.length)
                inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < inventory.length; ++i)
            if (inventory[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                inventory[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }

        par1NBTTagCompound.setTag("Items", nbttaglist);
    }
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this ? false : entityplayer.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openChest() { }

	@Override
	public void closeChest() { }

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
	
	public boolean isRedTeam() {
		return getBlockMetadata() == 0;
	}

}
