package net.vanust.liminalcraft.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.block.LiminalCraftBlocks;


public class CreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LiminalCraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LIMINAL_TAB =
            CREATIVE_MOD_TABS.register("liminal_tab",
                    () -> CreativeModeTab.builder().icon(
                            () -> new ItemStack(LiminalCraftItems.LEVEL_0_SIGN.get()))
                            .title(Component.translatable("creativetab.liminal_tab"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(LiminalCraftItems.LEVEL_0_SIGN.get());
                                pOutput.accept(LiminalCraftItems.PIECE_OF_YELLOW_WALLPAPER.get());
                                pOutput.accept(LiminalCraftItems.FLASHLIGHT_ITEM.get());
                                pOutput.accept(LiminalCraftItems.REVOLVER_ITEM.get());
                                pOutput.accept(LiminalCraftBlocks.YELLOW_WALLPAPER.get());
                                pOutput.accept(LiminalCraftBlocks.YELLOW_WALLPAPER_WORSE.get());
                                pOutput.accept(LiminalCraftBlocks.LEVEL_0_PORTAL.get());
                                pOutput.accept(LiminalCraftBlocks.YELLOW_WALLPAPER_SLAB.get());
                                pOutput.accept(LiminalCraftBlocks.YELLOW_WALLPAPER_SLAB_1.get());
                                pOutput.accept(LiminalCraftBlocks.LEVEL_1_PORTAL.get());
                                pOutput.accept(LiminalCraftBlocks.BASIC_FLOOR_0.get());
                                pOutput.accept(LiminalCraftBlocks.BASIC_FLOOR_LIGHT_0.get());
                                pOutput.accept(LiminalCraftBlocks.BASIC_LIGHT_SLAB_0.get());
                                pOutput.accept(LiminalCraftBlocks.BASIC_SLAB_0.get());
                                pOutput.accept(LiminalCraftBlocks.BASIC_STAIRS_0.get());
                                pOutput.accept(LiminalCraftBlocks.YELLOW_WALLPAPER_1.get());
                                pOutput.accept(LiminalCraftItems.GLASS_SHARD.get());
                                pOutput.accept(LiminalCraftBlocks.LEVEL_0_CEILING.get());
                                pOutput.accept(LiminalCraftBlocks.LEVEL_0_CEILING_LIGHTS.get());
                                pOutput.accept(LiminalCraftBlocks.LEVEL_0_CEILING_LIGHTS_WEAK.get());
                                pOutput.accept(LiminalCraftBlocks.LEVEL_0_CEILING_LIGHTS_OFF.get());
                                pOutput.accept(LiminalCraftItems.SMALL_BATTERY.get());
                                pOutput.accept(LiminalCraftBlocks.END_OF_STRUCTURE.get());
                                pOutput.accept(LiminalCraftBlocks.STRUCTURE_AIR.get());
                            })
                            .build());


    public static void register(IEventBus eventBus){

        CREATIVE_MOD_TABS.register(eventBus);

    }
}
