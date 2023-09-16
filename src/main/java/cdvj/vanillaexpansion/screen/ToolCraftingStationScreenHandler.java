package cdvj.vanillaexpansion.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class ToolCraftingStationScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public ToolCraftingStationScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(6), new ArrayPropertyDelegate(2));
    }
    public ToolCraftingStationScreenHandler(int syncId, PlayerInventory playerInventory,
                                               Inventory inventory, PropertyDelegate delegate) {
        super(ModScreenHandlers.TOOL_CRAFTING_SCREEN_HANDLER, syncId);
        checkSize(inventory, 6);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
            this.propertyDelegate = delegate;

            this.addSlot(new Slot(inventory, 0,7 ,10 ));
            this.addSlot(new Slot(inventory, 1,79 ,10 ));
            this.addSlot(new Slot(inventory, 2,43 ,34 ));
            this.addSlot(new Slot(inventory, 3,7 ,57 ));
            this.addSlot(new Slot(inventory, 4,79 ,57 ));
            this.addSlot(new Slot(inventory, 5,141 ,30 ));




            addPlayerInventory(playerInventory);
            addPlayerHotbar(playerInventory);

            addProperties(delegate);


    }
    public boolean isCrafting() {
        return propertyDelegate.get(2) > 0;
    }
    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(2);
        int maxProgress = this.propertyDelegate.get(2);
        int progressArrowSize = 26;

        return maxProgress != 2 && progress != 2 ? progress * progressArrowSize / maxProgress : 2;
    }


    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = (Slot)this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot < 9 ? !this.insertItem(itemStack2, 9, 45, true) : !this.insertItem(itemStack2, 0, 9, false)) {
                return ItemStack.EMPTY;
            }
            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot2.onTakeItem(player, itemStack2);
        }
        return itemStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
    private void addPlayerInventory(PlayerInventory playerInventory) {
        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
    }
    private void addPlayerHotbar(PlayerInventory playerInventory) {
        int i;
        for (i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

    }
}
