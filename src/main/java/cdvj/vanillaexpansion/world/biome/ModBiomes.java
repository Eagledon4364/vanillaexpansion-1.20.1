package cdvj.vanillaexpansion.world.biome;

import cdvj.vanillaexpansion.VanillaExpansion;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModBiomes {
    public static final RegistryKey<Biome> ANCIENT_PLAINS = register("ancient_plains");
    public static final RegistryKey<Biome> REDWOOD_FOREST = register("redwood_forest");
    public static final RegistryKey<Biome> WILLOW_SWAMP = register("willow_swamp");

    public static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(VanillaExpansion.MOD_ID, name));
    }

    public static void bootstrap(Registerable<Biome> context) {
        context.register(ANCIENT_PLAINS, ancientPlains(context));
        context.register(REDWOOD_FOREST, redwoodForest(context));
        context.register(WILLOW_SWAMP, willowSwamp(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
       DefaultBiomeFeatures.addLandCarvers(builder);
       DefaultBiomeFeatures.addDungeons(builder);
       DefaultBiomeFeatures.addSprings(builder);
       DefaultBiomeFeatures.addAmethystGeodes(builder);
       DefaultBiomeFeatures.addMineables(builder);
    }

    public static Biome ancientPlains(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF,
                5, 4, 4));

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);


        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);




        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x285484)
                        .waterFogColor(0x285484)
                        .skyColor(0x91b2d6)
                        .grassColor(0x1d5d19)
                        .foliageColor(0x1d5d19)
                        .fogColor(0x91b2d6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .build();
    }

    public static Biome redwoodForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);
        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
        DefaultBiomeFeatures.addLargeFerns(biomeBuilder);
        DefaultBiomeFeatures.addDefaultGrass(biomeBuilder);


        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.GRASS_BONEMEAL);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_NORMAL);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.BROWN_MUSHROOM_TAIGA);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_TAIGA_2);



        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.1f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x285484)
                        .waterFogColor(0x285484)
                        .skyColor(0x91b2d6)
                        .grassColor(0x1d5d19)
                        .foliageColor(0x1d5d19)
                        .fogColor(0x91b2d6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .build();
    }

    public static Biome willowSwamp(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FROG, 5, 4, 4));

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);
        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.GRASS_BONEMEAL);



        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x285484)
                        .waterFogColor(0x285484)
                        .skyColor(0x91b2d6)
                        .grassColor(0x1d5d19)
                        .foliageColor(0x1d5d19)
                        .fogColor(0x91b2d6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .build();
    }
}