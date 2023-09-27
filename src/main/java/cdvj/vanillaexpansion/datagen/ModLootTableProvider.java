package cdvj.vanillaexpansion.datagen;

import cdvj.vanillaexpansion.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import cdvj.vanillaexpansion.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //willow
        addDrop(ModBlocks.WILLOW_PLANKS);
        addDrop(ModBlocks.WILLOW_LOG);
        addDrop(ModBlocks.WILLOW_WOOD);
        addDrop(ModBlocks.STRIPPED_WILLOW_LOG);
        addDrop(ModBlocks.STRIPPED_WILLOW_WOOD);
        addDrop(ModBlocks.WILLOW_BUTTON);
        addDrop(ModBlocks.WILLOW_DOOR, doorDrops(ModBlocks.WILLOW_DOOR));
        addDrop(ModBlocks.WILLOW_STAIRS);
        addDrop(ModBlocks.WILLOW_SLAB, slabDrops(ModBlocks.WILLOW_SLAB));
        addDrop(ModBlocks.WILLOW_TRAPDOOR);
        addDrop(ModBlocks.WILLOW_FENCE);
        addDrop(ModBlocks.WILLOW_FENCE_GATE);
        addDrop(ModBlocks.WILLOW_SAPLING);

        //redwood
        addDrop(ModBlocks.REDWOOD_PLANKS);
        addDrop(ModBlocks.REDWOOD_LOG);
        addDrop(ModBlocks.REDWOOD_WOOD);
        addDrop(ModBlocks.STRIPPED_REDWOOD_LOG);
        addDrop(ModBlocks.STRIPPED_REDWOOD_WOOD);
        addDrop(ModBlocks.REDWOOD_BUTTON);
        addDrop(ModBlocks.REDWOOD_DOOR, doorDrops(ModBlocks.REDWOOD_DOOR));
        addDrop(ModBlocks.REDWOOD_STAIRS);
        addDrop(ModBlocks.REDWOOD_SLAB, slabDrops(ModBlocks.REDWOOD_SLAB));
        addDrop(ModBlocks.REDWOOD_TRAPDOOR);
        addDrop(ModBlocks.REDWOOD_FENCE);
        addDrop(ModBlocks.REDWOOD_FENCE_GATE);
        addDrop(ModBlocks.REDWOOD_SAPLING);


        addDrop(ModBlocks.RUBY_ORE, copperLikeOreDrops(ModBlocks.RUBY_ORE, ModItems.RUBY));
        addDrop(ModBlocks.PYRONITE_ORE);
        addDrop(ModBlocks.PYRONITE_ORE, oreLikeDrops(ModBlocks.TUNGSTEN_ORE, ModItems.RAW_TUNGSTEN));
        //ancient stone
        addDrop(ModBlocks.ANCIENT_STONE);
        addDrop(ModBlocks.ANCIENT_STONE_WALL);
        addDrop(ModBlocks.ANCIENT_STONE_STAIRS);
        addDrop(ModBlocks.ANCIENT_STONE_SLAB, slabDrops(ModBlocks.ANCIENT_STONE_SLAB));







    }



    public LootTable.Builder oreLikeDrops(Block dropWithSilkTouch, Item drop) {
        return BlockLootTableGenerator.dropsWithSilkTouch(dropWithSilkTouch,
                (LootPoolEntry.Builder)this.applyExplosionDecay(dropWithSilkTouch,
                        ItemEntry.builder(drop).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(1.0f, 2.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}