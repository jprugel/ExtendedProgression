package dev.jprugel.extendedProgression.block;

import dev.jprugel.extendedProgression.ExtendedProgression;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class EnderiteBlock extends Block implements PolymerTexturedBlock {
    private static final float DESTROY_TIME = 15F;

    private final BlockState polymerState;

    public EnderiteBlock(Properties properties) {
        super(properties.destroyTime(DESTROY_TIME).sound(SoundType.GRASS));

        this.polymerState = PolymerBlockResourceUtils.requestBlock(
                BlockModelType.FULL_BLOCK,
                PolymerBlockModel.of(
                        Identifier.fromNamespaceAndPath(
                                ExtendedProgression.MOD_ID,
                                "block/enderite_block"
                        )
                )
        );
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, @Nullable PacketContext context) {
        return this.polymerState;
    }
}
