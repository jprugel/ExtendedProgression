package dev.jprugel.extendedProgression.item.tool;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class EnderiteSpear extends Item implements PolymerItem {
    public static final float ATTACK_DURATION = 3F;
    public static final float DAMAGE_MULTIPLIER = 3F;
    public static final float DELAY = 0.2F;
    public static final float DISMOUNT_TIME = 2F;
    public static final float DISMOUNT_THRESHOLD = 2F;
    public static final float KNOCKBACK_TIME = 2F;
    public static final float KNOCKBACK_THRESHOLD = 2F;
    public static final float DAMAGE_TIME = 2F;
    public static final float DAMAGE_THRESHOLD = 2F;

    public EnderiteSpear(Properties properties) {
        super(properties.spear(EnderiteToolMaterial.INSTANCE,
                ATTACK_DURATION,
                DAMAGE_MULTIPLIER,
                DELAY,
                DISMOUNT_TIME,
                DISMOUNT_THRESHOLD,
                KNOCKBACK_TIME,
                KNOCKBACK_THRESHOLD,
                DAMAGE_TIME,
                DAMAGE_THRESHOLD
        ));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return Items.NETHERITE_SPEAR;
    }
}
