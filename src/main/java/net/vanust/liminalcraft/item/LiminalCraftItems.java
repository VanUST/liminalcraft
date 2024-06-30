package net.vanust.liminalcraft.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vanust.liminalcraft.LiminalCraft;

public class LiminalCraftItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LiminalCraft.MOD_ID);

    public static final RegistryObject<Item> PIECE_OF_YELLOW_WALLPAPER =
            ITEMS.register("piece_of_yellow_wallpaper",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PIECE_OF_LAMP =
            ITEMS.register("piece_of_lamp",() -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }



}
