package com.itserthere.wiwwimc.datagen;

import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),registries);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.IRON_TILE.get());
        dropSelf(ModBlocks.POLISHED_IRON_TILE.get());
        dropSelf(ModBlocks.BLAZING_CORE.get());
        dropSelf(ModBlocks.NETHER_CORE.get());
        dropSelf(ModBlocks.STELLAR_CORE.get());
        dropSelf(ModBlocks.DIAMOND_CORE.get());
        dropSelf(ModBlocks.ENDER_CORE.get());
        dropSelf(ModBlocks.REDSTONE_CORE.get());
        dropSelf(ModBlocks.FIRM_DRIPLEAF.get());
        dropSelf(ModBlocks.SMITHED_OAK_PLANKS.get());
        dropSelf(ModBlocks.SMITHED_OAK_PLANKS_STAIRS.get());
        dropSelf(ModBlocks.SMITHED_OAK_PLANKS_FENCE.get());
        dropSelf(ModBlocks.SMITHED_OAK_PLANKS_FENCE_GATE.get());
        dropSelf(ModBlocks.SMITHED_OAK_PLANKS_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.SMITHED_OAK_PLANKS_STAIRS.get());
        dropSelf(ModBlocks.NETHER_CORE_WALL.get());
        dropSelf(ModBlocks.SCULK_FRAME.get());
        dropSelf(ModBlocks.FULL_GRASS.get());
        add(ModBlocks.SMITHED_OAK_PLANKS_SLAB.get(),
                block->createSlabItemTable(ModBlocks.SMITHED_OAK_PLANKS_SLAB.get()));

        //ORES
        //add(ModBlocks.EXAMPLE_ORE.get(),
        //        block->createOreDrop(ModBlocks.EXAMPLE_ORE.get(), ModItems.EXAMPLE_GEM.get()));
    }
}
