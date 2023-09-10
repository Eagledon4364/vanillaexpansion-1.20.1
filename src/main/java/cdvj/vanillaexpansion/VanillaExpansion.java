package cdvj.vanillaexpansion;

import cdvj.vanillaexpansion.block.ModBlocks;
import cdvj.vanillaexpansion.datagen.ModRecipeProvider;
import cdvj.vanillaexpansion.item.ModItemGroups;
import cdvj.vanillaexpansion.item.ModItems;
import cdvj.vanillaexpansion.util.ModFlammableBlocks;
import cdvj.vanillaexpansion.util.ModStrippableBlocks;
import cdvj.vanillaexpansion.world.feature.ModConfiguredFeatures;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaExpansion implements ModInitializer {
	public static final String MOD_ID = "vanillaexpansion";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModFlammableBlocks.registerFlammableBlocks();
		ModStrippableBlocks.registerStrippables();

		ModConfiguredFeatures.registerConfiguredFeatures();






		LOGGER.info("Vanilla Expansion Modpack made by Eagledon4364");
	}
}
