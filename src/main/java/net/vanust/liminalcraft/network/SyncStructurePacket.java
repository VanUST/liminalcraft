package net.vanust.liminalcraft.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.event.EventNetworkChannel;
import net.vanust.liminalcraft.LiminalCraft;

import java.util.function.Supplier;

public class SyncStructurePacket {


    public void encode(FriendlyByteBuf buffer){

    }

    public SyncStructurePacket(FriendlyByteBuf buffer){

    }

    public SyncStructurePacket(){

    }
    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // Client-side logic here to refresh the view
            // You can force a block update or any other necessary updates
            Minecraft.getInstance().levelRenderer.allChanged();
        });
        ctx.get().setPacketHandled(true);
    }

}