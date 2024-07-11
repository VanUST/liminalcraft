package net.vanust.liminalcraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.block.LiminalCraftBlocks;
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

        this.tag(LiminalCraftTags.Blocks.IS_FLOOR).add(LiminalCraftBlocks.BASIC_FLOOR.get())
                .add(LiminalCraftBlocks.BASIC_FLOOR_LIGHT.get());
    }
}
