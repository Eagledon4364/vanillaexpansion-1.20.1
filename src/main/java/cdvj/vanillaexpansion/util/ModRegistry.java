package cdvj.vanillaexpansion.util;

import cdvj.vanillaexpansion.VanillaExpansion;
import cdvj.vanillaexpansion.block.ModBlocks;
import cdvj.vanillaexpansion.item.ModItems;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModRegistry {
    public static void registerStuff() {
        createPortal();
    }
    private static void createPortal() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.ANCIENT_STONE)
                .lightWithItem(ModItems.PULVERIZING_UPGRADE)
                .destDimID(new Identifier(VanillaExpansion.MOD_ID, "ancient_dimension"))
                .tintColor(0x00ff00)
                .registerPortal();
    }

}
