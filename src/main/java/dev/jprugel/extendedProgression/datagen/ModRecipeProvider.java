package dev.jprugel.extendedProgression.datagen;

import dev.jprugel.extendedProgression.ExtendedProgression;
import dev.jprugel.extendedProgression.block.ModBlocks;
import dev.jprugel.extendedProgression.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new EPRecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                //HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
                oreSmelting(
                        List.of(ModBlocks.ASTRAL_DEBRIS),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.ENDERITE_SCRAP,
                        3f,
                        1000,
                        "astral_debris_to_enderite_scrap"
                );

                oreBlasting(
                        List.of(ModBlocks.ASTRAL_DEBRIS),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.ENDERITE_SCRAP,
                        3f,
                        500,
                        "astral_debris_to_enderite_scrap"
                );

                shapeless(RecipeCategory.MISC, ModItems.ENDERITE_INGOT)
                        .requires(ModItems.ENDERITE_SCRAP, 3)
                        .requires(Items.ECHO_SHARD, 3)
                        .unlockedBy(
                                getHasName(ModItems.ENDERITE_SCRAP),
                                has(ModItems.ENDERITE_SCRAP)
                        )
                        .save(output, "enderite");

                shaped(RecipeCategory.MISC, ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, 2)
                        .pattern("aba")
                        .pattern("aca")
                        .pattern("aaa")
                        .define('a', Ingredient.of(Items.NETHERITE_INGOT))
                        .define('b', Ingredient.of(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE))
                        .define('c', Ingredient.of(Items.ECHO_SHARD))
                        .group(ExtendedProgression.MOD_ID)
                        .unlockedBy(getHasName(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output);

                enderiteSmithing(
                        Items.NETHERITE_AXE,
                        RecipeCategory.COMBAT,
                        ModItems.ENDERITE_AXE
                );
            }
        };
    }

    @Override
    public String getName() {
        return "ExtendedProgressionRecipeProvider";
    }
}