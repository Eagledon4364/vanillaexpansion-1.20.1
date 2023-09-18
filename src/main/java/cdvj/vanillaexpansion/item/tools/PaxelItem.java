package cdvj.vanillaexpansion.item.tools;


import cdvj.vanillaexpansion.util.CustomBlockTags;
import cdvj.vanillaexpansion.util.LogRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class PaxelItem extends MiningToolItem {

    private final Map<Block, Block> logStrippingMap = new HashMap<>();

    public PaxelItem(float attackDamage, float attackSpeed, ToolMaterial material, TagKey<Block> effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, CustomBlockTags.PAXEL_MINEABLE, settings);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return state.isIn(BlockTags.LOGS) || super.canMine(state, world, pos, miner);
    }


    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isIn(BlockTags.LOGS)) {
            return getMaterial().getMiningSpeedMultiplier();
        }
        return super.getMiningSpeedMultiplier(stack, state);
    }



    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();

        if (player != null) {
            Block strippedLog = LogRegistry.getLogStrippingMap().get(state.getBlock());
            if (strippedLog != null) {
                if (!world.isClient) {
                    BlockState strippedState = strippedLog.getDefaultState()
                            .with(Properties.AXIS, state.get(Properties.AXIS));
                    world.setBlockState(pos, strippedState);
                    world.playSound(null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    stack.damage(1, player, (entity) -> entity.sendToolBreakStatus(context.getHand()));
                }
                return TypedActionResult.success(stack).getResult();
            }
            if (state.isIn(BlockTags.DIRT)) {
                if (!world.isClient) {
                    world.setBlockState(pos, Blocks.DIRT_PATH.getDefaultState(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
                    world.playSound(null, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    stack.damage(1, player, (entity) -> entity.sendToolBreakStatus(context.getHand()));
                }
                return TypedActionResult.success(stack).getResult();
            }
        }

        return TypedActionResult.fail(stack).getResult();
    }
}
