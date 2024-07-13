package net.vanust.liminalcraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.item.custom.FlashlightItem;

public class LiminalCraftItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LiminalCraft.MOD_ID);

    public static final RegistryObject<Item> PIECE_OF_YELLOW_WALLPAPER =
            ITEMS.register("piece_of_yellow_wallpaper",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEVEL_0_SIGN =
            ITEMS.register("level_0_sign",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLASHLIGHT_ITEM =
            ITEMS.register("flashlight_item",() -> new FlashlightItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> GLASS_SHARD =
            ITEMS.register("glass_shard",() -> new Item(new Item.Properties().stacksTo(64)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }



}
