package com.itserthere.wiwwimc.Blocks;

import com.itserthere.wiwwimc.WIWWIMC;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.ModelProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import net.minecraft.data.models.ModelProvider.*;

import static net.minecraft.core.Direction.NORTH;
import static net.minecraft.core.Direction.UP;
import static net.neoforged.neoforge.client.model.generators.ModelProvider.BLOCK_FOLDER;

public class MultidirectionalBlock extends OmniDirectionalBlock {
    public MultidirectionalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition
                        .any().setValue(NORTH_UV,1).setValue(WEST_UV,1).setValue(BOTTOM_UV,1)
                        .setValue(SOUTH_UV,1).setValue(EAST_UV,1).setValue(TOP_UV,1)
        );
    }
    public static final IntegerProperty NORTH_UV = IntegerProperty.create("north_uv",1,4);
    public static final IntegerProperty SOUTH_UV = IntegerProperty.create("south_uv",1,4);
    public static final IntegerProperty EAST_UV = IntegerProperty.create("east_uv",1,4);
    public static final IntegerProperty WEST_UV = IntegerProperty.create("west_uv",1,4);
    public static final IntegerProperty TOP_UV = IntegerProperty.create("up_uv",1,4);
    public static final IntegerProperty BOTTOM_UV = IntegerProperty.create("down_uv",1,4);

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(0,0,0,16,16,16);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BOTTOM_UV).add(NORTH_UV).add(WEST_UV).add(EAST_UV).add(TOP_UV).add(SOUTH_UV);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return Objects.requireNonNull(
                super.getStateForPlacement(context)).setValue(BOTTOM_UV,1).setValue(TOP_UV,1)
                .setValue(NORTH_UV,1).setValue(SOUTH_UV,1).setValue(EAST_UV,1).setValue(WEST_UV,1);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(stack.is(Items.STICK)) {
            Vec3 v = player.getEyePosition();
            UseOnContext context = new UseOnContext(player,hand,hitResult);
            Direction direction = context.getClickedFace().getOpposite();
            switch (direction) {
                case UP -> state.setValue(TOP_UV,1+state.getValue(TOP_UV)%4);
                case DOWN -> state.setValue(BOTTOM_UV,1+state.getValue(BOTTOM_UV)%4);
                case NORTH -> state.setValue(NORTH_UV,1+state.getValue(NORTH_UV)%4);
                case SOUTH -> state.setValue(SOUTH_UV,1+state.getValue(SOUTH_UV)%4);
                case EAST -> state.setValue(EAST_UV,1+state.getValue(EAST_UV)%4);
                case WEST -> state.setValue(WEST_UV,1+state.getValue(WEST_UV)%4);
            }
        }
        return ItemInteractionResult.SUCCESS;
    }
}
