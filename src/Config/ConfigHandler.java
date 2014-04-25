package Config;

import Block.Technical.BlockInfo;
import Item.Technical.ItemInfo;
import WorldGen.Technical.OreInfo;
import net.minecraftforge.common.Configuration;

import java.io.File;

public class ConfigHandler 
{
		public static void init (File file)
		{
			Configuration Config = new Configuration (file);
			Config.load();
			
			BlockInfo.FanID = Config.getBlock(BlockInfo.FanKey, BlockInfo.FanDefault).getInt();
			BlockInfo.TransID = Config.getBlock(BlockInfo.TransKey, BlockInfo.TransDefault).getInt();
            BlockInfo.ConveyorID = Config.getBlock(BlockInfo.ConveyorKey, BlockInfo.ConveyorDefault).getInt();
            BlockInfo.ConveyorID1 = Config.getBlock(BlockInfo.ConveyorKey1, BlockInfo.ConveyorDefault1).getInt();
            BlockInfo.RouterID = Config.getBlock(BlockInfo.RouterKey, BlockInfo.RouterDefault).getInt();

            OreInfo.OreCopperID = Config.getBlock(OreInfo.OreCopperKey, OreInfo.OreCopperDefault).getInt();
            OreInfo.OreTinID = Config.getBlock(OreInfo.OreTinKey, OreInfo.OreTinDefault).getInt();
            OreInfo.OreZincID = Config.getBlock(OreInfo.OreZincKey, OreInfo.OreZincDefault).getInt();

			ItemInfo.CraftingComponentID = Config.getItem(ItemInfo.CraftingComponentKey,  ItemInfo.CraftingComponentDefault).getInt()-256;
			ItemInfo.WrenchID = Config.getItem(ItemInfo.WrenchKey, ItemInfo.WrenchDefault).getInt()-256;
            ItemInfo.RodOfAgesID = Config.getItem(ItemInfo.RodOfAgesKey, ItemInfo.RodOfAgesDefault).getInt()-256;
			ItemInfo.ClockID = Config.getItem(ItemInfo.ClockKey, ItemInfo.ClockDefault).getInt()-256;
            ItemInfo.DustID = Config.getItem(ItemInfo.DustKey, ItemInfo.DustDefault).getInt()-256;
            ItemInfo.IngotID = Config.getItem(ItemInfo.IngotKey, ItemInfo.IngotDefault).getInt()-256;
			
			Config.save();
		}
	
}
