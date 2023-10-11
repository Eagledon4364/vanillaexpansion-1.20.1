package cdvj.vanillaexpansion;

import cdvj.vanillaexpansion.block.ModBlocks;
import cdvj.vanillaexpansion.entity.ModEntities;
import cdvj.vanillaexpansion.entity.client.ModModelLayers;
import cdvj.vanillaexpansion.entity.client.PrimalDragonRenderer;
import cdvj.vanillaexpansion.entity.custom.PrimalDragonModel;
import cdvj.vanillaexpansion.screen.ModScreenHandlers;
import cdvj.vanillaexpansion.screen.ToolCraftingStationScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class VanillaExpansionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRY_BUSH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILLOW_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILLOW_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILLOW_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILLOW_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REDWOOD_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REDWOOD_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REDWOOD_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANCIENT_STONE_SLAB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANCIENT_STONE_STAIRS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANCIENT_STONE_WALL, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.PRIMAL_DRAGON, PrimalDragonRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PrimalDragon, PrimalDragonModel::getTexturedModelData);


        HandledScreens.register(ModScreenHandlers.TOOL_CRAFTING_SCREEN_HANDLER,
                ToolCraftingStationScreen::new);

    }
}
