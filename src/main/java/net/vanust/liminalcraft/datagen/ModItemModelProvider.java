package net.vanust.liminalcraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.block.LiminalCraftBlocks;
import net.vanust.liminalcraft.item.LiminalCraftItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LiminalCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

//        simpleItem(LiminalCraftItems.FLASHLIGHT_ITEM);
        simpleItem(LiminalCraftItems.LEVEL_0_SIGN);
        simpleItem(LiminalCraftItems.PIECE_OF_YELLOW_WALLPAPER);
        simpleItem(LiminalCraftItems.GLASS_SHARD);
        simpleItem(LiminalCraftItems.SMALL_BATTERY);
//        trapdoorItem(LiminalCraftBlocks.CEILING_LIGHT_1);

        evenSimplerBlockItem(LiminalCraftBlocks.BASIC_LIGHT_SLAB_0);
        evenSimplerBlockItem(LiminalCraftBlocks.BASIC_SLAB_0);
        evenSimplerBlockItem(LiminalCraftBlocks.YELLOW_WALLPAPER_SLAB);
        evenSimplerBlockItem(LiminalCraftBlocks.YELLOW_WALLPAPER_SLAB_1);
        evenSimplerBlockItem(LiminalCraftBlocks.BASIC_STAIRS_0);
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(LiminalCraft.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LiminalCraft.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(LiminalCraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(LiminalCraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(LiminalCraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LiminalCraft.MOD_ID,"item/" + item.getId().getPath()));
    }
}
