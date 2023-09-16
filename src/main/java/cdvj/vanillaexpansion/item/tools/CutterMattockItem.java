package cdvj.vanillaexpansion.item.tools;

import cdvj.vanillaexpansion.util.CustomBlockTags;
import cdvj.vanillaexpansion.util.LogRegistry;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;

import java.util.Map;
import java.util.Optional;

public class CutterMattockItem extends MiningToolItem {
    public CutterMattockItem(float attackDamage, float attackSpeed, ToolMaterial material, TagKey<Block> effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, CustomBlockTags.CUTTER_MATTOCK_MINEABLE, settings);
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
