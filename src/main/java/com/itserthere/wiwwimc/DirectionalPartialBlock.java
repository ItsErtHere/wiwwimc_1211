package com.itserthere.wiwwimc;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.core.Direction.NORTH;

public class DirectionalPartialBlock extends TransparentBlock {
    public DirectionalPartialBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(FACE, NORTH)
        );
    }
    public static final DirectionProperty FACE = DirectionProperty.create(
            "face", NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN
    );

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACE,context.getClickedFace().getOpposite());
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACE);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        double[] arr = new double[]{0,0,0,16,16,16};
        if(state.is(ModTags.Blocks.ALL_CORAL_PLANTS)) {arr=new double[]{2,0,2,14,16,14};}
        else if(state.is(ModTags.Blocks.ALL_CORAL_FANS)) {arr=new double[]{2,0,2,14,4 ,14};}
        else if(state.is(ModTags.Blocks.ALL_FUNGI)) {arr=new double[]{4,0,4,12,8 ,12};}
        return Helpers.toVoxel(Helpers.rotate(state.getValue(FACE),arr));
    }
}
