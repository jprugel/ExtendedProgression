package dev.jprugel.extendedProgression.datagen;

import dev.jprugel.extendedProgression.block.ModBlocks;
import dev.jprugel.extendedProgression.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        // Specifying en_us is optional, as it's the default language code
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider holderLookup, TranslationBuilder tb) {
        tb.add("creativeTab.extended-progression", "Pyric Server Additions Enderite");
        tb.add(ModItemTagProvider.ENDERITE_TOOL_MATERIAL_TAG, "Enderite Tool Material");

        tb.add(ModBlocks.ASTRAL_DEBRIS, "Astral Debris");
        tb.add(ModBlocks.ENDERITE_BLOCK, "Enderite Block");

        tb.add(ModItems.ENDERITE_INGOT, "Enderite Ingot");
        tb.add(ModItems.ENDERITE_SCRAP, "Enderite Scrap");
        tb.add(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, "Enderite Upgrade");

        tb.add(ModItems.ENDERITE_HOE, "Enderite Hoe");
        tb.add(ModItems.ENDERITE_AXE, "Enderite Axe");
        tb.add(ModItems.ENDERITE_SPEAR, "Enderite Spear");
        tb.add(ModItems.ENDERITE_SWORD, "Enderite Sword");
        tb.add(ModItems.ENDERITE_SHOVEL, "Enderite Shovel");
        tb.add(ModItems.ENDERITE_PICKAXE, "Enderite Pickaxe");

        tb.add(ModItems.ENDERITE_BOOTS, "Enderite Boots");
        tb.add(ModItems.ENDERITE_HELMET, "Enderite Helmet");
        tb.add(ModItems.ENDERITE_LEGGINGS, "Enderite Leggings");
        tb.add(ModItems.ENDERITE_CHESTPLATE, "Enderite Chestplate");
    }
}
