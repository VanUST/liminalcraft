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

import net.vanust.liminalcraft.network.ModNetworkHandler;
import net.vanust.liminalcraft.network.RechargePacket;

@Mod.EventBusSubscriber(modid = LiminalCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value =  Dist.CLIENT)
public class ClientForgeHandler {

    @SubscribeEvent
    public static void level_0_ambience(TickEvent.LevelTickEvent event) {

    }

    @SubscribeEvent
    public static void clientClick(TickEvent.PlayerTickEvent event) {
        if (KeyBindings.INSTANCE.recharge.consumeClick()) {
            ModNetworkHandler.sendToServer(new RechargePacket());
        }
    }

}
