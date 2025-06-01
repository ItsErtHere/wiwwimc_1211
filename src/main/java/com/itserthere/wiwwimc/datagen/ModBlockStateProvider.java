package com.itserthere.wiwwimc.datagen;

import com.itserthere.wiwwimc.Blocks.DripleafBlock;
import com.itserthere.wiwwimc.Blocks.MultidirectionalBlock;
import com.itserthere.wiwwimc.Blocks.OmniDirectionalBlock;
import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.WIWWIMC;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

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
        blockWithItemAndVanillaTexture(ModBlocks.ACTIVE_SCULK_FRAME,"sculk_shrieker_can_summon_inner_top");
        simpleBlockWithItem(ModBlocks.SCULK_CORE);
        simpleBlockWithItem(ACTIVE_SCULK_CORE);
        simpleBlockWithItem(SOULITE);
        blockWithItemAndVanillaTexture(ModBlocks.IDLE_SCULK,"sculk_sensor_bottom");
        blockWithItemAndVanillaTexture(BRIGHT_IDLE_SCULK,"sculk_shrieker_bottom");
        blockWithItemAndVanillaTexture(BLOOMING_SCULK,"sculk_catalyst_top_bloom");
        blockWithItemAndVanillaTexture(BLUE_SCULK,"sculk_sensor_top");
        pillarWithItemAndHMTexture(SCULK_TUBE,"sculk_tube","sculk_catalyst_bottom");
        blockWithItemAndVanillaTexture(ModBlocks.CONDENSED_SCULK_CATALYST,"sculk_catalyst_bottom");
        mDBlockWithItem(CHISELED_CAST_IRON,"observer_side");
        blockWithItemAndVanillaTexture(ModBlocks.CAST_IRON,"cauldron_inner");
        blockWithItemAndVanillaTexture(ModBlocks.SMITHED_IRON,"anvil");
        blockWithItemAndVanillaTexture(STURDY_STONE,"furnace_top");
        mDBlockWithItem(CHISELED_STURDY_STONE,"observer_top");
        blockWithItemAndVanillaTexture(SMOOTH_STURDY_STONE,"crafter_bottom");
        blockWithItemAndVanillaTexture(STURDY_STONE_TILE,"stonecutter_bottom");
        //blockWithItemAndVanillaTexture(ModBlocks.RESIN_TILE,"chiseled_resin_brick_top"); //1.21.4
        blockWithItemAndVanillaTexture(ModBlocks.CHISELED_ANDESITE,"lodestone_side");
        blockWithItemAndVanillaTexture(ModBlocks.ANDESITE_TILE,"lodestone_top");
        blockWithItemAndVanillaTexture(ModBlocks.TUFF_TILE,"chiseled_tuff_top");
        blockWithItemAndVanillaTexture(TUFF_BRICK_TILE,"chiseled_tuff_bricks_top");
        blockWithItemAndVanillaTexture(TUFF_MOSAIC,"chiseled_tuff");
        blockWithItemAndVanillaTexture(TUFF_BRICK_MOSAIC,"chiseled_tuff_bricks");
       blockWithItemAndVanillaTexture(ModBlocks.OAK_LAYERS,"beehive_side");
       simpleBlockWithItem(SMOOTH_OAK_PLANKS);
       blockWithItemAndVanillaTexture(ModBlocks.BORDERED_SMOOTH_OAK_PLANKS,"beehive_front");
       blockWithItemAndVanillaTexture(ModBlocks.OAK_MOSAIC,"chiseled_bookshelf_top");
       blockWithItemAndVanillaTexture(ModBlocks.OAK_VENTS ,"chiseled_bookshelf_empty");
       blockWithItemAndVanillaTexture(ModBlocks.CHISELED_OAK_PLANKS,"chiseled_bookshelf_side");
       blockWithItemAndVanillaTexture(ModBlocks.OAK_TILE,"lectern_top");
       simpleBlockWithItem(ENCASED_OAK_PLANKS);
       simpleBlockWithItem(BIRCH_TILE);
       simpleBlockWithItem(JUNGLE_TILE);
       blockWithItemAndVanillaTexture(ModBlocks.BAMBOO_TILE,"bee_nest_top");
       blockWithItemAndVanillaTexture(ModBlocks.BAMBOO_LAYERS,"bee_nest_side");
       blockWithItemAndVanillaTexture(ModBlocks.SPRUCE_VENTS,"loom_side");
       blockWithItemAndVanillaTexture(SMITHED_SPRUCE_PLANKS,"loom_top");
       blockWithItemAndVanillaTexture(ModBlocks.SPRUCE_LAYERS,"composter_side");
       blockWithItemAndVanillaTexture(CHISELED_SPRUCE_PLANKS,"composter_bottom");
        blockWithItemAndVanillaTexture(ENCASED_SPRUCE_PLANKS,"barrel_bottom");
       simpleBlockWithItem(SPRUCE_TILE);
       simpleBlockWithItem(CHISELED_DARK_OAK_PLANKS);
       blockWithItemAndVanillaTexture(ModBlocks.DARK_OAK_TILE,"smithing_table_bottom");
       blockWithItemAndVanillaTexture(ModBlocks.DARK_OAK_LAYERS,"loom_bottom");
       blockWithItemAndVanillaTexture(ModBlocks.SOUL_QUARTZ_TILES,"daylight_detector_side");
       blockWithItemAndVanillaTexture(ModBlocks.SOUL_QUARTZ_BULBS,"daylight_detector_top");
        blockWithItemAndVanillaTexture(ModBlocks.SOUL_QUARTZ,"vault_bottom");
        blockWithItemAndVanillaTexture(ModBlocks.SOUL_IRON_BLOCK,"trial_spawner_top_inactive_ominous");
        blockWithItemAndTexture(ModBlocks.SOUL_IRON_BARS_BLOCK,"soul_iron_bars");
        blockWithItemAndVanillaTexture(CHISELED_SOUL_IRON_BARS_BLOCK,"trial_spawner_side_inactive_ominous");
        simpleBlockWithItem(ModBlocks.SOUL_GOLD_BLOCK);
        //simpleBlockWithItem(ModBlocks.SOUL_GOLD_VENTS);
        blockWithItemAndVanillaTexture(SOUL_GOLD_BARS_BLOCK,"spawner");
        blockWithItemAndTexture(SOUL_GOLD_GRATES,"soul_gold_grates");
        blockWithItemAndVanillaTexture(ModBlocks.SOUL_GOLD_TILE,"trial_spawner_top_inactive_ominous");
        blockWithItemAndVanillaTexture(ModBlocks.ENCASED_SOULITE,"vault_top_ejecting");
        blockWithItemAndVanillaTexture(ModBlocks.SMITHED_TUFF,"vault_top_ominous");
        blockWithItemAndVanillaTexture(ModBlocks.ENCASED_SOUL_QUARTZ,"vault_top_ejecting_ominous");
        /*azalea_top, flowering_azalea_top, podzol, mycelium_top, crimson_nylium, warped_nylium, beacon, bee_nest_bottom,
        blast_furnace_side, blast_furnace_top, cake_bottom, dried_kelp_top, end_frame_top,
        farmland_dry, farmland_wet, glow_lichen, hopper_top (casing), polished_basalt_top (basalt tiles),
        portal, respawn_anchor_top, respawn_anchor_top_off, glowing_obsidian, stonecutter_top (old)
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
    private void pillarWithItemAndVanillaTexture(DeferredBlock<?> block, String sides, String bottom, String top) {
        simpleBlockWithItem(block.get(),models().cubeBottomTop(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                ResourceLocation.withDefaultNamespace("block/"+sides),
                ResourceLocation.withDefaultNamespace("block/"+bottom),
                ResourceLocation.withDefaultNamespace("block/"+top))
                .renderType("cutout"));
    }
    private void pillarWithItemAndHMTexture(DeferredBlock<?> block, String sides, String bottom, String top) {
        simpleBlockWithItem(block.get(),models().cubeBottomTop(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,"block/"+sides),
                ResourceLocation.withDefaultNamespace("block/"+bottom),
                ResourceLocation.withDefaultNamespace("block/"+top))
                .renderType("cutout"));
    }
    private void pillarWithItemAndHMTexture(DeferredBlock<?> block, String sides, String bottom) {
        simpleBlockWithItem(block.get(),models().cubeBottomTop(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,"block/"+sides),
                ResourceLocation.withDefaultNamespace("block/"+bottom),
                ResourceLocation.withDefaultNamespace("block/"+bottom))
                .renderType("cutout"));
    }
    private void pillarWithItemAndVanillaTexture(DeferredBlock<?> block, String sides, String bt) {
        pillarWithItemAndVanillaTexture(block,sides,bt,bt);
    }
    @SubscribeEvent
    public ModelFile getDripleafModel(boolean isSlab,int deg, boolean isRot, boolean isStretched) {
        String st = "block/";
        if(isSlab) {st+="slab_dripleaf";} else {st+="big_dripleaf";}
        switch (deg) {
            case 0: {st+="_norm"; break;}
            case 1: {st+="_partial"; break;}
            case 2: {st+="_full"; break;}
            case 3: {st+="_xtra"; break;}
            case 4: {st+="_stem"; break;}
            case 5: {st+="_leaf"; break;}
        }
        if(isRot) {st+="_rot";}
        if(isStretched) {st+="_stretched";}
        return models().getExistingFile(ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,st));
    }
    public ModelFile getMDModel(DeferredBlock<Block> deferredBlock,String texture_name, boolean isRot, boolean isVert) {
        String string = "template_multidirectional";
        String affix=(isVert ? "_vert" : "_horiz") + (isRot ? "_rot" : "");
        models().singleTexture(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath()+affix,
                ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,"block/"+string+affix),
                ResourceLocation.withDefaultNamespace("block/"+texture_name));
        return models().getExistingFile(ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,
                BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath()+affix));
    }
    public void omnidirectionalBlockWithItem(Block bl,ModelFile modelFile, ModelFile rotModelFile) {
        omniDirectionalBlock(bl,modelFile,rotModelFile,0);
        simpleBlockItem(bl, modelFile);
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
                        .renderType("cutout")
        );
    }
    private void blockWithItemAndTexture(DeferredBlock<?> deferredBlock, String name) {
        simpleBlockWithItem(deferredBlock.get(),
                models().cubeAll(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                                ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,"block/"+name))
                        .renderType("cutout")
        );
    }
    private void bAndIV(DeferredBlock<?> deferredBlock, String name) {
        simpleBlockWithItem(deferredBlock.get(),
                models().cubeAll(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                                ResourceLocation.withDefaultNamespace(name))
                        .renderType("cutout")
        );
    }
    private void directionalBIV(DeferredBlock<?> deferredBlock, String name) {
        directionalBlock(deferredBlock.get(),models().cubeAll(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                        ResourceLocation.withDefaultNamespace("block/"+name))
                .renderType("cutout"));
        simpleBlockItem(deferredBlock.get(),models().cubeAll(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                        ResourceLocation.withDefaultNamespace("block/"+name))
                .renderType("cutout"));
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
                            isSlab, deg, use_rot, state.getValue(DripleafBlock.STRETCHED));
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
    public void mDBlockWithItem(DeferredBlock<Block> bl, String texture_name) {
        multiDirectionalBlock(bl,texture_name);
        simpleBlockItem(bl.get(),getMDModel(bl,texture_name,false,false));
    }
    public void multiDirectionalBlock(DeferredBlock<Block> block, String texture_name) {
        getVariantBuilder(block.get())
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
                    ModelFile newModelFile = getMDModel(block,texture_name,use_rot,
                            state.getValue(MultidirectionalBlock.VERTICAL));
                    return ConfiguredModel.builder()
                            .modelFile(newModelFile).rotationX(rotX)
                            .rotationY(rotY).build();
                });
    }
}
