package dev.jprugel.extendedProgression.item.armor;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.ArmorType;

public class EnderiteBoots extends Item implements PolymerItem {
    public EnderiteBoots(Properties properties) {
        super(properties.humanoidArmor(EnderiteArmorMaterial.INSTANCE, ArmorType.BOOTS));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return Items.NETHERITE_BOOTS;
    }
}
