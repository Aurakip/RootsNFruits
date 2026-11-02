package gaymeow.rootsnfruits.tags;

import gaymeow.rootsnfruits.RootsFruits;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class RFTags {
    public static class Blocks{
        public static final TagKey<Block> SUPPORTS_SOUL_FUNGUS = createTag("supports_soul_fungus");
        public static final TagKey<Block> SOUL_GOLEM_CAN_SPAWN_FUNGUS_ON = createTag("soul_golem_can_spawn_fungus_on");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, RootsFruits.id(name));
        }
    }
}
