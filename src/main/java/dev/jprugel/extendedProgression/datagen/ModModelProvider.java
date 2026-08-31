package dev.jprugel.extendedProgression.datagen;

import dev.jprugel.extendedProgression.block.ModBlocks;
import dev.jprugel.extendedProgression.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialBlock(ModBlocks.ASTRAL_DEBRIS, TexturedModel.COLUMN);
        blockModelGenerators.createTrivialCube(ModBlocks.ENDERITE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_SCRAP, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_AXE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_HOE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_SPEAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_SWORD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_SHOVEL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_PICKAXE, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_BOOTS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_HELMET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ENDERITE_CHESTPLATE, ModelTemplates.FLAT_ITEM);
    }
}
