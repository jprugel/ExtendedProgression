package dev.jprugel.extendedProgression.item.tool;

import dev.jprugel.extendedProgression.item.ModItems;
import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.world.item.*;

public class EnderiteAxe extends AxeItem implements PolymerItem {

    public EnderiteAxe(Properties properties) {
        super(ModItems.ENDERITE_TOOL_MATERIAL, 1f, 1f, properties);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
        return Items.NETHERITE_AXE;
    }
}
