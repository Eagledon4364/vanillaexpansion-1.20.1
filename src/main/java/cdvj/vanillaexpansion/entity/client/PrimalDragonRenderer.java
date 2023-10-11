package cdvj.vanillaexpansion.entity.client;

import cdvj.vanillaexpansion.VanillaExpansion;
import cdvj.vanillaexpansion.VanillaExpansionClient;
import cdvj.vanillaexpansion.entity.custom.PrimalDragonEntity;
import cdvj.vanillaexpansion.entity.custom.PrimalDragonModel;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

import java.time.temporal.ValueRange;

public class PrimalDragonRenderer extends MobEntityRenderer<PrimalDragonEntity, PrimalDragonModel<PrimalDragonEntity>> {
    private static final Identifier TEXTURE = new Identifier(VanillaExpansion.MOD_ID, "textures/entity/primal_dragon.png");
    public PrimalDragonRenderer(EntityRendererFactory.Context context) {
        super(context, new PrimalDragonModel<>(context.getPart(ModModelLayers.PrimalDragon)), 0.2f);
    }

    @Override
    public Identifier getTexture(PrimalDragonEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(PrimalDragonEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }


        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
