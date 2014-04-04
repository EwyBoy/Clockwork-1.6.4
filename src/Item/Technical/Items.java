package Item.Technical;

import Item.Items.Clock;
import Item.Items.Wrench;
import Item.Items.CraftingComponent;
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
        Clock = new Clock (ItemInfo.ClockID);
        Wrench = new Wrench (ItemInfo.WrenchID);
        CraftingComponent =  new CraftingComponent (ItemInfo.CraftingComponentID);
    }

    public static void addNames()
    {
        LanguageRegistry.addName(Clock, ItemInfo.ClockName);
        LanguageRegistry.addName(Wrench, ItemInfo.WrenchName);

        for (int i = 0; i < ItemInfo.CraftingComponentNames.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(CraftingComponent, 1, i), ItemInfo.CraftingComponentNames[i]);
        }
    }

}
