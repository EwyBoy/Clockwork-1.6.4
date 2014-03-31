package Recipes;

import Item.Technical.Items;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class registerRecipies 
{
	public static void init()
	{
		registerRecipie();
	}

	public static void registerRecipie()
	{
		GameRegistry.addRecipe(new ItemStack(Items.Clock , 1 , 0),
				new Object[] {"XMX","XOX","XMX", 'X', Item.ingotGold, 'M', Item.redstone, 'O', Item.compass});
	}
	
	/*{
		GameRegistry.addRecipe(new ItemStack(Items.CraftingComponent , 1 , 0),
				new Object[] {  "X", 'X', Item.ingotIron});
		
		GameRegistry.addRecipe(new ItemStack(Items.CraftingComponent , 3 , 1),
				new Object[] {  "X", "X", "X", 'X', Item.ingotIron});
		
		GameRegistry.addRecipe(new ItemStack(Items.CraftingComponent , 1 , 2),
				new Object[] {  "XXX","XXX" , 'X', new ItemStack(Block.cloth)});
		
		
		
		GameRegistry.addRecipe(new ItemStack(Items.CraftingComponent , 1 , 3),
				new Object[] {  "X X", "X X", " X " , 'X', Item.ingotIron});
		
		GameRegistry.addRecipe(new ItemStack(Items.CraftingComponent , 1 , 4),
				new Object[] {  " XO", "X�X", "OX " , 'X', Item.ingotIron, 'O', Items.CraftingComponent, '�', Block.blockRedstone});
		
		GameRegistry.addRecipe(new ItemStack(Items.CraftingComponent , 1 , 5),
				new Object[] {  "X  ", " X ", "  X", 'X', Item.ingotIron});
		
		
		GameRegistry.addRecipe(new ItemStack(Items.Wrench),
				new Object[] {  "X  ", " Y ", "  Z", 
			
			'X', Items.CraftingComponent,  
			'Y', Items.CraftingComponent,
			'Z', Items.CraftingComponent,
		});
		
	}
*/
	
	
}
