package Block.Technical;

import Block.Blocks.Fan;
import Block.Blocks.TransBlock;
import Block.Blocks.Conveyor;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;


public class Blocks 
{
	public static Block Trans;
    public static Block Fan;
    public static Block Conveyor;

	public static void init()
	{
		registerBlocks();
		addNames();
	}

	private static void registerBlocks() 
	{
		Trans = new TransBlock(BlockInfo.TransID, false).setUnlocalizedName(BlockInfo.TransUnlocalized);
		GameRegistry.registerBlock(Trans, BlockInfo.TransKey);

        Fan = new Fan( BlockInfo.FanID, false).setUnlocalizedName(BlockInfo.FanUnlocalized);
        GameRegistry.registerBlock(Fan, BlockInfo.FanKey);

        Conveyor = new Conveyor(BlockInfo.ConveyorID, false).setUnlocalizedName(BlockInfo.ConveyorUnlocalized);
        GameRegistry.registerBlock(Conveyor, BlockInfo.ConveyorKey);
    }

	public static void addNames()
	{
		LanguageRegistry.addName(Trans, BlockInfo.TransName);
        LanguageRegistry.addName(Fan, BlockInfo.FanName);
        LanguageRegistry.addName(Conveyor, BlockInfo.ConveyorName);
	}

	
}
