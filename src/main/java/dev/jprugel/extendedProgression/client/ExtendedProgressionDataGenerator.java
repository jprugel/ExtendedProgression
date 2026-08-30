package dev.jprugel.extendedProgression.client;

import dev.jprugel.extendedProgression.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import org.jspecify.annotations.NonNull;

public class ExtendedProgressionDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void buildRegistry(@NonNull RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, ModWorldConfiguredFeatures::configure);
        registryBuilder.add(Registries.PLACED_FEATURE, ModWorldPlacedFeatures::configure);
    }

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModBlockLootTableProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModWorldGenProvider::new);
        pack.addProvider(ModEnglishLangProvider::new);
    }
}
