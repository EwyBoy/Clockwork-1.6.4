package Block.Technical;

import Block.TransBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;


public class Blocks 
{
	//public static Block Clockwork;
	public static Block Trans;

	
	public static void init()
	{
		registerBlocks();
		addNames();
	}


	private static void registerBlocks() 
	{
		//Clockwork = new ClockworkBlock (BlockInfo.ClockworkID, false).setUnlocalizedName(BlockInfo.ClockworkUnlocalized);
		//GameRegistry.registerBlock(Clockwork, BlockInfo.ClockworkKey);
		
		Trans = new TransBlock(BlockInfo.TransID, false).setUnlocalizedName(BlockInfo.TransUnlocalized); 
		GameRegistry.registerBlock(Trans, BlockInfo.TransKey);
	}
	
	public static void addNames()
	{
	//LanguageRegistry.addName(Clockwork, BlockInfo.ClockworkName);
		LanguageRegistry.addName(Trans, BlockInfo.TransName);
	}

	
}
