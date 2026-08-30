package dev.jprugel.extendedProgression.datagen;

import dev.jprugel.extendedProgression.ExtendedProgression;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModWorldPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ASTRAL_DEBRIS_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE,
            Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, "astral_debris_placed")
    );

    public static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<PlacementModifier> astralDebrisVeinModifiers = List.of(
                CountPlacement.of(1),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.TOP, VerticalAnchor.BOTTOM)
        );

        context.register(
                ASTRAL_DEBRIS_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModWorldConfiguredFeatures.ASTRAL_DEBRIS_VEIN_CONFIGURED_KEY),
                        astralDebrisVeinModifiers
                )
        );
    }
}
