package cdvj.vanillaexpansion.item;

import cdvj.vanillaexpansion.VanillaExpansion;
import cdvj.vanillaexpansion.util.CustomBlockTags;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item ANCIENT_NETHERITE_INGOT = registerItem("ancient_netherite_ingot", new Item(new FabricItemSettings()));
    public static final Item ANCIENT_NETHERITE_PAXEL = registerItem("ancient_netherite_paxel", new PaxelItem(5.5f, -3.0f, ModToolMaterial.ANCIENT_NETHERITE,
            CustomBlockTags.PAXEL_MINEABLE, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(VanillaExpansion.MOD_ID, name), item);
    }

    public static void registerModItems() {
        VanillaExpansion.LOGGER.info("registering mod items for " + VanillaExpansion.MOD_ID);
    }
}
