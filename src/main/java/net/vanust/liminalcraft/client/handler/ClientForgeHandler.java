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
import net.vanust.liminalcraft.structures.BaseStructure;
import net.vanust.liminalcraft.util.LiminalCraftUtilityFunctions;
import net.vanust.liminalcraft.worldgen.dimension.LiminalCraftLevels;
//import net.vanust.liminalcraft.util.LiminalCraftUtilityFunctions.;
import java.util.Objects;
import java.util.Random;

import static net.vanust.liminalcraft.worldgen.portal.LiminalCraftTeleports.normal_random;

@Mod.EventBusSubscriber(modid = LiminalCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value =  Dist.CLIENT)
public class ClientForgeHandler {

    public static Random normal_random = new Random();
    @SubscribeEvent
    public static void teleport_to_backrooms(ServerChatEvent event){
        String message = event.getRawText();
        Player player = event.getPlayer();
        if (Objects.equals(message, "noclip")){
            if (!player.level().isClientSide()) {
                if ((player.level().dimension() == Level.OVERWORLD)) {

                    ServerLevel level_0 = player.level().getServer().getLevel(LiminalCraftLevels.LEVEL_0_KEY);

                    int y = 256;
                    int random_x = (int) (player.getX() + normal_random.nextGaussian(0, 5000));
                    int random_z = (int) (player.getX() + normal_random.nextGaussian(0, 5000));

                    BlockPos destpos = new BlockPos(random_x, y, random_z);



                    ResourceLocation structureLocation = new ResourceLocation(LiminalCraft.MOD_ID, "level_0/fallback_4_5");
                    StructureTemplate template = level_0.getStructureManager().get(structureLocation).orElse(null);

                    if (template != null) {
                        BlockPos structurePos = new BlockPos(destpos.getX(), destpos.getY(), destpos.getZ());
                        StructurePlaceSettings settings = new StructurePlaceSettings()
                                .setMirror(Mirror.NONE)
                                .setRotation(Rotation.NONE)
                                .setIgnoreEntities(false);
                        template.placeInWorld(level_0,structurePos, structurePos, settings, RandomSource.create(level_0.getSeed()), 2);
                    } else {
                        player.sendSystemMessage(Component.literal("Failed to load structure template."));
                    }
//                    LiminalCraftUtilityFunctions.execute_command(player, "place jigsaw liminalcraft:level_0/basic_4_5 liminalcraft:4_5 6 ~ ~ ~");
                    //                    player.sendSystemMessage(Component.literal(destpos.toString()));
                    player.teleportTo(level_0, random_x, y, random_z,
                            RelativeMovement.ALL, 0, 0);
                    //                    player.sendSystemMessage(Component.literal(destpos.toString()));

                    BlockPos valid_spawn_point = LiminalCraftUtilityFunctions.find_nearest_room(level_0, destpos);
                                    //                    player.sendSystemMessage(Component.literal(valid_spawn_point.toString()));
                                    //                    player.sendSystemMessage(Component.literal(destpos.toString()));

                    if (!player.canUseGameMasterBlocks()) {
                        LiminalCraftUtilityFunctions.execute_command(player, "spawnpoint @s " + valid_spawn_point.getX() + " " + valid_spawn_point.getY() + " " + valid_spawn_point.getZ());
                    }


                    player.teleportTo(valid_spawn_point.getX(), valid_spawn_point.getY(), valid_spawn_point.getZ());

                    if (!player.canUseGameMasterBlocks()) {
                        player.getInventory().clearContent();
                    }
                    player.sendSystemMessage(Component.literal("Seems like you noclipped through reality... Good luck surviving in the ̶̸̸̵̸̶̵̢̧̨̧̢̧̛̮̪͚̙͇̖̻̖͙̺̜͖̠̙̯̙͎̲̯̭̤͔̝̝̺̥͓̻͕̤̹͕̘͓̭̳̠̩̲̦̺̣͖͔̞̮̲̺̟̲̠͙̪̰̫̲͎̲̍̀̿̿̇̈́̓͊͋̎̔̉̉̉̒̈́̂̅̓͆̊̈́̍̏͗̀̇͗͒̌̊͒̃̄̀̍̉͗̃͂̍̾̆̀̈́̔̅͊́̽̅͒̈́͆͑̽̿̅̍̍̒̐͂̄͑̓̈́̃́̿̕̕͜͠͝͝͝͝͝ͅͅͅ"));

//                    LiminalCraftUtilityFunctions.execute_command(player, "place jigsaw liminalcraft:level_0/basic_4_5 liminalcraft:4_5 6 ~ ~ ~");
                }
            }
        }
        if (Objects.equals(message, "pray")) {
            if (!player.level().isClientSide()) {

                ServerLevel level_0 = player.level().getServer().getLevel(LiminalCraftLevels.LEVEL_0_KEY);
                ResourceLocation structureLocation = new ResourceLocation(LiminalCraft.MOD_ID, "level_0/fallback_4_5");
                StructureTemplate template = level_0.getStructureManager().get(structureLocation).orElse(null);

                if (template != null) {
                    BlockPos structurePos = new BlockPos((int)player.getX(), (int)player.getY(), (int)player.getZ());
                    StructurePlaceSettings settings = new StructurePlaceSettings()
                            .setMirror(Mirror.NONE)
                            .setRotation(Rotation.NONE)
                            .setIgnoreEntities(false)
                            .addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
                    template.placeInWorld(level_0, structurePos, structurePos, settings, RandomSource.create(level_0.getSeed()), 2);
                } else {
                    player.sendSystemMessage(Component.literal("Failed to load structure template."));
                }
            }
        }
    }


    @SubscribeEvent
    public static void clientClick(TickEvent.PlayerTickEvent event){

//        Player player = Minecraft.getInstance().player;
//
//        if (player.level() instanceof ServerLevel serverlevel) {
//            if ((player.level().dimension() == Level.OVERWORLD) && (!player.canUseGameMasterBlocks())) {
//
//                int y = 150;
//                int random_x = (int) (player.getX() + normal_random.nextGaussian(0, 5000));
//                int random_z = (int) (player.getX() + normal_random.nextGaussian(0, 5000));
//
//                player.teleportTo(serverlevel.getServer().getLevel(LiminalCraftLevels.LEVEL_0_KEY), random_x, y, random_z,
//                        RelativeMovement.ALL, 0, 0);
//            }
//
//        }

        if (!event.player.level().isClientSide) {

            if (KeyBindings.INSTANCE.recharge.consumeClick()) {
                ItemStack curr_item = Minecraft.getInstance().player.getMainHandItem();
                ItemStack offhand = Minecraft.getInstance().player.getOffhandItem();
//            Minecraft.getInstance().player.sendSystemMessage(Component.literal(offhand.toString()));
//            Minecraft.getInstance().player.sendSystemMessage(Component.literal(curr_item.toString()));
                if (curr_item.getItem().equals(LiminalCraftItems.FLASHLIGHT_ITEM.get())) {
                    if (offhand.getItem().equals(LiminalCraftItems.SMALL_BATTERY.get())) {
                        offhand.setCount(offhand.getCount() - 1);

                        FlashlightItemLiminal flashlight = (FlashlightItemLiminal) curr_item.getItem();
                        flashlight.charge(curr_item, LiminalCraftItems.small_battery_energy);

                    }
                }

            }
        }
    }

}
