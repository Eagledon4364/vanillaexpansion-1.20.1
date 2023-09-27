package cdvj.vanillaexpansion.world.feature.tree;

import cdvj.vanillaexpansion.world.feature.ModConfiguredFeatures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class RedwoodSaplingGenerator extends LargeTreeSaplingGenerator {
    @Override
public boolean generate(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random random) {
    for (int i = 0; i >= -1; --i) {
        for (int j = 0; j >= -1; --j) {
            if (!LargeTreeSaplingGenerator.canGenerateLargeTree(state, world, pos, i, j)) continue;
            return this.generateLargeTree(world, chunkGenerator, pos, state, random, i, j);
        }
    }
    return super.generate(world, chunkGenerator, pos, state, random);
}

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return null;
    }

    @Nullable
    protected RegistryKey<ConfiguredFeature<?, ?>> getLargeTreeFeature(Random var1) {
        return ModConfiguredFeatures.REDWOOD_KEY;
    }

    public boolean generateLargeTree(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random random, int x, int z) {
        RegistryKey<ConfiguredFeature<?, ?>> registryKey = this.getLargeTreeFeature(random);
        if (registryKey == null) {
            return false;
        }
        RegistryEntry registryEntry = world.getRegistryManager().get(RegistryKeys.CONFIGURED_FEATURE).getEntry(registryKey).orElse(null);
        if (registryEntry == null) {
            return false;
        }
        ConfiguredFeature configuredFeature = (ConfiguredFeature)registryEntry.value();
        BlockState blockState = Blocks.AIR.getDefaultState();
        world.setBlockState(pos.add(x, 0, z), blockState, Block.NO_REDRAW);
        world.setBlockState(pos.add(x + 1, 0, z), blockState, Block.NO_REDRAW);
        world.setBlockState(pos.add(x, 0, z + 1), blockState, Block.NO_REDRAW);
        world.setBlockState(pos.add(x + 1, 0, z + 1), blockState, Block.NO_REDRAW);
        if (configuredFeature.generate(world, chunkGenerator, random, pos.add(x, 0, z))) {
            return true;
        }
        world.setBlockState(pos.add(x, 0, z), state, Block.NO_REDRAW);
        world.setBlockState(pos.add(x + 1, 0, z), state, Block.NO_REDRAW);
        world.setBlockState(pos.add(x, 0, z + 1), state, Block.NO_REDRAW);
        world.setBlockState(pos.add(x + 1, 0, z + 1), state, Block.NO_REDRAW);
        return false;
    }

    public static boolean canGenerateLargeTree(BlockState state, BlockView world, BlockPos pos, int x, int z) {
        Block block = state.getBlock();
        return world.getBlockState(pos.add(x, 0, z)).isOf(block) && world.getBlockState(pos.add(x + 1, 0, z)).isOf(block) && world.getBlockState(pos.add(x, 0, z + 1)).isOf(block) && world.getBlockState(pos.add(x + 1, 0, z + 1)).isOf(block);
    }

}
