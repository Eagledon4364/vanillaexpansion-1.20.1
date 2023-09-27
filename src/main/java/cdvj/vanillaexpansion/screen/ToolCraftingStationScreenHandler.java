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
        this(syncId, playerInventory, new SimpleInventory(3), new ArrayPropertyDelegate(2));
    }
    public ToolCraftingStationScreenHandler(int syncId, PlayerInventory playerInventory,
                                               Inventory inventory, PropertyDelegate delegate) {
        super(ModScreenHandlers.TOOL_CRAFTING_SCREEN_HANDLER, syncId);
        checkSize(inventory, 3);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
            this.propertyDelegate = delegate;

            this.addSlot(new Slot(inventory, 0,21 ,35 ));
            this.addSlot(new Slot(inventory, 1,60 ,35 ));
            this.addSlot(new Slot(inventory, 2,128 ,35 ));




            addPlayerInventory(playerInventory);
            addPlayerHotbar(playerInventory);

            addProperties(delegate);


    }
    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }
    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int progressArrowSize = 24;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }




    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        Slot slot = this.slots.get(slotIndex);

        if (slot != null && slot.hasStack()) {
            ItemStack stackInSlot = slot.getStack();
            ItemStack stackToMove = stackInSlot.copy();

            if (slotIndex < 2) {
                // If the clicked slot is one of your ingredient slots, try to move it to the player's inventory
                if (!this.insertItem(stackInSlot, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (slotIndex == 2) {
                // If the clicked slot is the output slot, try to move it to the player's inventory
                if (!this.insertItem(stackInSlot, 3, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // If the clicked slot is in the player's inventory, try to move it to your ingredient slots
                if (!this.insertItem(stackInSlot, 0, 2, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stackInSlot.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            if (stackInSlot.getCount() == stackToMove.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, stackToMove);
        }

        return ItemStack.EMPTY;
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
