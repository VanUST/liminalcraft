package net.vanust.liminalcraft.client.handler;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.client.KeyBindings;

@Mod.EventBusSubscriber(modid = LiminalCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value =  Dist.CLIENT)
public class ClientModHandler {
//    @SubscribeEvent
//    public static void clientSetup(FMLClientSetupEvent event){
//        event.enqueueWork(()-> {
////            MenuScreens.register();
//        });
//    }
    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event){
        event.register(KeyBindings.INSTANCE.recharge);
    }
}
