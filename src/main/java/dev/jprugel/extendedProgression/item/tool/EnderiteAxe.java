package dev.jprugel.extendedProgression.item.tool;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.world.item.*;

public class EnderiteAxe extends AxeItem implements PolymerItem {
    public static final float ATTACK_DAMAGE_BASELINE = 5.5F;
    public static final float ATTACK_SPEED_BASELINE = -2.9F;

    public EnderiteAxe(Properties properties) {
        super(EnderiteToolMaterial.INSTANCE, ATTACK_DAMAGE_BASELINE, ATTACK_SPEED_BASELINE, properties);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return Items.NETHERITE_AXE;
    }
}
