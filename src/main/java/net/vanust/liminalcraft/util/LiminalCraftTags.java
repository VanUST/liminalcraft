package net.vanust.liminalcraft.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.vanust.liminalcraft.LiminalCraft;

public class LiminalCraftTags {
    public  static  class Blocks{

        public static final TagKey<Block> IS_WALL = tag("is_wall");

        public static final TagKey<Block> IS_FLOOR = tag("is_floor");

        public static final TagKey<Block> IS_CEILING = tag("is_floor");

        public static final TagKey<Block> NOT_REPLACE = tag("not_replace");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(LiminalCraft.MOD_ID,name));
        }

    }

    public  static  class Items{
        public static final TagKey<Item> ENERGY_SOURCE = tag("energy_source");

        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(LiminalCraft.MOD_ID,name));
        }
    }
//
//    public static class Entities{
//        public static final TagKey<EntityType> SCP = tag("scp");
//
//        private static TagKey<EntityType> tag(String name){
//            return EntityTypeTags.create(new ResourceLocation(LiminalCraft.MOD_ID,name));
//        }
//    }

//    public  static  class Biomes{
//        public static final TagKey<Biome> LEVEL_0 = tag("level_0");
//
//        private static TagKey<Item> tag(String name){
//            return BiomeTags.create(new ResourceLocation(LiminalCraft.MOD_ID,name));
//        }
//    }

}
