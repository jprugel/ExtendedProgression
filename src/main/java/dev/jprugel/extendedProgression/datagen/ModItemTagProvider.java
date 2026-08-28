package dev.jprugel.extendedProgression.datagen;

import dev.jprugel.extendedProgression.ExtendedProgression;
import dev.jprugel.extendedProgression.item.ModItemIds;
import dev.jprugel.extendedProgression.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public static final TagKey<Item> ENDERITE_TOOL_MATERIALS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, "enderite_tool_materials"));

    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        builder(ENDERITE_TOOL_MATERIALS)
                .add(ModItemIds.ENDERITE_INGOT)
                .setReplace(true);
    }
}
