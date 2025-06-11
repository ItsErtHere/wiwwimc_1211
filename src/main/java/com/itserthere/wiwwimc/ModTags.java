package com.itserthere.wiwwimc;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,name));
        }
        public static final TagKey<Block> DRIPLEAF_BLOCKS = createTag("dripleaf_blocks");
        public static final TagKey<Block> DRIPLEAF_HALVES = createTag("dripleaf_halves");
        public static final TagKey<Block> ALL_CASINGS = createTag("all_casings");
        public static final TagKey<Block> ALL_GRATES = createTag("all_grates");
        public static final TagKey<Block> ALL_FRAMES = createTag("all_frames");
        public static final TagKey<Block> DEAD_CORAL_PLANTS = createTag("dead_coral_plants");
        public static final TagKey<Block> ALL_CORAL_PLANTS = createTag("all_coral_plants");
        public static final TagKey<Block> ALL_CORAL_FANS = createTag("all_coral_fans");
        public static final TagKey<Block> ALL_CORAL_WALL_FANS = createTag("all_coral_wall_fans");
        public static final TagKey<Block> ALL_FUNGI = createTag("all_fungi");
    }
    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,name));
        }
        public static final TagKey<Item> FRAME_MODIFIABLE_ITEMS = createTag("frame_modifiable_items");
        public static final TagKey<Item> ALL_CASING_OBJECTS = createTag("all_casing_objects");
    }
}
