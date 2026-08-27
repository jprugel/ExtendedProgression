package dev.jprugel.extendedProgression.item;

import dev.jprugel.extendedProgression.ExtendedProgression;
import eu.pb4.polymer.core.api.item.PolymerCreativeModeTabUtils;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Function;

public class ModItems {
    public static final Item ENDERITE = register(ModItemIds.ENDERITE, SimplePolymerItem::new, new Item.Properties());
    public static final Item ENDERITE_SCRAP = register(ModItemIds.ENDERITE_SCRAP, SimplePolymerItem::new, new Item.Properties());
    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(ExtendedProgression.MOD_ID, "creative_tab")
    );
    public static final CreativeModeTab CUSTOM_CREATIVE_TAB = PolymerCreativeModeTabUtils.builder()
            .icon(() -> new ItemStack(ModItems.ENDERITE))
            .title(Component.translatable("creativeTab.extended-progression"))
            .displayItems((params, output) -> {
                output.accept(ModItems.ENDERITE);
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
                .register((creativeTab) -> creativeTab.accept(ModItems.ENDERITE));
        CreativeModeTabEvents.modifyOutputEvent(CUSTOM_CREATIVE_TAB_KEY)
                .register((creativeTab) -> creativeTab.accept(ModItems.ENDERITE_SCRAP));
    }
}
