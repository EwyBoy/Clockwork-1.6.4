package Item.Technical;

import Item.Items.RodOfAges;
import Item.Items.Wrench;
import Item.Items.CraftingComponent;
import Item.Items.Dust;
import Item.Items.Ingot;
import Item.Items.Clock;
import KeyBindings.WrenchKeyBind;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import KeyBindings.Keyboard;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import net.minecraft.item.ItemStack;

public class Items
{
    public static Item Clock;
    public static Item Wrench;
    public static Item CraftingComponent;
    public static Item Dust;
    public static Item Ingot;
    public static Item RodOfAges;

    public static void init()
    {
        RegisterItems();
        addNames();

        KeyBinding[] key = {new KeyBinding("CW Wrench", Keyboard.KEY_G)};
        boolean[] repeat = {false};
        KeyBindingRegistry.registerKeyBinding(new WrenchKeyBind(key, repeat));

    }

    public static void RegisterItems()
    {
        Clock = new Clock(ItemInfo.ClockID);
        Wrench = new Wrench (ItemInfo.WrenchID);
        RodOfAges = new RodOfAges(ItemInfo.RodOfAgesID);
        CraftingComponent =  new CraftingComponent (ItemInfo.CraftingComponentID);
        Dust = new Dust (ItemInfo.DustID);
        Ingot = new Ingot (ItemInfo.IngotID);
    }

    public static void addNames()
    {
        LanguageRegistry.addName(Clock, ItemInfo.ClockName);
        LanguageRegistry.addName(Wrench, ItemInfo.WrenchName);
        LanguageRegistry.addName(RodOfAges, ItemInfo.RodOfAgesName);

        for (int i = 0; i < ItemInfo.CraftingComponentNames.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(CraftingComponent, 1, i), ItemInfo.CraftingComponentNames[i]);
        }

        for (int i = 0; i < ItemInfo.DustNames.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(Dust, 1, i), ItemInfo.DustNames[i]);
        }

        for (int i = 0; i < ItemInfo.IngotNames.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(Ingot, 1, i), ItemInfo.IngotNames[i]);
        }

    }

}
