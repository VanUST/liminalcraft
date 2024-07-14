package net.vanust.liminalcraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.block.LiminalCraftBlocks;

public class ModBlockStateProvider extends BlockStateProvider {


    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LiminalCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        blockWithItem(LiminalCraftBlocks.YELLOW_WALLPAPER);
        blockWithItem(LiminalCraftBlocks.YELLOW_WALLPAPER_WORSE);
        blockWithItem(LiminalCraftBlocks.LEVEL_0_PORTAL);
        blockWithItem(LiminalCraftBlocks.BASIC_FLOOR);
        blockWithItem(LiminalCraftBlocks.BASIC_FLOOR_LIGHT);
        blockWithItem(LiminalCraftBlocks.LEVEL_1_PORTAL);
//        blockWithItem(LiminalCraftBlocks.CEILING_LIGHT_1);

        trapdoorBlockWithRenderType((TrapDoorBlock) LiminalCraftBlocks.CEILING_LIGHT_1.get(),
                modLoc("block/ceiling_light_1"),
                true,
                "cutoff");

//        blockWithItem(LiminalCraftBlocks.METAL_LADDER);
//        blockWithItem(LiminalCraftBlocks.CEILING_LIGHT_1);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    

}
