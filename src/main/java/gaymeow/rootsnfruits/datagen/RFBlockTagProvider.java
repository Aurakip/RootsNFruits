package gaymeow.rootsnfruits.datagen;

import gaymeow.rootsnfruits.block.RFBlocks;
import gaymeow.rootsnfruits.tags.RFTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class RFBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public RFBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(RFBlocks.SOUL_ROOTS);

        valueLookupBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(RFBlocks.SOUL_ROOTS);

        valueLookupBuilder(BlockTags.SOUL_SPEED_BLOCKS)
                .add(RFBlocks.SOUL_ROOTS);

        valueLookupBuilder(BlockTags.SUPPORTS_WARPED_FUNGUS);

        valueLookupBuilder(RFTags.Blocks.SUPPORTS_SOUL_FUNGUS)
                .addTag(BlockTags.SUPPORTS_WARPED_FUNGUS)
                .addTag(BlockTags.SOUL_SPEED_BLOCKS);
    }
}
