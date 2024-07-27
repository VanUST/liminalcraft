package net.vanust.liminalcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.RelativeMovement;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.BlockHitResult;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.network.ModNetworkHandler;
import net.vanust.liminalcraft.network.SyncStructurePacket;
import net.vanust.liminalcraft.util.LiminalCraftUtilityFunctions;
import net.vanust.liminalcraft.worldgen.dimension.LiminalCraftLevels;
import net.vanust.liminalcraft.worldgen.portal.LiminalCraftTeleports;

import java.io.Console;
import java.util.Objects;
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
            LiminalCraftUtilityFunctions.handle_portal(LiminalCraftLevels.LEVEL_0_KEY,pPlayer,256,"level_0","4_5",false, true);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }


}
