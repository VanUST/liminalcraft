package net.vanust.liminalcraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.vanust.liminalcraft.LiminalCraft;
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


    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LiminalCraft.MOD_ID,"item/" + item.getId().getPath()));
    }
}
