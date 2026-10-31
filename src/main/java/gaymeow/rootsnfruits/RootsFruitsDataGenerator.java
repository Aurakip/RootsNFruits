package gaymeow.rootsnfruits;

import gaymeow.rootsnfruits.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class RootsFruitsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(RFModelProvider::new);
		pack.addProvider(RFBlockTagProvider	::new);
		pack.addProvider(RFBlockLootTableProvider::new);
		pack.addProvider(RFRecipeProvider::new);
		pack.addProvider(RFItemTagProvider::new);
	}
}
