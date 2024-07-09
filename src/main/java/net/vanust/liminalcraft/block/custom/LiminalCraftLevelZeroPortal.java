package net.vanust.liminalcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.vanust.liminalcraft.worldgen.dimension.LiminalCraftLevels;
import net.vanust.liminalcraft.worldgen.portal.LiminalCraftTeleports;

public class LiminalCraftLevelZeroPortal extends Block {
    public LiminalCraftLevelZeroPortal(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.canChangeDimensions()) {
            handlePortal(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    private void handlePortal(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> resourcekey = player.level().dimension() == LiminalCraftLevels.LEVEL_0_KEY ?
                    Level.OVERWORLD : LiminalCraftLevels.LEVEL_0_KEY;

            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            if (portalDimension != null && !player.isPassenger()) {
                if(resourcekey == LiminalCraftLevels.LEVEL_0_KEY) {
                    player.changeDimension(portalDimension, new LiminalCraftTeleports(pPos, true));
                } else {
                    player.changeDimension(portalDimension, new LiminalCraftTeleports(pPos, false));
                }
            }
        }
    }
}
