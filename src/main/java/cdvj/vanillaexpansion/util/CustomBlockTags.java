package cdvj.vanillaexpansion.util;


import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CustomBlockTags {

    public static final TagKey<Block> WILLOW_LOGS = of("willow_logs");
    public static final TagKey<Block> REDWOOD_LOGS = of("redwood_logs");


    //2
    public static final TagKey<Block> AXEL_MINEABLE = of("axel_mineable");
    public static final TagKey<Block> TROWEL_MINEABLE = of("trowel_mineable");
    public static final TagKey<Block> ADZE_MINEABLE = of("adze_mineable");
    public static final TagKey<Block> SCYTHE_MINEABLE = of("scythe_mineable");
    public static final TagKey<Block> MATTOCK_MINEABLE = of("mattock_mineable");
    public static final TagKey<Block> CUTTER_MATTOCK_MINEABLE = of("cutter_mattock_mineable");

    //3
    public static final TagKey<Block> PAXEL_MINEABLE = of("paxel_mineable");
    public static final TagKey<Block> CUTTER_MINEABLE = of("cutter_mineable");
    public static final TagKey<Block> RIPPER_MINEABLE = of("ripper_mineable");
    public static final TagKey<Block> SCOOP_MINEABLE = of("ripper_mineable");

    //4
    public static final TagKey<Block> TERRABREAKER_MINEABLE = of("terrabreaker_mineable");


    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(id));
    }

}
