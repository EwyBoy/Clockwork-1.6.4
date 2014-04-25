package Crafting;

import Item.Technical.ItemInfo;
import Item.Technical.Items;
import WorldGen.Technical.OreInfo;
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

        FurnaceRecipes.smelting().addSmelting(OreInfo.OreCopperID, new ItemStack(Items.Ingot, 1, 0), 0.1f);
        FurnaceRecipes.smelting().addSmelting(OreInfo.OreTinID, new ItemStack(Items.Ingot, 1, 1), 0.1f);
        FurnaceRecipes.smelting().addSmelting(OreInfo.OreZincID, new ItemStack(Items.Ingot, 1, 2), 0.1f);

        FurnaceRecipes.smelting().addSmelting(Items.Dust.itemID, 0, new ItemStack(Items.Ingot, 1, 0), 0.1f);
        FurnaceRecipes.smelting().addSmelting(Items.Dust.itemID, 1, new ItemStack(Items.Ingot, 1, 1), 0.1f);
        FurnaceRecipes.smelting().addSmelting(Items.Dust.itemID, 2, new ItemStack(Items.Ingot, 1, 2), 0.1f);
        FurnaceRecipes.smelting().addSmelting(Items.Dust.itemID, 3, new ItemStack(Items.Ingot, 1, 3), 0.1f);
        FurnaceRecipes.smelting().addSmelting(Items.Dust.itemID, 4, new ItemStack(Items.Ingot, 1, 4), 0.1f);
    }
}   