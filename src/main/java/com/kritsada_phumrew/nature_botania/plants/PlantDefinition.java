package com.kritsada_phumrew.nature_botania.plants;

/**
 * ข้อมูลพื้นฐานของพืชหนึ่งชนิดใน Nature Botania
 */
public record PlantDefinition(
        String id,
        String scientificName,
        String displayName,
        PlantType type,
        String texture
) {
    public enum PlantType {
        LEAVES
    }
}