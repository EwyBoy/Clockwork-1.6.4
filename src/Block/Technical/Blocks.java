package Block.Technical;

import Block.Blocks.Fan;
import Block.Blocks.TransBlock;
import Block.Blocks.Conveyor;
import Block.Blocks.ConveyorTest;
import Block.Blocks.Router;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;

public class Blocks 
{
	public static Block Trans;
    public static Block Fan;
    public static Block Conveyor;
    public static Block ConveyorTest;
    public static Block Router;

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

        ConveyorTest = new ConveyorTest(BlockInfo.ConveyorID1, false).setUnlocalizedName(BlockInfo.ConveyorUnlocalized1);
        GameRegistry.registerBlock(ConveyorTest, BlockInfo.ConveyorKey1);

        Router = new Router(BlockInfo.RouterID, false).setUnlocalizedName(BlockInfo.RouterUnlocalized);
        GameRegistry.registerBlock(Router, BlockInfo.RouterKey);
    }

	public static void addNames()
	{
		LanguageRegistry.addName(Trans, BlockInfo.TransName);
        LanguageRegistry.addName(Fan, BlockInfo.FanName);
        LanguageRegistry.addName(Conveyor, BlockInfo.ConveyorName);
        LanguageRegistry.addName(Router, BlockInfo.RouterName);
	}

	
}
