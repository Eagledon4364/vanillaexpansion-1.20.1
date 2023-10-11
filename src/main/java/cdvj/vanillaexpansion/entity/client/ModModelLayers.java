package cdvj.vanillaexpansion.entity.client;

import cdvj.vanillaexpansion.VanillaExpansion;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PrimalDragon =
            new EntityModelLayer(new Identifier(VanillaExpansion.MOD_ID, "primal_dragon"), "main");
}
