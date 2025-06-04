package com.itserthere.wiwwimc.BlockEntities;

import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.WIWWIMC;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
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
                    CasingBlockEntity::new, ModBlocks.PORTALIC_CASING.get()
            ).build(null));
    public static final Supplier<BlockEntityType<CasingBlockEntity>> OBSIDIAN_CASING_BE =
            BLOCK_ENTITIES.register("obsidian_casing_be",()->BlockEntityType.Builder.of(
                    CasingBlockEntity::new, ModBlocks.OBSIDIAN_CASING.get()
            ).build(null));
}
