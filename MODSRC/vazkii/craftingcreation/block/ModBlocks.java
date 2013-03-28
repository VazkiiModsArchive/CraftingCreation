package vazkii.craftingcreation.block;

import static vazkii.craftingcreation.handler.ConfigurationHandler.*;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public final class ModBlocks {

	public static Block creationClay,
						creationClayBreakable,
						creationBricks,
						portal,
						kiln,
						beacon,
						invisibleWall,
						smokeyBlock;
	
	public void initBlocks() {
		creationClay = new BlockCraftingCreation(blockIDCreationClay, Material.rock).setBlockUnbreakable().setUnlocalizedName("CrCr_creationClayDark");
		creationClayBreakable = new BlockCreationClay(blockIDCreationClayBreakable).setHardness(1F).setUnlocalizedName("CrCr_creationClay");
		creationBricks = new BlockCraftingCreation(blockIDCreationBricks, Material.rock).setUnlocalizedName("CrCr_creationBricks");
		portal = new BlockPortal(blockIDPortal).setUnlocalizedName("CrCr_portal");
		kiln = new BlockKiln(blockIDKiln).setUnlocalizedName("CrCr_kiln");
		beacon = new BlockBeacon(blockIDBeacon).setUnlocalizedName("CrCr_beacon");
		invisibleWall = new BlockInvisibleWall(blockIDInvisibleWall).setUnlocalizedName("CrCr_invisibleWall");
		smokeyBlock = new BlockSmokeyBlock(blockIDSmokeyBlock).setUnlocalizedName("CrCr_smokeyBlock"); 
	}
	
	public void nameBlocks() {
		LanguageRegistry.addName(creationClay, "Creation Clay");
		LanguageRegistry.addName(creationClayBreakable, "Creation Clay Breakable");
		LanguageRegistry.addName(creationBricks, "Creation Clay Bricks");
		LanguageRegistry.addName(portal, "CC Portal");
		LanguageRegistry.addName(kiln, "Creation Kiln");
		LanguageRegistry.addName(beacon, "CC Beacon");
		LanguageRegistry.addName(invisibleWall, "CC Invisible Wall");
		LanguageRegistry.addName(smokeyBlock, "Smokey Block");
	}
}
