package Config;

import Block.Technical.BlockInfo;
import Item.Technical.ItemInfo;
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

			ItemInfo.CraftingComponentID = Config.getItem(ItemInfo.CraftingComponentKey,  ItemInfo.CraftingComponentDefault).getInt()-256;
			ItemInfo.WrenchID = Config.getItem(ItemInfo.WrenchKey, ItemInfo.WrenchDefault).getInt()-256;
			ItemInfo.ClockID = Config.getItem(ItemInfo.ClockKey, ItemInfo.ClockDefault).getInt()-256;
			
			Config.save();
		}
	
}
