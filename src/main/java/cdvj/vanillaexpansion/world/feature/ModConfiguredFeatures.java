package cdvj.vanillaexpansion.world.feature;

import cdvj.vanillaexpansion.VanillaExpansion;
import cdvj.vanillaexpansion.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;

import java.util.List;


public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> WILLOW_KEY = registryKey("willow_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> REDWOOD_KEY = registryKey("redwood_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TUNGSTEN_ORE_KEY = registryKey("tungsten_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PYRONITE_ORE_KEY = registryKey("pyronite_ore");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);
        register(context, WILLOW_KEY, Feature.TREE, (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.WILLOW_LOG),
                new ForkingTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.WILLOW_LEAVES),
                new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), 3),
                new TwoLayersFeatureSize(3, 1, 5))).build());



        register(context, REDWOOD_KEY, Feature.TREE, (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.REDWOOD_LOG),
                new GiantTrunkPlacer(14, 18, 11),
                BlockStateProvider.of(ModBlocks.REDWOOD_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), ConstantIntProvider.create(13)),
                new TwoLayersFeatureSize(1, 1, 2))).build());

        List<OreFeatureConfig.Target> overWorldTungstenOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.TUNGSTEN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.TUNGSTEN_ORE.getDefaultState()));
        register(context, TUNGSTEN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overWorldTungstenOres, 10));

        List<OreFeatureConfig.Target> pyronite_ore =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.PYRONITE_ORE.getDefaultState()));

        register(context, PYRONITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(pyronite_ore, 9));


    }








    private static <FC extends FeatureConfig, F extends Feature<FC>> void
    register(Registerable<ConfiguredFeature<?, ?>> context,
         RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(VanillaExpansion.MOD_ID, name));

    }

    public static void registerConfiguredFeatures() {
        VanillaExpansion.LOGGER.debug("registering features for " + VanillaExpansion.MOD_ID);
    }
}
