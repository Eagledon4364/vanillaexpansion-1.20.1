package cdvj.vanillaexpansion.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<ToolCraftingStationScreenHandler> TOOL_CRAFTING_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        TOOL_CRAFTING_SCREEN_HANDLER = new ScreenHandlerType<>(ToolCraftingStationScreenHandler::new, null);
    }
}
