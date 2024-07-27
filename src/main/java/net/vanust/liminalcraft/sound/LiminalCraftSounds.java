package net.vanust.liminalcraft.sound;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vanust.liminalcraft.LiminalCraft;

public class LiminalCraftSounds {
    public static DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LiminalCraft.MOD_ID);

    public static final RegistryObject<SoundEvent> CEILING_LIGHT_BUZZ = registerSoundEvents("ceiling_light_buzz");
    public static final RegistryObject<SoundEvent> LEVEL_0_AMBIENT_MUSIC_1 = registerSoundEvents("level_0_ambient_music_1");

//    public  static final ForgeSoundType CEILING_LIGHT_BUZZ_TYPE = new ForgeSoundType(1f,1f, SoundEvents.GLASS_BREAK,
//            SoundEvents.GLASS_STEP, SoundEvents.)

    public static RegistryObject<SoundEvent> registerSoundEvents(String name){
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(LiminalCraft.MOD_ID,name)));
    }

    public static void register(IEventBus bus){
        SOUND_EVENTS.register(bus);
    }
}
