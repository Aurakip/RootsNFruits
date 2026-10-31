package gaymeow.rootsnfruits.datagen;

import gaymeow.rootsnfruits.block.RFBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class RFRecipeProvider extends FabricRecipeProvider {
    public RFRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries,output) {
            @Override
            public void buildRecipes() {
                shapeless(RecipeCategory.BUILDING_BLOCKS, RFBlocks.SOUL_ROOTS)
                        .requires(Blocks.SOUL_SOIL)
                        .requires(Blocks.MANGROVE_ROOTS).unlockedBy(getHasName(Blocks.SOUL_SOIL), has(Blocks.SOUL_SOIL)).save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
