package net.vanust.liminalcraft.client.handler;

import com.gitlab.srcmc.powered_flashlight.forge.items.FlashlightItem;
import com.gitlab.srcmc.powered_flashlight.items.AbstractFlashlightItem;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vanust.liminalcraft.LiminalCraft;
import net.vanust.liminalcraft.client.KeyBindings;
import net.vanust.liminalcraft.item.LiminalCraftItems;
import net.vanust.liminalcraft.item.custom.FlashlightItemLiminal;

@Mod.EventBusSubscriber(modid = LiminalCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value =  Dist.CLIENT)
public class ClientForgeHandler {
    @SubscribeEvent
    public static void clientClick(TickEvent.ClientTickEvent event){



        if (KeyBindings.INSTANCE.recharge.consumeClick()){
            ItemStack curr_item = Minecraft.getInstance().player.getMainHandItem();
            ItemStack offhand = Minecraft.getInstance().player.getOffhandItem();
//            Minecraft.getInstance().player.sendSystemMessage(Component.literal(offhand.toString()));
//            Minecraft.getInstance().player.sendSystemMessage(Component.literal(curr_item.toString()));
            if (curr_item.getItem().equals(LiminalCraftItems.FLASHLIGHT_ITEM.get())){
                if (offhand.getItem().equals(LiminalCraftItems.SMALL_BATTERY.get())){
                    offhand.setCount(offhand.getCount() - 1);

                    FlashlightItemLiminal flashlight = (FlashlightItemLiminal)curr_item.getItem();
                    flashlight.charge(curr_item,LiminalCraftItems.small_battery_energy);

                }
            }

        }
    }

}
