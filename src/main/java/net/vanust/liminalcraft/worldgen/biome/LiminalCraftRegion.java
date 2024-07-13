package net.vanust.liminalcraft.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class LiminalCraftRegion extends Region {
    public LiminalCraftRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

//    @Override
//    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
//        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
////            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST,LiminalCraftBiomes.LEVEL_0_CORRIDORS);
//        });
//    }
}