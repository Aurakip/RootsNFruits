package gaymeow.rootsnfruits.block;

import gaymeow.rootsnfruits.RootsFruits;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class RFBlocks {

    public static final Block SOUL_ROOTS = registerBlock("soul_roots",
            properties -> new Block(properties.strength(0.5f).mapColor(MapColor.COLOR_BROWN).sound(SoundType.SOUL_SOIL)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function){
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.
                create(Registries.BLOCK,RootsFruits.id(name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK,RootsFruits.id(name),toRegister);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(BuiltInRegistries.ITEM, RootsFruits.id(name),new BlockItem(block, new Item.Properties()
            .useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM,RootsFruits.id(name)))));
    }

    public static void  registerAllBlocks(){}
}
