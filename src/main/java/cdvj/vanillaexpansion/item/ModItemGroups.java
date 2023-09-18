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
    public static final ItemGroup TOOL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(VanillaExpansion.MOD_ID, "ancient_netherite_paxel"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.tool"))
                    .icon(() -> new ItemStack(ModItems.PYRONITE_PAXEL)).
                    entries((displayContext, entries) -> {
                        entries.add(ModItems.BASE_TOOL);
                        //upgrades
                        entries.add(ModItems.PICKAXE_UPGRADE);
                        entries.add(ModItems.AXE_UPRGADE);
                        entries.add(ModItems.SHOVEL_UPGRADE);
                        entries.add(ModItems.HOE_UPGRADE);
                        entries.add(ModItems.SMELTING_UPGRADE);
                        entries.add(ModItems.PULVERIZING_UPGRADE);
                        //base tools
                        entries.add(ModItems.PYRONITE_PICKAXE);
                        entries.add(ModItems.PYRONITE_AXE);
                        entries.add(ModItems.PYRONITE_SHOVEL);
                        entries.add(ModItems.PYRONITE_HOE);
                        //2use
                        entries.add(ModItems.PYRONITE_AXEL);
                        entries.add(ModItems.PYRONITE_TROWEL);
                        entries.add(ModItems.PYRONITE_CUTTER_MATTOCK);
                        entries.add(ModItems.PYRONITE_MATTOCK);
                        entries.add(ModItems.PYRONITE_SCYTHE);
                        entries.add(ModItems.PYRONITE_ADZE);
                        //3use
                        entries.add(ModItems.PYRONITE_PAXEL);
                        entries.add(ModItems.PYRONITE_CUTTER);
                        entries.add(ModItems.PYRONITE_RIPPER);
                        entries.add(ModItems.PYRONITE_SCOOP);
                        //terrabreaker
                        entries.add(ModItems.PYRONITE_TERRA_BREAKER);

                    }).build());
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(VanillaExpansion.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.TOOL_CRAFTING_STATION);
                        //ores and drops
                        entries.add(ModItems.RUBY);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModItems.PYRONITE_INGOT);
                        entries.add(ModBlocks.PYRONITE_ORE);
                        //willow
                        entries.add(ModBlocks.WILLOW_LOG);
                        entries.add(ModBlocks.STRIPPED_WILLOW_LOG);
                        entries.add(ModBlocks.WILLOW_WOOD);
                        entries.add(ModBlocks.STRIPPED_WILLOW_WOOD);
                        entries.add(ModBlocks.WILLOW_LEAVES);
                        entries.add(ModBlocks.WILLOW_SAPLING);
                        entries.add(ModBlocks.WILLOW_PLANKS);
                        entries.add(ModBlocks.WILLOW_SLAB);
                        entries.add(ModBlocks.WILLOW_STAIRS);
                        entries.add(ModBlocks.WILLOW_DOOR);
                        entries.add(ModBlocks.WILLOW_TRAPDOOR);
                        entries.add(ModBlocks.WILLOW_FENCE);
                        entries.add(ModBlocks.WILLOW_FENCE_GATE);
                        entries.add(ModBlocks.WILLOW_BUTTON);
                        entries.add(ModBlocks.WILLOW_PRESSURE_PLATE);
                        //redwood
                        entries.add(ModBlocks.REDWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_REDWOOD_LOG);
                        entries.add(ModBlocks.REDWOOD_WOOD);
                        entries.add(ModBlocks.STRIPPED_REDWOOD_WOOD);
                        entries.add(ModBlocks.REDWOOD_LEAVES);
                        entries.add(ModBlocks.REDWOOD_SAPLING);
                        entries.add(ModBlocks.REDWOOD_PLANKS);
                        entries.add(ModBlocks.REDWOOD_SLAB);
                        entries.add(ModBlocks.REDWOOD_STAIRS);
                        entries.add(ModBlocks.REDWOOD_DOOR);
                        entries.add(ModBlocks.REDWOOD_TRAPDOOR);
                        entries.add(ModBlocks.REDWOOD_FENCE);
                        entries.add(ModBlocks.REDWOOD_FENCE_GATE);
                        entries.add(ModBlocks.REDWOOD_BUTTON);
                        entries.add(ModBlocks.REDWOOD_PRESSURE_PLATE);


                    }).build());





    public static void registerItemGroups() {
        VanillaExpansion.LOGGER.info("registering item groups for " + VanillaExpansion.MOD_ID);
    }
}
