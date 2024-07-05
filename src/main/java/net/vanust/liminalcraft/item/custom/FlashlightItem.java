package net.vanust.liminalcraft.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;

public class FlashlightItem extends Item {
    boolean is_used;
    public FlashlightItem(Properties pProperties){
        super(pProperties);
        is_used = false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand){
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide()){
            if (!is_used){
                is_used = true;

                pPlayer.sendSystemMessage(Component.literal("FLASHLIGHT ON"));
            }

            else {
                is_used = false;
                pPlayer.sendSystemMessage(Component.literal("FLASHLIGHT OFF"));

            }

        }
        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (is_used){

            pLevel.setBlock(pLivingEntity.blockPosition(),Blocks.LIGHT.defaultBlockState(),2);
            pLivingEntity.sendSystemMessage(Component.literal("FLASHLIGHT WORKS"));



        }
    }

}
