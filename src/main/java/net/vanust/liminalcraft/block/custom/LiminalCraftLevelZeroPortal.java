package net.vanust.liminalcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.RelativeMovement;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.vanust.liminalcraft.worldgen.dimension.LiminalCraftLevels;
import net.vanust.liminalcraft.worldgen.portal.LiminalCraftTeleports;

import java.io.Console;
import java.util.Random;
import java.util.logging.ConsoleHandler;


public class LiminalCraftLevelZeroPortal extends Block {

    public static Random normal_random = new Random();

    public LiminalCraftLevelZeroPortal(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.canChangeDimensions()) {
            handlePortal(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }

    private void handlePortal(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> resourcekey = LiminalCraftLevels.LEVEL_0_KEY;
//            player.sendSystemMessage(Component.literal(resourcekey.toString()));
            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            player.teleportTo(portalDimension,(int)(player.getX()  + normal_random.nextGaussian(0,1000)),100,(int)(player.getZ() + normal_random.nextGaussian(0,1000)),
                    RelativeMovement.ALL,0,0);
//            if (portalDimension != null && !player.isPassenger()) {
//                player.changeDimension(portalDimension, new LiminalCraftTeleports(pPos, true, true, LiminalCraftLevelZeroPortal.this));
//            }
        }
    }
}
