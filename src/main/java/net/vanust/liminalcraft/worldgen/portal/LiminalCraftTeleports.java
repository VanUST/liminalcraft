package net.vanust.liminalcraft.worldgen.portal;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.util.ITeleporter;
import net.vanust.liminalcraft.block.LiminalCraftBlocks;
import net.vanust.liminalcraft.block.custom.LiminalCraftLevelZeroPortal;
import net.vanust.liminalcraft.worldgen.dimension.LiminalCraftLevels;

import java.lang.Object;
import java.util.Random;
import java.util.function.Function;

public class LiminalCraftTeleports implements ITeleporter {
    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideDimension = true;
    public static Random normal_random = new Random();
    public static boolean one_way_teleport;
    public static Block teleporter;
    public LiminalCraftTeleports(BlockPos pos, boolean insideDim, boolean one_way, Block portal_block) {
        thisPos = pos;
        insideDimension = insideDim;
        one_way_teleport = one_way;
        teleporter = portal_block;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destinationWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        int y = 150;

        if (!insideDimension) {
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(
                (int)(thisPos.getX()),  //+ normal_random.nextGaussian(0,10000)),
                (int)(y),//+  normal_random.nextGaussian(0,100)),
                (int)(thisPos.getZ()) //+ normal_random.nextGaussian(0,10000))
        );

        int tries = 0;
        while ((destinationWorld.getBlockState(destinationPos).getBlock() != Blocks.AIR) &&
                !destinationWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
                (destinationWorld.getBlockState(destinationPos.above()).getBlock()  != Blocks.AIR) &&
                !destinationWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && (tries < 100)) {
            destinationPos = destinationPos.above(2).east(2);
            tries++;
        }

        entity.setPos(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        if (!one_way_teleport) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(10).west(10),
                    destinationPos.above(10).east(10))) {
                if (destinationWorld.getBlockState(checkPos).getBlock() instanceof LiminalCraftLevelZeroPortal) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                destinationWorld.setBlock(destinationPos, teleporter.defaultBlockState(), 3);
            }
        }

        return entity;
    }
//    public static ResourceKey<Level> check_dimension(Entity pPlayer){
//
//        if (pPlayer.level().dimension() == Level.OVERWORLD){ return Level.OVERWORLD;}
//        if (pPlayer.level().dimension() == LiminalCraftLevels.LEVEL_0_KEY){ return LiminalCraftLevels.LEVEL_0_KEY;}
//
//        return Level.OVERWORLD;
//    }
}
