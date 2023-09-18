package cdvj.vanillaexpansion.block.entity;

import cdvj.vanillaexpansion.block.ModBlockEntities;
import cdvj.vanillaexpansion.item.ModItems;
import cdvj.vanillaexpansion.recipe.ToolCraftingRecipe;
import cdvj.vanillaexpansion.screen.ToolCraftingStationScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
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

import java.util.Optional;

public class ToolCraftingStationBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(3, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 50;
    public ToolCraftingStationBlockEntity(BlockPos pos, BlockState state) {
        
        super(ModBlockEntities.TOOL_CRAFTING_STATION, pos, state);
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
    public void markDirty() {
        super.markDirty();
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

        Optional<ToolCraftingRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(ToolCraftingRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasrecipe(entity)) {
            entity.removeStack(1, 1);
            entity.removeStack(0, 1);

            entity.setStack(2, new ItemStack(recipe.get().getOutput().getItem(),
                    entity.getStack(2).getCount() + 1));
            entity.resetProgress();
        }

        
    }

    private static boolean hasrecipe(ToolCraftingStationBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }
        Optional<ToolCraftingRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(ToolCraftingRecipe.Type.INSTANCE, inventory, entity.getWorld());

        return match.isPresent() && canInsertAmountInOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput().getItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(2).getItem() == output || inventory.getStack(5).isEmpty();
    }

    private static boolean canInsertAmountInOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }
}
