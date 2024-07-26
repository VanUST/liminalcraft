package net.vanust.liminalcraft.item.custom;

import net.mcreator.boh.item.WfPistolItem;
import net.mcreator.boh.procedures.WfPistolRightclickedProcedure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class LiminalCraftRevolver extends WfPistolItem {
    public int capability = 6;

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        ItemStack itemstack = (ItemStack)ar.getObject();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        if (capability >0) {
            capability = capability - 1;
            WfPistolRightclickedProcedure.execute(world, x, y, z, entity, itemstack);
        }
        return ar;
    }
}
