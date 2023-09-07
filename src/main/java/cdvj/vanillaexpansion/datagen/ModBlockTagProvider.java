package cdvj.vanillaexpansion.datagen;

import cdvj.vanillaexpansion.util.CustomBlockTags;
import cdvj.vanillaexpansion.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {




        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
        ;



        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.WILLOW_PLANKS)
                .add(ModBlocks.WILLOW_BUTTON)
                .add(ModBlocks.STRIPPED_WILLOW_LOG)
                .add(ModBlocks.STRIPPED_WILLOW_WOOD)
                .add(ModBlocks.WILLOW_LOG)
                .add(ModBlocks.WILLOW_WOOD)
                .add(ModBlocks.WILLOW_DOOR)
                .add(ModBlocks.WILLOW_TRAPDOOR)
                .add(ModBlocks.WILLOW_FENCE)
                .add(ModBlocks.WILLOW_FENCE_GATE)
                .add(ModBlocks.WILLOW_PRESSURE_PLATE)


                .add(ModBlocks.REDWOOD_PLANKS)
                .add(ModBlocks.REDWOOD_BUTTON)
                .add(ModBlocks.STRIPPED_REDWOOD_LOG)
                .add(ModBlocks.STRIPPED_REDWOOD_WOOD)
                .add(ModBlocks.REDWOOD_LOG)
                .add(ModBlocks.REDWOOD_WOOD)
                .add(ModBlocks.REDWOOD_DOOR)
                .add(ModBlocks.REDWOOD_TRAPDOOR)
                .add(ModBlocks.REDWOOD_FENCE)
                .add(ModBlocks.REDWOOD_FENCE_GATE)
                .add(ModBlocks.REDWOOD_PRESSURE_PLATE)
                ;
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.WILLOW_LOG)
                .add(ModBlocks.STRIPPED_WILLOW_LOG)
                .add(ModBlocks.REDWOOD_LOG)
                .add(ModBlocks.STRIPPED_REDWOOD_LOG);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.WILLOW_BUTTON)
                .add(ModBlocks.REDWOOD_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.WILLOW_SLAB)
                .add(ModBlocks.REDWOOD_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.WILLOW_DOOR)
                .add(ModBlocks.REDWOOD_DOOR)
                ;

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.WILLOW_TRAPDOOR)
                .add(ModBlocks.REDWOOD_TRAPDOOR)
        ;

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.WILLOW_FENCE)
                .add(ModBlocks.REDWOOD_FENCE)
        ;
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.WILLOW_FENCE_GATE)
                .add(ModBlocks.REDWOOD_FENCE_GATE)
        ;

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.WILLOW_PRESSURE_PLATE)
                .add(ModBlocks.REDWOOD_PRESSURE_PLATE)
        ;

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.WILLOW_STAIRS)
                .add(ModBlocks.REDWOOD_STAIRS)
        ;



        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
        ;



        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.WILLOW_LEAVES)
                .add(ModBlocks.REDWOOD_LEAVES)
        ;
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.WILLOW_FENCE)
                .add(ModBlocks.REDWOOD_FENCE)
        ;


        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.WILLOW_FENCE_GATE)
                .add(ModBlocks.REDWOOD_FENCE_GATE)
        ;

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.WILLOW_STAIRS)
                .add(ModBlocks.REDWOOD_STAIRS)
        ;

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.WILLOW_DOOR)
                .add(ModBlocks.REDWOOD_DOOR)
        ;

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.WILLOW_LOG)
                .add(ModBlocks.STRIPPED_WILLOW_LOG)
                .add(ModBlocks.REDWOOD_LOG)
                .add(ModBlocks.STRIPPED_REDWOOD_LOG)
        ;

        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.WILLOW_TRAPDOOR)
        ;

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.WILLOW_LEAVES)
                .add(ModBlocks.REDWOOD_LEAVES)
        ;
        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.WILLOW_SAPLING)
                .add(ModBlocks.REDWOOD_SAPLING)
        ;
        getOrCreateTagBuilder(CustomBlockTags.REDWOOD_LOGS)
                .add(ModBlocks.REDWOOD_LOG)
                .add(ModBlocks.STRIPPED_REDWOOD_LOG)
                .add(ModBlocks.REDWOOD_WOOD)
                .add(ModBlocks.STRIPPED_REDWOOD_WOOD)
        ;
        getOrCreateTagBuilder(CustomBlockTags.WILLOW_LOGS)
                .add(ModBlocks.WILLOW_LOG)
                .add(ModBlocks.STRIPPED_WILLOW_LOG)
                .add(ModBlocks.WILLOW_WOOD)
                .add(ModBlocks.STRIPPED_WILLOW_WOOD)
        ;
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.WILLOW_PLANKS)
                .add(ModBlocks.REDWOOD_PLANKS)
        ;
        getOrCreateTagBuilder(CustomBlockTags.PAXEL_MINEABLE)
                .addTag(BlockTags.AXE_MINEABLE)
                .addTag(BlockTags.PICKAXE_MINEABLE)
                .addTag(BlockTags.SHOVEL_MINEABLE)
        ;





    }
}
