package dev.jprugel.extendedProgression.datagen;

import dev.jprugel.extendedProgression.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public abstract class EPRecipeProvider extends RecipeProvider {

    public EPRecipeProvider(
            HolderLookup.Provider registries,
            RecipeOutput output
    ) {
        super(registries, output);
    }

    public void enderiteSmithing(
            Item base,
            RecipeCategory category,
            Item result
    ) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(base),
                        this.tag(ModItemTagProvider.ENDERITE_TOOL_MATERIALS),
                        category,
                        result
                )
                .unlocks(
                        "has_netherite_ingot",
                        this.has(ItemTags.NETHERITE_TOOL_MATERIALS)
                )
                .save(
                        this.output,
                        RecipeProvider.getItemName(result) + "_smithing"
                );
    }
}
