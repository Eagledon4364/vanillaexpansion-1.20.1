package cdvj.vanillaexpansion.screen;

import cdvj.vanillaexpansion.VanillaExpansion;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ToolCraftingStationScreen extends HandledScreen<ToolCraftingStationScreenHandler> {
    public static final Identifier TEXTURE =
            new Identifier(VanillaExpansion.MOD_ID, "textures/gui/tool_crafting_station.png");
    public ToolCraftingStationScreen(ToolCraftingStationScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexColorProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawForeground(context, x, y, 0, 0, backgroundWidth, backgroundHeight);
        


    }

    private void drawForeground(DrawContext context, int x, int y, int i, int i1, int backgroundWidth, int backgroundHeight) {
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
        
    }
}
