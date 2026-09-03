package dev.jprugel.extendedProgression;

import dev.jprugel.extendedProgression.block.ModBlocks;
import dev.jprugel.extendedProgression.datagen.ModWorldPlacedFeatures;
import dev.jprugel.extendedProgression.item.ModItems;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtendedProgression implements ModInitializer {
    public static final String MOD_ID = "extended-progression";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing...");

        PolymerResourcePackUtils.markAsRequired();
        PolymerResourcePackUtils.addModAssets(ExtendedProgression.MOD_ID);

        BiomeModifications.addFeature(
                BiomeSelectors.tag(BiomeTags.HAS_END_CITY),
                GenerationStep.Decoration.RAW_GENERATION,
                ModWorldPlacedFeatures.ASTRAL_DEBRIS_PLACED_KEY
        );

        ModItems.initialize();
        ModBlocks.initialize();

        LOGGER.info("Finished Initializing.");
    }
}
