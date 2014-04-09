package Recipes;

import WorldGen.Ores.OreZinc;
import WorldGen.Technical.OreInfo;
import WorldGen.Technical.Ores;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class registerSmelting
{
    public static void init()
    {
        registerSmelting();
    }

    public static void registerSmelting()
    {
        FurnaceRecipes.smelting().addSmelting(OreInfo.OreCopperID, new ItemStack(Item.ingotIron, 1), 0.1F);
    }
}