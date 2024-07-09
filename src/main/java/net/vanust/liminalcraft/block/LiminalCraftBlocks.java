package net.vanust.liminalcraft.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.block.custom.LiminalCraftLevelZeroPortal;
import net.vanust.liminalcraft.item.LiminalCraftItems;

import java.util.function.Supplier;

public class LiminalCraftBlocks {


//    CASUAL BLOCKS
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LiminalCraft.MOD_ID);

    public static final RegistryObject<Block> YELLOW_WALLPAPER = registerBlock("yellow_wallpaper",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).strength(-1f,36f)));

    public static final RegistryObject<Block> YELLOW_WALLPAPER_WORSE = registerBlock("yellow_wallpaper_worse",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(-1f,36f)));





//    SPECIAL BLOCKS
    public static final RegistryObject<Block> LEVEL_0_PORTAL = registerBlock("level_0_portal",
            () -> new LiminalCraftLevelZeroPortal(BlockBehaviour.Properties.copy(Blocks.END_GATEWAY).strength(-1f,36f).noCollission().noOcclusion().noLootTable()));





    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem (String name, RegistryObject<T> block){
        return LiminalCraftItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }
}
