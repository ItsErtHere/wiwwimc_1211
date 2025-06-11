package com.itserthere.wiwwimc.Blocks;

import com.itserthere.wiwwimc.Helpers;
import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OmniDirectionalPartial extends OmniDirectionalBlock {
    public OmniDirectionalPartial(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CLEAR,false));
    }
    public static final BooleanProperty CLEAR = BooleanProperty.create("clear");

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder); builder.add(CLEAR);
    }

    @Override
    public MapColor getMapColor(BlockState state, BlockGetter level, BlockPos pos, MapColor defaultColor) {
        MapColor mapColor = MapColor.NONE;
        if(!state.getValue(CLEAR)) {
            if(state.is(ModBlocks.ALT_FIRE_CORAL)||
                    state.is(ModBlocks.ALT_FIRE_CORAL_FAN)||
                    state.is(ModBlocks.ALT_FIRE_CORAL_WALL_FAN)) {mapColor = MapColor.COLOR_RED;}
            else if(state.is(ModBlocks.ALT_HORN_CORAL)||
                    state.is(ModBlocks.ALT_HORN_CORAL_FAN)||
                    state.is(ModBlocks.ALT_HORN_CORAL_WALL_FAN)) {mapColor = MapColor.COLOR_YELLOW;}
            else if(state.is(ModBlocks.ALT_TUBE_CORAL)||
                    state.is(ModBlocks.ALT_TUBE_CORAL_FAN)||
                    state.is(ModBlocks.ALT_TUBE_CORAL_WALL_FAN)) {mapColor = MapColor.COLOR_BLUE;}
            else if(state.is(ModBlocks.ALT_BRAIN_CORAL)||
                    state.is(ModBlocks.ALT_BRAIN_CORAL_FAN)||
                    state.is(ModBlocks.ALT_BRAIN_CORAL_WALL_FAN)) {mapColor = MapColor.COLOR_PINK;}
            else if(state.is(ModBlocks.ALT_BUBBLE_CORAL)||
                    state.is(ModBlocks.ALT_BUBBLE_CORAL_FAN)||
                    state.is(ModBlocks.ALT_BUBBLE_CORAL_WALL_FAN)) {mapColor = MapColor.COLOR_PURPLE;}
            else if(state.is(ModTags.Blocks.DEAD_CORAL_PLANTS)) {mapColor = MapColor.COLOR_GRAY;}
        }
        return super.getMapColor(state, level, pos, defaultColor);
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        double[] arr = new double[]{0,0,0,16,16,16};
        if(state.is(ModTags.Blocks.ALL_CORAL_WALL_FANS)) {arr=new double[]{4,0,4,12,8,12};}
        return Helpers.toVoxel(Helpers.rotate(state.getValue(OmniDirectionalBlock.FACE),arr));
    }
}
