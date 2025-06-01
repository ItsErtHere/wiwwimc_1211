package com.itserthere.wiwwimc.datagen;

import com.itserthere.wiwwimc.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
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
        dropSelf(ModBlocks.SMITHED_OAK_PLANKS.get());
        dropSelf(ModBlocks.SMITHED_OAK_PLANKS_STAIRS.get());
        dropSelf(ModBlocks.SMITHED_OAK_PLANKS_FENCE.get());
        dropSelf(ModBlocks.SMITHED_OAK_PLANKS_FENCE_GATE.get());
        dropSelf(ModBlocks.SMITHED_OAK_PLANKS_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.SMITHED_OAK_PLANKS_STAIRS.get());
        dropSelf(ModBlocks.NETHER_CORE_WALL.get());
        dropSelf(ModBlocks.SCULK_FRAME.get());
        dropSelf(ModBlocks.ACTIVE_SCULK_FRAME.get());
        dropSelf(ModBlocks.FULL_GRASS.get());
        dropSelf(ModBlocks.SCULK_CORE.get());
        dropSelf(ModBlocks.ACTIVE_SCULK_CORE.get());
        dropSelf(ModBlocks.SOULITE.get());
        dropSelf(ModBlocks.IDLE_SCULK.get());
        dropSelf(ModBlocks.BRIGHT_IDLE_SCULK.get());
        dropSelf(ModBlocks.BLOOMING_SCULK.get());
        dropSelf(ModBlocks.BLUE_SCULK.get());
        dropSelf(ModBlocks.SCULK_TUBE.get());
        dropSelf(ModBlocks.CONDENSED_SCULK_CATALYST.get());
        dropSelf(ModBlocks.SMITHED_IRON.get());
        dropSelf(ModBlocks.CAST_IRON.get());
        dropSelf(ModBlocks.CHISELED_CAST_IRON.get());
        dropSelf(ModBlocks.STURDY_STONE.get());
        dropSelf(ModBlocks.CHISELED_STURDY_STONE.get());
        dropSelf(ModBlocks.SMOOTH_STURDY_STONE.get());
        dropSelf(ModBlocks.STURDY_STONE_TILE.get());
        dropSelf(ModBlocks.ANDESITE_TILE.get());
        dropSelf(ModBlocks.CHISELED_ANDESITE.get());
        dropSelf(ModBlocks.TUFF_TILE.get());
        dropSelf(ModBlocks.OAK_LAYERS.get());
        dropSelf(ModBlocks.OAK_MOSAIC.get());
        dropSelf(ModBlocks.OAK_TILE.get());
        dropSelf(ModBlocks.OAK_VENTS.get());
        dropSelf(ModBlocks.SMOOTH_OAK_PLANKS.get());
        dropSelf(ModBlocks.BIRCH_TILE.get());
        dropSelf(ModBlocks.SPRUCE_LAYERS.get());
        dropSelf(ModBlocks.SPRUCE_TILE.get());
        dropSelf(ModBlocks.SPRUCE_VENTS.get());
        dropSelf(ModBlocks.SMITHED_SPRUCE_PLANKS.get());
        dropSelf(ModBlocks.DARK_OAK_LAYERS.get());
        dropSelf(ModBlocks.DARK_OAK_TILE.get());
        dropSelf(ModBlocks.CHISELED_DARK_OAK_PLANKS.get());
        dropSelf(ModBlocks.ENCASED_OAK_PLANKS.get());
        dropSelf(ModBlocks.BORDERED_SMOOTH_OAK_PLANKS.get());
        dropSelf(ModBlocks.CHISELED_OAK_PLANKS.get());
        dropSelf(ModBlocks.JUNGLE_TILE.get());
        dropSelf(ModBlocks.BAMBOO_TILE.get());
        dropSelf(ModBlocks.BAMBOO_LAYERS.get());
        dropSelf(ModBlocks.CHISELED_SPRUCE_PLANKS.get());
        dropSelf(ModBlocks.SOUL_QUARTZ_BULBS.get());
        dropSelf(ModBlocks.SOUL_QUARTZ_TILES.get());
        dropSelf(ModBlocks.TUFF_BRICK_TILE.get());
        dropSelf(ModBlocks.TUFF_BRICK_MOSAIC.get());
        dropSelf(ModBlocks.TUFF_MOSAIC.get());
        dropSelf(ModBlocks.ENCASED_SPRUCE_PLANKS.get());
        dropSelf(ModBlocks.SOUL_QUARTZ.get());
        dropSelf(ModBlocks.SOUL_GOLD_BARS_BLOCK.get());
        dropSelf(ModBlocks.SOUL_IRON_BARS_BLOCK.get());
        dropSelf(ModBlocks.CHISELED_SOUL_IRON_BARS_BLOCK.get());
        dropSelf(ModBlocks.SOUL_GOLD_GRATES.get());
        dropSelf(ModBlocks.SOUL_GOLD_BLOCK.get());
        dropSelf(ModBlocks.SOUL_IRON_BLOCK.get());
        dropSelf(ModBlocks.SOUL_GOLD_TILE.get());
        dropSelf(ModBlocks.ENCASED_SOULITE.get());
        dropSelf(ModBlocks.ENCASED_SOUL_QUARTZ.get());
        dropSelf(ModBlocks.SMITHED_TUFF.get());






        //DRIPLEAFS
        dropSelf(ModBlocks.FIRM_DRIPLEAF.get());
        dropSelf(ModBlocks.FIRM_DRIPLEAF_PARTIAL.get());
        dropSelf(ModBlocks.FIRM_DRIPLEAF_FULL.get());
        dropSelf(ModBlocks.FIRM_DRIPLEAF_XTRA.get());
        dropSelf(ModBlocks.DRIPLEAF_STEM.get());
        dropSelf(ModBlocks.HALF_DRIPLEAF.get());
        dropSelf(ModBlocks.HALF_DRIPLEAF_PARTIAL.get());
        dropSelf(ModBlocks.HALF_DRIPLEAF_FULL.get());
        dropSelf(ModBlocks.HALF_DRIPLEAF_XTRA.get());
        dropSelf(ModBlocks.HALF_DRIPLEAF_STEM.get());
        dropSelf(ModBlocks.DRIPLEAF_LEAF.get());
        //SLABS
        add(ModBlocks.SMITHED_OAK_PLANKS_SLAB.get(),
                block->createSlabItemTable(ModBlocks.SMITHED_OAK_PLANKS_SLAB.get()));

        //ORES
        //add(ModBlocks.EXAMPLE_ORE.get(),
        //        block->createOreDrop(ModBlocks.EXAMPLE_ORE.get(), ModItems.EXAMPLE_GEM.get()));
    }
}
