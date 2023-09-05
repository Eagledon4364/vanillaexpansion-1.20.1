package cdvj.vanillaexpansion.util;

import cdvj.vanillaexpansion.block.ModBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModStrippableBlocks {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.WILLOW_LOG, ModBlocks.STRIPPED_WILLOW_LOG);
        StrippableBlockRegistry.register(ModBlocks.WILLOW_WOOD, ModBlocks.STRIPPED_WILLOW_WOOD);
        StrippableBlockRegistry.register(ModBlocks.REDWOOD_LOG, ModBlocks.STRIPPED_REDWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.REDWOOD_WOOD, ModBlocks.STRIPPED_REDWOOD_WOOD);
        //to add more just duplicate first one
    }
}
