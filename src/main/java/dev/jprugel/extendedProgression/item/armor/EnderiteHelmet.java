package dev.jprugel.extendedProgression.item.armor;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.ArmorType;

public class EnderiteHelmet extends Item implements PolymerItem {
    public EnderiteHelmet(Properties properties) {
        super(properties.humanoidArmor(EnderiteArmorMaterial.INSTANCE, ArmorType.HELMET));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return Items.NETHERITE_HELMET;
    }
}
