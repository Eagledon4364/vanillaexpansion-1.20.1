package cdvj.vanillaexpansion.world.biome;


import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }


    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
 //       this.addBiomeSimilar(mapper, BiomeKeys.BADLANDS, ModBiomes.ANCIENT_PLAINS);
        this.addBiomeSimilar(mapper, BiomeKeys.TAIGA, ModBiomes.REDWOOD_FOREST);
        this.addBiomeSimilar(mapper,  BiomeKeys.SWAMP, ModBiomes.WILLOW_SWAMP);
//        this.addBiome(mapper, MultiNoiseUtil.createNoiseHypercube(0.5f, 1f, 1.3f, 0.2f, 0.3f, 0.25f, 1), ModBiomes.WILLOW_SWAMP);
//        this.addBiome(mapper, MultiNoiseUtil.createNoiseHypercube(0.5f, 1f, 1.3f, 0.2f, 0.3f, 0.25f, 1), ModBiomes.REDWOOD_FOREST);
    }


}
