package com.itserthere.wiwwimc;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Helpers {
    public static VoxelShape rotate(Direction face, VoxelShape voxelShape) {
        double mnx = voxelShape.min(Direction.Axis.X);
        double mny = voxelShape.min(Direction.Axis.Y);
        double mnz = voxelShape.min(Direction.Axis.Z);
        double mxx = voxelShape.max(Direction.Axis.X);
        double mxy = voxelShape.max(Direction.Axis.Y);
        double mxz = voxelShape.max(Direction.Axis.Z);
        switch (face) {
            case UP ->    {voxelShape = Block.box(mnx,16-mxy,mnz, mxx,16-mny,mxz);}
            case NORTH -> {voxelShape = Block.box(mnx,mnz,mny,mxx,mxz,mxy);}
            case SOUTH -> {voxelShape = Block.box(mnx,16-mxz,mny, mxx,16-mnz,mxy);}
            case WEST ->  {voxelShape = Block.box(mny,mnx,mnz,mxy,mxx,mxz);}
            case EAST ->  {voxelShape = Block.box(mny,16-mxx,mnz, mxy,16-mnx,mxz);}
        }
        return voxelShape;
    }
    public static double[] rotate(Direction face, double[] arr) {
        switch (face) {
            case UP ->    {arr = new double[] {arr[0],16-arr[4],arr[2], arr[3],16-arr[1],arr[5]};}
            case NORTH -> {arr = new double[] {arr[0],arr[2],arr[1],arr[3],arr[5],arr[4]};}
            case SOUTH -> {arr = new double[] {arr[0],16-arr[5],16-arr[4], arr[3],16-arr[2],16-arr[1]};}
            case WEST ->  {arr = new double[] {arr[1],arr[0],arr[2],arr[4],arr[3],arr[5]};}
            case EAST ->  {arr = new double[] {16-arr[4],16-arr[3],arr[2],16-arr[1],16-arr[0],arr[5]};}
        }
        return arr;
    }
    public static VoxelShape toVoxel(double[] arr) {
        return Block.box(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
    }
    public static VoxelShape box(double x1,double y1,double z1,double x2,double y2,double z2) {
        return Block.box(Math.min(x1,x2),Math.min(y1,y2),Math.min(z1,z2),
                Math.max(x1,x2),Math.max(y1,y2),Math.max(z1,z2));
    }
    public static Vec2 getRot(Direction face, Direction front) {
        int rotX=0; int rotY=0;
        switch (face) {
            case DOWN -> {rotY = switch (front) {
                case WEST -> 270; case NORTH -> 180; case EAST -> 90; default -> 0;
            };}
            case UP -> {rotX=180; rotY = switch (front) {
                case EAST -> 270; case SOUTH -> 180; case WEST -> 90; default -> 0;
            };}
            case SOUTH -> {switch (front) {
                case EAST, UP -> {rotX=270; rotY=180;}
                case WEST, DOWN -> {rotX=90;}
            };}
            case NORTH -> {switch (front) {
                case EAST, UP -> {rotX=270;}
                case WEST, DOWN -> {rotX=90; rotY=180;}
            };}
            case WEST -> {switch (front) {
                case NORTH, UP -> {rotX=90; rotY=90;}
                case SOUTH, DOWN -> {rotX=270; rotY=270;}
            };}
            case EAST -> {switch (front) {
                case NORTH, DOWN -> {rotX=270; rotY=90;}
                case SOUTH, UP -> {rotX=90; rotY=270;}
            };}
        }
        return new Vec2(rotX,rotY);
    }
    public static Vec2 getRot(Direction face, int uv) {
        int rotX=0; int rotY=0;
        switch (face) {
            case DOWN -> {rotY = switch (uv) {
                case 4 -> 270; case 3 -> 180; case 2 -> 90; default -> 0;
            };}
            case UP -> {rotX=180; rotY = switch (uv) {
                case 4 -> 270; case 3 -> 180; case 2 -> 90; default -> 0;
            };}
            case SOUTH -> {switch (uv) {
                case 2, 1 -> {rotX=270; rotY=180;}
                case 4, 3 -> {rotX=90;}
            };}
            case NORTH -> {switch (uv) {
                case 2, 1 -> {rotX=270;}
                case 4, 3 -> {rotX=90; rotY=180;}
            };}
            case WEST -> {switch (uv) {
                case 4, 1 -> {rotX=90; rotY=90;}
                case 2, 3 -> {rotX=270; rotY=270;}
            };}
            case EAST -> {switch (uv) {
                case 4, 3 -> {rotX=270; rotY=90;}
                case 2, 1 -> {rotX=90; rotY=270;}
            };}
        }
        return new Vec2(rotX,rotY);
    }
    public static Direction[] ALL_DIRECTIONS = {Direction.DOWN,Direction.UP,Direction.NORTH,Direction.SOUTH,Direction.WEST,Direction.EAST};
    public static boolean isRot(Direction face, Direction front) {
        return (face == Direction.NORTH || face == Direction.SOUTH || face == Direction.EAST|| face == Direction.WEST)
        &&(front == Direction.NORTH || front == Direction.SOUTH || front == Direction.EAST|| front == Direction.WEST);
    }
    public static boolean isRot(Direction face, int i) {
        return (face == Direction.NORTH || face == Direction.SOUTH || face == Direction.EAST|| face == Direction.WEST)
                && i%2==1;
    }
    //FOR SHADERS
}
