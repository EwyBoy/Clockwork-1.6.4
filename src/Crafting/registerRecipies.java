package Crafting;

import Item.Items.Dust;
import Item.Technical.Items;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class registerRecipies 
{
	public static void init()
	{
		registerRecipe();
	}

	public static void registerRecipe()
	{
        ItemStack CopperDust = new ItemStack(Items.Dust,1, 0);
        ItemStack TinDust = new ItemStack(Items.Dust,1, 1);
        ItemStack ZincDust = new ItemStack(Items.Dust,1, 2);
        ItemStack BronzeDust = new ItemStack(Items.Dust,1, 3);
        ItemStack BrassDust = new ItemStack(Items.Dust,1, 4);

        ItemStack CopperIngot = new ItemStack(Items.Ingot,1, 0);
        ItemStack TinIngot = new ItemStack(Items.Ingot,1, 1);
        ItemStack ZincIngot = new ItemStack(Items.Ingot,1, 2);
        ItemStack BronzeIngot = new ItemStack(Items.Ingot,1, 3);
        ItemStack BrassIngot = new ItemStack(Items.Ingot,1, 4);

        ItemStack GearBronze = new ItemStack(Items.CraftingComponent,1, 0);
        ItemStack GearBrass = new ItemStack(Items.CraftingComponent,1, 1);
        ItemStack Roller = new ItemStack(Items.CraftingComponent,1, 2);
        ItemStack Strip = new ItemStack(Items.CraftingComponent,1, 3);
        ItemStack Head = new ItemStack(Items.CraftingComponent,1, 4);
        ItemStack Core = new ItemStack(Items.CraftingComponent,1, 5);
        ItemStack Handel = new ItemStack(Items.CraftingComponent,1, 6);

        GameRegistry.addShapelessRecipe(new ItemStack(Items.Dust, 1, 0), new ItemStack(Items.Ingot, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.Dust, 1, 1), new ItemStack(Items.Ingot, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.Dust, 1, 2), new ItemStack(Items.Ingot, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.Dust, 1, 3), new ItemStack(Items.Ingot, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.Dust, 1, 4), new ItemStack(Items.Ingot, 1, 4));

        GameRegistry.addShapelessRecipe(new ItemStack(Items.Dust, 1, 3), new ItemStack(Items.Dust, 1, 0),new ItemStack(Items.Dust, 1, 0),new ItemStack(Items.Dust, 1, 0), new ItemStack(Items.Dust, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.Dust, 1, 4), new ItemStack(Items.Dust, 1, 0),new ItemStack(Items.Dust, 1, 0),new ItemStack(Items.Dust, 1, 0), new ItemStack(Items.Dust, 1, 2));

        GameRegistry.addRecipe(new ItemStack(Items.Wrench), "  x"," y ", "z  ",
                'x', Head, 'y', Core, 'z', Handel);

        GameRegistry.addRecipe(new ItemStack(Items.CraftingComponent, 1, 0), " x ","x x", " x ",
                'x', BronzeIngot);
        GameRegistry.addRecipe(new ItemStack(Items.CraftingComponent, 1, 1), " x ","x x", " x ",
                'x', BrassIngot);
	}

}
