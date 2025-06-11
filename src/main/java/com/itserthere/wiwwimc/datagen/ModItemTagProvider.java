package com.itserthere.wiwwimc.datagen;

import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.ModTags;
import com.itserthere.wiwwimc.WIWWIMC;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, WIWWIMC.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.FRAME_MODIFIABLE_ITEMS)
                .addTag(ItemTags.PICKAXES).addTag(ItemTags.AXES).addTag(ItemTags.SWORDS)
                .addTag(ItemTags.SHOVELS).addTag(ItemTags.HOES).addTag(ItemTags.ARMOR_ENCHANTABLE)
                .add(Items.FLINT_AND_STEEL).addTag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .addTag(ItemTags.ARROWS).addTag(ItemTags.TRIM_TEMPLATES);
        tag(ModTags.Items.ALL_CASING_OBJECTS)
                .add(Item.byBlock(ModBlocks.STONE_CASING.get()))
                .add(Item.byBlock(ModBlocks.OBSIDIAN_CASING.get()))
                .add(Item.byBlock(ModBlocks.PLANT_CASING.get()))
                .add(Item.byBlock(ModBlocks.SOUL_IRON_CASING.get()))
                .add(Item.byBlock(ModBlocks.SOUL_GOLD_CASING.get()))
                .add(Item.byBlock(ModBlocks.BLACKSTONE_CASING.get()))
                .add(Item.byBlock(ModBlocks.DEEPSLATE_CASING.get()))
                .add(Item.byBlock(ModBlocks.BONE_CASING.get()))
                .add(Item.byBlock(ModBlocks.ALT_COPPER_GRATE.get()))
                .add(Item.byBlock(ModBlocks.ALT_EXPOSED_COPPER_GRATE.get()))
                .add(Item.byBlock(ModBlocks.ALT_WEATHERED_COPPER_GRATE.get()))
                .add(Item.byBlock(ModBlocks.ALT_OXIDIZED_COPPER_GRATE.get()));

    }
}
