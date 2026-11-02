package gaymeow.rootsnfruits.datagen;

import gaymeow.rootsnfruits.block.RFBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.TexturedModel;

public class RFModelProvider extends FabricModelProvider {
    public RFModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialBlock(RFBlocks.SOUL_ROOTS, TexturedModel.COLUMN_ALT);
        blockModelGenerators.createPlantWithDefaultItem(RFBlocks.SOUL_FUNGUS,RFBlocks.POTTED_SOUL_FUNGUS, BlockModelGenerators.PlantType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}
