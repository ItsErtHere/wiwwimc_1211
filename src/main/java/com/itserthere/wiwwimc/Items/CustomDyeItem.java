package com.itserthere.wiwwimc.Items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

import static java.util.Map.*;

public class CustomDyeItem extends Item {
    private static final Map<Block, Block> DYE_MAP = of(
            Blocks.BLACK_WOOL,Blocks.RED_WOOL,
            Blocks.ORANGE_WOOL,Blocks.BROWN_WOOL,
            Blocks.YELLOW_WOOL, Blocks.LIME_WOOL,
            Blocks.GREEN_WOOL, Blocks.CYAN_WOOL,
            Blocks.LIGHT_BLUE_WOOL, Blocks.BLUE_WOOL,
            Blocks.PURPLE_WOOL, Blocks.PINK_WOOL,
            Blocks.MAGENTA_WOOL, Blocks.LIGHT_GRAY_WOOL,
            Blocks.GRAY_WOOL, Blocks.BLACK_WOOL
            );
    public CustomDyeItem(Properties properties) {
        super(properties);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        if(DYE_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(),
                        DYE_MAP.get(clickedBlock).defaultBlockState());
                context.getItemInHand().hurtAndBreak(1,((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
            }
        }

        return InteractionResult.SUCCESS;
    }

}
