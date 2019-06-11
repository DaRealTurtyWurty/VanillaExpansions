package com.turtywurty.vanillaexpansion.recipes;

import com.turtywurty.vanillaexpansion.init.BlockInit;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingRecipes 
{
	public static void registerRecipes()
	{
		GameRegistry.addShapelessRecipe(new ResourceLocation("vanillaexpansion:hardenedStoneToCobble"), null, new ItemStack(Blocks.STONE, 9), Ingredient.fromStacks(new ItemStack(BlockInit.HARDENED_STONE)));
	}
}
