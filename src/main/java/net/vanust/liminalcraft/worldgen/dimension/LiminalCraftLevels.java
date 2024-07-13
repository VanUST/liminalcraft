package net.vanust.liminalcraft.worldgen.dimension;

import com.mojang.datafixers.util.Pair;
import net.vanust.liminalcraft.LiminalCraft;
//import net.kaupenjoe.tutorialmod.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.vanust.liminalcraft.worldgen.LiminalCraftNoiseSettings;
import net.vanust.liminalcraft.worldgen.biome.LiminalCraftBiomes;

import java.util.List;
import java.util.OptionalLong;

public class LiminalCraftLevels {
    public static final ResourceKey<LevelStem> LEVEL_0_STEM_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(LiminalCraft.MOD_ID, "level_0"));
    public static final ResourceKey<Level> LEVEL_0_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(LiminalCraft.MOD_ID, "level_0"));
    public static final ResourceKey<DimensionType> LEVEL_0_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(LiminalCraft.MOD_ID, "level_0_type"));

    public static final ResourceKey<LevelStem> LEVEL_1_STEM_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(LiminalCraft.MOD_ID, "level_1"));
    public static final ResourceKey<Level> LEVEL_1_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(LiminalCraft.MOD_ID, "level_1"));
    public static final ResourceKey<DimensionType> LEVEL_1_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(LiminalCraft.MOD_ID, "level_1_type"));


    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(LEVEL_0_TYPE, new DimensionType(
                OptionalLong.of(18000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                512, // height
                512, // logicalHeight
                BlockTags.BASE_STONE_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
        context.register(LEVEL_1_TYPE, new DimensionType(
                OptionalLong.of(18000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                512, // height
                512, // logicalHeight
                BlockTags.BASE_STONE_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(Biomes.DARK_FOREST)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator0 = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(Pair.of(
                                        Climate.parameters(0.3F, 0.0F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(LiminalCraftBiomes.LEVEL_0_CORRIDORS))
//                                Pair.of(
//                                        Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.BIRCH_FOREST)),
//                                Pair.of(
//                                        Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.OCEAN)),
//                                Pair.of(
//                                        Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.DARK_FOREST))

                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.END)
        );

        NoiseBasedChunkGenerator noiseBasedChunkGenerator1 = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(Pair.of(
                                        Climate.parameters(0.3F, 0.0F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(LiminalCraftBiomes.LEVEL_1_HALLS))
//                                Pair.of(
//                                        Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.BIRCH_FOREST)),
//                                Pair.of(
//                                        Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.OCEAN)),
//                                Pair.of(
//                                        Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.DARK_FOREST))

                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.END)
        );

        LevelStem stem1 = new LevelStem(dimTypes.getOrThrow(LiminalCraftLevels.LEVEL_1_TYPE), noiseBasedChunkGenerator0);
        LevelStem stem0 = new LevelStem(dimTypes.getOrThrow(LiminalCraftLevels.LEVEL_0_TYPE), noiseBasedChunkGenerator0);

        context.register(LEVEL_1_STEM_KEY, stem1);
        context.register(LEVEL_0_STEM_KEY, stem0);
    }
}