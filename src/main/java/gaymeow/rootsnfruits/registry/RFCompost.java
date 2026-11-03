package gaymeow.rootsnfruits.registry;

import gaymeow.rootsnfruits.block.RFBlocks;
import net.fabricmc.fabric.api.registry.CompostableRegistry;

public class RFCompost {
    public static void registerCompost(){
        CompostableRegistry.INSTANCE.add(RFBlocks.SOUL_FUNGUS,0.65f);
        CompostableRegistry.INSTANCE.add(RFBlocks.SOUL_WART_BLOCK,0.85f);
    }
}
