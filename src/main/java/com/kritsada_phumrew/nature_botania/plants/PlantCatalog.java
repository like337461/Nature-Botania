package com.kritsada_phumrew.nature_botania.plants;

import java.util.List;

import com.kritsada_phumrew.nature_botania.plants.PlantDefinition.PlantType;

public final class PlantCatalog {

    private PlantCatalog() {
        // ป้องกันการสร้าง instance ของคลาสนี้
    }

    public static final List<PlantDefinition> PLANTS = List.of(
            new PlantDefinition(
                    "siamese_rain_tree_leaves",
                    "Samanea saman",
                    "Siamese Rain Tree Leaves",
                    PlantType.LEAVES,
                    "block/siamese_rain_tree_leaves"
            ),

            new PlantDefinition(
                    "test_leaves",
                    "Unknown",
                    "Test Leaves",
                    PlantType.LEAVES,
                    "block/test_leaves"
            )
    );
}
