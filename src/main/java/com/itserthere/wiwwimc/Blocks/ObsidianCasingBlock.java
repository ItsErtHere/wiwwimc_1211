package com.itserthere.wiwwimc.Blocks;

import com.itserthere.wiwwimc.BlockEntities.CasingBlockEntity;
import com.itserthere.wiwwimc.BlockEntities.ObsidianCasingBlockEntity;
import com.itserthere.wiwwimc.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class ObsidianCasingBlock extends CasingBlock {
    public ObsidianCasingBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }
    public static final MapCodec<CasingBlock> CODEC = simpleCodec(CasingBlock::new);

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {return CODEC;}
    @Override
    protected RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}


    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos,
                                  CollisionContext context) {return Block.box(0,0,0,16,16,16);}

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ObsidianCasingBlockEntity(pos,state);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock()!=newState.getBlock()) {
            if(level.getBlockEntity(pos) instanceof ObsidianCasingBlockEntity casingBlockEntity){
                casingBlockEntity.drops();
                level.updateNeighbourForOutputSignal(pos,this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.getBlockEntity(pos) instanceof CasingBlockEntity casingBlockEntity) {
            if(casingBlockEntity.inventory.getStackInSlot(0).isEmpty() && !stack.isEmpty()
                    && !stack.is(ItemTags.PICKAXES)) {
                if(stack.is(Items.FLINT_AND_STEEL)) {
                    level.setBlock(pos, ModBlocks.PORTALIC_CASING.get().defaultBlockState(),31);
                }
                else{
                    casingBlockEntity.inventory.insertItem(0,stack.copy(),false);
                    stack.shrink(1);
                    level.playSound(player,pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS,1f,2f);
                }
            } else if(stack.is(ItemTags.PICKAXES)) {
                ItemStack stackInCasing = casingBlockEntity.inventory.extractItem(1,1,false);
                player.setItemInHand(InteractionHand.MAIN_HAND, stackInCasing);
                casingBlockEntity.clearContents();
                level.playSound(player,pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS,1f,2f);
            }
        }
        return ItemInteractionResult.SUCCESS;
    }
}
