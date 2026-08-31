package dev.jprugel.extendedProgression.item;

import dev.jprugel.extendedProgression.ExtendedProgression;
import dev.jprugel.extendedProgression.block.ModBlocks;
import dev.jprugel.extendedProgression.datagen.ModBlockTagProvider;
import dev.jprugel.extendedProgression.datagen.ModItemTagProvider;
import dev.jprugel.extendedProgression.item.armor.EnderiteBoots;
import dev.jprugel.extendedProgression.item.armor.EnderiteChestplate;
import dev.jprugel.extendedProgression.item.armor.EnderiteHelmet;
import dev.jprugel.extendedProgression.item.armor.EnderiteLeggings;
import dev.jprugel.extendedProgression.item.tool.*;
import eu.pb4.polymer.core.api.item.PolymerCreativeModeTabUtils;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

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

    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, "creative_tab")
    );
    public static final CreativeModeTab CUSTOM_CREATIVE_TAB = PolymerCreativeModeTabUtils.builder()
            .icon(() -> new ItemStack(ModItems.ENDERITE_INGOT))
            .title(Component.translatable("creativeTab.extended-progression"))
            .displayItems((_, output) -> {
                output.accept(ModItems.ENDERITE_INGOT);
                output.accept(ModItems.ENDERITE_SCRAP);
                output.accept(ModItems.ENDERITE_HORSE_ARMOR);
                output.accept(ModItems.ENDERITE_NAUTILUS_ARMOR);
                output.accept(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE);

                output.accept(ModBlocks.ASTRAL_DEBRIS);
                output.accept(ModBlocks.ENDERITE_BLOCK);

                output.accept(ModItems.ENDERITE_AXE);
                output.accept(ModItems.ENDERITE_HOE);
                output.accept(ModItems.ENDERITE_SPEAR);
                output.accept(ModItems.ENDERITE_SWORD);
                output.accept(ModItems.ENDERITE_SHOVEL);
                output.accept(ModItems.ENDERITE_PICKAXE);

                output.accept(ModItems.ENDERITE_BOOTS);
                output.accept(ModItems.ENDERITE_HELMET);
                output.accept(ModItems.ENDERITE_LEGGINGS);
                output.accept(ModItems.ENDERITE_CHESTPLATE);
            })
            .build();

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        PolymerCreativeModeTabUtils.registerPolymerCreativeModeTab(CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
    }
}
