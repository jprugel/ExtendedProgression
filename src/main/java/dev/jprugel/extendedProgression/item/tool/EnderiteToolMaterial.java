package dev.jprugel.extendedProgression.item.tool;

import dev.jprugel.extendedProgression.datagen.ModBlockTagProvider;
import dev.jprugel.extendedProgression.datagen.ModItemTagProvider;
import net.minecraft.world.item.ToolMaterial;

public class EnderiteToolMaterial {
    public static final int BASE_DURABILITY = 2640;
    public static final float BASE_SPEED = 11F;
    public static final float BASE_ATTACK_DAMAGE_BONUS = 4.5F;
    public static final int BASE_ENCHANTMENT_VALUE = 22;

    public static final ToolMaterial INSTANCE = new ToolMaterial(
            ModBlockTagProvider.INCORRECT_FOR_ENDERITE_TOOL,
            BASE_DURABILITY,
            BASE_SPEED,
            BASE_ATTACK_DAMAGE_BONUS,
            BASE_ENCHANTMENT_VALUE,
            ModItemTagProvider.ENDERITE_TOOL_MATERIAL_TAG
    );
}
