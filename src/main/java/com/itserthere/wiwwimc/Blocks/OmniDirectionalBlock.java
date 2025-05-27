package com.itserthere.wiwwimc.Blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import static net.minecraft.core.Direction.*;

public class OmniDirectionalBlock extends Block {

    public static final DirectionProperty FACE = DirectionProperty.create(
            "face", NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN
    );
    public static final DirectionProperty FRONT = DirectionProperty.create(
            "front", NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN
    );

    public OmniDirectionalBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(FACE, NORTH).setValue(FRONT,UP)
        );
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace().getOpposite();
        Direction direction1 = Direction.EAST;
        switch (direction) {
            case UP -> {
                double xpos = Math.abs(context.getClickLocation().x)%1-0.5;
                double zpos = Math.abs(context.getClickLocation().z)%1-0.5;
                if(zpos>Math.abs(xpos)) {direction1=Direction.SOUTH;}
                else if(zpos<-Math.abs(xpos)) {direction1=Direction.NORTH;}
                else if(xpos>Math.abs(zpos)) {direction1=Direction.WEST;}
            }
            case DOWN -> {
                double xpos = Math.abs(context.getClickLocation().x)%1-0.5;
                double zpos = Math.abs(context.getClickLocation().z)%1-0.5;
                if(zpos>Math.abs(xpos)) {direction1=Direction.SOUTH;}
                else if(zpos<-Math.abs(xpos)) {direction1=Direction.NORTH;} //n
                else if(xpos>Math.abs(zpos)) {direction1=Direction.WEST;} //W
                else if(xpos<-Math.abs(zpos)) {direction1=Direction.EAST;}
            }
            case NORTH -> {
                double xpos = Math.abs(context.getClickLocation().x)%1-0.5;
                double ypos = Math.abs(context.getClickLocation().y)%1-0.5;
                if(ypos>Math.abs(xpos)) {direction1=Direction.UP;}
                else if(ypos<-Math.abs(xpos)) {direction1=Direction.DOWN;}
                else if(xpos>Math.abs(ypos)) {direction1=Direction.WEST;}
            }
            case SOUTH -> {
                double xpos = Math.abs(context.getClickLocation().x)%1-0.5;
                double ypos = Math.abs(context.getClickLocation().y)%1-0.5;
                if(ypos>Math.abs(xpos)) {direction1=Direction.UP;}
                else if(ypos<-Math.abs(xpos)) {direction1=Direction.DOWN;}
                else if(xpos<-Math.abs(ypos)) {direction1=Direction.WEST;}
            }
            case EAST, WEST -> {
                double zpos = Math.abs(context.getClickLocation().z)%1-0.5;
                double ypos = Math.abs(context.getClickLocation().y)%1-0.5;
                if(ypos>Math.abs(zpos)) {direction1=Direction.DOWN;}
                else if(ypos<-Math.abs(zpos)) {direction1=Direction.UP;}
                else if(zpos<-Math.abs(ypos)) {direction1=Direction.NORTH;}
                else if(zpos>Math.abs(ypos)) {direction1= SOUTH;}
            }
        };
        return this.defaultBlockState()
                .setValue(FACE,direction).setValue(FRONT,direction1);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACE).add(FRONT);
    }
}
