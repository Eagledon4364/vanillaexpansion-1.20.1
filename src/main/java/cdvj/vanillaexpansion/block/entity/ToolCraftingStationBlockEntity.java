package cdvj.vanillaexpansion.block.entity;

import cdvj.vanillaexpansion.item.ModItems;
import cdvj.vanillaexpansion.registry.ModBlockEntityType;
import cdvj.vanillaexpansion.screen.ToolCraftingStationScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ToolCraftingStationBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(6, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    public ToolCraftingStationBlockEntity(BlockPos pos, BlockState state) {
        
        super(ModBlockEntityType.TOOL_CRAFTING_STATION, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return ToolCraftingStationBlockEntity.this.progress;
                    case 1: return ToolCraftingStationBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }
            public void set(int index, int value) {
                switch (index) {
                    case 0: ToolCraftingStationBlockEntity.this.progress = value; break;
                    case 1: ToolCraftingStationBlockEntity.this.maxProgress = value; break;
                }

            }
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("tool_crafting_station");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ToolCraftingStationScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("tool_crafting_station.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("tool_crafting_station.progress");
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, ToolCraftingStationBlockEntity entity) {
        if(world.isClient()) {
            return;
        }
        if(hasrecipe(entity)) {
            entity.progress++;
            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(ToolCraftingStationBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }
        if(hasrecipe(entity)) {
            entity.removeStack(2, 1);
            entity.removeStack(0, 1);

            entity.setStack(5, new ItemStack(ModItems.PYRONITE_AXE, entity.getStack(5).getCount() +
                    1));
        }

        
    }

    private static boolean hasrecipe(ToolCraftingStationBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }
        boolean hasToolItemInSlot = entity.getStack(2).getItem() == ModItems.BASE_TOOL;
        boolean hasUpgradeItemInSlot = entity.getStack(0).getItem() == ModItems.AXE_UPRGADE;

        return hasToolItemInSlot && hasUpgradeItemInSlot && canInsertAmountInOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, ModItems.PYRONITE_AXE);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(5).getItem() == output || inventory.getStack(5).isEmpty();
    }

    private static boolean canInsertAmountInOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(5).getMaxCount() > inventory.getStack(5).getCount();
    }
}
