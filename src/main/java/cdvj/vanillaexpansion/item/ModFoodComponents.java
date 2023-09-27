package cdvj.vanillaexpansion.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent STRAWBERRY = new FoodComponent.Builder().hunger(4).saturationModifier(0.8f).build();
    public static final FoodComponent STRAWBERRY_PIE = new FoodComponent.Builder().hunger(8).saturationModifier(1f).build();
}