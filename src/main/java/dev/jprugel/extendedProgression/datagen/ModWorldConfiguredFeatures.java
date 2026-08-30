package dev.jprugel.extendedProgression.datagen;

import dev.jprugel.extendedProgression.ExtendedProgression;
import dev.jprugel.extendedProgression.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModWorldConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASTRAL_DEBRIS_VEIN_CONFIGURED_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, "astral_debris_vein")
            );

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest endstoneReplaceableRule = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> astralDebrisOreConfig =
                List.of(
                        OreConfiguration.target(endstoneReplaceableRule, ModBlocks.ASTRAL_DEBRIS.defaultBlockState())
                );

        context.register(
                ASTRAL_DEBRIS_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(astralDebrisOreConfig, 2)
                )
        );
    }
}
