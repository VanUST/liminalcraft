package net.vanust.liminalcraft.util;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.vanust.liminalcraft.block.custom.LiminalCraftLevelZeroPortal;

import java.io.Console;

public class LiminalCraftUtilityFunctions {


    public static void execute_command(Player serverPlayer, String command){
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
