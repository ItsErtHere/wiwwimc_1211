package com.itserthere.wiwwimc.datagen;

import com.itserthere.wiwwimc.Blocks.OmniDirectionalBlock;
import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.WIWWIMC;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.core.FrontAndTop;
import net.minecraft.core.registries.BuiltInRegistries;
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

import java.util.Vector;
import java.util.function.Function;
import static com.itserthere.wiwwimc.ModBlocks.FIRM_DRIPLEAF;

public class ModBlockStateProvider extends BlockStateProvider {
    public boolean isRot = false;
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
        simpleBlockWithItem(ModBlocks.FULL_GRASS);
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
        blockWithItemAndVanillaTexture(ModBlocks.SCULK_FRAME,
                ResourceLocation.withDefaultNamespace("block/sculk_catalyst_inner_top"));


        blockItem(ModBlocks.SMITHED_OAK_PLANKS_SLAB);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_STAIRS);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_FENCE_GATE);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_PRESSURE_PLATE);
        blockItem(ModBlocks.NETHER_CORE_WALL);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_FENCE);
        dripleafBlockWithItem(FIRM_DRIPLEAF.get(), false,0);

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
    private void vanBlockWithItem(DeferredBlock<?> deferredBlock, String name) {
        blockWithItemAndVanillaTexture(deferredBlock,
                ResourceLocation.withDefaultNamespace("block/"+name));
    }

    private void blockWithItemAndVanillaTexture(DeferredBlock<?> deferredBlock, ResourceLocation rl)
    {
        simpleBlockWithItem(deferredBlock.get(),
                this.models().cubeAll(deferredBlock.get().toString(), rl)
        );
    }
    @SubscribeEvent
    public ModelFile getDripleafModel(boolean isSlab,int deg) {
        String st = "block/";
        if(isSlab) {st+="slab_dripleaf_";} else {st+="big_dripleaf_";}
        switch (deg) {
            case 0: {st+="norm"; break;}
            case 1: {st+="partial"; break;}
            case 2: {st+="full"; break;}
            case 3: {st+="xtra"; break;}
            case 4: {st+="stem"; break;}
        }
        return models().getExistingFile(ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,st));
    }
    @SubscribeEvent
    public ModelFile getRotDripleafModel(boolean isSlab,int deg) {
        String st = "block/";
        if(isSlab) {st+="slab_dripleaf_";} else {st+="big_dripleaf_";}
        switch (deg) {
            case 0: {st+="norm_rot"; break;}
            case 1: {st+="partial_rot"; break;}
            case 2: {st+="full_rot"; break;}
            case 3: {st+="xtra_rot"; break;}
            case 4: {st+="stem_rot"; break;}
        }
        return models().getExistingFile(ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,st));
    }
    public void omnidirectionalBlockWithItem(Block bl,ModelFile modelFile, ModelFile rotModelFile) {
        omniDirectionalBlock(bl,modelFile,rotModelFile,0);
        simpleBlockItem(bl, modelFile);
    }
    public void dripleafBlockWithItem(Block bl, boolean isSlab, int deg) {
        omnidirectionalBlockWithItem(bl, getDripleafModel(isSlab,deg), getRotDripleafModel(isSlab,deg));
    }
    public void omniDirectionalBlock(Block block, ModelFile modelFile, ModelFile rotModelFile,
                                     int angleOffset) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    Direction face = state.getValue(OmniDirectionalBlock.FACE);
                    Direction front = state.getValue(OmniDirectionalBlock.FRONT);
                    int rotX=0;int rotY=0; boolean use_rot = false;
                    switch (face) {
                        case DOWN -> {rotY = switch (front) {
                            case WEST -> 90; case NORTH -> 180; case EAST -> 270; default -> 0;
                        };}
                        case UP -> {rotX=180; rotY = switch (front) {
                            case EAST -> 90; case SOUTH -> 180; case WEST -> 270; default -> 0;
                        };}
                        case SOUTH -> { use_rot = true; switch (front) {
                            case EAST  -> {rotX=90;}
                            case WEST  -> {rotX=270; rotY=180;}
                            case DOWN    -> {rotX=90; use_rot=false;}
                            case UP  -> {rotX=270; rotY=180;  use_rot=false;}
                        };}
                        case NORTH -> { use_rot=true; switch (front) {
                            case EAST  -> {rotX=90; rotY=180;}
                            case WEST  -> {rotX=270;}
                            case UP    -> {rotX=270;           use_rot=false;}
                            case DOWN  -> {rotX=90; rotY=180;  use_rot=false;}
                        };}
                        case WEST -> { use_rot=true; switch (front) {
                            case SOUTH -> {rotX=270; rotY=270;}
                            case NORTH -> {rotX=90; rotY=90;}
                            case UP    -> {rotX=90; rotY=90;  use_rot=false;}
                            case DOWN  -> {rotX=270; rotY=270;use_rot=false;}
                        };}
                        case EAST -> {use_rot=true; switch (front) {
                            case SOUTH -> {rotX=90; rotY=270;}
                            case NORTH -> {rotX=270; rotY=90;} //
                            case UP    -> {rotX=90; rotY=270;  use_rot=false;}
                            case DOWN  -> {rotX=270; rotY=90; use_rot=false;}
                        };}

                    }
                    ModelFile newModelFile = use_rot ? rotModelFile : modelFile;
                    return ConfiguredModel.builder()
                            .modelFile(newModelFile).rotationX(rotX)
                            .rotationY(rotY).build();
                });
    }
}
