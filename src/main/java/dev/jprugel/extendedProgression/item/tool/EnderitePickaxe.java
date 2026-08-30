package dev.jprugel.extendedProgression.item.tool;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class EnderitePickaxe extends Item implements PolymerItem {
    public EnderitePickaxe(Properties properties) {
        super(properties);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return Items.NETHERITE_PICKAXE;
    }
}
