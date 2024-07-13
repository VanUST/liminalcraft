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
                                pOutput.accept(LiminalCraftBlocks.YELLOW_WALLPAPER.get());
                                pOutput.accept(LiminalCraftBlocks.YELLOW_WALLPAPER_WORSE.get());
                                pOutput.accept(LiminalCraftBlocks.LEVEL_0_PORTAL.get());
                                pOutput.accept(LiminalCraftBlocks.LEVEL_1_PORTAL.get());
                                pOutput.accept(LiminalCraftBlocks.BASIC_FLOOR.get());
                                pOutput.accept(LiminalCraftBlocks.BASIC_FLOOR_LIGHT.get());
                                pOutput.accept(LiminalCraftItems.GLASS_SHARD.get());
                                pOutput.accept(LiminalCraftBlocks.CEILING_LIGHT_1.get());
                            })
                            .build());


    public static void register(IEventBus eventBus){

        CREATIVE_MOD_TABS.register(eventBus);

    }
}
