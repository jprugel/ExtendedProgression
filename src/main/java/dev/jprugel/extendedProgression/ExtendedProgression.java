package dev.jprugel.extendedProgression;

import dev.jprugel.extendedProgression.block.ModBlocks;
import dev.jprugel.extendedProgression.item.ModItems;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
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

        ModItems.initialize();
        ModBlocks.initialize();
    }
}
