package cdvj.vanillaexpansion.item;

import cdvj.vanillaexpansion.VanillaExpansion;
import cdvj.vanillaexpansion.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(VanillaExpansion.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        //willow
                        entries.add(ModBlocks.WILLOW_PLANKS);
                        entries.add(ModBlocks.WILLOW_LOG);
                        entries.add(ModBlocks.STRIPPED_WILLOW_LOG);
                        entries.add(ModBlocks.WILLOW_DOOR);
                        entries.add(ModBlocks.WILLOW_TRAPDOOR);
                        entries.add(ModBlocks.WILLOW_BUTTON);
                        entries.add(ModBlocks.WILLOW_FENCE);
                        entries.add(ModBlocks.WILLOW_FENCE_GATE);
                        entries.add(ModBlocks.WILLOW_SLAB);
                        entries.add(ModBlocks.WILLOW_STAIRS);
                        entries.add(ModBlocks.WILLOW_LEAVES);
                        entries.add(ModBlocks.WILLOW_PRESSURE_PLATE);
                        entries.add(ModBlocks.WILLOW_WOOD);
                        entries.add(ModBlocks.STRIPPED_WILLOW_WOOD);
                        entries.add(ModBlocks.WILLOW_SAPLING);
                        //redwood
                        entries.add(ModBlocks.REDWOOD_PLANKS);
                        entries.add(ModBlocks.REDWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_REDWOOD_LOG);
                        entries.add(ModBlocks.REDWOOD_DOOR);
                        entries.add(ModBlocks.REDWOOD_TRAPDOOR);
                        entries.add(ModBlocks.REDWOOD_BUTTON);
                        entries.add(ModBlocks.REDWOOD_FENCE);
                        entries.add(ModBlocks.REDWOOD_FENCE_GATE);
                        entries.add(ModBlocks.REDWOOD_SLAB);
                        entries.add(ModBlocks.REDWOOD_STAIRS);
                        entries.add(ModBlocks.REDWOOD_LEAVES);
                        entries.add(ModBlocks.REDWOOD_PRESSURE_PLATE);
                        entries.add(ModBlocks.REDWOOD_WOOD);
                        entries.add(ModBlocks.STRIPPED_REDWOOD_WOOD);
                        entries.add(ModBlocks.REDWOOD_SAPLING);


                    }).build());





    public static void registerItemGroups() {
        VanillaExpansion.LOGGER.info("registering itemgroups for " + VanillaExpansion.MOD_ID);
    }
}
