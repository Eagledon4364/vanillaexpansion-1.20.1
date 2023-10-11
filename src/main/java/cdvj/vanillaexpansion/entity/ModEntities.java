package cdvj.vanillaexpansion.entity;

import cdvj.vanillaexpansion.VanillaExpansion;
import cdvj.vanillaexpansion.entity.custom.PrimalDragonEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<PrimalDragonEntity> PRIMAL_DRAGON = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(VanillaExpansion.MOD_ID, "primal_dragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PrimalDragonEntity::new).dimensions(EntityDimensions.fixed(2f, 2f)).build());
}
