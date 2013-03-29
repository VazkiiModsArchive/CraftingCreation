package vazkii.craftingcreation.item;

import static vazkii.craftingcreation.handler.ConfigurationHandler.*;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.item.Item;

public final class ModItems {
	
	public static Item creationClay,
						creationClaySword,
						creationClayPick,
						creationClayAxe,
						creationClayShovel,
						creationClayHelmet,
						creationClayChestplate,
						creationClayLeggings,
						creationClayBoots,
						creationClayApple,
						creationClayBow,
						creationClayArrow,
						creationStar;
	
	public static void initItems() {
		creationClay = new ItemCreationClay(itemIDCreationClay).setUnlocalizedName("CrCr_creationClayItem");
		creationClaySword = new ItemCreationSword(itemIDCreationClaySword).setUnlocalizedName("CrCr_creationClaySword");
		creationClayPick = new ItemCreationTool(itemIDCreationClayPick, 1).setUnlocalizedName("CrCr_creationClayPick");
		creationClayShovel = new ItemCreationTool(itemIDCreationClayShovel, 0).setUnlocalizedName("CrCr_creationClayShovel");
		creationClayAxe = new ItemCreationTool(itemIDCreationClayAxe, 2).setUnlocalizedName("CrCr_creationClayAxe");
		creationClayHelmet = new ItemCreationArmor(itemIDCreationClayHelmet, 0).setUnlocalizedName("CrCr_creationClayHelmet");
		creationClayChestplate = new ItemCreationArmor(itemIDCreationClayChestplate, 1).setUnlocalizedName("CrCr_creationClayChestplate");
		creationClayLeggings = new ItemCreationArmor(itemIDCreationClayLeggings, 2).setUnlocalizedName("CrCr_creationClayLeggings");
		creationClayBoots = new ItemCreationArmor(itemIDCreationClayBoots, 0).setUnlocalizedName("CrCr_creationClayBoots");
		creationClayApple = new ItemCreationApple(itemIDCreationClayApple).setUnlocalizedName("CrCr_creationClayApple");
		creationClayBow = new ItemCreationClayBow(itemIDCreationClayBow).setUnlocalizedName("CrCr_creationClayBow");
		creationClayArrow = new ItemCreationArrow(itemIDCreationClayArrow).setUnlocalizedName("CrCr_creationClayArrow");

		creationStar = new ItemCreationStar(itemIDCreationStar).setUnlocalizedName("CrCr_creationStar");
	}
	
	public static void nameItems() {
		LanguageRegistry.addName(creationClay, "Creation Clay");
		LanguageRegistry.addName(creationClayPick, "Creation Clay Pickaxe");
		LanguageRegistry.addName(creationClaySword, "Creation Clay Sword");
		LanguageRegistry.addName(creationClayShovel, "Creation Clay Shovel");
		LanguageRegistry.addName(creationClayAxe, "Creation Clay Axe");
		LanguageRegistry.addName(creationClayHelmet, "Creation Clay Helmet");
		LanguageRegistry.addName(creationClayChestplate, "Creation Clay Chestplate");
		LanguageRegistry.addName(creationClayLeggings, "Creation Clay Leggings");
		LanguageRegistry.addName(creationClayBoots, "Creation Clay Boots");
		LanguageRegistry.addName(creationClayApple, "Creation Clay Apple");
		LanguageRegistry.addName(creationClayBow, "Creation Clay Bow");
		LanguageRegistry.addName(creationClayArrow, "Creation Clay Arrow");
		
		LanguageRegistry.addName(creationStar, "Star of Creation");
	}
}
