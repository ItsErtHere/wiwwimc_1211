package com.itserthere.wiwwimc.Blocks;

import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

import static com.itserthere.wiwwimc.Blocks.DripleafVoxels.getTilt;

public class DripleafBlock extends OmniDirectionalBlock {
    public DripleafBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(STRETCHED,false));
    }
    public static final BooleanProperty STRETCHED = BooleanProperty.create("stretched");

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape voxelShape = Block.box(0,0,0,16,16,16);
        if(ModBlocks.getDeferredBlock(state).is(ModTags.Blocks.DRIPLEAF_BLOCKS)) {
            if(getTilt(state)==4||getTilt(state)==3) {
                voxelShape = DripleafVoxels.getStemVoxel(state);
            }
            else voxelShape = DripleafVoxels.getDripleafVoxel(state);
        }
        return voxelShape;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide() && getTilt(state)!=4){
            boolean currentState = state.getValue(STRETCHED);
            level.setBlockAndUpdate(pos,state.setValue(STRETCHED,!currentState));
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.wiwwimc.for_bdubs"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(STRETCHED);
    }
}
