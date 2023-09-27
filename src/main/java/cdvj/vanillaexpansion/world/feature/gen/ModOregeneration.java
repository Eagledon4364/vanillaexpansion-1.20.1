package cdvj.vanillaexpansion.world.feature.gen;

import cdvj.vanillaexpansion.world.feature.ModPlacedFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOregeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeature.TUNGSTEN_ORE_PLACED_KEY);
    }
}
