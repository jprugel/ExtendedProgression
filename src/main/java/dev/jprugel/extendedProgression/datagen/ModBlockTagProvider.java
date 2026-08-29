package dev.jprugel.extendedProgression.datagen;

import dev.jprugel.extendedProgression.ExtendedProgression;
import dev.jprugel.extendedProgression.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockIds;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public static final TagKey<Block> INCORRECT_FOR_ENDERITE_TOOL =
            TagKey.create(
                    Registries.BLOCK,
                    Identifier.fromNamespaceAndPath(
                            ExtendedProgression.MOD_ID,
                            "incorrect_for_enderite_tool"
                    )
            );

    public ModBlockTagProvider(
            FabricPackOutput output,
            CompletableFuture<HolderLookup.Provider> registriesFuture
    ) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        builder(INCORRECT_FOR_ENDERITE_TOOL)
                .add(BlockIds.END_PORTAL)
                .add(BlockIds.END_GATEWAY);
    }
}
