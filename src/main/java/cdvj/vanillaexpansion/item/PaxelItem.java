package cdvj.vanillaexpansion.item;

import cdvj.vanillaexpansion.util.CustomBlockTags;
import net.minecraft.block.Block;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;

public class PaxelItem extends MiningToolItem {
    public PaxelItem(float attackDamage, float attackSpeed, ToolMaterial material, TagKey<Block> effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, CustomBlockTags.PAXEL_MINEABLE, settings);
    }
}
