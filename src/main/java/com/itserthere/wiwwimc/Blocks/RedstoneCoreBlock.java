package com.itserthere.wiwwimc.Blocks;

import com.itserthere.wiwwimc.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class RedstoneCoreBlock extends Block {
    public RedstoneCoreBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(itemEntity.getItem().getItem()== Items.DIAMOND) {
                updateOrDestroy(ModBlocks.REDSTONE_CORE.get().defaultBlockState(),
                        ModBlocks.DIAMOND_CORE.get().defaultBlockState(),
                        level,pos,1);
            }
            else if(itemEntity.getItem().getItem()== Items.NETHERRACK) {
                updateOrDestroy(ModBlocks.REDSTONE_CORE.get().defaultBlockState(),
                        ModBlocks.NETHER_CORE.get().defaultBlockState(),
                        level,pos,1);
            }
            else if(itemEntity.getItem().getItem()== Items.NETHER_STAR) {
                updateOrDestroy(ModBlocks.REDSTONE_CORE.get().defaultBlockState(),
                        ModBlocks.STELLAR_CORE.get().defaultBlockState(),
                        level,pos,1);
            }
            else if(itemEntity.getItem().getItem()== Items.BLAZE_POWDER) {
                updateOrDestroy(ModBlocks.REDSTONE_CORE.get().defaultBlockState(),
                        ModBlocks.BLAZING_CORE.get().defaultBlockState(),
                        level,pos,1);
            }
            else if(itemEntity.getItem().getItem()== Items.ENDER_EYE) {
                updateOrDestroy(ModBlocks.REDSTONE_CORE.get().defaultBlockState(),
                        ModBlocks.ENDER_CORE.get().defaultBlockState(),
                        level,pos,1);
            }
        }
        super.stepOn(level, pos, state, entity);
    }
}
