package net.vanust.liminalcraft.datagen;

import me.clumsycat.furnitureexpanded.registries.RegistryHandler;
import me.clumsycat.furnitureexpanded.blocks.tileentities.CardboxTileEntity;
import net.mehvahdjukaar.supplementaries.reg.ModRegistry;
import net.mehvahdjukaar.supplementaries.common.block.blocks.RedstoneIlluminatorBlock;
import net.mehvahdjukaar.supplementaries.forge.SupplementariesForge;
import net.mehvahdjukaar.supplementaries.forge.SupplementariesForgeClient;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.block.LiminalCraftBlocks;
import net.vanust.liminalcraft.item.LiminalCraftItems;
import net.vanust.liminalcraft.util.LiminalCraftTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LiminalCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(LiminalCraftTags.Blocks.IS_WALL)
                .add(LiminalCraftBlocks.YELLOW_WALLPAPER.get())
                .add(LiminalCraftBlocks.YELLOW_WALLPAPER_WORSE.get());

        this.tag(LiminalCraftTags.Blocks.IS_FLOOR).add(LiminalCraftBlocks.BASIC_FLOOR_0.get())
                .add(LiminalCraftBlocks.BASIC_FLOOR_LIGHT_0.get());

        this.tag(LiminalCraftTags.Blocks.NOT_REPLACE).add(LiminalCraftBlocks.END_OF_STRUCTURE.get())
                .add(LiminalCraftBlocks.STRUCTURE_AIR.get()).add(LiminalCraftBlocks.BASIC_STAIRS_0.get())
                .add(LiminalCraftBlocks.YELLOW_WALLPAPER_SLAB.get())
                .add((LiminalCraftBlocks.BASIC_SLAB_0.get()))
                .add((LiminalCraftBlocks.BASIC_LIGHT_SLAB_0.get()))
                .add(RegistryHandler.CARDBOX.get())
//                .add(ModRegistry.REDSTONE_ILLUMINATOR.get())
                ;
    }
}
