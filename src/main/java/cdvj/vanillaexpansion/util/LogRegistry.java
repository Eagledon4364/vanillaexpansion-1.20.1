package cdvj.vanillaexpansion.util;

import java.util.HashMap;
import java.util.Map;

import cdvj.vanillaexpansion.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class LogRegistry {
    private static final Map<Block, Block> logStrippingMap = new HashMap<>();

    static {
        // Populate the HashMap with log-stripped log relationships for vanilla logs and wood blocks
        logStrippingMap.put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG);
        logStrippingMap.put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD);
        logStrippingMap.put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG);
        logStrippingMap.put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD);
        logStrippingMap.put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG);
        logStrippingMap.put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD);
        logStrippingMap.put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG);
        logStrippingMap.put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD);
        logStrippingMap.put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG);
        logStrippingMap.put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD);
        logStrippingMap.put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG);
        logStrippingMap.put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_LOG);
        logStrippingMap.put(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG);
        logStrippingMap.put(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD);
        logStrippingMap.put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG);
        logStrippingMap.put(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD);
        logStrippingMap.put(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK);
        logStrippingMap.put(ModBlocks.REDWOOD_LOG, ModBlocks.STRIPPED_REDWOOD_LOG);
        logStrippingMap.put(ModBlocks.REDWOOD_WOOD, ModBlocks.STRIPPED_REDWOOD_WOOD);
        logStrippingMap.put(ModBlocks.WILLOW_LOG, ModBlocks.STRIPPED_WILLOW_LOG);
        logStrippingMap.put(ModBlocks.WILLOW_WOOD, ModBlocks.STRIPPED_WILLOW_WOOD);

        // Nether wood types
        logStrippingMap.put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM);
        logStrippingMap.put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE);
        logStrippingMap.put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM);
        logStrippingMap.put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE);
    }

    public static Map<Block, Block> getLogStrippingMap() {
        return logStrippingMap;
    }
}
