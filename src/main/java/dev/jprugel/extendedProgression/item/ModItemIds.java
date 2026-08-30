package dev.jprugel.extendedProgression.item;

import dev.jprugel.extendedProgression.ExtendedProgression;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {
    public static final ResourceKey<Item> ENDERITE_INGOT = create("enderite");
    public static final ResourceKey<Item> ENDERITE_SCRAP = create("enderite_scrap");
    public static final ResourceKey<Item> ENDERITE_UPGRADE_SMITHING_TEMPLATE = create("enderite_upgrade");

    public static final ResourceKey<Item> ENDERITE_AXE = create("enderite_axe");
    public static final ResourceKey<Item> ENDERITE_HOE = create("enderite_hoe");
    public static final ResourceKey<Item> ENDERITE_SWORD = create("enderite_sword");
    public static final ResourceKey<Item> ENDERITE_SHOVEL = create("enderite_shovel");
    public static final ResourceKey<Item> ENDERITE_PICKAXE = create("enderite_pickaxe");

    public static final ResourceKey<Item> ENDERITE_BOOTS = create("enderite_boots");
    public static final ResourceKey<Item> ENDERITE_HELMET = create("enderite_helmet");
    public static final ResourceKey<Item> ENDERITE_LEGGINGS = create("enderite_leggings");
    public static final ResourceKey<Item> ENDERITE_CHESTPLATE = create("enderite_chestplate");


    public static ResourceKey<Item> create(String name) {
        // Create the item key.
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, name));
    }
}
