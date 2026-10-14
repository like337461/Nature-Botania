
package com.kritsada_phumrew.nature_botania.registry;

import java.util.LinkedHashMap;
import java.util.Map;

import com.kritsada_phumrew.nature_botania.NatureBotania;
import com.kritsada_phumrew.nature_botania.plants.PlantCatalog;
import com.kritsada_phumrew.nature_botania.plants.PlantDefinition;
import com.kritsada_phumrew.nature_botania.plants.PlantDefinition.PlantType;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {

    private ModBlocks() {}

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(NatureBotania.MODID);

    public static final Map<String, DeferredBlock<LeavesBlock>> LEAVES =
            new LinkedHashMap<>();

    static {
        for (PlantDefinition plant : PlantCatalog.PLANTS) {
            if (plant.type() == PlantType.LEAVES) {
                DeferredBlock<LeavesBlock> block =
                        BLOCKS.register(plant.id(), () ->
                                new LeavesBlock(
                                        BlockBehaviour.Properties.ofFullCopy(
                                                Blocks.OAK_LEAVES
                                        )
                                )
                        );

                LEAVES.put(plant.id(), block);
            }
        }
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
