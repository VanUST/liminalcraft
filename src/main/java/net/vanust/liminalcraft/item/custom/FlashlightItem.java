package net.vanust.liminalcraft.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import java.lang.Double;

public class FlashlightItem extends Item {
    boolean is_on;
    BlockPos prev_pos;
    public FlashlightItem(Properties pProperties){
        super(pProperties);
        is_on = false;
        prev_pos = BlockPos.ZERO;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand){
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide()){
            if (!is_on){
                is_on = true;

//                pPlayer.sendSystemMessage(Component.literal("FLASHLIGHT ON"));

//                prev_pos = pPlayer.getOnPos().above().above();
                prev_pos = trace_light(pLevel,pPlayer);
                pLevel.setBlock(prev_pos,Blocks.LIGHT.defaultBlockState(),2);
            }

            else {
                is_on = false;
//                pPlayer.sendSystemMessage(Component.literal("FLASHLIGHT OFF"));
                pLevel.setBlock(prev_pos,Blocks.AIR.defaultBlockState(),2);
            }

        }
        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

        if (!pLevel.isClientSide && is_on && pIsSelected && (pLevel.getBlockState(trace_light(pLevel,pEntity)) == Blocks.AIR.defaultBlockState())){

            pLevel.setBlock(prev_pos,Blocks.AIR.defaultBlockState(),2);
//            prev_pos = pEntity.getOnPos().above().above();
            prev_pos = trace_light(pLevel,pEntity);
            pLevel.setBlock(prev_pos,Blocks.LIGHT.defaultBlockState(),2);
//            pEntity.sendSystemMessage(Component.literal("FLASHLIGHT WORKS"));
        }
        if (!pLevel.isClientSide && is_on && !pIsSelected){
            pLevel.setBlock(prev_pos,Blocks.AIR.defaultBlockState(),2);
        }

    }

    public BlockPos trace_light( Level pLevel, Entity pEntity){
        Double rayLength = Double.valueOf(5);
        Vec3 playerRotation = pEntity.getViewVector(0);
        Vec3 rayPath = playerRotation.scale(rayLength);

        //RAY START AND END POINTS
        Vec3 from = pEntity.getEyePosition(0);
        Vec3 to = from.add(rayPath);

        ClipContext rayCtx = new ClipContext(from, to, ClipContext.Block.VISUAL,ClipContext.Fluid.ANY,pEntity);
        BlockHitResult rayHit = pLevel.clip(rayCtx);

        //CHECK THE RESULTS
        if (rayHit.getType() == BlockHitResult.Type.MISS){
            //IF RAY MISSED
            Vec3i intLocation = new Vec3i((int)to.x,(int)to.y,(int)to.z);
            return new BlockPos(intLocation);
        }
        else {
            //IF RAY HIT SOMETHING
            Vec3 hitLocation = rayHit.getLocation();
            Vec3 path = playerRotation.scale(1.5);
            hitLocation = hitLocation.subtract(path);
            Vec3i intLocation = new Vec3i((int)hitLocation.x,(int)hitLocation.y,(int)hitLocation.z);

            return new BlockPos(intLocation);
        }



    }

}
