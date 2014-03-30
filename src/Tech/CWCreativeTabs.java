package Tech;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CWCreativeTabs 
{

	public static CreativeTabs ClockworkTab = new CreativeTabs ("§3Clockwork") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.compass,1,0);
		}
	};
	
}
