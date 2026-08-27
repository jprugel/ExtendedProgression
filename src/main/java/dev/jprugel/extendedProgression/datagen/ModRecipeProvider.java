package dev.jprugel.extendedProgression.datagen;

import dev.jprugel.extendedProgression.block.ModBlocks;
import dev.jprugel.extendedProgression.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
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

                shapeless(RecipeCategory.MISC, ModItems.ENDERITE)
                        .requires(ModItems.ENDERITE_SCRAP, 3)
                        .requires(Items.ECHO_SHARD, 3)
                        .unlockedBy(
                                getHasName(ModItems.ENDERITE_SCRAP),
                                has(ModItems.ENDERITE_SCRAP)
                        )
                        .save(output, "enderite");
            }
        };
    }

    @Override
    public String getName() {
        return "ExtendedProgressionRecipeProvider";
    }
}
