package com.itserthere.wiwwimc.Blocks;

import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.ModTags;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredBlock;

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
    public static int getTilt(BlockState state) {
        int x=-1;
        if(isDripleaf(ModBlocks.getDeferredBlock(state))) {
            if(state.is(ModBlocks.FIRM_DRIPLEAF)||state.is(ModBlocks.HALF_DRIPLEAF)) {x = 0;}
            else if(state.is(ModBlocks.FIRM_DRIPLEAF_PARTIAL)||
                    state.is(ModBlocks.HALF_DRIPLEAF_PARTIAL)) {x = 1;}
            else if(state.is(ModBlocks.FIRM_DRIPLEAF_FULL)||
                    state.is(ModBlocks.HALF_DRIPLEAF_FULL)) {x = 2;}
            else if(state.is(ModBlocks.FIRM_DRIPLEAF_XTRA)||
                    state.is(ModBlocks.HALF_DRIPLEAF_XTRA)) {x = 3;}
            else if(state.is(ModBlocks.DRIPLEAF_STEM)||
                    state.is(ModBlocks.HALF_DRIPLEAF_STEM)) {x = 4;}
            else if(state.is(ModBlocks.DRIPLEAF_LEAF)) {x = 5;}
        }
        return x;
    }
    public static boolean getSlab(BlockState state) {
        return (state.is(ModTags.Blocks.DRIPLEAF_HALVES));
    }
    public static boolean cTFaS(BlockState state, int tilt, Direction face, boolean isSlab) {
        String blockname = ModBlocks.getBlockName(state);
        boolean isSlab1 = blockname.contains("half") || blockname.contains("slab");
        return cFa(state,face) && (isSlab1 == isSlab) &&
                (getTilt(state) == tilt || (tilt==4 && getTilt(state)<5));
    }
    public static boolean cFaFr(BlockState state, Direction face, Direction front) {
        return state.getValue(FACE)==face && state.getValue(FRONT) == front;
    }
    public static boolean cFa(BlockState state, Direction face) {
        return state.getValue(FACE)==face;
    }
    public static boolean cFaS(BlockState state, Direction face, boolean isSlab) {
        return state.getValue(FACE)==face && getSlab(state);
    }
    public static boolean cTP(BlockState state, int tilt, int face, boolean isSlab) {
        return getSlab(state)==isSlab && (
                (state.getValue(FACE).getAxisDirection() == Direction.AxisDirection.NEGATIVE && face==-1)||
                (state.getValue(FACE).getAxisDirection() == Direction.AxisDirection.POSITIVE && face==1)
        ) && getTilt(state)==tilt;
    }
    public static int[] stemTilts = {3,4};
    public static boolean isStem(int i) {
        boolean b = false;
        for(int n:stemTilts) {
            if(n==i){b=true; break;}
        }
        return b;
    }
    public static VoxelShape getDripleafVoxel(BlockState state) {
        VoxelShape newVoxel = Block.box(0,0,0,16,16,16);
        int mn=0; int mx=0;
        if(isStem(getTilt(state))){newVoxel=Block.box(0,0,0,0,0,0);}
        else if(cTP(state,0,-1,false)||cTP(state,2,1,true)) {mn=13;}
        else if(cTP(state,1,-1,false)||cTP(state,1,1,true)) {mn=11;}
        else if(cTP(state,2,-1,false)||cTP(state,0,1,true)) {mn=9;}
        else if(cTP(state,0,-1,true)||cTP(state,2,1,false)) {mn=5;}
        else if(cTP(state,1,-1,true)||cTP(state,1,1,false)) {mn=3;}
        else if(cTP(state,2,-1,true)||cTP(state,0,1,false)) {mn=1;}
        if(!isStem(getTilt(state))) {
            if(cFa(state,EAST )||cFa(state,WEST )) {newVoxel=Block.box(mn,0,0,mn+2,16,16);}
            if(cFa(state,NORTH)||cFa(state,SOUTH)) {newVoxel=Block.box(0,0,mn,16,16,mn+2);}
            if(cFa(state,UP   )||cFa(state,DOWN )) {newVoxel=Block.box(0,mn,0,16,mn+2,16);}
        }

        return newVoxel;
    }
    public static VoxelShape getStemVoxel(BlockState state) {
        VoxelShape newVoxel = Block.box(0,0,0,16,16,16);
        int mn=0; int mx = 0;
        switch (state.getValue(FACE)) {
            case DOWN, WEST, NORTH: {mx = getSlab(state) ? 7 : 15;}
            case SOUTH, EAST, UP: {mx=16; mn = getSlab(state) ? 9 : 1;}
        }
        if(cFaFr(state,NORTH,WEST))      {newVoxel=Block.box(11,5 ,mn,14,11,mx);}
        else if(cFaFr(state,NORTH,EAST)) {newVoxel=Block.box(2 ,5 ,mn,5 ,11,mx);}
        else if(cFaFr(state,NORTH,DOWN)) {newVoxel=Block.box(5 ,11,mn,11,14,mx);}
        else if(cFaFr(state,NORTH,UP  )) {newVoxel=Block.box(5 ,2 ,mn,11,5 ,mx);}
        else if(cFaFr(state,SOUTH,EAST)) {newVoxel=Block.box(11,5 ,mn,14,11,mx);}
        else if(cFaFr(state,SOUTH,WEST)) {newVoxel=Block.box(2 ,5 ,mn,5 ,11,mx);}
        else if(cFaFr(state,SOUTH,DOWN)) {newVoxel=Block.box(5 ,11,mn,11,14,mx);}
        else if(cFaFr(state,SOUTH,UP  )) {newVoxel=Block.box(5 ,2 ,mn,11,5 ,mx);}
        else if(cFaFr(state,EAST,NORTH)) {newVoxel=Block.box(mn,5 ,2 ,mx,11,5 );}
        else if(cFaFr(state,EAST,SOUTH)) {newVoxel=Block.box(mn,5 ,11,mx,11,14);}
        else if(cFaFr(state,EAST,DOWN )) {newVoxel=Block.box(mn,2 ,5 ,mx,5 ,11);}
        else if(cFaFr(state,EAST,UP   )) {newVoxel=Block.box(mn,11,5 ,mx,14,11);}
        else if(cFaFr(state,WEST,NORTH)) {newVoxel=Block.box(mn,5 ,2 ,mx,11,5 );}
        else if(cFaFr(state,WEST,SOUTH)) {newVoxel=Block.box(mn,5 ,11,mx,11,14);}
        else if(cFaFr(state,WEST,DOWN )) {newVoxel=Block.box(mn,2 ,5 ,mx,5 ,11);}
        else if(cFaFr(state,WEST,UP   )) {newVoxel=Block.box(mn,11,5 ,mx,14,11);}
        else if(cFaFr(state,DOWN,NORTH)) {newVoxel=Block.box(5 ,mn,2 ,11,mx,5 );}
        else if(cFaFr(state,DOWN,SOUTH)) {newVoxel=Block.box(5 ,mn,11,11,mx,14);}
        else if(cFaFr(state,DOWN,EAST )) {newVoxel=Block.box(2 ,mn,5 ,5 ,mx,11);}
        else if(cFaFr(state,DOWN,WEST )) {newVoxel=Block.box(11,mn,5 ,14,mx,11);}
        else if(cFaFr(state,UP  ,NORTH)) {newVoxel=Block.box(5 ,mn,2 ,11,mx,5 );}
        else if(cFaFr(state,UP  ,SOUTH)) {newVoxel=Block.box(5 ,mn,11,11,mx,14);}
        else if(cFaFr(state,UP  ,EAST )) {newVoxel=Block.box(2 ,mn,5 ,5 ,mx,11);}
        else if(cFaFr(state,UP  ,WEST )) {newVoxel=Block.box(11,mn,5 ,14,mx,11);}
        return newVoxel;
    }
}
