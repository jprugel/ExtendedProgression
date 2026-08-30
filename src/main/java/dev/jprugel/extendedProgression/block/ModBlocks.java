package dev.jprugel.extendedProgression.block;

import dev.jprugel.extendedProgression.ExtendedProgression;
import dev.jprugel.extendedProgression.item.ModItems;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import eu.pb4.polymer.core.api.block.SimplePolymerBlock;
import eu.pb4.polymer.core.api.item.PolymerBlockItem;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    public static final AstralDebrisBlock ASTRAL_DEBRIS = register(
            ModBlockItemIds.ASTRAL_DEBRIS,
            AstralDebrisBlock::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.GRASS)
    );

    public static final EnderiteBlock ENDERITE_BLOCK = register(
            ModBlockItemIds.ENDERITE_BLOCK,
            EnderiteBlock::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.GRASS)
    );

    private static <T extends Block> T register(BlockItemId id, Function<BlockBehaviour.Properties, T> blockFactory, BlockBehaviour.Properties properties) {
        // Create the block instance
        var block = register(id.block(), blockFactory, properties);

        // Create the block item instance
        BlockItem blockItem = new PolymerBlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
        Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

        return block;
    }

    private static <T extends Block> T register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, T> blockFactory, BlockBehaviour.Properties properties) {
        // Create the block instance
        var block = blockFactory.apply(properties.setId(id));

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(ModItems.CUSTOM_CREATIVE_TAB_KEY).register((creativeTab) -> {
            creativeTab.accept(ModBlocks.ASTRAL_DEBRIS.asItem());
        });
    }
}
