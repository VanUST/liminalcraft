package net.vanust.liminalcraft.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.vanust.liminalcraft.block.LiminalCraftBlocks;
import net.vanust.liminalcraft.item.LiminalCraftItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(LiminalCraftBlocks.YELLOW_WALLPAPER.get());
        this.dropSelf(LiminalCraftBlocks.YELLOW_WALLPAPER_SLAB.get());
        this.dropSelf(LiminalCraftBlocks.YELLOW_WALLPAPER_WORSE.get());
        this.dropSelf(LiminalCraftBlocks.BASIC_FLOOR_0.get());
        this.dropSelf(LiminalCraftBlocks.BASIC_FLOOR_LIGHT_0.get());
        this.dropSelf(LiminalCraftBlocks.BASIC_STAIRS_0.get());
        this.dropSelf(LiminalCraftBlocks.BASIC_SLAB_0.get());
        this.dropSelf(LiminalCraftBlocks.BASIC_LIGHT_SLAB_0.get());
//        this.dropSelf(LiminalCraftBlocks.END_OF_STRUCTURE.get());
//        this.dropSelf(LiminalCraftBlocks.METAL_LADDER.get());
//        this.dropSelf(LiminalCraftBlocks.CEILING_LIGHT_1.get());
        this.add(LiminalCraftBlocks.CEILING_LIGHT_1.get(),block -> createProbDrop(LiminalCraftBlocks.CEILING_LIGHT_1.get(), LiminalCraftItems.GLASS_SHARD.get(),0.5F));
//        this.add(ModBlocks.SAPPHIRE_ORE.get(),
//                block -> createCopperLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
    }

//    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
//        return createSilkTouchDispatchTable(pBlock,
//                this.applyExplosionDecay(pBlock,
//                        LootItem.lootTableItem(item)
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
//                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))
//                                ;
//    }

    protected LootTable.Builder createProbDrop(Block pBlock, Item pItem, float probability) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(pBlock, ((LootPoolSingletonContainer.Builder)LootItem.lootTableItem(pItem).when(LootItemRandomChanceCondition.randomChance(probability))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))));

    }

    @Override
    protected Iterable<Block> getKnownBlocks(){

        return LiminalCraftBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
