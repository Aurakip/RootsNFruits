package gaymeow.rootsnfruits;

import gaymeow.rootsnfruits.block.RFBlocks;
import gaymeow.rootsnfruits.creativemodetab.RFCreativeModeTab;
import gaymeow.rootsnfruits.item.RFItems;
import gaymeow.rootsnfruits.registry.RFCompost;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RootsFruits implements ModInitializer {
	public static final String MOD_ID = "rootsnfruits";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}


	@Override
	public void onInitialize() {
		RFBlocks.registerAllBlocks();
		RFItems.registerAllItems();
		RFCreativeModeTab.registerTabs();
		RFCompost.registerCompost();

		LOGGER.info("The roots grow...");
	}


}
