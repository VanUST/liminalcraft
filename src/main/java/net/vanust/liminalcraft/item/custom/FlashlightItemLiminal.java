package net.vanust.liminalcraft.item.custom;

import com.gitlab.srcmc.powered_flashlight.ModCommon;
import com.gitlab.srcmc.powered_flashlight.forge.capabilities.EnergyCapability;
import com.gitlab.srcmc.powered_flashlight.forge.items.FlashlightItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.IEnergyStorage;

import java.io.Console;

public class FlashlightItemLiminal extends FlashlightItem {

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt) {

        int preCharge = stack.getOrCreateTag().getInt("energy");
        if (stack.getTag().getBoolean("precharged")) {
            preCharge = ModCommon.commonConfig.energyCapacity();
            stack.removeTagKey("precharged");
        }

        return new EnergyCapability(stack, 50000, 50000, ModCommon.commonConfig.energyDrainPerTick(), preCharge);
    }

    public void charge(ItemStack stack, int value){
        IEnergyStorage es = (IEnergyStorage)stack.getCapability(ForgeCapabilities.ENERGY).orElse((IEnergyStorage)null);
        if (es != null) {
            es.receiveEnergy(value, false);
        }
    }



    //    boolean is_on;
//    BlockPos prev_pos;
//    public FlashlightItem(Properties pProperties){
//        super(pProperties);
//        is_on = false;
//        prev_pos = BlockPos.ZERO;
//    }
//
//    @Override
//    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand){
//        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
//        if (!pLevel.isClientSide()){
//            if (!is_on){
//                BlockPos curr_pos = trace_light(pLevel,pPlayer);
//                if ((pLevel.getBlockState(curr_pos) == Blocks.AIR.defaultBlockState())){
//                    is_on = true;
//
////                pPlayer.sendSystemMessage(Component.literal("FLASHLIGHT ON"));
//
////                prev_pos = pPlayer.getOnPos().above().above();
//                    prev_pos = curr_pos;
//                    pLevel.setBlock(prev_pos,Blocks.LIGHT.defaultBlockState(),2);
//                }
//
//            }
//
//            else {
//                is_on = false;
////                pPlayer.sendSystemMessage(Component.literal("FLASHLIGHT OFF"));
//                pLevel.setBlock(prev_pos,Blocks.AIR.defaultBlockState(),2);
//            }
//
//        }
//        return InteractionResultHolder.success(itemstack);
//    }
//
//    @Override
//    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
//
//        if (!pLevel.isClientSide && is_on ) {
//
//            BlockPos curr_pos = trace_light(pLevel,pEntity);
//            BlockState curr_state = pLevel.getBlockState(curr_pos);
//            if (pIsSelected) {
//                if (( curr_state == Blocks.AIR.defaultBlockState())) {
//                    if (curr_pos != prev_pos) {
//
//
//                        pLevel.setBlock(prev_pos, Blocks.AIR.defaultBlockState(), 2);
////            prev_pos = pEntity.getOnPos().above().above();
//                        prev_pos = curr_pos;
//                        pLevel.setBlock(prev_pos, Blocks.LIGHT.defaultBlockState(), 2);
////            pEntity.sendSystemMessage(Component.literal("FLASHLIGHT WORKS"));
//                    }
//                }
//                else if (curr_state == Blocks.WATER.defaultBlockState()){
//                    is_on = false;
//                    pLevel.setBlock(prev_pos,Blocks.AIR.defaultBlockState(),2);
//                }
//            }else {
//                pLevel.setBlock(prev_pos, Blocks.AIR.defaultBlockState(), 2);
//            }
//        }
//    }
//
//    public BlockPos trace_light( Level pLevel, Entity pEntity){
//        Double rayLength = Double.valueOf(5);
//        Vec3 playerRotation = pEntity.getViewVector(0);
//        Vec3 rayPath = playerRotation.scale(rayLength);
//
//        //RAY START AND END POINTS
//        Vec3 from = pEntity.getEyePosition(0);
//        Vec3 to = from.add(rayPath);
//
//        ClipContext rayCtx = new ClipContext(from, to, ClipContext.Block.VISUAL,ClipContext.Fluid.ANY,pEntity);
//        BlockHitResult rayHit = pLevel.clip(rayCtx);
//
//        //CHECK THE RESULTS
//        if (rayHit.getType() == BlockHitResult.Type.MISS){
//            //IF RAY MISSED
//            Vec3i intLocation = new Vec3i((int)to.x,(int)to.y,(int)to.z);
//            return new BlockPos(intLocation);
//        }
//        else {
//            //IF RAY HIT SOMETHING
//            Vec3 hitLocation = rayHit.getLocation();
//            Vec3 path = playerRotation.scale(1.5);
//            hitLocation = hitLocation.subtract(path);
//            Vec3i intLocation = new Vec3i((int)hitLocation.x,(int)hitLocation.y,(int)hitLocation.z);
//
//            return new BlockPos(intLocation);
//        }
//
//
//
//    }

}
