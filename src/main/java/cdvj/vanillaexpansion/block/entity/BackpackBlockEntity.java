package cdvj.vanillaexpansion.block.entity;

import cdvj.vanillaexpansion.block.ModBlockEntities;
import cdvj.vanillaexpansion.screen.BackpackScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ShulkerBoxScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class BackpackBlockEntity  extends LootableContainerBlockEntity implements ImplementedInventory {
    private DefaultedList<ItemStack> items = DefaultedList.ofSize(54, ItemStack.EMPTY);
    public static final String ITEMS_KEY = "Items";
    public BackpackBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BACKPACK, pos, state);
    }

    @Override
    public int size() {
        return this.items.size();
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public void markDirty() {
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.readInventoryNbt(nbt);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (!this.serializeLootTable(nbt)) {
            Inventories.writeNbt(nbt, this.items, false);
        }
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.backpack");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new BackpackScreenHandler(syncId, playerInventory, this);
    }

    public void readInventoryNbt(NbtCompound nbt) {
        this.items = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(nbt) && nbt.contains(ITEMS_KEY, NbtElement.LIST_TYPE)) {
            Inventories.readNbt(nbt, this.items);
        }
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.items;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.items = list;
    }
}
