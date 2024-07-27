package net.vanust.liminalcraft.client.handler;
import com.gitlab.srcmc.powered_flashlight.forge.items.FlashlightItem;
import com.gitlab.srcmc.powered_flashlight.items.AbstractFlashlightItem;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.RelativeMovement;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.LiminalCraftStructureRegister;
import net.vanust.liminalcraft.client.KeyBindings;
import net.vanust.liminalcraft.item.LiminalCraftItems;
import net.vanust.liminalcraft.item.custom.FlashlightItemLiminal;
import net.vanust.liminalcraft.network.ModNetworkHandler;
import net.vanust.liminalcraft.network.RechargePacket;
import net.vanust.liminalcraft.network.SyncStructurePacket;
import net.vanust.liminalcraft.structures.BaseStructure;
import net.vanust.liminalcraft.util.LiminalCraftUtilityFunctions;
import net.vanust.liminalcraft.worldgen.dimension.LiminalCraftLevels;
//import net.vanust.liminalcraft.util.LiminalCraftUtilityFunctions.;
import java.util.Objects;
import java.util.Random;

@Mod.EventBusSubscriber(modid = LiminalCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ServerForgeHandler {
//
//    public static final RandomSource randomSource = RandomSource.create();
//
//    @SubscribeEvent
//    public static void teleport_to_backrooms(ServerChatEvent event) {
//        String message = event.getRawText();
//        ServerPlayer player = event.getPlayer();
//        if (Objects.equals(message, "noclip")) {
//            if ((player.level().dimension() == Level.OVERWORLD)) {
//
//                ServerLevel level_0 = player.server.getLevel(LiminalCraftLevels.LEVEL_0_KEY);
//
//                int y = 256;
//                int random_x = (int) (player.getX() + randomSource.nextGaussian() * 5000);
//                int random_z = (int) (player.getZ() + randomSource.nextGaussian() * 5000);
//
//                BlockPos destpos = new BlockPos(random_x, y, random_z);
//
//                player.teleportTo(level_0, random_x, y, random_z, player.getYRot(), player.getXRot());
//                player.sendSystemMessage(Component.literal(destpos.toString()));
//
//                // Load and place the structure
//                ResourceLocation structureLocation = new ResourceLocation(LiminalCraft.MOD_ID, "level_0/fallback_4_5");
//                StructureTemplate template = level_0.getStructureManager().getOrCreate(structureLocation);
//
//                if (template != null) {
//                    BlockPos structurePos = new BlockPos(destpos.getX(), destpos.getY(), destpos.getZ());
//                    StructurePlaceSettings settings = new StructurePlaceSettings()
//                            .setMirror(Mirror.NONE)
//                            .setRotation(Rotation.NONE)
//                            .setIgnoreEntities(false)
//                            .addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
//
//                    // Place the structure and handle entities
//                    template.placeInWorld(level_0, structurePos, structurePos, settings, randomSource, 2);
//                } else {
//                    player.sendSystemMessage(Component.literal("Failed to load structure template."));
//                }
//
//                BlockPos valid_spawn_point = LiminalCraftUtilityFunctions.find_nearest_room(level_0, destpos);
//
//                if (!player.canUseGameMasterBlocks()) {
//                    LiminalCraftUtilityFunctions.execute_command(player, "spawnpoint @s " + valid_spawn_point.getX() + " " + valid_spawn_point.getY() + " " + valid_spawn_point.getZ());
//                }
//
//                player.teleportTo(valid_spawn_point.getX(), valid_spawn_point.getY(), valid_spawn_point.getZ());
//
//                if (!player.canUseGameMasterBlocks()) {
//                    player.getInventory().clearContent();
//                }
//                ModNetworkHandler.sendToAllCLients(new SyncStructurePacket());
//            }
//
//        }
//        if (Objects.equals(message, "pray")) {
//            ServerLevel level_0 = player.server.getLevel(LiminalCraftLevels.LEVEL_0_KEY);
//            ResourceLocation structureLocation = new ResourceLocation(LiminalCraft.MOD_ID, "level_0/fallback_4_5");
//            StructureTemplate template = level_0.getStructureManager().get(structureLocation).orElse(null);
//
//            if (template != null) {
//                BlockPos structurePos = new BlockPos((int) player.getX(), (int) player.getY(), (int) player.getZ());
//                StructurePlaceSettings settings = new StructurePlaceSettings()
//                        .setMirror(Mirror.NONE)
//                        .setRotation(Rotation.NONE)
//                        .setIgnoreEntities(false)
//                        .addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
//
//                // Ensure entities like command blocks and jigsaw blocks retain their data
//                template.placeInWorld(level_0, structurePos, structurePos, settings, randomSource, 2);
//
//                // Update command blocks, jigsaw blocks, and other entities
////                        updateBlockEntities(level_0, structurePos, template, settings);
//
//            } else {
//                player.sendSystemMessage(Component.literal("Failed to load structure template."));
//            }
//            ModNetworkHandler.sendToAllCLients(new SyncStructurePacket());
//        }
//
//    }
}
