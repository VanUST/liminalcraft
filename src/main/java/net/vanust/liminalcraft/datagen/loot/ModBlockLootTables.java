package net.vanust.liminalcraft.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.vanust.liminalcraft.block.LiminalCraftBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(LiminalCraftBlocks.YELLOW_WALLPAPER.get());
        this.dropSelf(LiminalCraftBlocks.YELLOW_WALLPAPER_WORSE.get());
        this.dropSelf(LiminalCraftBlocks.BASIC_FLOOR.get());
        this.dropSelf(LiminalCraftBlocks.BASIC_FLOOR_LIGHT.get());
//        this.add(ModBlocks.SAPPHIRE_ORE.get(),
//                block -> createCopperLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
    }

//    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
//        return createSilkTouchDispatchTable(pBlock,
//                this.applyExplosionDecay(pBlock,
//                        LootItem.lootTableItem(item)
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
//                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
//    }

    @Override
    protected Iterable<Block> getKnownBlocks(){

        return LiminalCraftBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
