package cdvj.vanillaexpansion.world.feature.gen;

import cdvj.vanillaexpansion.world.biome.ModBiomes;
import cdvj.vanillaexpansion.world.feature.ModPlacedFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.REDWOOD_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeature.REDWOOD_TREE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.WILLOW_SWAMP),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeature.WILLOW_TREE_PLACED_KEY);

    }
}
