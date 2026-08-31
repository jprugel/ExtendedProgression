package dev.jprugel.extendedProgression.item;

import dev.jprugel.extendedProgression.block.ModBlocks;
import dev.jprugel.extendedProgression.datagen.ModBlockTagProvider;
import dev.jprugel.extendedProgression.datagen.ModItemTagProvider;
import dev.jprugel.extendedProgression.item.armor.EnderiteBoots;
import dev.jprugel.extendedProgression.item.armor.EnderiteChestplate;
import dev.jprugel.extendedProgression.item.armor.EnderiteHelmet;
import dev.jprugel.extendedProgression.item.armor.EnderiteLeggings;
import dev.jprugel.extendedProgression.item.tool.*;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;

import java.util.function.Function;

public class ModItems {
    public static final ToolMaterial ENDERITE_TOOL_MATERIAL = new ToolMaterial(
            ModBlockTagProvider.INCORRECT_FOR_ENDERITE_TOOL,
            455,
            1f,
            2f,
            22,
            ModItemTagProvider.ENDERITE_TOOL_MATERIAL_TAG
    );

    public static final Item ENDERITE_INGOT = register(ModItemIds.ENDERITE_INGOT, SimplePolymerItem::new, new Item.Properties());
    public static final Item ENDERITE_SCRAP = register(ModItemIds.ENDERITE_SCRAP, SimplePolymerItem::new, new Item.Properties());
    public static final Item ENDERITE_HORSE_ARMOR = register(ModItemIds.ENDERITE_HORSE_ARMOR, SimplePolymerItem::new, new Item.Properties());
    public static final Item ENDERITE_NAUTILUS_ARMOR = register(ModItemIds.ENDERITE_NAUTILUS_ARMOR, SimplePolymerItem::new, new Item.Properties());
    public static final Item ENDERITE_UPGRADE_SMITHING_TEMPLATE = register(ModItemIds.ENDERITE_UPGRADE_SMITHING_TEMPLATE, SimplePolymerItem::new, new Item.Properties());

    public static final Item ENDERITE_AXE = register(ModItemIds.ENDERITE_AXE, EnderiteAxe::new, new Item.Properties());
    public static final Item ENDERITE_HOE = register(ModItemIds.ENDERITE_HOE, EnderiteHoe::new, new Item.Properties());
    public static final Item ENDERITE_SPEAR = register(ModItemIds.ENDERITE_SPEAR, EnderiteSpear::new, new Item.Properties());
    public static final Item ENDERITE_SWORD = register(ModItemIds.ENDERITE_SWORD, EnderiteSword::new, new Item.Properties());
    public static final Item ENDERITE_SHOVEL = register(ModItemIds.ENDERITE_SHOVEL, EnderiteShovel::new, new Item.Properties());
    public static final Item ENDERITE_PICKAXE = register(ModItemIds.ENDERITE_PICKAXE, EnderitePickaxe::new, new Item.Properties());

    public static final Item ENDERITE_BOOTS = register(ModItemIds.ENDERITE_BOOTS, EnderiteBoots::new, new Item.Properties());
    public static final Item ENDERITE_HELMET = register(ModItemIds.ENDERITE_HELMET, EnderiteHelmet::new, new Item.Properties());
    public static final Item ENDERITE_LEGGINGS = register(ModItemIds.ENDERITE_LEGGINGS, EnderiteLeggings::new, new Item.Properties());
    public static final Item ENDERITE_CHESTPLATE = register(ModItemIds.ENDERITE_CHESTPLATE, EnderiteChestplate::new, new Item.Properties());

    public static void addTo(ResourceKey<CreativeModeTab> creativeModeTabs, ItemLike itemBefore, ItemLike item) {
        CreativeModeTabEvents.modifyOutputEvent(creativeModeTabs)
                .register((creativeTab) -> creativeTab.insertAfter(itemBefore, item));
    }

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        addTo(CreativeModeTabs.INGREDIENTS, Items.NETHERITE_INGOT, ENDERITE_SCRAP);
        addTo(CreativeModeTabs.INGREDIENTS, ENDERITE_SCRAP, ENDERITE_INGOT);
        addTo(CreativeModeTabs.COMBAT, Items.NETHERITE_HORSE_ARMOR, ENDERITE_HORSE_ARMOR);
        addTo(CreativeModeTabs.COMBAT, Items.NETHERITE_NAUTILUS_ARMOR, ENDERITE_NAUTILUS_ARMOR);
        addTo(CreativeModeTabs.INGREDIENTS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ENDERITE_UPGRADE_SMITHING_TEMPLATE);
        addTo(CreativeModeTabs.COMBAT, Items.NETHERITE_SWORD, ENDERITE_SWORD);
        addTo(CreativeModeTabs.COMBAT, Items.NETHERITE_SPEAR, ENDERITE_SPEAR);
        addTo(CreativeModeTabs.COMBAT, Items.NETHERITE_AXE, ENDERITE_AXE);
        addTo(CreativeModeTabs.COMBAT, Items.NETHERITE_BOOTS, ENDERITE_HELMET);
        addTo(CreativeModeTabs.COMBAT, ENDERITE_HELMET, ENDERITE_CHESTPLATE);
        addTo(CreativeModeTabs.COMBAT, ENDERITE_CHESTPLATE, ENDERITE_LEGGINGS);
        addTo(CreativeModeTabs.COMBAT, ENDERITE_LEGGINGS, ENDERITE_BOOTS);
        addTo(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.NETHERITE_HOE, ENDERITE_HOE);
        addTo(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.NETHERITE_SHOVEL, ENDERITE_SHOVEL);
        addTo(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.NETHERITE_PICKAXE, ENDERITE_PICKAXE);
        addTo(CreativeModeTabs.NATURAL_BLOCKS, Items.ANCIENT_DEBRIS, ModBlocks.ASTRAL_DEBRIS);
        addTo(CreativeModeTabs.BUILDING_BLOCKS, Items.NETHERITE_BLOCK, ModBlocks.ENDERITE_BLOCK);
    }
}
