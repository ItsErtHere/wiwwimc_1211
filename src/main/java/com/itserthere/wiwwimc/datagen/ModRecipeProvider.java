package com.itserthere.wiwwimc.datagen;

import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.WIWWIMC;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        //
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRON_TILE.get())
                .pattern("II ")
                .pattern("II ")
                .pattern("   ")
                .define('I', Blocks.IRON_BLOCK)
                .unlockedBy("has_iron_block",has(Blocks.IRON_BLOCK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.POLISHED_IRON_TILE.get())
                .pattern("II ")
                .pattern("II ")
                .pattern("   ")
                .define('I', ModBlocks.IRON_TILE)
                .unlockedBy("has_iron_tile",has(ModBlocks.IRON_TILE)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.REDSTONE_CORE.get())
                .pattern("DBD")
                .pattern("BBB")
                .pattern("DBD")
                .define('B', Blocks.REDSTONE_BLOCK)
                .define('D', Blocks.REDSTONE_WIRE)
                .unlockedBy("has_redstone",has(Blocks.REDSTONE_WIRE)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModBlocks.BLAZING_CORE.get(),1)
                .requires(ModBlocks.REDSTONE_CORE).requires(Items.BLAZE_POWDER)
                .unlockedBy("has_blaze_powder",has(Items.BLAZE_POWDER)).save(recipeOutput);
        //Second input to save(recipeOutput,file_name)

    }
    //DO NOT TOUCH
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult,float pExp,
                                      int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new,pIngredients,
                pCategory,pResult,pExp,pCookingTime,pGroup,"_from_smelting");
    }
    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult,float pExp,
                                      int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new,pIngredients,
                pCategory,pResult,pExp,pCookingTime,pGroup,"_from_blasting");
    }
    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSterilizer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience,
                                                                       int pCookingTime,String pGroup, String pRecipeName) {
        for(ItemLike itemLike:pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike),pCategory,pResult,pExperience,pCookingTime,pCookingSterilizer,factory)
                    .group(pGroup).unlockedBy(getHasName(itemLike),has(itemLike))
                    .save(recipeOutput, WIWWIMC.MODID+":"+getItemName(pResult)+pRecipeName+"_"+getItemName(itemLike));
        }
    }
}
