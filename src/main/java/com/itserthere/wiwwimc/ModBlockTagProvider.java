package com.itserthere.wiwwimc;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, WIWWIMC.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        //TOOL TYPES
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.IRON_TILE.get())
                .add(ModBlocks.POLISHED_IRON_TILE.get())
                .add(ModBlocks.REDSTONE_CORE.get())
                .add(ModBlocks.NETHER_CORE.get())
                .add(ModBlocks.BLAZING_CORE.get())
                .add(ModBlocks.STELLAR_CORE.get())
                .add(ModBlocks.ENDER_CORE.get())
                .add(ModBlocks.DIAMOND_CORE.get())
                .add(ModBlocks.CAST_IRON.get())
                .add(ModBlocks.CHISELED_CAST_IRON.get())
                .add(ModBlocks.SMITHED_IRON.get())
                .add(ModBlocks.STURDY_STONE.get())
                .add(ModBlocks.CHISELED_STURDY_STONE.get())
                .add(ModBlocks.SMOOTH_STURDY_STONE.get())
                .add(ModBlocks.TUFF_TILE.get())
                .add(ModBlocks.TUFF_BRICK_TILE.get())
                .add(ModBlocks.TUFF_MOSAIC.get())
                .add(ModBlocks.TUFF_BRICK_MOSAIC.get())
                .add(ModBlocks.STURDY_STONE_TILE.get())
                .add(ModBlocks.SOUL_QUARTZ_TILES.get())
                .add(ModBlocks.SOUL_QUARTZ_BULBS.get())
                .add(ModBlocks.GLOWING_OBSIDIAN.get())
                .add(ModBlocks.PURPUR_TILE.get())
                .add(ModBlocks.OBSIDIAN_CASING.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SMITHED_OAK_PLANKS.get())
                .add(ModBlocks.OAK_VENTS.get())
                .add(ModBlocks.OAK_TILE.get())
                .add(ModBlocks.OAK_MOSAIC.get())
                .add(ModBlocks.OAK_LAYERS.get())
                .add(ModBlocks.BIRCH_TILE.get())
                .add(ModBlocks.SPRUCE_VENTS.get())
                .add(ModBlocks.SPRUCE_TILE.get())
                .add(ModBlocks.SPRUCE_LAYERS.get())
                .add(ModBlocks.DARK_OAK_TILE.get())
                .add(ModBlocks.DARK_OAK_LAYERS.get())
                .add(ModBlocks.CHISELED_DARK_OAK_PLANKS.get())
                .add(ModBlocks.ENCASED_OAK_PLANKS.get())
                .add(ModBlocks.BORDERED_SMOOTH_OAK_PLANKS.get())
        ;
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.FULL_GRASS.get())
                .add(ModBlocks.ALT_PODZOL.get())
                .add(ModBlocks.ALT_MYCELIUM.get())
                .add(ModBlocks.ALT_CRIMSON_NYLIUM.get())
                .add(ModBlocks.ALT_WARPED_NYLIUM.get());
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.SCULK_FRAME.get())
                .add(ModBlocks.ACTIVE_SCULK_FRAME.get())
                .add(ModBlocks.FIRM_DRIPLEAF.get())
                .add(ModBlocks.FIRM_DRIPLEAF_PARTIAL.get())
                .add(ModBlocks.FIRM_DRIPLEAF_FULL.get())
                .add(ModBlocks.FIRM_DRIPLEAF_XTRA.get())
                .add(ModBlocks.DRIPLEAF_STEM.get())
                .add(ModBlocks.HALF_DRIPLEAF.get())
                .add(ModBlocks.HALF_DRIPLEAF_PARTIAL.get())
                .add(ModBlocks.HALF_DRIPLEAF_FULL.get())
                .add(ModBlocks.HALF_DRIPLEAF_XTRA.get())
                .add(ModBlocks.HALF_DRIPLEAF_STEM.get())
                .add(ModBlocks.DRIPLEAF_LEAF.get())
                .add(ModBlocks.IDLE_SCULK.get())
                .add(ModBlocks.BRIGHT_IDLE_SCULK.get())
                .add(ModBlocks.BLOOMING_SCULK.get())
                .add(ModBlocks.BLUE_SCULK.get())
                .add(ModBlocks.CONDENSED_SCULK_CATALYST.get())
                .add(ModBlocks.SCULK_TUBE.get())
                .add(ModBlocks.ALT_FIRE_CORAL_BLOCK.get())
                .add(ModBlocks.ALT_HORN_CORAL_BLOCK.get())
                .add(ModBlocks.ALT_TUBE_CORAL_BLOCK.get())
                .add(ModBlocks.ALT_BRAIN_CORAL_BLOCK.get())
                .add(ModBlocks.ALT_BUBBLE_CORAL_BLOCK.get())
                .add(ModBlocks.ALT_MUSHROOM_STEM.get())
                .add(ModBlocks.ALT_BROWN_MUSHROOM_BLOCK.get())
                .add(ModBlocks.ALT_RED_MUSHROOM_BLOCK.get())
                .add(ModBlocks.STRIPPED_MUSHROOM_STEM.get());

        //TOOL TIERS
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.IRON_TILE.get())
                .add(ModBlocks.POLISHED_IRON_TILE.get())
                .add(ModBlocks.CAST_IRON.get())
                .add(ModBlocks.CHISELED_CAST_IRON.get())
                .add(ModBlocks.SMITHED_IRON.get())
                .add(ModBlocks.SMOOTH_STURDY_STONE.get())
                .add(ModBlocks.SMITHED_STURDY_STONE.get())
                .add(ModBlocks.STURDY_STONE.get())
                .add(ModBlocks.CHISELED_STURDY_STONE.get())
                .add(ModBlocks.STURDY_STONE_TILE.get())
                .add(ModBlocks.CHISELED_ANDESITE.get())
                .add(ModBlocks.ANDESITE_TILE.get())
                .add(ModBlocks.TUFF_TILE.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SCULK_FRAME.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.REDSTONE_CORE.get())
                .add(ModBlocks.NETHER_CORE.get())
                .add(ModBlocks.BLAZING_CORE.get())
                .add(ModBlocks.STELLAR_CORE.get())
                .add(ModBlocks.ENDER_CORE.get())
                .add(ModBlocks.DIAMOND_CORE.get())
                .add(ModBlocks.GLOWING_OBSIDIAN.get())
                .add(ModBlocks.OBSIDIAN_CASING.get())
        ;

        tag(BlockTags.FENCES)
                .add(ModBlocks.SMITHED_OAK_PLANKS_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.SMITHED_OAK_PLANKS_FENCE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.NETHER_CORE_WALL.get());

        //MODDED TAGS
        tag(ModTags.Blocks.DRIPLEAF_BLOCKS)
                .add(ModBlocks.FIRM_DRIPLEAF.get())
                .add(ModBlocks.FIRM_DRIPLEAF_PARTIAL.get())
                .add(ModBlocks.FIRM_DRIPLEAF_FULL.get())
                .add(ModBlocks.FIRM_DRIPLEAF_XTRA.get())
                .add(ModBlocks.DRIPLEAF_STEM.get())
                .add(ModBlocks.HALF_DRIPLEAF.get())
                .add(ModBlocks.HALF_DRIPLEAF_PARTIAL.get())
                .add(ModBlocks.HALF_DRIPLEAF_FULL.get())
                .add(ModBlocks.HALF_DRIPLEAF_XTRA.get())
                .add(ModBlocks.HALF_DRIPLEAF_STEM.get())
                .add(ModBlocks.DRIPLEAF_LEAF.get());
        tag(ModTags.Blocks.DRIPLEAF_HALVES)
                .add(ModBlocks.HALF_DRIPLEAF.get())
                .add(ModBlocks.HALF_DRIPLEAF_PARTIAL.get())
                .add(ModBlocks.HALF_DRIPLEAF_FULL.get())
                .add(ModBlocks.HALF_DRIPLEAF_XTRA.get())
                .add(ModBlocks.HALF_DRIPLEAF_STEM.get());
        tag(ModTags.Blocks.ALL_CASINGS)
                .add(ModBlocks.STONE_CASING.get())
                .add(ModBlocks.OBSIDIAN_CASING.get())
                .add(ModBlocks.PLANT_CASING.get())
                .add(ModBlocks.SOUL_IRON_CASING.get())
                .add(ModBlocks.SOUL_GOLD_CASING.get())
                .add(ModBlocks.BLACKSTONE_CASING.get())
                .add(ModBlocks.DEEPSLATE_CASING.get())
                .add(ModBlocks.BONE_CASING.get());
        tag(ModTags.Blocks.ALL_GRATES)
                .add(ModBlocks.ALT_COPPER_GRATE.get())
                .add(ModBlocks.ALT_EXPOSED_COPPER_GRATE.get())
                .add(ModBlocks.ALT_WEATHERED_COPPER_GRATE.get())
                .add(ModBlocks.ALT_OXIDIZED_COPPER_GRATE.get());
        tag(ModTags.Blocks.DEAD_CORAL_PLANTS)
                .add(ModBlocks.ALT_DEAD_FIRE_CORAL.get())
                .add(ModBlocks.ALT_DEAD_FIRE_CORAL_FAN.get())
                .add(ModBlocks.ALT_DEAD_FIRE_CORAL_WALL_FAN.get())
                .add(ModBlocks.ALT_DEAD_HORN_CORAL.get())
                .add(ModBlocks.ALT_DEAD_HORN_CORAL_FAN.get())
                .add(ModBlocks.ALT_DEAD_HORN_CORAL_WALL_FAN.get())
                .add(ModBlocks.ALT_DEAD_TUBE_CORAL.get())
                .add(ModBlocks.ALT_DEAD_TUBE_CORAL_FAN.get())
                .add(ModBlocks.ALT_DEAD_TUBE_CORAL_WALL_FAN.get())
                .add(ModBlocks.ALT_DEAD_BRAIN_CORAL.get())
                .add(ModBlocks.ALT_DEAD_BRAIN_CORAL_FAN.get())
                .add(ModBlocks.ALT_DEAD_BRAIN_CORAL_WALL_FAN.get())
                .add(ModBlocks.ALT_DEAD_BUBBLE_CORAL.get())
                .add(ModBlocks.ALT_DEAD_BUBBLE_CORAL_FAN.get())
                .add(ModBlocks.ALT_DEAD_BUBBLE_CORAL_WALL_FAN.get());
        tag(ModTags.Blocks.ALL_CORAL_PLANTS)
                .add(ModBlocks.ALT_FIRE_CORAL.get()).add(ModBlocks.ALT_DEAD_FIRE_CORAL.get())
                .add(ModBlocks.ALT_HORN_CORAL.get()).add(ModBlocks.ALT_DEAD_HORN_CORAL.get())
                .add(ModBlocks.ALT_TUBE_CORAL.get()).add(ModBlocks.ALT_DEAD_TUBE_CORAL.get())
                .add(ModBlocks.ALT_BRAIN_CORAL.get()).add(ModBlocks.ALT_DEAD_BRAIN_CORAL.get())
                .add(ModBlocks.ALT_BUBBLE_CORAL.get()).add(ModBlocks.ALT_DEAD_BUBBLE_CORAL.get());
        tag(ModTags.Blocks.ALL_CORAL_FANS)
                .add(ModBlocks.ALT_FIRE_CORAL_FAN.get()).add(ModBlocks.ALT_DEAD_FIRE_CORAL_FAN.get())
                .add(ModBlocks.ALT_HORN_CORAL_FAN.get()).add(ModBlocks.ALT_DEAD_HORN_CORAL_FAN.get())
                .add(ModBlocks.ALT_TUBE_CORAL_FAN.get()).add(ModBlocks.ALT_DEAD_TUBE_CORAL_FAN.get())
                .add(ModBlocks.ALT_BRAIN_CORAL_FAN.get()).add(ModBlocks.ALT_DEAD_BRAIN_CORAL_FAN.get())
                .add(ModBlocks.ALT_BUBBLE_CORAL_FAN.get()).add(ModBlocks.ALT_DEAD_BUBBLE_CORAL_FAN.get());
        tag(ModTags.Blocks.ALL_CORAL_WALL_FANS)
                .add(ModBlocks.ALT_FIRE_CORAL_WALL_FAN.get()).add(ModBlocks.ALT_DEAD_FIRE_CORAL_WALL_FAN.get())
                .add(ModBlocks.ALT_HORN_CORAL_WALL_FAN.get()).add(ModBlocks.ALT_DEAD_HORN_CORAL_WALL_FAN.get())
                .add(ModBlocks.ALT_TUBE_CORAL_WALL_FAN.get()).add(ModBlocks.ALT_DEAD_TUBE_CORAL_WALL_FAN.get())
                .add(ModBlocks.ALT_BRAIN_CORAL_WALL_FAN.get()).add(ModBlocks.ALT_DEAD_BRAIN_CORAL_WALL_FAN.get())
                .add(ModBlocks.ALT_BUBBLE_CORAL_WALL_FAN.get()).add(ModBlocks.ALT_DEAD_BUBBLE_CORAL_WALL_FAN.get());
        tag(ModTags.Blocks.ALL_FUNGI)
                .add(ModBlocks.ALT_BROWN_MUSHROOM.get()).add(ModBlocks.ALT_RED_MUSHROOM.get())
                .add(ModBlocks.ALT_CRIMSON_FUNGUS.get()).add(ModBlocks.ALT_WARPED_FUNGUS.get());





    }
}
