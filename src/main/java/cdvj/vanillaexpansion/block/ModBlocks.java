package cdvj.vanillaexpansion.block;

import cdvj.vanillaexpansion.VanillaExpansion;
import cdvj.vanillaexpansion.block.custom.ToolCraftingStationBlock;
import cdvj.vanillaexpansion.world.feature.tree.RedwoodSaplingGenerator;
import cdvj.vanillaexpansion.world.feature.tree.WillowSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.shape.VoxelShape;

public class ModBlocks {
    private static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 11, 16);



    public static final Block TOOL_CRAFTING_STATION = registerBlock("tool_crafting_station",
            new ToolCraftingStationBlock(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE).nonOpaque()));
    //ores
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)));
    public static final Block PYRONITE_ORE = registerBlock("pyronite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)));
    //trees
    public static final Block WILLOW_PLANKS = registerBlock("willow_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block WILLOW_LOG = registerBlock("willow_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block WILLOW_WOOD = registerBlock("willow_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_WILLOW_LOG = registerBlock("stripped_willow_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_WILLOW_WOOD = registerBlock("stripped_willow_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block WILLOW_SLAB = registerBlock("willow_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).nonOpaque()));
    public static final Block WILLOW_STAIRS = registerBlock("willow_stairs",
            new StairsBlock(ModBlocks.WILLOW_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).nonOpaque()));
    public static final Block WILLOW_PRESSURE_PLATE = registerBlock("willow_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block WILLOW_BUTTON = registerBlock("willow_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block WILLOW_FENCE = registerBlock("willow_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block WILLOW_FENCE_GATE = registerBlock("willow_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE), WoodType.OAK));
    public static final Block WILLOW_DOOR = registerBlock("willow_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).nonOpaque(), BlockSetType.OAK));
    public static final Block WILLOW_TRAPDOOR = registerBlock("willow_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).nonOpaque(), BlockSetType.OAK));
    public static final Block WILLOW_LEAVES = registerBlock("willow_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));

    public static final Block WILLOW_SAPLING = registerBlock("willow_sapling",
            new SaplingBlock(new WillowSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    public static final Block REDWOOD_PLANKS = registerBlock("redwood_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block REDWOOD_LOG = registerBlock("redwood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block REDWOOD_WOOD = registerBlock("redwood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_REDWOOD_LOG = registerBlock("stripped_redwood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_REDWOOD_WOOD = registerBlock("stripped_redwood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block REDWOOD_SLAB = registerBlock("redwood_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).nonOpaque()));
    public static final Block REDWOOD_STAIRS = registerBlock("redwood_stairs",
            new StairsBlock(ModBlocks.WILLOW_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).nonOpaque()));
    public static final Block REDWOOD_PRESSURE_PLATE = registerBlock("redwood_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block REDWOOD_BUTTON = registerBlock("redwood_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block REDWOOD_FENCE = registerBlock("redwood_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block REDWOOD_FENCE_GATE = registerBlock("redwood_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE), WoodType.OAK));
    public static final Block REDWOOD_DOOR = registerBlock("redwood_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).nonOpaque(), BlockSetType.OAK));
    public static final Block REDWOOD_TRAPDOOR = registerBlock("redwood_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).nonOpaque(), BlockSetType.OAK));
    public static final Block REDWOOD_LEAVES = registerBlock("redwood_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));
    public static final Block REDWOOD_SAPLING = registerBlock("redwood_sapling",
            new SaplingBlock(new RedwoodSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(VanillaExpansion.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(VanillaExpansion.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        VanillaExpansion.LOGGER.info("registering modblocks for " + VanillaExpansion.MOD_ID);
    }
}
