package vazkii.craftingcreation.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import vazkii.craftingcreation.gui.ModCreativeTab;

public class ItemCreationClayBow extends ItemBow implements IMark, ILevelable {

	public ItemCreationClayBow(int par1) {
		super(par1 - 256);
		setMaxDamage(24);
		setCreativeTab(ModCreativeTab.theTab);
		setFull3D();
	}
	
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		super.getSubItems(par1, par2CreativeTabs, par3List);
		
		ItemStack lvl1 = new ItemStack(par1, 1, 0);
		lvl1.addEnchantment(Enchantment.power, 1);
		par3List.add(lvl1);
		
		ItemStack lvl2 = new ItemStack(par1, 1, 0);
		lvl2.addEnchantment(Enchantment.power, 2);
		par3List.add(lvl2);
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

        if (par3EntityPlayer.inventory.hasItem(ModItems.creationClayArrow.itemID)) {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if (f < 1.0F)
                return;

            EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer, 1.5F);

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
            entityarrow.setDamage(entityarrow.getDamage() + k * 2 + 1);
            
            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            
            par3EntityPlayer.inventory.consumeInventoryItem(ModItems.creationClayArrow.itemID);

            entityarrow.canBePickedUp = 2;
             
            if (!par2World.isRemote)
                par2World.spawnEntityInWorld(entityarrow);
        }
    }
	
	@Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)  {
        if (par3EntityPlayer.inventory.hasItem(ModItems.creationClayArrow.itemID))
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));

        return par1ItemStack;
    }
	
	Icon[] textures = new Icon[4];
	
	@Override
    public void updateIcons(IconRegister par1IconRegister) {
        textures[0] = par1IconRegister.registerIcon("CraftingCreation:" + getUnlocalizedName().replaceAll("item.CrCr_", ""));
        iconIndex = textures[0];
        textures[1] = par1IconRegister.registerIcon("CraftingCreation:" + getUnlocalizedName().replaceAll("item.CrCr_", "") + "1");
        textures[2] = par1IconRegister.registerIcon("CraftingCreation:" + getUnlocalizedName().replaceAll("item.CrCr_", "") + "2");
        textures[3] = par1IconRegister.registerIcon("CraftingCreation:" + getUnlocalizedName().replaceAll("item.CrCr_", "") + "3");
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Value: " + getValue(par1ItemStack));
	}
	
    @Override
    public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        return textures[player.getItemInUseCount() == 0 ? 0 : getUseLevel(getMaxItemUseDuration(stack) - player.getItemInUseCount())];
    }
	
    public static int getUseLevel(int useDuration) {
        return useDuration >= 18 ? 3 : useDuration > 3 ? 2 : useDuration > 0 ? 1 : 0;
    }
    
	@Override
	public String getMarker(ItemStack stack) {
		return "Bow";
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return false;
	}
	
	@Override
	public int getLevel(ItemStack stack) {
		return EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);
	}

	@Override
	public int getValue(ItemStack stack) {
		return (int) (((getMaxDamage() * Math.pow(2, getLevel(stack))) - stack.getItemDamage() * (Math.pow(2, getLevel(stack)))));
	}
}
