package net.vanust.liminalcraft.util;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.RelativeMovement;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.JigsawBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.Fluids;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.worldgen.dimension.LiminalCraftLevels;
//import net.vanust.liminalcraft.block.custom.LiminalCraftLevelZeroPortal;

import java.io.Console;
import java.util.Random;

public class LiminalCraftUtilityFunctions {

    public static Random normal_random = new Random();

    public static void spawn_template(ResourceLocation template_location, BlockPos structurePos, ServerLevel level){

        StructureTemplate template = level.getStructureManager().getOrCreate(template_location);
        if (template != null) {
            StructurePlaceSettings settings = new StructurePlaceSettings()
                    .setMirror(Mirror.NONE)
                    .setRotation(Rotation.NONE)
                    .setIgnoreEntities(false)
                    .addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);

            // Place the structure and handle entities
            template.placeInWorld(level, structurePos, structurePos, settings, RandomSource.create(), 2);
        }

    }


    public static void handle_portal(ResourceKey<Level> destination_level,Entity player, int y_level_spawn ,String level_number, String starting_jigsaw_size, boolean able_to_build, boolean clear_inventory) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ServerLevel portalDimension = minecraftserver.getLevel(destination_level);

            int random_x = (int) (player.getX() + normal_random.nextGaussian() * 5000);
            int random_z = (int) (player.getZ() + normal_random.nextGaussian() * 5000);

            BlockPos destpos = new BlockPos(random_x, y_level_spawn, random_z);

//            spawn_template(starting_fallback,destpos,portalDimension);


            player.teleportTo(portalDimension,random_x,y_level_spawn,random_z,
                    RelativeMovement.ALL,0,0);


            execute_command(player,"place jigsaw liminalcraft:"+level_number+"/basic_"+starting_jigsaw_size+" liminalcraft:"+starting_jigsaw_size+ " 6");

            BlockPos valid_spawn_point = LiminalCraftUtilityFunctions.find_nearest_room(portalDimension, destpos);

            if (!((Player) player).canUseGameMasterBlocks()) {
                LiminalCraftUtilityFunctions.execute_command(player, "spawnpoint @s " + valid_spawn_point.getX() + " " + valid_spawn_point.getY() + " " + valid_spawn_point.getZ());
            }

            player.teleportTo(valid_spawn_point.getX(), valid_spawn_point.getY(), valid_spawn_point.getZ());

            if (!((Player) player).canUseGameMasterBlocks()) {
                if (player instanceof Player){
                    if (clear_inventory){((Player) player).getInventory().clearContent();}
                    ((Player) player).getAbilities().mayBuild = able_to_build;
                }
            }
        }
    }

    public static void execute_command(Entity serverPlayer, String command){
        CommandSourceStack commandSourceStack = serverPlayer.createCommandSourceStack().withSuppressedOutput().withPermission(4);

        CommandDispatcher<CommandSourceStack> commanddispatcher = serverPlayer.getServer().getCommands().getDispatcher();
        ParseResults<CommandSourceStack> results = commanddispatcher.parse(command, commandSourceStack);
        int result = serverPlayer.getServer().getCommands().performCommand(results, command);
//        int result = serverPlayer.getServer().getCommands().performCommand();
    }

    public static BlockPos find_nearest_room(ServerLevel destinationWorld, BlockPos destinationPos) {
        int tries = 0;

        for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(1).west(100).north(100),
                destinationPos.above(1).east(100).south(100))) {

//            System.out.print(destinationWorld.getBlockState(checkPos).toString());
            // Check if checkPos is not an air block
            if (!destinationWorld.getBlockState(checkPos).isAir()) {

                // Check if the two blocks above checkPos are air blocks
                BlockPos posAbove1 = checkPos.above(1);
                BlockPos posAbove2 = checkPos.above(2);
                if (destinationWorld.getBlockState(posAbove1).isAir() && destinationWorld.getBlockState(posAbove2).isAir()) {

                    // Check if there is at least one non-air block within 10 blocks above checkPos
                    boolean hasNonAirBlockAbove = false;
                    for (int i = 1; i <= 10; i++) {
                        BlockPos posAbove = checkPos.above(i);
                        if (!destinationWorld.getBlockState(posAbove).isAir()) {
                            hasNonAirBlockAbove = true;
                            break;
                        }
                    }

                    if (hasNonAirBlockAbove) {
                        // This checkPos satisfies all conditions
                        return checkPos.above();
                    }
                }
            }
        }

        return destinationPos;
    }
}
