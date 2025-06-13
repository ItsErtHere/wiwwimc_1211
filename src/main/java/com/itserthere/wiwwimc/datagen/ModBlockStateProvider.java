package com.itserthere.wiwwimc.datagen;

import com.itserthere.wiwwimc.Blocks.DripleafBlock;
import com.itserthere.wiwwimc.Blocks.MultidirectionalBlock;
import com.itserthere.wiwwimc.Blocks.OmniDirectionalBlock;
import com.itserthere.wiwwimc.DirectionalPartialBlock;
import com.itserthere.wiwwimc.Helpers;
import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.WIWWIMC;
import jdk.jfr.Description;
import jdk.jfr.Label;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.model.CompositeModel;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.client.model.generators.loaders.CompositeModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.checkerframework.framework.qual.InheritedAnnotation;
import org.checkerframework.framework.qual.PostconditionAnnotation;
import org.spongepowered.asm.mixin.injection.Desc;

import static com.itserthere.wiwwimc.ModBlocks.*;
import static net.minecraft.core.Direction.SOUTH;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WIWWIMC.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        bAndI(ModBlocks.REDSTONE_CORE);
        bAndI(ModBlocks.NETHER_CORE);
        bAndI(ModBlocks.BLAZING_CORE);
        bAndI(ModBlocks.STELLAR_CORE);
        bAndI(ModBlocks.ENDER_CORE);
        bAndI(ModBlocks.DIAMOND_CORE);
        bAndI(ModBlocks.IRON_TILE);
        bAndI(ModBlocks.POLISHED_IRON_TILE);
        bAndI(ModBlocks.SMITHED_OAK_PLANKS);
        bAndI(ModBlocks.FULL_GRASS);
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
        bAndIVC(ModBlocks.SCULK_FRAME,"sculk_shrieker_inner_top");
        bAndIVC(ModBlocks.ACTIVE_SCULK_FRAME,"sculk_shrieker_can_summon_inner_top");
        bAndI(ModBlocks.SCULK_CORE);
        bAndI(ACTIVE_SCULK_CORE);
        bAndI(SOULITE);
        bAndIVC(ModBlocks.IDLE_SCULK,"sculk_sensor_bottom");
        bAndIVC(BRIGHT_IDLE_SCULK,"sculk_shrieker_bottom");
        bAndIVC(BLOOMING_SCULK,"sculk_catalyst_top_bloom");
        bAndIVC(BLUE_SCULK,"sculk_sensor_top");
        pAndIV(SCULK_TUBE,"sculk_tube","sculk_catalyst_bottom");
        bAndIVC(ModBlocks.CONDENSED_SCULK_CATALYST,"sculk_catalyst_bottom");
        mDBlockWithItem(CHISELED_CAST_IRON,ResourceLocation.withDefaultNamespace("block/observer_side"));
        bAndIVC(ModBlocks.CAST_IRON,"cauldron_inner");
        bAndIVC(ModBlocks.SMITHED_IRON,"anvil");
        bAndIVC(STURDY_STONE,"furnace_top");
        mDBlockWithItem(CHISELED_STURDY_STONE,ResourceLocation.withDefaultNamespace("block/observer_top"));
        bAndIVC(SMOOTH_STURDY_STONE,"crafter_bottom");
        bAndIVC(STURDY_STONE_TILE,"stonecutter_bottom");
        //blockWithItemAndVanillaTexture(ModBlocks.RESIN_TILE,"chiseled_resin_brick_top"); //1.21.4
        bAndIVC(ModBlocks.CHISELED_ANDESITE,"lodestone_side");
        bAndIVC(ModBlocks.ANDESITE_TILE,"lodestone_top");
        bAndIVC(ModBlocks.TUFF_TILE,"chiseled_tuff_top");
        bAndIVC(TUFF_BRICK_TILE,"chiseled_tuff_bricks_top");
        bAndIVC(TUFF_MOSAIC,"chiseled_tuff");
        bAndIVC(TUFF_BRICK_MOSAIC,"chiseled_tuff_bricks");
       bAndIVC(ModBlocks.OAK_LAYERS,"beehive_side");
       bAndI(SMOOTH_OAK_PLANKS);
       bAndIVC(ModBlocks.BORDERED_SMOOTH_OAK_PLANKS,"beehive_end");
       bAndIVC(ModBlocks.OAK_MOSAIC,"chiseled_bookshelf_top");
       bAndIVC(ModBlocks.OAK_VENTS ,"chiseled_bookshelf_empty");
       bAndIVC(ModBlocks.CHISELED_OAK_PLANKS,"chiseled_bookshelf_side");
       bAndIVC(ModBlocks.OAK_TILE,"lectern_top");
       bAndI(ENCASED_OAK_PLANKS);
       bAndI(BIRCH_TILE);
       bAndI(JUNGLE_TILE);
       bAndIVC(ModBlocks.BAMBOO_TILE,"bee_nest_top");
       bAndIVC(ModBlocks.BAMBOO_LAYERS,"bee_nest_side");
       bAndIVC(ModBlocks.SPRUCE_VENTS,"loom_side");
       bAndIVC(SMITHED_SPRUCE_PLANKS,"loom_top");
       bAndIVC(ModBlocks.SPRUCE_LAYERS,"composter_side");
       bAndIVC(CHISELED_SPRUCE_PLANKS,"composter_bottom");
        bAndIVC(ENCASED_SPRUCE_PLANKS,"barrel_bottom");
       bAndI(SPRUCE_TILE);
       bAndI(CHISELED_DARK_OAK_PLANKS);
       bAndIVC(ModBlocks.DARK_OAK_TILE,"smithing_table_bottom");
       bAndIVC(ModBlocks.DARK_OAK_LAYERS,"loom_bottom");
       bAndIVC(ModBlocks.SOUL_QUARTZ_TILES,"daylight_detector_side");
       bAndIVC(ModBlocks.SOUL_QUARTZ_BULBS,"daylight_detector_top");
        bAndIVC(ModBlocks.SOUL_QUARTZ,"vault_bottom");
        bAndIVC(ModBlocks.SOUL_IRON_BLOCK,"trial_spawner_top_inactive_ominous");
        bAndIC(ModBlocks.SOUL_IRON_BARS_BLOCK,"soul_iron_bars");
        bAndIVC(CHISELED_SOUL_IRON_BARS_BLOCK,"trial_spawner_side_inactive_ominous");
        bAndI(ModBlocks.SOUL_GOLD_BLOCK);
        //simpleBlockWithItem(ModBlocks.SOUL_GOLD_VENTS);
        bAndIVC(SOUL_GOLD_BARS_BLOCK,"spawner");
        bAndIC(SOUL_GOLD_GRATES,"soul_gold_grates");
        bAndIVC(ModBlocks.SOUL_GOLD_TILE,"vault_top");
        bAndIVC(ModBlocks.ENCASED_SOULITE,"vault_top_ejecting");
        bAndIVC(ModBlocks.SMITHED_TUFF,"vault_top_ominous");
        bAndIVC(ModBlocks.ENCASED_SOUL_QUARTZ,"vault_top_ejecting_ominous");
        bAndIVC(AZALEA_BUSH,"azalea_top");
        bAndIVC(FLOWERING_AZALEA_BUSH,"flowering_azalea_top");
        bAndI(GLOWING_OBSIDIAN);
        bAndIVT(PORTALIC_BLOCK,"nether_portal");
        bAndIVT(WATER_TANK,"water_still");
        bAndIVT(LAVA_TANK,"lava_still");
        //CASINGS
        bAndIC(OBSIDIAN_CASING,"obsidian_casing");
        bAndIC(STONE_CASING,"stone_casing");
        bAndIC(DEEPSLATE_CASING,"deepslate_casing");
        bAndIC(PLANT_CASING,"plant_casing");
        bAndIC(BLACKSTONE_CASING,"blackstone_casing");
        bAndIC(SOUL_GOLD_CASING,"soul_gold_casing");
        bAndIC(SOUL_IRON_CASING,"soul_iron_casing");
        bAndIV(ALT_COPPER_GRATE,"copper_grate");
        bAndIV(ALT_EXPOSED_COPPER_GRATE,"exposed_copper_grate");
        bAndIV(ALT_WEATHERED_COPPER_GRATE,"weathered_copper_grate");
        bAndIV(ALT_OXIDIZED_COPPER_GRATE,"oxidized_copper_grate");
        bAndIC(BONE_CASING,"bone_casing");
        //FRAMES
        bAndIV(COPPER_FRAME,"copper_trapdoor");
        bAndIV(EXPOSED_COPPER_FRAME,"exposed_copper_trapdoor");
        bAndIV(WEATHERED_COPPER_FRAME,"weathered_copper_trapdoor");
        bAndIV(OXIDIZED_COPPER_FRAME,"oxidized_copper_trapdoor");
        bAndIV(OAK_FRAME,"oak_trapdoor");
        bAndIC(JUNGLE_FRAME,"jungle_frame");
        bAndIC(ACACIA_FRAME,"acacia_frame");
        bAndIV(MANGROVE_FRAME,"mangrove_trapdoor");
        bAndIC(CHERRY_FRAME,"cherry_frame");
        bAndIC(BAMBOO_FRAME,"bamboo_frame");
        bAndIV(CRIMSON_FRAME,"crimson_trapdoor");
        bAndIV(WARPED_FRAME,"warped_trapdoor");
        bAndIV(IRON_FRAME,"iron_trapdoor");
        //FUNGI
        bAndIV(ALT_RED_MUSHROOM_BLOCK,"red_mushroom_block");
        bAndIV(ALT_BROWN_MUSHROOM_BLOCK,"brown_mushroom_block");
        bAndIV(ALT_MUSHROOM_STEM,"mushroom_stem");
        bAndIV(STRIPPED_MUSHROOM_STEM,"mushroom_block_inside");
        //CORALS
        bAndIV(ALT_FIRE_CORAL_BLOCK,"fire_coral_block");
        bAndIV(ALT_HORN_CORAL_BLOCK,"horn_coral_block");
        bAndIV(ALT_TUBE_CORAL_BLOCK,"tube_coral_block");
        bAndIV(ALT_BRAIN_CORAL_BLOCK,"brain_coral_block");
        bAndIV(ALT_BUBBLE_CORAL_BLOCK,"bubble_coral_block");

        odBAndI(ALT_FIRE_CORAL_WALL_FAN,"fire_coral_wall_fan");
        dpBAndIV(ALT_FIRE_CORAL_FAN,"coral_fan","fire_coral_fan");
        dpBAndIV(ALT_FIRE_CORAL,"cross","fire_coral");
        odBAndI(ALT_DEAD_FIRE_CORAL_WALL_FAN,"template_coral_wall_fan","dead_fire_coral_fan");
        dpBAndIV(ALT_DEAD_FIRE_CORAL_FAN,"coral_fan","dead_fire_coral_fan");
        dpBAndIV(ALT_DEAD_FIRE_CORAL,"cross","dead_fire_coral");

        odBAndI(ALT_HORN_CORAL_WALL_FAN,"horn_coral_wall_fan");
        dpBAndIV(ALT_HORN_CORAL_FAN,"coral_fan","horn_coral_fan");
        dpBAndIV(ALT_HORN_CORAL,"cross","horn_coral");
        odBAndI(ALT_DEAD_HORN_CORAL_WALL_FAN,"template_coral_wall_fan","dead_horn_coral_fan");
        dpBAndIV(ALT_DEAD_HORN_CORAL_FAN,"coral_fan","dead_horn_coral_fan");
        dpBAndIV(ALT_DEAD_HORN_CORAL,"cross","dead_horn_coral");

        odBAndI(ALT_TUBE_CORAL_WALL_FAN,"tube_coral_wall_fan");
        dpBAndIV(ALT_TUBE_CORAL_FAN,"coral_fan","tube_coral_fan");
        dpBAndIV(ALT_TUBE_CORAL,"cross","tube_coral");
        odBAndI(ALT_DEAD_TUBE_CORAL_WALL_FAN,"template_coral_wall_fan","dead_tube_coral_fan");
        dpBAndIV(ALT_DEAD_TUBE_CORAL_FAN,"coral_fan","dead_tube_coral_fan");
        dpBAndIV(ALT_DEAD_TUBE_CORAL,"cross","dead_tube_coral");

        odBAndI(ALT_BRAIN_CORAL_WALL_FAN,"brain_coral_wall_fan");
        dpBAndIV(ALT_BRAIN_CORAL_FAN,"coral_fan","brain_coral_fan");
        dpBAndIV(ALT_BRAIN_CORAL,"cross","brain_coral");
        odBAndI(ALT_DEAD_BRAIN_CORAL_WALL_FAN,"template_coral_wall_fan","dead_brain_coral_fan");
        dpBAndIV(ALT_DEAD_BRAIN_CORAL_FAN,"coral_fan","dead_brain_coral_fan");
        dpBAndIV(ALT_DEAD_BRAIN_CORAL,"cross","dead_brain_coral");

        odBAndI(ALT_BUBBLE_CORAL_WALL_FAN,"bubble_coral_wall_fan");
        dpBAndIV(ALT_BUBBLE_CORAL_FAN,"coral_fan","bubble_coral_fan");
        dpBAndIV(ALT_BUBBLE_CORAL,"cross","bubble_coral");
        odBAndI(ALT_DEAD_BUBBLE_CORAL_WALL_FAN,"template_coral_wall_fan","dead_bubble_coral_fan");
        dpBAndIV(ALT_DEAD_BUBBLE_CORAL_FAN,"coral_fan","dead_bubble_coral_fan");
        dpBAndIV(ALT_DEAD_BUBBLE_CORAL,"cross","dead_bubble_coral");

        //FUNGI
        dpBAndIV(ALT_BROWN_MUSHROOM,"cross","brown_mushroom");
        dpBAndIV(ALT_RED_MUSHROOM,"cross","red_mushroom");
        dpBAndIV(ALT_CRIMSON_FUNGUS,"cross","crimson_fungus");
        dpBAndIV(ALT_WARPED_FUNGUS,"cross","warped_fungus");


        //ALT BLOCKS
        bAndIVC(ALT_CRIMSON_NYLIUM,"crimson_nylium");
        bAndIVC(ALT_WARPED_NYLIUM,"warped_nylium");
        bAndIVC(ALT_MYCELIUM,"mycelium_top");
        bAndIVC(ALT_PODZOL,"podzol_top");
        bAndIVC(ALT_DRY_FARMLAND,"farmland");
        bAndIVC(ALT_WET_FARMLAND,"farmland_moist");
        bAndIVC(PURPUR_TILE,"purpur_pillar_top");
        bAndIVC(SMITHED_STURDY_STONE, "blast_furnace_top");

        bAndIV(SMITHED_DEEPSLATE, "reinforced_deepslate_top");
        bAndIV(STURDY_STONE_VENTS, "smoker_top");
        bAndIV(ALT_BASALT, "basalt_top");
        bAndIV(ALT_BONE_BLOCK, "bone_block_top");
        pAndIVV(ALT_REINFORCED_DEEPSLATE,"reinforced_deepslate_side", "reinforced_deepslate_top");
        pAndIVV(ALT_CHISELED_TUFF,"chiseled_tuff", "chiseled_tuff_top");
        pAndIVV(ALT_CHISELED_TUFF_BRICKS,"chiseled_tuff_bricks", "chiseled_tuff_bricks_top");
        /*beacon, bee_nest_bottom, blast_furnace_side (MD), cake_bottom, dried_kelp_top,
        end_frame_top (BE), [alt_glow_lichen.json], hopper_top (casing),
        polished_basalt_top (basalt tiles), portal, {respawn_anchor_top_off} (casing),
        stonecutter_top (old)
        Fire, Brain, Bubble, Tube, Horn||Coral Block, Coral, Fan
        ALL Bars and Grates
         */

        blockItem(ModBlocks.SMITHED_OAK_PLANKS_SLAB);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_STAIRS);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_FENCE_GATE);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_PRESSURE_PLATE);
        blockItem(ModBlocks.NETHER_CORE_WALL);
        blockItem(ModBlocks.SMITHED_OAK_PLANKS_FENCE);
        bAndIV(ALT_DRIED_KELP_BLOCK,"dried_kelp_top");
        bAndIV(ALT_HAY_BALE,"hay_block_top");
        bAndIV(ACTIVE_REDSTONE_LAMP,"redstone_lamp_on");
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
    private void pAndIV(DeferredBlock<?> block, String sides, String bottom, String top) {
        simpleBlockWithItem(block.get(),models().cubeBottomTop(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,"block/"+sides),
                ResourceLocation.withDefaultNamespace("block/"+bottom),
                ResourceLocation.withDefaultNamespace("block/"+top))
                .renderType("cutout"));
    }
    private void pAndIV(DeferredBlock<?> block, String sides, String top) {
        simpleBlockWithItem(block.get(),models().cubeColumn(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,"block/"+sides),
                ResourceLocation.withDefaultNamespace("block/"+top))
                .renderType("cutout"));
    }
    private void pAndIVV(DeferredBlock<?> block, String sides, String top) {
        /*simpleBlockWithItem(block.get(),models().cubeColumn(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                        ResourceLocation.withDefaultNamespace("block/"+sides),
                        ResourceLocation.withDefaultNamespace("block/"+top))
                .renderType("cutout"));*/
        pillarWithItemAndVanillaTexture(block,sides,top);
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
    private void bAndI(DeferredBlock<?> deferredBlock) {
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

    private void bAndIVC(DeferredBlock<?> deferredBlock, String name) {
        simpleBlockWithItem(deferredBlock.get(),
                models().cubeAll(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                                ResourceLocation.withDefaultNamespace("block/"+name))
                        .renderType("cutout")
        );
    }
    private void bAndIVT(DeferredBlock<?> deferredBlock, String name) {
        simpleBlockWithItem(deferredBlock.get(),
                models().cubeAll(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                                ResourceLocation.withDefaultNamespace("block/"+name))
                        .renderType("translucent")
        );
    }
    private void bAndIC(DeferredBlock<?> deferredBlock, String name) {
        simpleBlockWithItem(deferredBlock.get(),
                models().cubeAll(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                                ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,"block/"+name))
                        .renderType("cutout")
        );
    }
    private void bAndIV(DeferredBlock<?> deferredBlock, String name) {
        simpleBlockWithItem(deferredBlock.get(),
                models().cubeAll(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                                ResourceLocation.withDefaultNamespace("block/"+name))
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
    private void dpBAndIV(DeferredBlock<Block> deferredBlock, String parentModel,String texturename) {
        directionalPlantBlock(deferredBlock, parentModel, texturename);
        simpleBlockItem(deferredBlock.get(), fromSingleTextureVV(deferredBlock,parentModel,texturename));
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
                    ModelFile newModelFile = getDripleafModel(
                            isSlab, deg, Helpers.isRot(face,front), state.getValue(DripleafBlock.STRETCHED));
                    return ConfiguredModel.builder()
                            .modelFile(newModelFile).rotationX((int)Helpers.getRot(face,front).x)
                            .rotationY((int)Helpers.getRot(face,front).y).build();
                });
    }
    public void odBAndI(Block bl, ModelFile modelFile, ModelFile rotModelFile) {
        omniDirectionalBlock(bl,modelFile,rotModelFile,0);
        simpleBlockItem(bl, modelFile);
    }
    public void odBAndI(DeferredBlock<Block> bl, String string) {
        odBAndI(bl.get(),
                new ModelFile.UncheckedModelFile("wiwwimc:block/"+string),
                new ModelFile.UncheckedModelFile("wiwwimc:block/"+string+"_rot"));
    }
    public void odBAndI(DeferredBlock<Block> bl, String modelName, String textureName) {
        odBAndI(bl.get(),
                fromSingleTextureMV(bl,modelName, textureName),
                fromSingleTextureMV(bl,modelName+"_rot", textureName));
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
    public ModelFile fromSingleTextureVV(DeferredBlock<Block> block, String parentModel, String texture) {
        String tkey = switch (parentModel) {
            default -> "texture";
            case "cross"->"cross";
            case "coral_fan"->"fan";
        };
        return models().singleTexture(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                ResourceLocation.withDefaultNamespace("block/"+parentModel),
                tkey,
                ResourceLocation.withDefaultNamespace("block/"+texture))
                .renderType("cutout");
    }
    public ModelFile fromSingleTextureVM(DeferredBlock<Block> block, String parentModel, String texture) {
        String tkey = switch (parentModel) {
            default -> "texture";
            case "cross"->"cross";
            case "coral_fan"->"fan";
        };
        return models().singleTexture(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                        ResourceLocation.withDefaultNamespace("block/"+parentModel),
                        tkey,
                        ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,"block/"+texture))
                .renderType("cutout");
    }
    public ModelFile fromSingleTextureMV(DeferredBlock<Block> block, String parentModel, String texture) {
        String tkey = switch (parentModel) {
            default -> "texture";
            case "cross"->"cross";
            case "coral_fan","template_coral_wall_fan"->"fan";
        };
        return models().singleTexture(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                        ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,"block/"+parentModel),
                        tkey,
                        ResourceLocation.withDefaultNamespace("block/"+texture))
                .renderType("cutout");
    }
    public void directionalPlantBlock(DeferredBlock<Block> block, String parentModel, String texture) {
        getVariantBuilder(block.get())
                .forAllStates(state -> {
                    int yrot=0; int xrot=0;
                    switch (state.getValue(DirectionalPartialBlock.FACE)) {
                        case UP    -> {xrot=180;}
                        case NORTH -> {xrot=270;}
                        case EAST  -> {xrot=90; yrot=270;}
                        case WEST  -> {xrot=90; yrot=90;}
                        case SOUTH -> {xrot=90;}
                    }
                    ModelFile newModelFile = fromSingleTextureVV(block,parentModel,texture);
                    return ConfiguredModel.builder().modelFile(newModelFile)
                            .rotationX(xrot).rotationY(yrot).build();
                });
    }
    public void mDBlockWithItem(DeferredBlock<Block> bl, ResourceLocation texture) {
        multiDirectionalBlock(bl,texture);
        simpleBlockItem(bl.get(),models().cubeAll(getBlockName(bl),texture));
    }
    public void multiDirectionalBlock(DeferredBlock<Block> block, ResourceLocation texture) {
        MultiPartBlockStateBuilder multipartBuilder = getMultipartBuilder(block.get());
        for(IntegerProperty n: MultidirectionalBlock.ALL_STATE_TYPES) {
            for(int i=1; i<=4; i++) {
                multipartBuilder.part().modelFile(getMDModel(block,texture,MultidirectionalBlock.getDir(n),i,0))
                        .rotationX((int)Helpers.getRot(n,i).x)
                        .rotationY((int)Helpers.getRot(n,i).y)
                        .addModel().condition(n,i).end();
            }
        }
    }
    @Description("i->MD Block, Panel top/bottom parts, Panel Side part, Panel Corner part")
    public ModelFile getMDModel(DeferredBlock<Block> block, ResourceLocation texture, boolean isRot, int i) {
        String modelName = "block/template_md_panel";
        switch (i) {
            case 1->modelName+="_tb";
            case 2->modelName+="_side";
            case 3->modelName+="_corner";
        }
        if(isRot) {modelName += "_rot";}
        return models().singleTexture(getBlockName(block),
                ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID, "block/template_md_panel" + (isRot ? "_rot" : "")
                ), texture);
    }
    public ModelFile getMDModel(DeferredBlock<Block> block, ResourceLocation texture, Direction face, Direction front, int i) {
        return getMDModel(block,texture,Helpers.isRot(face,front),i);
    }
    public ModelFile getMDModel(DeferredBlock<Block> block, ResourceLocation texture, Direction face, int uv, int i) {
        return getMDModel(block,texture,Helpers.isRot(face,uv),i);
    }

    private static String getBlockName(DeferredBlock<Block> block) {
        return BuiltInRegistries.BLOCK.getKey(block.get()).getPath();
    }

}
