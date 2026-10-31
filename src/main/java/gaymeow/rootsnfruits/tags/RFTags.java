package gaymeow.rootsnfruits.tags;

import gaymeow.rootsnfruits.RootsFruits;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class RFTags {
    public static class Blocks{
        public static final TagKey<Block> SUPPORTS_SOUL_FUNGUS = createTag("supports_soul_fungus");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, RootsFruits.id(name));
        }
    };
}
