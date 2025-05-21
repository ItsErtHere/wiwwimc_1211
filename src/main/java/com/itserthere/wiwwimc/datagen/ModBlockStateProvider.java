package com.itserthere.wiwwimc.datagen;

import com.itserthere.wiwwimc.Blocks.CustomDripleafBlock;
import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.WIWWIMC;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.spongepowered.asm.mixin.injection.Inject;

import static com.itserthere.wiwwimc.ModBlocks.FIRM_DRIPLEAF;

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
        simpleBlockWithItem(ModBlocks.SMITHED_OAK_PLANKS);
        stairsBlock(ModBlocks.SMITHED_OAK_PLANKS_STAIRS.get(),
                blockTexture(ModBlocks.SMITHED_OAK_PLANKS.get()));
        pressurePlateBlock(ModBlocks.SMITHED_OAK_PLANKS_PRESSURE_PLATE.get(),
                blockTexture(ModBlocks.SMITHED_OAK_PLANKS.get()));
        fenceBlock(ModBlocks.SMITHED_OAK_PLANKS_FENCE.get(),
                blockTexture(ModBlocks.SMITHED_OAK_PLANKS.get()));
        fenceGateBlock(ModBlocks.SMITHED_OAK_PLANKS_FENCE_GATE.get(),
                blockTexture(ModBlocks.SMITHED_OAK_PLANKS.get()));
        slabBlock(ModBlocks.SMITHED_OAK_PLANKS_SLAB.get(),
                blockTexture(ModBlocks.SMITHED_OAK_PLANKS.get()),
                blockTexture(ModBlocks.SMITHED_OAK_PLANKS.get()));
        wallBlock(ModBlocks.NETHER_CORE_WALL.get(),
                blockTexture(ModBlocks.NETHER_CORE.get()));


        blockItem(ModBlocks.SMITHED_OAK_PLANKS_SLAB);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_STAIRS);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_FENCE_GATE);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_PRESSURE_PLATE);
        blockItem(ModBlocks.NETHER_CORE_WALL);
        blockItem(ModBlocks.FULL_GRASS);
        simpleBlockItem(FIRM_DRIPLEAF.get(), getDripleafModel(false, 0, Direction.EAST));

    }
    private void simpleBlockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),cubeAll(deferredBlock.get()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(),
                new ModelFile.UncheckedModelFile("wiwwimc:block/"+deferredBlock.getId().getPath()+appendix));
    }
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(),
                new ModelFile.UncheckedModelFile("wiwwimc:block/"+deferredBlock.getId().getPath()));
    }
    @SubscribeEvent
    public ModelFile getDripleafModel(boolean isSlab,float deg,Direction facing) {
        return models().getExistingFile(ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,"block/firm_dripleaf"));
    }
    private void getDripleafBlockstate(boolean isSlab, float degree) {
        getVariantBuilder(FIRM_DRIPLEAF.get()).forAllStates(state -> {
            return new ConfiguredModel[]{
                    new ConfiguredModel(getDripleafModel(isSlab, degree,
                            state.getValue(CustomDripleafBlock.FACING)))};
        });
    }
}
