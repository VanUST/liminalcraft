package net.vanust.liminalcraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
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
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
