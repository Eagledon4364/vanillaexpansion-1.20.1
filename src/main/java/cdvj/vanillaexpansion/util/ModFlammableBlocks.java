package cdvj.vanillaexpansion.util;

import cdvj.vanillaexpansion.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        //willow
        registry.add(ModBlocks.WILLOW_LOG, 5, 5);
        registry.add(ModBlocks.WILLOW_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_WILLOW_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_WILLOW_WOOD, 5, 5);
        registry.add(ModBlocks.WILLOW_PLANKS, 5, 20);
        registry.add(ModBlocks.WILLOW_SLAB, 5, 5);
        registry.add(ModBlocks.WILLOW_STAIRS, 5, 5);
        registry.add(ModBlocks.WILLOW_FENCE_GATE, 5, 5);
        registry.add(ModBlocks.WILLOW_FENCE, 5, 5);
        registry.add(ModBlocks.WILLOW_BUTTON, 5, 5);
        registry.add(ModBlocks.WILLOW_PRESSURE_PLATE, 5, 5);
        registry.add(ModBlocks.WILLOW_LEAVES, 30, 60);
        registry.add(ModBlocks.WILLOW_SAPLING, 5, 5);
        //redwood
        registry.add(ModBlocks.REDWOOD_LOG, 5, 5);
        registry.add(ModBlocks.REDWOOD_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_REDWOOD_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_REDWOOD_WOOD, 5, 5);
        registry.add(ModBlocks.REDWOOD_PLANKS, 5, 20);
        registry.add(ModBlocks.REDWOOD_SLAB, 5, 5);
        registry.add(ModBlocks.REDWOOD_STAIRS, 5, 5);
        registry.add(ModBlocks.REDWOOD_FENCE_GATE, 5, 5);
        registry.add(ModBlocks.REDWOOD_FENCE, 5, 5);
        registry.add(ModBlocks.REDWOOD_BUTTON, 5, 5);
        registry.add(ModBlocks.REDWOOD_PRESSURE_PLATE, 5, 5);
        registry.add(ModBlocks.REDWOOD_LEAVES, 30, 60);
        registry.add(ModBlocks.REDWOOD_SAPLING, 5, 5);






    }
}
