package net.vanust.liminalcraft.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.vanust.liminalcraft.LiminalCraft;

public class LiminalCraftTags {
    public  static  class Blocks{

        public static final TagKey<Block> IS_WALL = tag("is_wall");



        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(LiminalCraft.MOD_ID,name));
        }

    }

    public  static  class Items{

    }

}
