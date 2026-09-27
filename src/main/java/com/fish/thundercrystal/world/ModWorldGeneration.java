package com.fish.thundercrystal.world;

import com.fish.thundercrystal.ThunderCrystal;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModWorldGeneration {
    public static final RegistryKey<PlacedFeature> THUNDER_CRYSTAL_ORE_PLACED =
            RegistryKey.of(
                    RegistryKeys.PLACED_FEATURE,
                    ThunderCrystal.id("thunder_crystal_ore")
            );

    public static void generationModWorldGen() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.VEGETAL_DECORATION,
                THUNDER_CRYSTAL_ORE_PLACED
        );
    }
}
