package dev.jprugel.extendedProgression.item.armor;

import java.util.Map;

import dev.jprugel.extendedProgression.ExtendedProgression;
import dev.jprugel.extendedProgression.datagen.ModItemTagProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class EnderiteArmorMaterial {

    public static final int BASE_DURABILITY = 15;
    //-- endregion base_durability

    // #region material_key
    public static final ResourceKey<EquipmentAsset> ENDERITE_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, "enderite"));
    // #endregion material_key

    // #region repair_tag
    // #endregion repair_tag

    // #region guidite_armor_material
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 4,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 4
            ),
            5,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            4.0F,
            2.0F,
            ModItemTagProvider.ENDERITE_ARMOR_MATERIAL_TAG,
            ENDERITE_ARMOR_MATERIAL_KEY
    );
    // #endregion guidite_armor_material
}
