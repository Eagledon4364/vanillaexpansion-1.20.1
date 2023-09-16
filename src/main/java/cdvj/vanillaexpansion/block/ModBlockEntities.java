package cdvj.vanillaexpansion.block;

import cdvj.vanillaexpansion.VanillaExpansion;
import cdvj.vanillaexpansion.block.entity.ToolCraftingStationBlockEntity;
import cdvj.vanillaexpansion.registry.ModBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<ToolCraftingStationBlockEntity> TOOL_CRAFTING_STATION = ModBlockEntityType.create("tool_crafting_station", ModBlockEntityType.Builder.create(ToolCraftingStationBlockEntity::new, ModBlocks.TOOL_CRAFTING_STATION));

    public static void registerBlockEntities() {
    }

}
