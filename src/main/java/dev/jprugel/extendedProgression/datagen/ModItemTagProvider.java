package dev.jprugel.extendedProgression.datagen;

import dev.jprugel.extendedProgression.ExtendedProgression;
import dev.jprugel.extendedProgression.item.ModItemIds;
import dev.jprugel.extendedProgression.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;
public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public static final TagKey<Item> ENDERITE_TOOL_MATERIAL = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, "enderite_tool_material"));
    public static final TagKey<Item> REPAIRS_ENDERITE_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, "repairs_enderite_armor"));


    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider _wrapperLookup) {
        builder(ENDERITE_TOOL_MATERIAL)
                .add(ModItemIds.ENDERITE_INGOT)
                .setReplace(true);

        builder(REPAIRS_ENDERITE_ARMOR)
                .add(ModItemIds.ENDERITE_INGOT)
                .setReplace(true);
    }
}
