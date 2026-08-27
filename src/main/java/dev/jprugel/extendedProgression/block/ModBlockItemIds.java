package dev.jprugel.extendedProgression.block;

import dev.jprugel.extendedProgression.ExtendedProgression;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModBlockItemIds {
    public static final BlockItemId ASTRAL_DEBRIS = create("astral_debris");

    private static BlockItemId create(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, name);
        return BlockItemId.create(id, id);
    }
}
