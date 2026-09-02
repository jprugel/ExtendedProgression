package dev.jprugel.extendedProgression.datagen;

import dev.jprugel.extendedProgression.ExtendedProgression;
import dev.jprugel.extendedProgression.item.ModItemIds;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;
public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public static final TagKey<Item> ENDERITE_TOOL_MATERIAL_TAG = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, "enderite_tool_material"));
    public static final TagKey<Item> ENDERITE_ARMOR_MATERIAL_TAG = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, "enderite_armor_material"));


    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider _wrapperLookup) {
        builder(ENDERITE_TOOL_MATERIAL_TAG)
                .add(ModItemIds.ENDERITE_INGOT);
        builder(ENDERITE_ARMOR_MATERIAL_TAG)
                .add(ModItemIds.ENDERITE_INGOT);

        builder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItemIds.ENDERITE_PICKAXE);
    }
}
