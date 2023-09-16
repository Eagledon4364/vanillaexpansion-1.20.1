package cdvj.vanillaexpansion.registry;

import cdvj.vanillaexpansion.block.ModBlockEntities;
import cdvj.vanillaexpansion.block.ModBlocks;
import cdvj.vanillaexpansion.block.entity.ToolCraftingStationBlockEntity;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.types.Type;
import com.mojang.logging.LogUtils;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;



public class ModBlockEntityType<T extends BlockEntity> {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final BlockEntityType<ToolCraftingStationBlockEntity> TOOL_CRAFTING_STATION = ModBlockEntityType.create("tool_crafting_station", ModBlockEntityType.Builder.create(ToolCraftingStationBlockEntity::new, ModBlocks.TOOL_CRAFTING_STATION));

    public static BlockEntityType<ToolCraftingStationBlockEntity> create(String tool_crafting_station, Builder<ToolCraftingStationBlockEntity> toolCraftingStationBlockEntityBuilder) {
        return TOOL_CRAFTING_STATION;
    }

    private final BlockEntityType.BlockEntityFactory<? extends T> factory;
    private final Set<Block> blocks;
    private final Type<?> type;

    @Nullable
    public static Identifier getId(BlockEntityType<?> type) {
        return Registries.BLOCK_ENTITY_TYPE.getId(type);
    }

    public ModBlockEntityType(BlockEntityType.BlockEntityFactory<? extends T> factory, Set<Block> blocks, Type<?> type) {
        this.factory = factory;
        this.blocks = blocks;
        this.type = type;
    }
    @Nullable
    public T instantiate(BlockPos pos, BlockState state) {
        return this.factory.create(pos, state);
    }

    public boolean supports(BlockState state) {
        return this.blocks.contains(state.getBlock());
    }

    @Nullable
    public T get(BlockView world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity == null) {
            return null;
        }
        return (T)blockEntity;
    }

    public static final class Builder<T extends BlockEntity> {
        private final ModBlockEntityType.BlockEntityFactory<? extends T> factory;
        final Set<Block> blocks;

        private Builder(ModBlockEntityType.BlockEntityFactory<? extends T> factory, Set<Block> blocks) {
            this.factory = factory;
            this.blocks = blocks;
        }

        public static <T extends BlockEntity> Builder<T> create(ModBlockEntityType.BlockEntityFactory<? extends T> factory, Block ... blocks) {
            return new ModBlockEntityType.Builder<T>(factory, ImmutableSet.copyOf(blocks));
        }

        public ModBlockEntityType<T> build(Type<?> type) {
            return new ModBlockEntityType<T>((BlockEntityType.BlockEntityFactory<? extends T>) this.factory, this.blocks, type);
        }
    }

    @FunctionalInterface
    public static interface BlockEntityFactory<T extends BlockEntity> {
        public T create(BlockPos var1, BlockState var2);
    }
}
