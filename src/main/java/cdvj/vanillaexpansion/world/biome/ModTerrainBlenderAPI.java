package cdvj.vanillaexpansion.world.biome;

import cdvj.vanillaexpansion.VanillaExpansion;
import cdvj.vanillaexpansion.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrainBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(VanillaExpansion.MOD_ID, "ancient_plains"), 1));
        Regions.register(new ModOverworldRegion(new Identifier(VanillaExpansion.MOD_ID, "redwood_forest"), 4));
        Regions.register(new ModOverworldRegion(new Identifier(VanillaExpansion.MOD_ID, "willow_swamp"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, VanillaExpansion.MOD_ID, ModMaterialRules.makeRules());
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, VanillaExpansion.MOD_ID, ModMaterialRules.makeRules());
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, VanillaExpansion.MOD_ID, ModMaterialRules.makeRules());
    }
}
