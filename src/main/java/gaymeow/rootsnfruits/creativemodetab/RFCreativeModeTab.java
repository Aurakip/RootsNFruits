package gaymeow.rootsnfruits.creativemodetab;

import gaymeow.rootsnfruits.RootsFruits;
import gaymeow.rootsnfruits.block.RFBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class RFCreativeModeTab {
    public static final CreativeModeTab RootsFruitsTab = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, RootsFruits.id("rootsnfruitstab"),
            FabricCreativeModeTab.builder()
                    .icon(()->new ItemStack(RFBlocks.SOUL_ROOTS))
                    .title(Component.translatable("creativemodetab.rootsnfruits.rootsnfruitstab"))
                    .displayItems((parameters, output) -> {
                        output.accept(RFBlocks.SOUL_ROOTS);
                        output.accept(RFBlocks.SOUL_FUNGUS);
                        output.accept(RFBlocks.SOUL_WART_BLOCK);
                    })
                    .build());

    public static void registerTabs(){}
}
