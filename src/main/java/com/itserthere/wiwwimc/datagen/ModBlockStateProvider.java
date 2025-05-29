package com.itserthere.wiwwimc.datagen;

import com.itserthere.wiwwimc.Blocks.DripleafBlock;
import com.itserthere.wiwwimc.Blocks.DripleafVoxels;
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

import static com.itserthere.wiwwimc.ModBlocks.*;

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
        blockWithItemAndVanillaTexture(ModBlocks.SCULK_FRAME,"sculk_shrieker_inner_top");
        /*
       blockWithItemAndVanillaTexture(ModBlocks.IDLE_SCULK,"sculk_catalyst_top");
       blockWithItemAndVanillaTexture(ModBlocks.SCULK_CORE,"sculk_catalyst_bottom");
       blockWithItemAndVanillaTexture(ModBlocks.CONDENSED_SCULK,"sculk_sensor_top");
       blockWithItemAndVanillaTexture(ModBlocks.SCULKY_PILLAR,"sculk_catalyst_side");

       blockWithItemAndVanillaTexture(ModBlocks.CHISELED_CAST_IRON,"cauldron_side");
       blockWithItemAndVanillaTexture(ModBlocks.CAST_IRON,"cauldron_bottom");
       blockWithItemAndVanillaTexture(ModBlocks.SMITHED_IRON,"anvil_top");
       blockWithItemAndVanillaTexture(ModBlocks.RESMITHED_IRON,"anvil_side"); //??

       blockWithItemAndVanillaTexture(ModBlocks.SMOOTH_STONE_TILE,"stonecutter_bottom");
       blockWithItemAndVanillaTexture(ModBlocks.STURDY_STONE_TILE,"crafter_bottom");
       blockWithItemAndVanillaTexture(ModBlocks.CHISELED_ANDESITE,"lodestone_side");
       blockWithItemAndVanillaTexture(ModBlocks.ANDESITE_TILE,"lodestone_top");
       blockWithItemAndVanillaTexture(ModBlocks.TUFF_TILE,"chiseled_tuff_brick_top");
       blockWithItemAndVanillaTexture(ModBlocks.RESIN_TILE,"chiseled_resin_brick_top");

       blockWithItemAndVanillaTexture(ModBlocks.OAK_LAYERS,"beehive_top");
       blockWithItemAndVanillaTexture(ModBlocks.SMOOTH_OAK,"beehive_side");
       blockWithItemAndVanillaTexture(ModBlocks.BORDERED_SMOOTH_OAK,"beehive_front");
       blockWithItemAndVanillaTexture(ModBlocks.OAK_MOSAIC,"chiseled_bookshelf_top");
       blockWithItemAndVanillaTexture(ModBlocks.OAK_VENTS ,"chiseled_bookshelf_front");
       blockWithItemAndVanillaTexture(ModBlocks.CHISELED_OAK,"chiseled_bookshelf_side");
       blockWithItemAndVanillaTexture(ModBlocks.OAK_TILE,"lectern_top");
       blockWithItemAndVanillaTexture(ModBlocks.ENCASED_OAK,"crafter_side"); //Stone encased
       blockWithItemAndVanillaTexture(ModBlocks.ENCASED_OAK_PILLAR,"crafter_back");

       blockWithItemAndVanillaTexture(ModBlocks.BIRCH_TILE,"fletching_table_top");
       blockWithItemAndVanillaTexture(ModBlocks.JUNGLE_TILE,"chest_top");

       blockWithItemAndVanillaTexture(ModBlocks.BAMBOO_TILE,"bee_nest_top");
       blockWithItemAndVanillaTexture(ModBlocks.BAMBOO_LAYERS,"bee_nest_side");

       blockWithItemAndVanillaTexture(ModBlocks.SPRUCE_VENTS,"loom_side");
       blockWithItemAndVanillaTexture(ModBlocks.SMITHED_SPRUCE,"loom_top");
       blockWithItemAndVanillaTexture(ModBlocks.SPRUCE_LAYERS,"composter_side");
       blockWithItemAndVanillaTexture(ModBlocks.CHISELED_SPRUCE,"composter_bottom");
       blockWithItemAndVanillaTexture(ModBlocks.SPRUCE_TILE,"barrel_top");

       blockWithItemAndVanillaTexture(ModBlocks.CHISELED_DARK_OAK,"smithing_table_side");
       blockWithItemAndVanillaTexture(ModBlocks.DARK_OAK_TILE,"smithing_table_bottom");
       blockWithItemAndVanillaTexture(ModBlocks.DARK_OAK_LAYERS,"loom_bottom");

       blockWithItemAndVanillaTexture(ModBlocks.SOUL_QUARTZ,"vault_bottom");
       blockWithItemAndVanillaTexture(ModBlocks.SOUL_QUARTZ_TILES,"daylight_detector_bottom");
       blockWithItemAndVanillaTexture(ModBlocks.SOUL_QUARTZ_BULBS,"daylight_detector_top");
       blockWithItemAndVanillaTexture(ModBlocks.SOUL_IRON_BLOCK,"trial_spawner_top");
       blockWithItemAndVanillaTexture(ModBlocks.SOUL_IRON_BARS,"vault_side");
       blockWithItemAndVanillaTexture(ModBlocks.CHISELED_SOUL_IRON_BARS,"vault_front");
       blockWithItemAndVanillaTexture(ModBlocks.SOUL_GOLD_BLOCK,"ender_chest_top");
       blockWithItemAndVanillaTexture(ModBlocks.SOUL_GOLD_BARS,"trial_spawner_bottom");
       blockWithItemAndVanillaTexture(ModBlocks.SOUL_GOLD_GRATES,"trial_spawner_side_inactive_ominous");
       blockWithItemAndVanillaTexture(ModBlocks.SOUL_GOLD_TILE,"trial_spawner_top_ejecting");

         */

        blockItem(ModBlocks.SMITHED_OAK_PLANKS_SLAB);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_STAIRS);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_FENCE_GATE);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_PRESSURE_PLATE);
        blockItem(ModBlocks.NETHER_CORE_WALL);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_FENCE);
        //DRIPLEAFS
        dripleafBlockWithItem(FIRM_DRIPLEAF.get(), false,0);
        dripleafBlockWithItem(FIRM_DRIPLEAF_PARTIAL.get(), false,1);
        dripleafBlockWithItem(FIRM_DRIPLEAF_FULL.get(), false,2);
        dripleafBlockWithItem(FIRM_DRIPLEAF_XTRA.get(), false,3);
        dripleafBlockWithItem(DRIPLEAF_STEM.get(), false,4);
        dripleafBlockWithItem(HALF_DRIPLEAF.get(), true,0);
        dripleafBlockWithItem(HALF_DRIPLEAF_PARTIAL.get(), true,1);
        dripleafBlockWithItem(HALF_DRIPLEAF_FULL.get(), true,2);
        dripleafBlockWithItem(HALF_DRIPLEAF_XTRA.get(), true,3);
        dripleafBlockWithItem(HALF_DRIPLEAF_STEM.get(), true,4);
        dripleafBlockWithItem(DRIPLEAF_LEAF.get(), false,5);


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

    private void blockWithItemAndVanillaTexture(DeferredBlock<?> deferredBlock, String name) {
        simpleBlockWithItem(deferredBlock.get(),
                models().cubeAll(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                        ResourceLocation.withDefaultNamespace("block/"+name))
        );
    }
    @SubscribeEvent
    public ModelFile getDripleafModel(boolean isSlab,int deg, boolean isRot, boolean isStretched) {
        String st = "block/";
        if(isSlab) {st+="slab_dripleaf_";} else {st+="big_dripleaf_";}
        switch (deg) {
            case 0: {st+="norm"; break;}
            case 1: {st+="partial"; break;}
            case 2: {st+="full"; break;}
            case 3: {st+="xtra"; break;}
            case 4: {st+="stem"; break;}
            case 5: {st+="leaf"; break;}
        }
        if(isRot) {st+="_rot";}
        if(isStretched) {st+="_stretched";}
        return models().getExistingFile(ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,st));
    }
    public void omnidirectionalBlockWithItem(Block bl,ModelFile modelFile, ModelFile rotModelFile) {
        omniDirectionalBlock(bl,modelFile,rotModelFile,0);
        simpleBlockItem(bl, modelFile);
    }
    public void dripleafBlockWithItem(Block bl, boolean isSlab, int deg) {
        dripleafBlock(bl,isSlab,deg);
        simpleBlockItem(bl,getDripleafModel(isSlab, deg,false,false));
    }
    public void dripleafBlock(Block bl, boolean isSlab, int deg) {
        getVariantBuilder(bl)
                .forAllStates(state -> {
                    Direction face = state.getValue(OmniDirectionalBlock.FACE);
                    Direction front = state.getValue(OmniDirectionalBlock.FRONT);
                    int rotX=0;int rotY=0; boolean use_rot = false;
                    switch (face) {
                        case DOWN -> {rotY = switch (front) {
                            case WEST -> 270; case SOUTH -> 180; case EAST -> 90; default -> 0;
                        };}
                        case UP -> {rotX=180; rotY = switch (front) {
                            case EAST -> 270; case NORTH -> 180; case WEST -> 90; default -> 0;
                        };}
                        case SOUTH -> { use_rot = true; switch (front) {
                            case EAST  -> {rotX=270; rotY=180;}
                            case WEST  -> {rotX=90;}
                            case DOWN  -> {rotX=270; rotY=180;  use_rot=false;}
                            case UP    -> {rotX=90; use_rot=false;}
                        };}
                        case NORTH -> { use_rot=true; switch (front) {
                            case EAST  -> {rotX=270;}
                            case WEST  -> {rotX=90; rotY=180;}
                            case UP    -> {rotX=90; rotY=180;   use_rot=false;}
                            case DOWN  -> {rotX=270;  use_rot=false;}
                        };}
                        case WEST -> { use_rot=true; switch (front) {
                            case SOUTH -> {rotX=90; rotY=90;}
                            case NORTH -> {rotX=270; rotY=270;}
                            case UP    -> {rotX=270; rotY=270;use_rot=false;}
                            case DOWN  -> {rotX=90; rotY=90;  use_rot=false;}
                        };}
                        case EAST -> {use_rot=true; switch (front) {
                            case SOUTH -> {rotX=270; rotY=90;}
                            case NORTH -> {rotX=90; rotY=270;}
                            case UP    -> {rotX=270; rotY=90;  use_rot=false;}
                            case DOWN  -> {rotX=90; rotY=270; use_rot=false;}
                        };}

                    }
                    ModelFile newModelFile = getDripleafModel(
                            DripleafVoxels.getSlab(state),
                            DripleafVoxels.getTilt(state), use_rot,
                            state.getValue(DripleafBlock.STRETCHED));
                    return ConfiguredModel.builder()
                            .modelFile(newModelFile).rotationX(rotX)
                            .rotationY(rotY).build();
                });
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
                            case WEST -> 270; case SOUTH -> 180; case EAST -> 90; default -> 0;
                        };}
                        case UP -> {rotX=180; rotY = switch (front) {
                            case EAST -> 270; case NORTH -> 180; case WEST -> 90; default -> 0;
                        };}
                        case SOUTH -> { use_rot = true; switch (front) {
                            case EAST  -> {rotX=270; rotY=180;}
                            case WEST  -> {rotX=90;}
                            case DOWN  -> {rotX=270; rotY=180;  use_rot=false;}
                            case UP    -> {rotX=90; use_rot=false;}
                        };}
                        case NORTH -> { use_rot=true; switch (front) {
                            case EAST  -> {rotX=270;}
                            case WEST  -> {rotX=90; rotY=180;}
                            case UP    -> {rotX=90; rotY=180;   use_rot=false;}
                            case DOWN  -> {rotX=270;  use_rot=false;}
                        };}
                        case WEST -> { use_rot=true; switch (front) {
                            case SOUTH -> {rotX=90; rotY=90;}
                            case NORTH -> {rotX=270; rotY=270;}
                            case UP    -> {rotX=270; rotY=270;use_rot=false;}
                            case DOWN  -> {rotX=90; rotY=90;  use_rot=false;}
                        };}
                        case EAST -> {use_rot=true; switch (front) {
                            case SOUTH -> {rotX=270; rotY=90;}
                            case NORTH -> {rotX=90; rotY=270;}
                            case UP    -> {rotX=270; rotY=90;  use_rot=false;}
                            case DOWN  -> {rotX=90; rotY=270; use_rot=false;}
                        };}

                    }
                    ModelFile newModelFile = use_rot ? rotModelFile : modelFile;
                    return ConfiguredModel.builder()
                            .modelFile(newModelFile).rotationX(rotX)
                            .rotationY(rotY).build();
                });
    }
}
