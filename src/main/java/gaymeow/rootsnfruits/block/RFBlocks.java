package gaymeow.rootsnfruits.block;

import gaymeow.rootsnfruits.RootsFruits;
import gaymeow.rootsnfruits.tags.RFTags;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;


public class RFBlocks {

    public static final Block SOUL_ROOTS = registerBlock("soul_roots",
            properties -> new Block(properties.strength(0.5f).mapColor(MapColor.COLOR_BROWN).sound(SoundType.SOUL_SOIL)));
    public static final Block SOUL_FUNGUS = registerBlock("soul_fungus",
            properties -> new NetherFungusBlock(TreeFeatures.OAK, Blocks.SOUL_SOIL, RFTags.Blocks.SUPPORTS_SOUL_FUNGUS,
                    properties.mapColor(MapColor.COLOR_LIGHT_BLUE).instabreak().noCollision().sound(SoundType.FUNGUS).pushReaction(PushReaction.DESTROY).lightLevel(_ ->7)));
    public static final Block POTTED_SOUL_FUNGUS = registerBlockNoItem("potted_soul_fungus",
            properties -> new FlowerPotBlock(SOUL_FUNGUS,properties));
    public static final Block SOUL_WART_BLOCK = registerBlock("soul_wart_block",
            properties -> new Block(properties.strength(1f).lightLevel(_->7).sound(SoundType.WART_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE)));



    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function){
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.
                create(Registries.BLOCK,RootsFruits.id(name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK,RootsFruits.id(name),toRegister);
    }

    private static Block registerBlockNoItem(String name, Function<BlockBehaviour.Properties, Block> function){
        return Registry.register(BuiltInRegistries.BLOCK, RootsFruits.id(name),
                function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,RootsFruits.id(name)))));
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(BuiltInRegistries.ITEM, RootsFruits.id(name),new BlockItem(block, new Item.Properties()
            .useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM,RootsFruits.id(name)))));
    }

    public static void  registerAllBlocks(){}
}
