package cdvj.vanillaexpansion.block;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class CustomBlockTags {
    public static final TagKey<Block> WILLOW_LOGS = of("willow_logs");
    public static final TagKey<Block> REDWOOD_LOGS = of("redwood_logs");


    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(id));
    }

}
