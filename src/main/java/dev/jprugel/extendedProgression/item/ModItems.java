package dev.jprugel.extendedProgression.item;

import dev.jprugel.extendedProgression.ExtendedProgression;
import dev.jprugel.extendedProgression.item.armor.EnderiteArmorMaterial;
import eu.pb4.polymer.core.api.item.PolymerCreativeModeTabUtils;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class ModItems {
    public static final TagKey<Block> INCORRECT_FOR_ENDERITE_TOOL = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, "incorrect_for_enderite_tool"));

    public static final ToolMaterial ENDERITE_TOOL_MATERIAL = new ToolMaterial(
            INCORRECT_FOR_ENDERITE_TOOL,
            455,
            5.0f,
            1.5f,
            22,
            EnderiteArmorMaterial.REPAIRS_ENDERITE_ARMOR
    );

    public static final Item ENDERITE_INGOT = register(ModItemIds.ENDERITE_INGOT, SimplePolymerItem::new, new Item.Properties());
    public static final Item ENDERITE_SCRAP = register(ModItemIds.ENDERITE_SCRAP, SimplePolymerItem::new, new Item.Properties());
    public static final Item ENDERITE_UPGRADE_SMITHING_TEMPLATE = register(ModItemIds.ENDERITE_UPGRADE_SMITHING_TEMPLATE, SimplePolymerItem::new, new Item.Properties());
    public static final Item ENDERITE_AXE = register(ModItemIds.ENDERITE_AXE, properties -> new SimplePolymerItem(
            properties.axe(ENDERITE_TOOL_MATERIAL, 1f, 1f),
            Items.NETHERITE_AXE
    ), new Item.Properties().axe(ENDERITE_TOOL_MATERIAL, 1f, 1f));


    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, "creative_tab")
    );
    public static final CreativeModeTab CUSTOM_CREATIVE_TAB = PolymerCreativeModeTabUtils.builder()
            .icon(() -> new ItemStack(ModItems.ENDERITE_INGOT))
            .title(Component.translatable("creativeTab.extended-progression"))
            .displayItems((params, output) -> {
                output.accept(ModItems.ENDERITE_INGOT);
                output.accept(ModItems.ENDERITE_SCRAP);
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
        CreativeModeTabEvents.modifyOutputEvent(CUSTOM_CREATIVE_TAB_KEY)
                .register((creativeTab) -> creativeTab.accept(ModItems.ENDERITE_INGOT));
        CreativeModeTabEvents.modifyOutputEvent(CUSTOM_CREATIVE_TAB_KEY)
                .register((creativeTab) -> creativeTab.accept(ModItems.ENDERITE_SCRAP));
        CreativeModeTabEvents.modifyOutputEvent(CUSTOM_CREATIVE_TAB_KEY)
                .register((creativeTab) -> creativeTab.accept(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE));
    }
}
