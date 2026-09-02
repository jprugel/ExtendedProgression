package dev.jprugel.extendedProgression.item.tool;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.world.item.*;

public class EnderiteShovel extends ShovelItem implements PolymerItem {
    public EnderiteShovel(Properties properties) {
        super(EnderiteToolMaterial.INSTANCE, 2f, -3f, properties);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return Items.NETHERITE_SHOVEL;
    }
}
