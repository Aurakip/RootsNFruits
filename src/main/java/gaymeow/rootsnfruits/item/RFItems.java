package gaymeow.rootsnfruits.item;

import gaymeow.rootsnfruits.RootsFruits;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class RFItems {



    private static Item registerItem(String name, Function<Item.Properties, Item> function){
        return Registry.register(BuiltInRegistries.ITEM, RootsFruits.id(name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, RootsFruits.id(name)))));
    }

    public static void registerAllItems(){}
}
