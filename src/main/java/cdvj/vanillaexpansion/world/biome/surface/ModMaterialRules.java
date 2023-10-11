package cdvj.vanillaexpansion.world.biome.surface;

import cdvj.vanillaexpansion.block.ModBlocks;
import cdvj.vanillaexpansion.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule ANCIENT_STONE = makeStateRule(ModBlocks.ANCIENT_STONE);




    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);


        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.ANCIENT_PLAINS),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, ANCIENT_STONE)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, ANCIENT_STONE)),

                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.REDWOOD_FOREST),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, GRASS_BLOCK)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, ANCIENT_STONE)),
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.WILLOW_SWAMP),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, GRASS_BLOCK)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, ANCIENT_STONE)),



                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
