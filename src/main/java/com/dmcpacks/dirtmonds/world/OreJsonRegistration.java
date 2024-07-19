package com.dmcpacks.dirtmonds.world;

import com.dmcpacks.dirtmonds.Dirtmonds;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class OreJsonRegistration {
    public static final RegistryKey<PlacedFeature> DIRTMOND_SMALL_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Dirtmonds.MOD_ID,"dirtmond_ore_small"));
    public static final RegistryKey<PlacedFeature> DIRTMOND_MEDIUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Dirtmonds.MOD_ID,"dirtmond_ore_medium"));
    public static final RegistryKey<PlacedFeature> DIRTMOND_LARGE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Dirtmonds.MOD_ID,"dirtmond_ore_large"));
    public static void registerOreGeneration() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, DIRTMOND_SMALL_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, DIRTMOND_MEDIUM_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, DIRTMOND_LARGE_ORE_PLACED_KEY);
        System.out.println("Registered blocks");
    }
}
