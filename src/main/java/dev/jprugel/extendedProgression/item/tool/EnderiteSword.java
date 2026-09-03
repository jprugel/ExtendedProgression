package dev.jprugel.extendedProgression.item.tool;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class EnderiteSword extends Item implements PolymerItem {
    public static final float ATTACK_DAMAGE_BASELINE = 3.5F;
    public static final float ATTACK_SPEED_BASELINE = -2.4F;

    public EnderiteSword(Properties properties) {
        super(properties.sword(EnderiteToolMaterial.INSTANCE, ATTACK_DAMAGE_BASELINE, ATTACK_SPEED_BASELINE));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return Items.NETHERITE_SWORD;
    }
}
