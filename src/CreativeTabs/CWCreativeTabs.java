package CreativeTabs;

import Block.Technical.Blocks;
import Item.Technical.Items;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CWCreativeTabs 
{

    public static void init()
    {
        AddCreativeTabs();
    }

    public static void AddCreativeTabs()
    {
        LanguageRegistry.instance().addStringLocalization("itemGroup.ClockworkItemTab", "en_US", "Items");
        LanguageRegistry.instance().addStringLocalization("itemGroup.ClockworkBlockTab", "en_US", "Blocks");
    }

    public static CreativeTabs ClockworkBlockTab = new CreativeTabs ("Clockwork Blocks") {
        public ItemStack getIconItemStack() {
            return new ItemStack(Blocks.Fan,1,0);
        }
    };

    public static CreativeTabs ClockworkItemTab = new CreativeTabs ("Clockwork Items") {
        public ItemStack getIconItemStack() {
            return new ItemStack(Items.Wrench,1,0);
        }
    };



}
