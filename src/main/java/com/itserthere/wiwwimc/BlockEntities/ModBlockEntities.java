package com.itserthere.wiwwimc.BlockEntities;

import com.google.common.collect.ImmutableSet;
import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.WIWWIMC;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, WIWWIMC.MODID);
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
    public static final Supplier<BlockEntityType<CasingBlockEntity>> CASING_BE =
            BLOCK_ENTITIES.register("casing_be",()->BlockEntityType.Builder.of(
                    CasingBlockEntity::new,
                    ModBlocks.STONE_CASING.get(),
                    ModBlocks.OBSIDIAN_CASING.get(),
                    ModBlocks.DEEPSLATE_CASING.get(),
                    ModBlocks.PLANT_CASING.get(),
                    ModBlocks.SOUL_GOLD_CASING.get(),
                    ModBlocks.SOUL_IRON_CASING.get(),
                    ModBlocks.BLACKSTONE_CASING.get(),
                    ModBlocks.ALT_COPPER_GRATE.get(),
                    ModBlocks.ALT_WEATHERED_COPPER_GRATE.get(),
                    ModBlocks.ALT_EXPOSED_COPPER_GRATE.get(),
                    ModBlocks.ALT_OXIDIZED_COPPER_GRATE.get(),
                    ModBlocks.BONE_CASING.get(),
                    ModBlocks.COPPER_FRAME.get(),
                    ModBlocks.EXPOSED_COPPER_FRAME.get(),
                    ModBlocks.WEATHERED_COPPER_FRAME.get(),
                    ModBlocks.OXIDIZED_COPPER_FRAME.get(),
                    ModBlocks.OAK_FRAME.get(),
                    ModBlocks.JUNGLE_FRAME.get(),
                    ModBlocks.ACACIA_FRAME.get(),
                    ModBlocks.MANGROVE_FRAME.get(),
                    ModBlocks.CHERRY_FRAME.get(),
                    ModBlocks.BAMBOO_FRAME.get(),
                    ModBlocks.CRIMSON_FRAME.get(),
                    ModBlocks.WARPED_FRAME.get(),
                    ModBlocks.IRON_FRAME.get()
            ).build(null));
}
