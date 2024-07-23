package net.vanust.liminalcraft;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.vanust.liminalcraft.block.LiminalCraftBlocks;
import net.vanust.liminalcraft.item.CreativeModTabs;
import net.vanust.liminalcraft.item.LiminalCraftItems;
import net.vanust.liminalcraft.loot.LiminalCraftLootModifiers;
import net.vanust.liminalcraft.worldgen.LiminalCraftNoiseSettings;
import net.vanust.liminalcraft.worldgen.biome.LiminalCraftTerraBlender;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(LiminalCraft.MOD_ID)
public class LiminalCraft
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "liminalcraft";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public LiminalCraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CreativeModTabs.register(modEventBus);

        LiminalCraftBlocks.register(modEventBus);

        LiminalCraftItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        LiminalCraftTerraBlender.registerBiomes();


        LiminalCraftLootModifiers.register(modEventBus);

        LiminalCraftStructureRegister.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
//        LiminalCraftNoiseSettings.register(modEventBus);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(LiminalCraftItems.PIECE_OF_YELLOW_WALLPAPER);
            event.accept(LiminalCraftItems.LEVEL_0_SIGN);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
