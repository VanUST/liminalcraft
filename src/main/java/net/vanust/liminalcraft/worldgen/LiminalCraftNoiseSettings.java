package net.vanust.liminalcraft.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.block.LiminalCraftBlocks;

import java.io.Console;
import java.util.List;

public class LiminalCraftNoiseSettings {



//    public static final DeferredRegister<NoiseGeneratorSettings> NOISE_REGISTER =
//            DeferredRegister.create(Registries.NOISE_SETTINGS, LiminalCraft.MOD_ID);
//////
//    public static final RegistryObject<NoiseGeneratorSettings> VOID_WORLD = NOISE_REGISTER.register("void_world",
//        () -> new NoiseGeneratorSettings(NoiseSettings.create(0,512,1,1), Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(),
//               new NoiseRouter(DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero())
//    , SurfaceRuleData.air(), List.of(), 63, true, false, false, false));
////
//    public static void register(IEventBus modEventBus){
//        NOISE_REGISTER.register(modEventBus);
//    }
    public static final ResourceKey<NoiseGeneratorSettings> LEVEL_0_WORLD = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation("liminalcraft:level_0_world"));

    public static void boostrap(BootstapContext<NoiseGeneratorSettings> pContext) {
//        System.out.print("BUILDING NOISE SETTINGS LIMINAL CRAFT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        pContext.register(LEVEL_0_WORLD, filled_world(LiminalCraftBlocks.BASIC_FLOOR_0.get()));

    }
    public static NoiseGeneratorSettings filled_world(Block pBlock) {
        NoiseSettings settings = NoiseSettings.create(0,512,1,1);
        SurfaceRules.RuleSource ruleSource = SurfaceRules.state(pBlock.defaultBlockState());
        NoiseRouter router = new NoiseRouter(DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero());
        return new NoiseGeneratorSettings(settings, pBlock.defaultBlockState(), Blocks.AIR.defaultBlockState(), router, ruleSource, List.of(), 63, false, false, false, false);
    }
//    public static void register(IEventBus eventBus){
//
//        LIMINAL_NOISE.register(eventBus);
//
//    }

}
