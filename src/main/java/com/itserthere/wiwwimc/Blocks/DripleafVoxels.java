package com.itserthere.wiwwimc.Blocks;

import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.ModTags;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.itserthere.wiwwimc.Blocks.OmniDirectionalBlock.FACE;

public class DripleafVoxels {
    public static VoxelShape getDripleafVoxelNoDir(boolean isSlab, int tilt) {
        int pix = isSlab ? 3 : 11;
        return switch (tilt) {
            default -> box(0,pix,0,16,pix+4,16);
            case 1 -> box(0,pix,0,16,pix+3,16);
            case 2 -> box(0,pix,0,16,pix+1,16);
        };
    }
    public static VoxelShape rotateVoxel(VoxelShape vs, Direction direction) {
        VoxelShape voxelShape = vs;
        double vxn = vs.min(Direction.Axis.X);
        double vxx = vs.max(Direction.Axis.X);
        double vyn = vs.min(Direction.Axis.Y);
        double vyx = vs.max(Direction.Axis.Y);
        double vzn = vs.min(Direction.Axis.Z);
        double vzx = vs.max(Direction.Axis.Z);
        switch (direction) {
            case UP -> voxelShape    = box(vxn,16-vyn,vzn,vxx,16-vyx,vzx);
            case NORTH -> voxelShape = box(vxn,vzn,vyn,vxx,vzx,vyx);
            case SOUTH -> voxelShape = box(vxn,vzn,16-vyn,vxx,vzn,16-vyn);
            case EAST -> voxelShape  = box(vyn,vxn,vzn,vyx,vxx,vzx);
            case WEST -> voxelShape  = box(16-vyn,vxn,vzn,16-vyx,vxx,vzx);
        }
        return voxelShape;
    }
    public static boolean isDripleaf(DeferredBlock<?> block) {
        return block.is(ModTags.Blocks.DRIPLEAF_BLOCKS);
    }
    private static int getTilt(DeferredBlock<?> block) {
        int x=-1;
        if(isDripleaf(block)) {
            String blockId = block.getRegisteredName();
            if(blockId.contains("_norm")) {x = 0;}
            else if(blockId.contains("_partial")) {x = 1;}
            else if(blockId.contains("_full")) {x = 2;}
            else if(blockId.contains("_xtra")) {x = 3;}
            else if(blockId.contains("_stem")) {x = 4;}
        }
        return x;
    }
    public static boolean getSlab(DeferredBlock<?> block) {
        return (isDripleaf(block) && block.getRegisteredName().contains("slab_"));
    }
    public boolean getRot(DeferredBlock<?> block) {
        return (isDripleaf(block) && block.getRegisteredName().contains("_rot"));
    }
    public static VoxelShape getDripleafVoxel(boolean isSlab, int tilt, Direction direction) {
        return rotateVoxel(getDripleafVoxelNoDir(isSlab,tilt),direction);
    }
    public static VoxelShape getDripleafVoxel(BlockState state) {
        return getDripleafVoxel(getSlab(ModBlocks.getDeferredBlock(state)),
                getTilt(ModBlocks.getDeferredBlock(state)),
                state.getValue(FACE));
    }
    public static VoxelShape box(double x1,double y1,double z1,double x2,double y2,double z2) {
        return Block.box(Math.min(x1,x2),Math.min(y1,y2),Math.min(z1,z2),
                Math.max(x1,x2),Math.max(y1,y2),Math.max(z1,z2));
    }
}
