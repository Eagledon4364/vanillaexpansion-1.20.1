package cdvj.vanillaexpansion.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import cdvj.vanillaexpansion.block.ModBlocks;
import cdvj.vanillaexpansion.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        //willow
        blockStateModelGenerator.registerLog(ModBlocks.WILLOW_LOG).log(ModBlocks.WILLOW_LOG).wood(ModBlocks.WILLOW_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_WILLOW_LOG).log(ModBlocks.STRIPPED_WILLOW_LOG).wood(ModBlocks.STRIPPED_WILLOW_WOOD);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.WILLOW_TRAPDOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.WILLOW_DOOR);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WILLOW_LEAVES);
        BlockStateModelGenerator.BlockTexturePool WILLOW_POOL = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WILLOW_PLANKS);
        WILLOW_POOL.pressurePlate(ModBlocks.WILLOW_PRESSURE_PLATE);
        WILLOW_POOL.fenceGate(ModBlocks.WILLOW_FENCE_GATE);
        WILLOW_POOL.fence(ModBlocks.WILLOW_FENCE);
        WILLOW_POOL.button(ModBlocks.WILLOW_BUTTON);
        WILLOW_POOL.slab(ModBlocks.WILLOW_SLAB);
        WILLOW_POOL.stairs(ModBlocks.WILLOW_STAIRS);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.WILLOW_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        //redwood
        blockStateModelGenerator.registerLog(ModBlocks.REDWOOD_LOG).log(ModBlocks.REDWOOD_LOG).wood(ModBlocks.REDWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_REDWOOD_LOG).log(ModBlocks.STRIPPED_REDWOOD_LOG).wood(ModBlocks.STRIPPED_REDWOOD_WOOD);
        BlockStateModelGenerator.BlockTexturePool REDWOOD_POOL = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.REDWOOD_PLANKS);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.REDWOOD_TRAPDOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.REDWOOD_DOOR);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REDWOOD_LEAVES);
        REDWOOD_POOL.pressurePlate(ModBlocks.REDWOOD_PRESSURE_PLATE);
        REDWOOD_POOL.fenceGate(ModBlocks.REDWOOD_FENCE_GATE);
        REDWOOD_POOL.fence(ModBlocks.REDWOOD_FENCE);
        REDWOOD_POOL.button(ModBlocks.REDWOOD_BUTTON);
        REDWOOD_POOL.slab(ModBlocks.REDWOOD_SLAB);
        REDWOOD_POOL.stairs(ModBlocks.REDWOOD_STAIRS);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.REDWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANCIENT_NETHERITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANCIENT_NETHERITE_PAXEL, Models.GENERATED);
    }
}
