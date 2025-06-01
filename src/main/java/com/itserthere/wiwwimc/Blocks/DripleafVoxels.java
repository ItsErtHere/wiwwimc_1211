package com.itserthere.wiwwimc.Blocks;

import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.ModTags;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.minecraft.core.Direction;

import java.util.Vector;

import static com.itserthere.wiwwimc.Blocks.OmniDirectionalBlock.FACE;
import static com.itserthere.wiwwimc.Blocks.OmniDirectionalBlock.FRONT;
import static net.minecraft.core.Direction.NORTH;
import static net.minecraft.core.Direction.SOUTH;
import static net.minecraft.core.Direction.EAST;
import static net.minecraft.core.Direction.WEST;
import static net.minecraft.core.Direction.UP;
import static net.minecraft.core.Direction.DOWN;

public class DripleafVoxels {
    public static boolean isDripleaf(DeferredBlock<?> block) {
        return block.is(ModTags.Blocks.DRIPLEAF_BLOCKS);
    }
    public static boolean isDripleaf(BlockState state) {
        return state.is(ModTags.Blocks.DRIPLEAF_BLOCKS);
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
            else if(blockId.contains("_leaf")) {x = 5;}
        }
        return x;
    }
    public static int getTilt(BlockState state) {
        int x=-1;
        if(isDripleaf(ModBlocks.getDeferredBlock(state))) {
            String blockId = state.getBlock().getDescriptionId();
            if(blockId.contains("_norm")||blockId.contains("firm_dripleaf")) {x = 0;}
            else if(blockId.contains("_partial")) {x = 1;}
            else if(blockId.contains("_full")) {x = 2;}
            else if(blockId.contains("_xtra")) {x = 3;}
            else if(blockId.contains("_stem")) {x = 4;}
            else if(blockId.contains("_leaf")) {x = 5;}
        }
        return x;
    }
    public static boolean getSlab(DeferredBlock<?> block) {
        return (isDripleaf(block) && block.getRegisteredName().contains("slab_"));
    }
    public static boolean getSlab(BlockState state) {
        return (isDripleaf(state) && state.getBlock().getDescriptionId().contains("slab_"));
    }
    public boolean getRot(DeferredBlock<?> block) {
        return (isDripleaf(block) && block.getRegisteredName().contains("_rot"));
    }

    public static boolean conShape(BlockState state,int tilt, Direction face, Direction front, boolean isSlab) {
        String blockname = ModBlocks.getBlockName(state);
        boolean isSlab1 = blockname.contains("half") || blockname.contains("slab");
        return conDir(state,face,front) && (isSlab1 == isSlab) &&
                (getTilt(state) == tilt || (tilt==4 && getTilt(state)<5));
    }
    public static boolean conShape(BlockState state,int tilt, Direction face, boolean isSlab) {
        String blockname = ModBlocks.getBlockName(state);
        boolean isSlab1 = blockname.contains("half") || blockname.contains("slab");
        return conDir(state,face) && (isSlab1 == isSlab) &&
                (getTilt(state) == tilt || (tilt==4 && getTilt(state)<5));
    }
    public static boolean conDir(BlockState state,Direction face, Direction front) {
        String blockname = ModBlocks.getBlockName(state);
        boolean isSlab1 = blockname.contains("half") || blockname.contains("slab");
        return state.getValue(FACE)==face && state.getValue(FRONT) == front;
    }
    public static boolean conDir(BlockState state,Direction face) {
        String blockname = ModBlocks.getBlockName(state);
        boolean isSlab1 = blockname.contains("half") || blockname.contains("slab");
        return state.getValue(FACE)==face;
    }
    public static boolean conDirX(BlockState state,Direction face, Direction front) {
        return conDir(state,face,front)||conDir(state,face.getOpposite(),front);
    }
    public static VoxelShape getDripleafVoxel(BlockState state) {
        VoxelShape newVoxel = Block.box(0,0,0,16,16,16);
        if(getTilt(state)==2|| getTilt(state)==3  || getTilt(state)==4){
            newVoxel=Block.box(0,0,0,0,0,0);
        }
        else if(conShape(state,0,NORTH,false)) {newVoxel=Block.box(0 ,0 ,1 ,16,16,5 );}
        else if(conShape(state,0,SOUTH,false)) {newVoxel=Block.box(0 ,0 ,11,16,16,15);}
        else if(conShape(state,0,EAST ,false)) {newVoxel=Block.box(1 ,0 ,0 ,5 ,16,16);}
        else if(conShape(state,0,WEST ,false)) {newVoxel=Block.box(11,0 ,0 ,15,16,16);}
        else if(conShape(state,0,UP   ,false)) {newVoxel=Block.box(0 ,1 ,0 ,16,5 ,16);}
        else if(conShape(state,0,DOWN ,false)) {newVoxel=Block.box(0 ,11,0 ,16,15,16);}

        else if(conShape(state,1,NORTH,false)) {newVoxel=Block.box(0,0,4,16,16,8 );}
        else if(conShape(state,1,SOUTH,false)) {newVoxel=Block.box(0,0,8,16,16,12);}
        else if(conShape(state,1,EAST ,false)) {newVoxel=Block.box(4,0,0,8 ,16,16);}
        else if(conShape(state,1,WEST ,false)) {newVoxel=Block.box(8,0,0,12,16,16);}
        else if(conShape(state,1,UP   ,false)) {newVoxel=Block.box(0,4,0,16,8 ,16);}
        else if(conShape(state,1,DOWN ,false)) {newVoxel=Block.box(0,8,0,16,12,16);}

        else if(conShape(state,1,NORTH,true)) {newVoxel=Block.box(0,0,0 ,16,16,1 );}
        else if(conShape(state,1,SOUTH,true)) {newVoxel=Block.box(0,0,15,16,16,16);}
        else if(conShape(state,1,EAST ,true)) {newVoxel=Block.box(15,0,0,16,16,16);}
        else if(conShape(state,1,WEST ,true)) {newVoxel=Block.box(0 ,0,0,1 ,16,16);}
        else if(conShape(state,1,UP   ,true)) {newVoxel=Block.box(0,15,0,16,16,16);}
        else if(conShape(state,1,DOWN ,true)) {newVoxel=Block.box(0,0 ,0,16,1 ,16);}

        else if(conShape(state,5,NORTH,false)) {newVoxel=Block.box(0,0,0 ,16,16,1 );}
        else if(conShape(state,5,SOUTH,false)) {newVoxel=Block.box(0,0,15,16,16,16);}
        else if(conShape(state,5,EAST ,false)) {newVoxel=Block.box(15,0,0,16,16,16);}
        else if(conShape(state,5,WEST ,false)) {newVoxel=Block.box(0 ,0,0,1 ,16,16);}
        else if(conShape(state,5,UP   ,false)) {newVoxel=Block.box(0,15,0,16,16,16);}
        else if(conShape(state,5,DOWN ,false)) {newVoxel=Block.box(0,0 ,0,16,1 ,16);}

        return newVoxel;
    }
    public static VoxelShape getStemVoxel(BlockState state) {
        VoxelShape newVoxel = Block.box(0,0,0,16,16,16);
        int mn=0; int mx = 0;
        switch (state.getValue(FACE)) {
            case NORTH, WEST, DOWN: {mx = getSlab(state) ? 7 : 15;}
            case SOUTH, EAST, UP: {mx=16; mn = getSlab(state) ? 9 : 1;}
        }
        if(conDir(state,NORTH,WEST))      {newVoxel=Block.box(11,5 ,mn,14,11,mx);}
        else if(conDir(state,NORTH,EAST)) {newVoxel=Block.box(2 ,5 ,mn,5 ,11,mx);}
        else if(conDir(state,NORTH,UP  )) {newVoxel=Block.box(5 ,11,mn,11,14,mx);}
        else if(conDir(state,NORTH,DOWN)) {newVoxel=Block.box(5 ,2 ,mn,11,5 ,mx);}
        else if(conDir(state,SOUTH,WEST)) {newVoxel=Block.box(11,5 ,mn,14,11,mx);}
        else if(conDir(state,SOUTH,EAST)) {newVoxel=Block.box(2 ,5 ,mn,5 ,11,mx);}
        else if(conDir(state,SOUTH,UP  )) {newVoxel=Block.box(5 ,11,mn,11,14,mx);}
        else if(conDir(state,SOUTH,DOWN)) {newVoxel=Block.box(5 ,2 ,mn,11,5 ,mx);}
        else if(conDir(state,EAST,SOUTH)) {newVoxel=Block.box(mn,5 ,2 ,mx,11,5 );}
        else if(conDir(state,EAST,NORTH)) {newVoxel=Block.box(mn,5 ,11,mx,11,14);}
        else if(conDir(state,EAST,UP   )) {newVoxel=Block.box(mn,2 ,5 ,mx,5 ,11);}
        else if(conDir(state,EAST,DOWN )) {newVoxel=Block.box(mn,11,5 ,mx,14,11);}
        else if(conDir(state,DOWN,SOUTH)) {newVoxel=Block.box(5 ,mn,2 ,11,mx,5 );}
        else if(conDir(state,DOWN,NORTH)) {newVoxel=Block.box(5 ,mn,11,11,mx,14);}
        else if(conDir(state,DOWN,EAST )) {newVoxel=Block.box(2 ,mn,5 ,5 ,mx,11);}
        else if(conDir(state,DOWN,WEST )) {newVoxel=Block.box(11,mn,5 ,14,mx,11);}
        else if(conDir(state,UP  ,SOUTH)) {newVoxel=Block.box(5 ,mn,2 ,11,mx,5 );}
        else if(conDir(state,UP  ,NORTH)) {newVoxel=Block.box(5 ,mn,11,11,mx,14);}
        else if(conDir(state,UP  ,EAST )) {newVoxel=Block.box(2 ,mn,5 ,5 ,mx,11);}
        else if(conDir(state,UP  ,WEST )) {newVoxel=Block.box(11,mn,5 ,14,mx,11);}
        return newVoxel;
    }
}
