package net.vanust.liminalcraft.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.vanust.liminalcraft.LiminalCraft;

public class ModNetworkHandler {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel LIMINAL_CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(LiminalCraft.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void sendToServer(Object msg){
        LIMINAL_CHANNEL.send(PacketDistributor.SERVER.noArg(), msg);
    }

    public static void sendToPlayer(Object msg, ServerPlayer player){
        LIMINAL_CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), msg);
    }

    public static void sendToAllCLients(Object msg){
        LIMINAL_CHANNEL.send(PacketDistributor.ALL.noArg(), msg);
    }


    public static void register() {
        LIMINAL_CHANNEL.messageBuilder(RechargePacket.class,0, NetworkDirection.PLAY_TO_SERVER)
                .encoder(RechargePacket::encode)
                .decoder(RechargePacket::new)
                .consumerMainThread(RechargePacket::handle)
                .add();

        LIMINAL_CHANNEL.messageBuilder(SyncStructurePacket.class,1,NetworkDirection.PLAY_TO_CLIENT)
                .encoder(SyncStructurePacket::encode)
                .decoder(SyncStructurePacket::new)
                .consumerMainThread(SyncStructurePacket::handle)
                .add();

    }
}