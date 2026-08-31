package dev.jprugel.extendedProgression.datagen;

import dev.jprugel.extendedProgression.ExtendedProgression;
import dev.jprugel.extendedProgression.block.ModBlocks;
import dev.jprugel.extendedProgression.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public static String GOT_ASTRAL_DEBRIS = "got_astral_debris";
    public static String FULL_SET_ENDERITE = "full_set_enderite";

    public ModAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.@NonNull Provider registryLookup, @NonNull Consumer<AdvancementHolder> consumer) {
        AdvancementHolder gotAstralDebris = Advancement.Builder.advancement()
                .parent(createPlaceholder(Identifier.withDefaultNamespace("end/kill_dragon")))
                .display(
                        ModBlocks.ASTRAL_DEBRIS,
                        Component.literal("Hidden in the Stars"),
                        Component.literal("Obtain Astral Debris"),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/end"),
                        AdvancementType.TASK,
                        true,
                        true,
                        true
                )
                .addCriterion(GOT_ASTRAL_DEBRIS, InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ASTRAL_DEBRIS))
                .save(consumer, Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, GOT_ASTRAL_DEBRIS));

        Advancement.Builder.advancement()
                .parent(gotAstralDebris)
                .display(
                        ModItems.ENDERITE_CHESTPLATE,
                        Component.literal("Space Suit Acquired"),
                        Component.literal("Wear a full set of Enderite Armor"),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/end"),
                        AdvancementType.TASK,
                        true,
                        true,
                        true
                )
                .addCriterion(FULL_SET_ENDERITE, InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERITE_BOOTS, ModItems.ENDERITE_HELMET, ModItems.ENDERITE_LEGGINGS, ModItems.ENDERITE_CHESTPLATE))
                .save(consumer, Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, FULL_SET_ENDERITE));
    }
}
