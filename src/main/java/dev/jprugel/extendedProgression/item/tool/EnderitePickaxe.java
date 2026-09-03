package dev.jprugel.extendedProgression.item.tool;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class EnderitePickaxe extends Item implements PolymerItem {
    public static final float ATTACK_DAMAGE_BASELINE = 1F;
    public static final float ATTACK_SPEED_BASELINE = -2.5F;

    public EnderitePickaxe(Properties properties) {
        super(properties.pickaxe(EnderiteToolMaterial.INSTANCE, ATTACK_DAMAGE_BASELINE, ATTACK_SPEED_BASELINE).fireResistant());
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return Items.NETHERITE_PICKAXE;
    }
}
