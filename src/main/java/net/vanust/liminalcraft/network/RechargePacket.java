package net.vanust.liminalcraft.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.item.LiminalCraftItems;
import net.vanust.liminalcraft.item.custom.FlashlightItemLiminal;

import java.util.function.Supplier;

public class RechargePacket {

    public void encode(FriendlyByteBuf buffer){

    }

    public RechargePacket(FriendlyByteBuf buffer){

    }

    public RechargePacket(){

    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null) {
                ItemStack currItem = player.getMainHandItem();
                ItemStack offhand = player.getOffhandItem();

                if (currItem.getItem().equals(LiminalCraftItems.FLASHLIGHT_ITEM.get())) {
                    if (offhand.getItem().equals(LiminalCraftItems.SMALL_BATTERY.get())) {
                        offhand.setCount(offhand.getCount() - 1);

                        FlashlightItemLiminal flashlight = (FlashlightItemLiminal) currItem.getItem();
                        flashlight.charge(currItem, LiminalCraftItems.small_battery_energy);
                    }
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }


}