package net.vanust.liminalcraft.block;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.block.custom.LiminalCraftLevelOnePortal;
import net.vanust.liminalcraft.block.custom.LiminalCraftLevelZeroPortal;
import net.vanust.liminalcraft.item.LiminalCraftItems;
import net.vanust.liminalcraft.worldgen.dimension.LiminalCraftLevels;

import java.util.function.Supplier;

public class LiminalCraftBlocks {


//    CASUAL BLOCKS
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LiminalCraft.MOD_ID);

    public static final RegistryObject<Block> YELLOW_WALLPAPER = registerBlock("yellow_wallpaper",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).strength(-1f,36f)));

    public static final RegistryObject<Block> YELLOW_WALLPAPER_WORSE = registerBlock("yellow_wallpaper_worse",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(-1f,36f)));

    public static final RegistryObject<Block> BASIC_FLOOR_0 = registerBlock("basic_floor_0",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(-1f,36f)));

    public static final RegistryObject<Block> BASIC_FLOOR_LIGHT_0 = registerBlock("basic_floor_light_0",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(-1f,36f)));

    public static final RegistryObject<Block> BASIC_STAIRS_0 = registerBlock("basic_stairs_light_0",
            () -> new StairBlock(() -> LiminalCraftBlocks.BASIC_FLOOR_0.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.STONE).strength(-1f,36f)));

    public static final RegistryObject<Block> BASIC_SLAB_0 = registerBlock("basic_slab_0",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(-1f,36f)));

    public static final RegistryObject<Block> BASIC_LIGHT_SLAB_0 = registerBlock("basic_slab_light_0",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(-1f,36f)));


    public static final RegistryObject<Block> END_OF_STRUCTURE = registerBlock("end_of_structure",() -> new AirBlock(BlockBehaviour.Properties.of().replaceable().noCollission().noLootTable().air()));

    public static final RegistryObject<Block> STRUCTURE_AIR = registerBlock("structure_air", () -> new AirBlock(BlockBehaviour.Properties.of().replaceable().noCollission().noLootTable().air()));


    public static final RegistryObject<Block> CEILING_LIGHT_1 = registerBlock("ceiling_light_1",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion().strength(1f,36f).sound(SoundType.GLASS)
                    .lightLevel((p_152607_) -> {
                        return 10;
                    })
                    , BlockSetType.GOLD)
            );

//    public static final RegistryObject<Block> METAL_LADDER = registerBlock("metal_ladder",
//            () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).strength(1F,5F))
//    );

    //    SPECIAL BLOCKS
    public static final RegistryObject<Block> LEVEL_0_PORTAL = registerBlock("level_0_portal",
            () -> new LiminalCraftLevelZeroPortal(BlockBehaviour.Properties.copy(Blocks.END_PORTAL).strength(-1f,36f).noCollission().noOcclusion().noLootTable()));

    public static final RegistryObject<Block> LEVEL_1_PORTAL = registerBlock("level_1_portal",
            () -> new LiminalCraftLevelOnePortal(BlockBehaviour.Properties.copy(Blocks.END_PORTAL).strength(-1f,36f).noCollission().noOcclusion().noLootTable()));





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

//    public static ResourceKey<Level> check_dimension(Entity pPlayer){
//
//        if (pPlayer.level().dimension() == Level.OVERWORLD){ return Level.OVERWORLD;}
//        if (pPlayer.level().dimension() == LiminalCraftLevels.LEVEL_0_KEY){ return Le;}
//        player.level().dimension() == LiminalCraftLevels.LEVEL_0_KEY ?
//                Level.OVERWORLD : LiminalCraftLevels.LEVEL_0_KEY;
//    }
}
