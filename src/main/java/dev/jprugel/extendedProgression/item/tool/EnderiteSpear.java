package dev.jprugel.extendedProgression.item.tool;

import dev.jprugel.extendedProgression.item.ModItems;
import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class EnderiteSpear extends Item implements PolymerItem {
    public EnderiteSpear(Properties properties) {
        super(properties.spear(ModItems.ENDERITE_TOOL_MATERIAL, 3f, 3f, 0.2f, 2f, 2f, 2f, 2f, 2f, 2f));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return Items.NETHERITE_SPEAR;
    }
}
