package dev.jprugel.extendedProgression.item.tool;

import dev.jprugel.extendedProgression.item.ModItems;
import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class EnderiteSword extends Item implements PolymerItem {
    public EnderiteSword(Properties properties) {
        super(properties.sword(ModItems.ENDERITE_TOOL_MATERIAL, 6f, -2f));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return Items.NETHERITE_SWORD;
    }
}
