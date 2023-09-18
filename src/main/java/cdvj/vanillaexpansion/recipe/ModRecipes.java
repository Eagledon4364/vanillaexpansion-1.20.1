package cdvj.vanillaexpansion.recipe;

import cdvj.vanillaexpansion.VanillaExpansion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(VanillaExpansion.MOD_ID, ToolCraftingRecipe.Serializer.ID),
                ToolCraftingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(VanillaExpansion.MOD_ID, ToolCraftingRecipe.Type.ID),
                ToolCraftingRecipe.Type.INSTANCE);
    }
}
