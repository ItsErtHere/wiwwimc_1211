package com.itserthere.wiwwimc.datagen;

import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.WIWWIMC;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WIWWIMC.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.REDSTONE_CORE);
        simpleBlockWithItem(ModBlocks.NETHER_CORE);
        simpleBlockWithItem(ModBlocks.BLAZING_CORE);
        simpleBlockWithItem(ModBlocks.STELLAR_CORE);
        simpleBlockWithItem(ModBlocks.ENDER_CORE);
        simpleBlockWithItem(ModBlocks.DIAMOND_CORE);
        simpleBlockWithItem(ModBlocks.IRON_TILE);
        simpleBlockWithItem(ModBlocks.POLISHED_IRON_TILE);
        simpleBlockWithItem(ModBlocks.FIRM_DRIPLEAF);
    }
    private void simpleBlockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),cubeAll(deferredBlock.get()));
    }
}
