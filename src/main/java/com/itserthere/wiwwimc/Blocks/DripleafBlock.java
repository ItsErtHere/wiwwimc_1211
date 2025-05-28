package com.itserthere.wiwwimc.Blocks;

import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DripleafBlock extends OmniDirectionalBlock {
    public DripleafBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape voxelShape = Block.box(0,0,0,16,16,16);
        if(ModBlocks.getDeferredBlock(state).is(ModTags.Blocks.DRIPLEAF_BLOCKS)) {
            voxelShape = DripleafVoxels.getDripleafVoxel(state);
        }
        return voxelShape;
    }
}
