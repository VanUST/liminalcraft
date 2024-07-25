package net.vanust.liminalcraft.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.worldgen.LiminalCraftBiomeModifiers;
import net.vanust.liminalcraft.worldgen.LiminalCraftNoiseSettings;
import net.vanust.liminalcraft.worldgen.biome.LiminalCraftBiomes;
import net.vanust.liminalcraft.worldgen.dimension.LiminalCraftLevels;

import java.util.Set;
import java.util.concurrent.CompletableFuture;


public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
//            .add(Registries.NOISE_SETTINGS, LiminalCraftNoiseSettings::boostrap)
            .add(Registries.DIMENSION_TYPE, LiminalCraftLevels::bootstrapType)
//            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
//            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
//            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, LiminalCraftBiomeModifiers::bootstrap)
            .add(Registries.BIOME, LiminalCraftBiomes::boostrap)

            .add(Registries.LEVEL_STEM, LiminalCraftLevels::bootstrapStem);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {

        super(output, registries, BUILDER, Set.of(LiminalCraft.MOD_ID));
    }
}
