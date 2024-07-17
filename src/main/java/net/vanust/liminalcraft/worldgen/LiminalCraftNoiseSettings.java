package net.vanust.liminalcraft.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.vanust.liminalcraft.LiminalCraft;

import java.io.Console;

public class LiminalCraftNoiseSettings {

//    public static final DeferredRegister<NoiseGeneratorSettings> LIMINAL_NOISE =
//            DeferredRegister.create(Registries.NOISE_SETTINGS, LiminalCraft.MOD_ID);

    public static final ResourceKey<NoiseGeneratorSettings> VOID_WORLD = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation("void_world"));

    public static void boostrap(BootstapContext<NoiseGeneratorSettings> pContext) {
        System.out.print("BUILDING NOISE SETTINGS LIMINAL CRAFT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        pContext.register(VOID_WORLD, NoiseGeneratorSettings.dummy());

    }

//    public static void register(IEventBus eventBus){
//
//        LIMINAL_NOISE.register(eventBus);
//
//    }

}
