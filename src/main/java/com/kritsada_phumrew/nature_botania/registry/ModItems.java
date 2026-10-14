
package com.kritsada_phumrew.nature_botania.registry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.kritsada_phumrew.nature_botania.NatureBotania;
import com.kritsada_phumrew.nature_botania.plants.PlantCatalog;
import com.kritsada_phumrew.nature_botania.plants.PlantDefinition;
import com.kritsada_phumrew.nature_botania.plants.PlantDefinition.PlantType;

import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {

    private ModItems() {}

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(NatureBotania.MODID);

    public static final Map<String, DeferredItem<BlockItem>> BLOCK_ITEMS =
            new LinkedHashMap<>();

    static {
        for (PlantDefinition plant : PlantCatalog.PLANTS) {
            if (plant.type() == PlantType.LEAVES) {
                var block = Objects.requireNonNull(
                        ModBlocks.LEAVES.get(plant.id()),
                        "Missing leaf block: " + plant.id()
                );

                DeferredItem<BlockItem> item =
                        ITEMS.registerSimpleBlockItem(plant.id(), block);

                BLOCK_ITEMS.put(plant.id(), item);
            }
        }
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
