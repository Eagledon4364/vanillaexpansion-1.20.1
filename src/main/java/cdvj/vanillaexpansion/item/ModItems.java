package cdvj.vanillaexpansion.item;

import cdvj.vanillaexpansion.VanillaExpansion;
import cdvj.vanillaexpansion.item.tools.AdzeItem;
import cdvj.vanillaexpansion.item.tools.AxelItem;
import cdvj.vanillaexpansion.item.tools.ScytheItem;
import cdvj.vanillaexpansion.item.tools.TerraBreakerItem;
import cdvj.vanillaexpansion.item.tools.CutterItem;
import cdvj.vanillaexpansion.item.tools.RipperItem;
import cdvj.vanillaexpansion.item.tools.*;
import cdvj.vanillaexpansion.item.tools.PaxelItem;
import cdvj.vanillaexpansion.util.CustomBlockTags;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item RUBY = registerItem("ruby",
            new Item(new FabricItemSettings()));
    public static final Item PYRONITE_INGOT = registerItem("pyronite_ingot",
            new Item(new FabricItemSettings().fireproof()));



//TOOLS
    //1 use
    public static final Item BASE_TOOL = registerItem("base_tool",
        new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static final Item PYRONITE_PICKAXE = registerItem("pyronite_pickaxe",
            new PickaxeItem(ModToolMaterial.PYRONITE, 1, -5,
                    new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static final Item PYRONITE_AXE = registerItem("pyronite_axe",
            new AxeItem(ModToolMaterial.PYRONITE, 5, -3,
                    new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static final Item PYRONITE_SHOVEL = registerItem("pyronite_shovel",
            new ShovelItem(ModToolMaterial.PYRONITE, 1, -3,
                    new FabricItemSettings()
                    .rarity(Rarity.RARE).fireproof()));
    public static final Item PYRONITE_HOE = registerItem("pyronite_hoe",
            new HoeItem(ModToolMaterial.PYRONITE, 1, -3,
                    new FabricItemSettings()
                    .rarity(Rarity.RARE).fireproof()));
    //2 use
    public static final  Item PYRONITE_AXEL = registerItem("pyronite_axel",
            new AxelItem(2, -3, ModToolMaterial.PYRONITE,
                    CustomBlockTags.AXEL_MINEABLE, new FabricItemSettings().rarity(Rarity.RARE).fireproof()));

    public static final  Item PYRONITE_ADZE = registerItem("pyronite_adze",
            new AdzeItem(2, -3, ModToolMaterial.PYRONITE,
                    CustomBlockTags.ADZE_MINEABLE, new FabricItemSettings().rarity(Rarity.RARE).fireproof()));

    public static final  Item PYRONITE_SCYTHE = registerItem("pyronite_scythe",
            new ScytheItem(2, -3, ModToolMaterial.PYRONITE,
                    CustomBlockTags.SCYTHE_MINEABLE, new FabricItemSettings().rarity(Rarity.RARE).fireproof()));

    public static final  Item PYRONITE_TROWEL = registerItem("pyronite_trowel",
            new TrowelItem(2, -3, ModToolMaterial.PYRONITE,
                    CustomBlockTags.TROWEL_MINEABLE, new FabricItemSettings().rarity(Rarity.RARE).fireproof()));

    public static final  Item PYRONITE_MATTOCK = registerItem("pyronite_mattock",
            new MattockItem(2, -3, ModToolMaterial.PYRONITE,
                        CustomBlockTags.MATTOCK_MINEABLE, new FabricItemSettings().rarity(Rarity.RARE).fireproof()));

    public static final  Item PYRONITE_CUTTER_MATTOCK = registerItem("pyronite_cutter_mattock",
            new CutterMattockItem(2, -3, ModToolMaterial.PYRONITE,
                    CustomBlockTags.CUTTER_MATTOCK_MINEABLE, new FabricItemSettings().rarity(Rarity.RARE).fireproof()));



    //3use
    public static final Item PYRONITE_PAXEL = registerItem("pyronite_paxel",
            new PaxelItem(5.5f, -3.0f, ModToolMaterial.PYRONITE,
                    CustomBlockTags.PAXEL_MINEABLE, new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static final Item PYRONITE_CUTTER = registerItem("pyronite_cutter",
            new CutterItem(5.5f, -3.0f, ModToolMaterial.PYRONITE,
                    CustomBlockTags.PAXEL_MINEABLE, new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static final Item PYRONITE_RIPPER = registerItem("pyronite_ripper",
            new RipperItem(5.5f, -3.0f, ModToolMaterial.PYRONITE,
                    CustomBlockTags.PAXEL_MINEABLE, new FabricItemSettings().rarity(Rarity.RARE).fireproof()));


    //TERRABREAKER
    public static final Item PYRONITE_TERRA_BREAKER = registerItem("pyronite_terra_breaker",
            new TerraBreakerItem(5.5f, -3.0f, ModToolMaterial.PYRONITE,
                    CustomBlockTags.TERRABREAKER_MINEABLE, new FabricItemSettings().rarity(Rarity.RARE).fireproof()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(VanillaExpansion.MOD_ID, name), item);
    }

    public static void registerModItems() {
        VanillaExpansion.LOGGER.info("registering mod items for " + VanillaExpansion.MOD_ID);
    }
}
