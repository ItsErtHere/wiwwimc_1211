package com.itserthere.wiwwimc;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, WIWWIMC.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.IRON_TILE.get())
                .add(ModBlocks.POLISHED_IRON_TILE.get())
                .add(ModBlocks.REDSTONE_CORE.get())
                .add(ModBlocks.NETHER_CORE.get())
                .add(ModBlocks.BLAZING_CORE.get())
                .add(ModBlocks.STELLAR_CORE.get())
                .add(ModBlocks.ENDER_CORE.get())
                .add(ModBlocks.DIAMOND_CORE.get());
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.IRON_TILE.get())
                .add(ModBlocks.POLISHED_IRON_TILE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.REDSTONE_CORE.get())
                .add(ModBlocks.NETHER_CORE.get())
                .add(ModBlocks.BLAZING_CORE.get())
                .add(ModBlocks.STELLAR_CORE.get())
                .add(ModBlocks.ENDER_CORE.get())
                .add(ModBlocks.DIAMOND_CORE.get());



    }
}
