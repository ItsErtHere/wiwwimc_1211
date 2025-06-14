package com.itserthere.wiwwimc.Blocks;

import com.itserthere.wiwwimc.BlockEntities.CasingBlockEntity;
import com.itserthere.wiwwimc.ModTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CasingBlock extends BaseEntityBlock {
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos,
                                  CollisionContext context) {return Block.box(0,0,0,16,16,16);}
    public static final MapCodec<CasingBlock> CODEC = simpleCodec(CasingBlock::new);
    public CasingBlock(Properties properties) {super(properties);}
    @Override
    protected @NotNull RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {return CODEC;}

    //CHANGE
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CasingBlockEntity(pos,state);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()) {
            if(level.getBlockEntity(pos) instanceof CasingBlockEntity casingBlockEntity) {
                casingBlockEntity.drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.getBlockEntity(pos) instanceof CasingBlockEntity casingBlockEntity) {
            if(casingBlockEntity.inventory.getStackInSlot(0).isEmpty() && !stack.isEmpty()
            && !stack.is(ModTags.Items.FRAME_MODIFIABLE_ITEMS)) {
                casingBlockEntity.inventory.insertItem(0,stack.copy(),false);
                stack.shrink(1);
                level.playSound(player,pos, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1, 2);
            } else if((stack.is(ItemTags.PICKAXES)&&(state.is(ModTags.Blocks.ALL_FRAMES)||state.is(ModTags.Blocks.ALL_GRATES)))
                ||(stack.is(ItemTags.AXES)&&state.is(ModTags.Blocks.ALL_CASINGS))) {
                ItemStack stackInCasing = casingBlockEntity.inventory.extractItem(0,1,false);
                player.addItem(stackInCasing);
                if(!player.addItem(stackInCasing)) {player.drop(stackInCasing,false);}
                casingBlockEntity.clearContents();
                level.playSound(player,pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1, 2);
            }
        }
        return ItemInteractionResult.SUCCESS;
    }
}
