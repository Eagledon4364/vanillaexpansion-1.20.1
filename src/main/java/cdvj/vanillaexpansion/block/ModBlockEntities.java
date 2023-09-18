package cdvj.vanillaexpansion.block;

import cdvj.vanillaexpansion.VanillaExpansion;
import cdvj.vanillaexpansion.block.entity.ToolCraftingStationBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<ToolCraftingStationBlockEntity> TOOL_CRAFTING_STATION = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(VanillaExpansion.MOD_ID, "tool_crafting_station_block"),
            FabricBlockEntityTypeBuilder.create(ToolCraftingStationBlockEntity::new, ModBlocks.TOOL_CRAFTING_STATION).build());

    public static void registerBlockEntities() {
    }

}
