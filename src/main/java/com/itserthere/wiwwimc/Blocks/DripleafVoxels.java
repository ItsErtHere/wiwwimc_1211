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
    public static int getTilt(BlockState state) {
        return getTilt(ModBlocks.getDeferredBlock(state));
    }
    public static boolean getSlab(DeferredBlock<?> block) {
        return (isDripleaf(block) && block.getRegisteredName().contains("slab_"));
    }
    public static boolean getSlab(BlockState state) {
        return getSlab(ModBlocks.getDeferredBlock(state));
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
    public static boolean conDir(BlockState state,Direction face, Direction front) {
        String blockname = ModBlocks.getBlockName(state);
        boolean isSlab1 = blockname.contains("half") || blockname.contains("slab");
        return (state.getValue(FACE)==face || face==null) &&
                (state.getValue(FRONT) == front || front==null);
    }
    public static boolean conDirX(BlockState state,Direction face, Direction front) {
        return conDir(state,face,front)||conDir(state,face.getOpposite(),front);
    }
    public static VoxelShape getDripleafVoxel(BlockState state) {
        VoxelShape newVoxel = Block.box(0,0,0,16,16,16);
        if(conShape(state,2,null,null,true)||
                conShape(state,3,null,null,false) ||conShape(state,3,null,null,true)
                ||conShape(state,4,null,null,false)||conShape(state,4,null,null,true)){
            newVoxel=Block.box(0,0,0,0,0,0);
        }
        else if(conShape(state,0,NORTH,null,false)) {newVoxel=Block.box(0 ,0 ,1 ,16,16,5 );}
        else if(conShape(state,0,SOUTH,null,false)) {newVoxel=Block.box(0 ,0 ,11,16,16,15);}
        else if(conShape(state,0,EAST ,null,false)) {newVoxel=Block.box(1 ,0 ,0 ,5 ,16,16);}
        else if(conShape(state,0,WEST ,null,false)) {newVoxel=Block.box(11,0 ,0 ,15,16,16);}
        else if(conShape(state,0,UP   ,null,false)) {newVoxel=Block.box(0 ,1 ,0 ,16,5 ,16);}
        else if(conShape(state,0,DOWN ,null,false)) {newVoxel=Block.box(0 ,11,0 ,16,15,16);}

        else if(conShape(state,1,NORTH,null,false)) {newVoxel=Block.box(0,0,4,16,16,8 );}
        else if(conShape(state,1,SOUTH,null,false)) {newVoxel=Block.box(0,0,8,16,16,12);}
        else if(conShape(state,1,EAST ,null,false)) {newVoxel=Block.box(4,0,0,8 ,16,16);}
        else if(conShape(state,1,WEST ,null,false)) {newVoxel=Block.box(8,0,0,12,16,16);}
        else if(conShape(state,1,UP   ,null,false)) {newVoxel=Block.box(0,4,0,16,8 ,16);}
        else if(conShape(state,1,DOWN ,null,false)) {newVoxel=Block.box(0,8,0,16,12,16);}

        else if(conShape(state,5,NORTH,null,false)) {newVoxel=Block.box(0,0,0 ,16,16,1 );}
        else if(conShape(state,5,SOUTH,null,false)) {newVoxel=Block.box(0,0,15,16,16,16);}
        else if(conShape(state,5,EAST ,null,false)) {newVoxel=Block.box(15,0,0,16,16,16);}
        else if(conShape(state,5,WEST ,null,false)) {newVoxel=Block.box(0 ,0,0,1 ,16,16);}
        else if(conShape(state,5,UP   ,null,false)) {newVoxel=Block.box(0,15,0,16,16,16);}
        else if(conShape(state,5,DOWN ,null,false)) {newVoxel=Block.box(0,0 ,0,16,1 ,16);}

        else if(conShape(state,2,NORTH,null,true )) {newVoxel=Block.box(0,0,10,16,16,14);}
        else if(conShape(state,2,SOUTH,null,true )) {newVoxel=Block.box(0,0,2 ,16,16,6 );}
        else if(conShape(state,2,EAST ,null,true )) {newVoxel=Block.box(10,0,0,14,16,16);}
        else if(conShape(state,2,WEST ,null,true )) {newVoxel=Block.box(2 ,0,0,6 ,16,16);}
        else if(conShape(state,2,UP   ,null,true )) {newVoxel=Block.box(0,10,0,16,14,16);}
        else if(conShape(state,2,DOWN ,null,true )) {newVoxel=Block.box(0,2 ,0,16,6 ,16);}

        else if(conShape(state,2,NORTH,EAST,false)) {newVoxel=Block.box(11,5 ,1,14,11,16);}
        else if(conShape(state,2,SOUTH,EAST,false)) {newVoxel=Block.box(11,5 ,0,14,11,15);}
        else if(conShape(state,2,NORTH,WEST,false)) {newVoxel=Block.box(2 ,5 ,1,5 ,11,16);}
        else if(conShape(state,2,SOUTH,WEST,false)) {newVoxel=Block.box(2 ,5 ,0,5 ,11,15);}
        else if(conShape(state,2,NORTH,UP  ,false)) {newVoxel=Block.box(2 ,11,1,11,14,16);}
        else if(conShape(state,2,SOUTH,UP  ,false)) {newVoxel=Block.box(2 ,11,0,11,14,15);}
        else if(conShape(state,2,NORTH,DOWN,false)) {newVoxel=Block.box(5 ,2 ,1,11,5 ,16);}
        else if(conShape(state,2,SOUTH,DOWN,false)) {newVoxel=Block.box(5 ,2 ,0,11,5 ,15);}

        else if(conShape(state,2,EAST,NORTH,false)) {newVoxel=Block.box(0,0,6,15,16,10);}
        else if(conShape(state,2,WEST,NORTH,false)) {newVoxel=Block.box(1,0,6,16,16,10);}
        else if(conShape(state,2,EAST,SOUTH,false)) {newVoxel=Block.box(0,0,6,15,16,10);}
        else if(conShape(state,2,WEST,SOUTH,false)) {newVoxel=Block.box(1,0,6,16,16,10);}
        else if(conShape(state,2,EAST,UP   ,false)) {newVoxel=Block.box(0,6,0,15,10,16);}
        else if(conShape(state,2,WEST,UP   ,false)) {newVoxel=Block.box(1,6,0,16,10,16);}
        else if(conShape(state,2,EAST,DOWN ,false)) {newVoxel=Block.box(0,6,0,15,10,16);}
        else if(conShape(state,2,WEST,DOWN ,false)) {newVoxel=Block.box(1,6,0,16,10,16);}

        else if(conShape(state,2,UP  ,NORTH,false)) {newVoxel=Block.box(0,1,6,16,16,10);}
        else if(conShape(state,2,DOWN,NORTH,false)) {newVoxel=Block.box(0,0,6,16,15,10);}
        else if(conShape(state,2,UP  ,SOUTH,false)) {newVoxel=Block.box(0,1,6,16,16,10);}
        else if(conShape(state,2,DOWN,SOUTH,false)) {newVoxel=Block.box(0,0,6,16,15,10);}
        else if(conShape(state,2,UP  ,EAST ,false)) {newVoxel=Block.box(6,1,0,10,16,16);}
        else if(conShape(state,2,DOWN,EAST ,false)) {newVoxel=Block.box(6,0,0,10,15,16);}
        else if(conShape(state,2,UP  ,WEST ,false)) {newVoxel=Block.box(6,1,0,10,16,16);}
        else if(conShape(state,2,DOWN,WEST ,false)) {newVoxel=Block.box(6,0,0,10,15,16);}

        return newVoxel;
    }
    public static VoxelShape getStemVoxel(BlockState state) {
        VoxelShape newVoxel = Block.box(0,0,0,16,16,16);
        int mn=0; int mx = 0;
        switch (state.getValue(FACE)) {
            case NORTH, WEST, DOWN: {mx = getSlab(state) ? 7 : 15;}
            case SOUTH, EAST, UP: {mx=16; mn = getSlab(state) ? 9 : 1;}
        }
        if(conDirX(state,NORTH,EAST))      {newVoxel=Block.box(11,5 ,mn,14,11,mx);}
        else if(conDirX(state,NORTH,WEST)) {newVoxel=Block.box(2 ,5 ,mn,5 ,11,mx);}
        else if(conDirX(state,NORTH,UP  )) {newVoxel=Block.box(5 ,11,mn,11,14,mx);}
        else if(conDirX(state,NORTH,DOWN)) {newVoxel=Block.box(5 ,2 ,mn,11,5 ,mx);}
        else if(conDirX(state,EAST,NORTH)) {newVoxel=Block.box(mn,5 ,2 ,mx,11,5 );}
        else if(conDirX(state,EAST,SOUTH)) {newVoxel=Block.box(mn,5 ,11,mx,11,14);}
        else if(conDirX(state,EAST,UP   )) {newVoxel=Block.box(mn,2 ,5 ,mx,5 ,11);}
        else if(conDirX(state,EAST,DOWN )) {newVoxel=Block.box(mn,11,5 ,mx,14,11);}
        else if(conDirX(state,UP  ,NORTH)) {newVoxel=Block.box(5 ,mn,2 ,11,mx,5 );}
        else if(conDirX(state,UP  ,SOUTH)) {newVoxel=Block.box(5 ,mn,11,11,mx,14);}
        else if(conDirX(state,DOWN,EAST )) {newVoxel=Block.box(2 ,mn,5 ,5 ,mx,11);}
        else if(conDirX(state,DOWN,WEST )) {newVoxel=Block.box(11,mn,5 ,14,mx,11);}
        return newVoxel;
    }
}
