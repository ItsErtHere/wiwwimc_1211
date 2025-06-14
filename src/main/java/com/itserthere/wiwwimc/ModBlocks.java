package com.itserthere.wiwwimc;

import com.itserthere.wiwwimc.Blocks.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(WIWWIMC.MODID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(),new Item.Properties()));
    }
    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, String tooltip) {
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(),new Item.Properties()){
            @Override
            public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable(tooltip));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });
    }
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> bl = BLOCKS.register(name,block);
        registerBlockItem(name, bl);
        return bl;
    }
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, String tooltip) {
        DeferredBlock<T> bl = BLOCKS.register(name,block);
        registerBlockItem(name, bl,tooltip);
        return bl;
    }
    public static DeferredBlock<Block> registerWoodenBlock(String name) {
        return registerBlock(name,
                ()->new Block(BlockBehaviour.Properties.of().strength(0.4f,0.2f)
                        .sound(SoundType.WOOD).mapColor(MapColor.WOOD)));
    }
    public static DeferredBlock<Block> registerMetalBlock(String name, MapColor mapColor) {
        return registerBlock(name,
                ()->new Block(BlockBehaviour.Properties.of().strength(0.4f,0.6f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL).mapColor(mapColor)));
    }
    public static DeferredBlock<Block> registerMetalBlock(String name, MapColor mapColor, String tooltip) {
        return registerBlock(name,
                ()->new Block(BlockBehaviour.Properties.of().strength(0.4f,0.6f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL).mapColor(mapColor)), tooltip);
    }
    public static DeferredBlock<Block> registerCoreBlock(String name, MapColor mapColor) {
        return registerBlock(name,
                ()->new RedstoneCoreBlock(
                        BlockBehaviour.Properties.of().strength(0.4f,0.6f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.GLASS).mapColor(mapColor)));
    }
    public static DeferredBlock<Block> registerDPlant(String name, SoundType soundType) {
        return registerBlock(name,
                ()->new DirectionalPartialBlock(BlockBehaviour.Properties.of()
                        .requiresCorrectToolForDrops().noOcclusion().noCollission()
                        .pushReaction(PushReaction.DESTROY).sound(soundType)));
    }
    public static DeferredBlock<Block> registerODPlant(String name, SoundType soundType) {
        return registerBlock(name,
                ()->new OmniDirectionalPartial(BlockBehaviour.Properties.of()
                        .requiresCorrectToolForDrops().noOcclusion().noCollission()
                        .pushReaction(PushReaction.DESTROY).sound(soundType)));
    }
    //OTHER USES
    public static DeferredBlock<Block> getDeferredBlock(BlockState state) {
        return DeferredBlock.createBlock(Objects.requireNonNull(state.getBlockHolder().getKey()));
    }
    public static String getBlockName(BlockState state) {
        return getDeferredBlock(state).getRegisteredName();
    }
    //BLOCK REGISTRIES
    public static final DeferredBlock<Block> IRON_TILE =
            registerMetalBlock("iron_tile",MapColor.COLOR_BLACK,"tooltip.wiwwimc.for_tango");
    public static final DeferredBlock<Block> POLISHED_IRON_TILE =
            registerMetalBlock("polished_iron_tile",MapColor.COLOR_BLACK);
    public static final DeferredBlock<Block> NETHER_CORE =
            registerCoreBlock("nether_core", MapColor.COLOR_RED);
    public static final DeferredBlock<Block> STELLAR_CORE =
            registerCoreBlock("stellar_core", MapColor.DIAMOND);
    public static final DeferredBlock<Block> DIAMOND_CORE =
            registerCoreBlock("diamond_core", MapColor.WARPED_WART_BLOCK);
    public static final DeferredBlock<Block> REDSTONE_CORE =
            registerCoreBlock("redstone_core", MapColor.FIRE);
    public static final DeferredBlock<Block> BLAZING_CORE =
            registerCoreBlock("blazing_core", MapColor.TERRACOTTA_YELLOW);
    public static final DeferredBlock<Block> ENDER_CORE =
            registerCoreBlock("ender_core", MapColor.COLOR_BLACK);
    public static final DeferredBlock<Block> SCULK_CORE =
            registerCoreBlock("sculk_core", MapColor.COLOR_BLACK);
    public static final DeferredBlock<Block> ACTIVE_SCULK_CORE =
            registerCoreBlock("active_sculk_core", MapColor.COLOR_BLACK);
    public static final DeferredBlock<Block> SOULITE =
            registerBlock("soulite", ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(DyeColor.BLACK).requiresCorrectToolForDrops().strength(1)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ENCASED_SOULITE =
            registerBlock("encased_soulite", ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(DyeColor.BLACK).requiresCorrectToolForDrops().strength(1)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> IDLE_SCULK =
            registerBlock("idle_sculk", ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(DyeColor.CYAN).requiresCorrectToolForDrops().strength(1)
                    .sound(SoundType.SCULK)));
    public static final DeferredBlock<Block> BRIGHT_IDLE_SCULK =
            registerBlock("bright_idle_sculk", ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(DyeColor.CYAN).requiresCorrectToolForDrops().strength(1)
                    .sound(SoundType.SCULK)));
    public static final DeferredBlock<Block> BLOOMING_SCULK =
            registerBlock("blooming_sculk", ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(DyeColor.CYAN).requiresCorrectToolForDrops().strength(1)
                    .sound(SoundType.SCULK)));
    public static final DeferredBlock<Block> BLUE_SCULK =
            registerBlock("blue_sculk", ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(DyeColor.CYAN).requiresCorrectToolForDrops().strength(1)
                    .sound(SoundType.SCULK)));
    public static final DeferredBlock<Block> SCULK_TUBE =
            registerBlock("sculk_tube", ()->new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(DyeColor.CYAN).requiresCorrectToolForDrops().strength(1)
                    .sound(SoundType.SCULK)));
    public static final DeferredBlock<Block> ALT_BASALT =
            registerBlock("alt_basalt", ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final DeferredBlock<Block> STURDY_STONE_VENTS =
            registerBlock("sturdy_stone_vents", ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> ALT_CHISELED_TUFF =
            registerBlock("alt_chiseled_tuff", ()->new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_GRAY).instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.TUFF).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> ALT_CHISELED_TUFF_BRICKS =
            registerBlock("alt_chiseled_tuff_bricks", ()->new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_GRAY).instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.TUFF).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> ALT_REINFORCED_DEEPSLATE =
            registerBlock("alt_reinforced_deepslate", ()->new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_GRAY).instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.TUFF).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> SMITHED_DEEPSLATE =
            registerBlock("smithed_deepslate", ()->new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_GRAY).instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.TUFF).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> CONDENSED_SCULK_CATALYST =
            registerBlock("condensed_sculk_catalyst", ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DEEPSLATE).strength(55.0F, 1200.0F)));
    public static final DeferredBlock<Block> ALT_BONE_BLOCK =
            registerBlock("alt_bone_block", ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND).instrument(NoteBlockInstrument.XYLOPHONE)
                    .requiresCorrectToolForDrops().strength(2.0F).sound(SoundType.BONE_BLOCK)));
    //DRIPLEAFS
    public static final DeferredBlock<Block> FIRM_DRIPLEAF =
            registerBlock("firm_dripleaf", ()->new DripleafBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).sound(SoundType.BIG_DRIPLEAF).noOcclusion()
                    .pushReaction(PushReaction.DESTROY).strength(0.1f)));
    public static final DeferredBlock<Block> FIRM_DRIPLEAF_PARTIAL =
            registerBlock("firm_dripleaf_partial", ()->new DripleafBlock(
                    BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).sound(SoundType.BIG_DRIPLEAF).noOcclusion()
                    .pushReaction(PushReaction.DESTROY).strength(0.1f)));
    public static final DeferredBlock<Block> FIRM_DRIPLEAF_FULL =
            registerBlock("firm_dripleaf_full", ()->new DripleafBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT).sound(SoundType.BIG_DRIPLEAF).noOcclusion()
                            .pushReaction(PushReaction.DESTROY).strength(0.1f)));
    public static final DeferredBlock<Block> FIRM_DRIPLEAF_XTRA =
            registerBlock("firm_dripleaf_xtra", ()->new DripleafBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT).sound(SoundType.BIG_DRIPLEAF).noOcclusion()
                            .pushReaction(PushReaction.DESTROY).strength(0.1f)));
    public static final DeferredBlock<Block> DRIPLEAF_STEM =
            registerBlock("firm_dripleaf_stem", ()->new DripleafBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT).sound(SoundType.BIG_DRIPLEAF).noOcclusion()
                            .pushReaction(PushReaction.DESTROY).strength(0.1f)));
    public static final DeferredBlock<Block> HALF_DRIPLEAF =
            registerBlock("half_dripleaf", ()->new DripleafBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).sound(SoundType.BIG_DRIPLEAF).noOcclusion()
                    .pushReaction(PushReaction.DESTROY).strength(0.1f)));
    public static final DeferredBlock<Block> HALF_DRIPLEAF_PARTIAL =
            registerBlock("half_dripleaf_partial", ()->new DripleafBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT).sound(SoundType.BIG_DRIPLEAF).noOcclusion()
                            .pushReaction(PushReaction.DESTROY).strength(0.1f)));
    public static final DeferredBlock<Block> HALF_DRIPLEAF_FULL =
            registerBlock("half_dripleaf_full", ()->new DripleafBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT).sound(SoundType.BIG_DRIPLEAF).noOcclusion()
                            .pushReaction(PushReaction.DESTROY).strength(0.1f)));
    public static final DeferredBlock<Block> HALF_DRIPLEAF_XTRA =
            registerBlock("half_dripleaf_xtra", ()->new DripleafBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT).sound(SoundType.BIG_DRIPLEAF).noOcclusion()
                            .pushReaction(PushReaction.DESTROY).strength(0.1f)));
    public static final DeferredBlock<Block> HALF_DRIPLEAF_STEM =
            registerBlock("half_dripleaf_stem", ()->new DripleafBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT).sound(SoundType.BIG_DRIPLEAF).noOcclusion()
                            .pushReaction(PushReaction.DESTROY).strength(0.1f)));
    public static final DeferredBlock<Block> DRIPLEAF_LEAF =
            registerBlock("dripleaf_leaf", ()->new DripleafBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT).sound(SoundType.BIG_DRIPLEAF).noOcclusion()
                            .pushReaction(PushReaction.DESTROY).strength(0.1f)));

    //WOODEN BLOCKS
    public static final DeferredBlock<Block> SMITHED_OAK_PLANKS =
            registerWoodenBlock("smithed_oak_planks");
    public static final DeferredBlock<Block> FULL_GRASS =
            registerBlock("full_grass", ()->new GrassBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.GRASS).strength(0.6F).sound(SoundType.GRASS)));
    public static final DeferredBlock<StairBlock> SMITHED_OAK_PLANKS_STAIRS = registerBlock(
            "smithed_oak_planks_stairs", ()->new StairBlock(
                    ModBlocks.SMITHED_OAK_PLANKS.get().defaultBlockState(),
                            BlockBehaviour.Properties.of().strength(0.2f)));
    public static final DeferredBlock<SlabBlock> SMITHED_OAK_PLANKS_SLAB = registerBlock(
            "smithed_oak_planks_slab", ()->new SlabBlock(BlockBehaviour.Properties.of().strength(0.2f)));

    public static final DeferredBlock<PressurePlateBlock> SMITHED_OAK_PLANKS_PRESSURE_PLATE = registerBlock(
            "smithed_oak_planks_pressure_plate", ()->new PressurePlateBlock(
                    BlockSetType.OAK, BlockBehaviour.Properties.of().strength(0.2f)));
    public static final DeferredBlock<FenceBlock> SMITHED_OAK_PLANKS_FENCE = registerBlock(
            "smithed_oak_planks_fence", ()->new FenceBlock(
                    BlockBehaviour.Properties.of().strength(0.2f)));
    public static final DeferredBlock<FenceGateBlock> SMITHED_OAK_PLANKS_FENCE_GATE = registerBlock(
            "smithed_oak_planks_fence_gate", ()->new FenceGateBlock(WoodType.OAK,
                    BlockBehaviour.Properties.of().strength(0.2f)));
    public static final DeferredBlock<WallBlock> NETHER_CORE_WALL = registerBlock(
            "nether_core_wall",()->new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SCULK_FRAME = registerBlock("sculk_frame",
            ()->new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1)
                    .mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredBlock<Block> ACTIVE_SCULK_FRAME = registerBlock("active_sculk_frame",
            ()->new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1)
                    .mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredBlock<Block> CAST_IRON = registerMetalBlock("cast_iron",MapColor.COLOR_BLACK);
    public static final DeferredBlock<Block> CHISELED_CAST_IRON = registerBlock("chiseled_cast_iron",
                ()->new MultidirectionalBlock(BlockBehaviour.Properties.of().strength(0.4f,0.6f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL).mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredBlock<Block> SMITHED_IRON = registerMetalBlock("smithed_iron",MapColor.COLOR_BLACK);
    public static final DeferredBlock<Block> STURDY_STONE = registerBlock("sturdy_stone",()->new Block(
            BlockBehaviour.Properties.of().sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1).mapColor(MapColor.STONE)
                    .pushReaction(PushReaction.BLOCK)));
    public static final DeferredBlock<Block> CHISELED_STURDY_STONE = registerBlock("chiseled_sturdy_stone",()->new MultidirectionalBlock(
            BlockBehaviour.Properties.of().sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1).mapColor(MapColor.STONE)
                    .pushReaction(PushReaction.BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_STURDY_STONE = registerBlock("smooth_sturdy_stone",()->new Block(
            BlockBehaviour.Properties.of().sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1).mapColor(MapColor.STONE)
                    .pushReaction(PushReaction.BLOCK)));
    public static final DeferredBlock<Block> STURDY_STONE_TILE = registerBlock("sturdy_stone_tile",()->new Block(
            BlockBehaviour.Properties.of().sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1).mapColor(MapColor.STONE)
                    .pushReaction(PushReaction.BLOCK)));
    public static final DeferredBlock<Block> SMITHED_STURDY_STONE = registerBlock("smithed_sturdy_stone",()->new Block(
            BlockBehaviour.Properties.of().sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1).mapColor(MapColor.STONE)
                    .pushReaction(PushReaction.BLOCK)));
    public static final DeferredBlock<Block> ANDESITE_TILE = registerBlock("andesite_tile",()->new Block(
            BlockBehaviour.Properties.of().sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> TUFF_TILE = registerBlock("tuff_tile",()->new Block(
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).requiresCorrectToolForDrops().strength(1)
                    .mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> SMITHED_TUFF = registerBlock("smithed_tuff",()->new Block(
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).requiresCorrectToolForDrops().strength(1)
                    .mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> TUFF_BRICK_TILE = registerBlock("tuff_brick_tile",()->new Block(
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).requiresCorrectToolForDrops().strength(1)
                    .mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> TUFF_BRICK_MOSAIC = registerBlock("tuff_brick_mosaic",()->new Block(
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).requiresCorrectToolForDrops().strength(1)
                    .mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> TUFF_MOSAIC = registerBlock("tuff_mosaic",()->new Block(
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).requiresCorrectToolForDrops().strength(1)
                    .mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> CHISELED_ANDESITE = registerBlock("chiseled_andesite",()->new Block(
            BlockBehaviour.Properties.of().sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> OAK_LAYERS = registerWoodenBlock("oak_layers");
    public static final DeferredBlock<Block> SMOOTH_OAK_PLANKS = registerWoodenBlock("smooth_oak_planks");
    public static final DeferredBlock<Block> BORDERED_SMOOTH_OAK_PLANKS = registerWoodenBlock("bordered_smooth_oak_planks");
    public static final DeferredBlock<Block> OAK_MOSAIC = registerWoodenBlock("oak_mosaic");
    public static final DeferredBlock<Block> OAK_VENTS = registerWoodenBlock("oak_vents");
    public static final DeferredBlock<Block> CHISELED_OAK_PLANKS = registerWoodenBlock("chiseled_oak_planks");
    public static final DeferredBlock<Block> OAK_TILE = registerWoodenBlock("oak_tile");
    public static final DeferredBlock<Block> ENCASED_OAK_PLANKS = registerWoodenBlock("encased_oak_planks");
    public static final DeferredBlock<Block> BIRCH_TILE = registerWoodenBlock("birch_tile");
    public static final DeferredBlock<Block> JUNGLE_TILE = registerWoodenBlock("jungle_tile");
    public static final DeferredBlock<Block> BAMBOO_TILE = registerWoodenBlock("bamboo_tile");
    public static final DeferredBlock<Block> BAMBOO_LAYERS = registerWoodenBlock("bamboo_layers");
    public static final DeferredBlock<Block> SPRUCE_VENTS = registerWoodenBlock("spruce_vents");
    public static final DeferredBlock<Block> SMITHED_SPRUCE_PLANKS = registerWoodenBlock("smithed_spruce_planks");
    public static final DeferredBlock<Block> SPRUCE_LAYERS = registerWoodenBlock("spruce_layers");
    public static final DeferredBlock<Block> CHISELED_SPRUCE_PLANKS = registerWoodenBlock("chiseled_spruce_planks");
    public static final DeferredBlock<Block> SPRUCE_TILE = registerWoodenBlock("spruce_tile");
    public static final DeferredBlock<Block> ENCASED_SPRUCE_PLANKS = registerWoodenBlock("encased_spruce_planks");
    public static final DeferredBlock<Block> CHISELED_DARK_OAK_PLANKS = registerWoodenBlock("chiseled_dark_oak_planks");
    public static final DeferredBlock<Block> DARK_OAK_TILE = registerWoodenBlock("dark_oak_tile");
    public static final DeferredBlock<Block> DARK_OAK_LAYERS = registerWoodenBlock("dark_oak_layers");
    public static final DeferredBlock<Block> SOUL_QUARTZ_TILES = registerBlock("soul_quartz_tiles",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SOUL_QUARTZ_BULBS = registerBlock("soul_quartz_bulbs",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));
    public static final DeferredBlock<Block> SOUL_QUARTZ = registerBlock("soul_quartz",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));
    public static final DeferredBlock<Block> ENCASED_SOUL_QUARTZ = registerBlock("encased_soul_quartz",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));
    public static final DeferredBlock<Block> SOUL_GOLD_BARS_BLOCK = registerBlock("soul_gold_bars_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT).noOcclusion()));
    public static final DeferredBlock<Block> SOUL_IRON_BARS_BLOCK = registerBlock("soul_iron_bars_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT).noOcclusion()));
    public static final DeferredBlock<Block> CHISELED_SOUL_IRON_BARS_BLOCK = registerBlock("chiseled_soul_iron_bars_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT).noOcclusion()));
    public static final DeferredBlock<Block> SOUL_GOLD_GRATES = registerBlock("soul_gold_grates",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT).noOcclusion()));
    public static final DeferredBlock<Block> SOUL_GOLD_TILE = registerBlock("soul_gold_tile",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));
    public static final DeferredBlock<Block> SOUL_GOLD_BLOCK = registerBlock("soul_gold_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));
    public static final DeferredBlock<Block> SOUL_IRON_BLOCK = registerBlock("soul_iron_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));
    public static final DeferredBlock<Block> GLOWING_OBSIDIAN = registerBlock("glowing_obsidian",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops().lightLevel(i->5).strength(50,1200)));
    public static final DeferredBlock<Block> AZALEA_BUSH = registerBlock("azalea_bush",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA)
                    .instabreak()));
    public static final DeferredBlock<Block> FLOWERING_AZALEA_BUSH = registerBlock("flowering_azalea_bush",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.FLOWERING_AZALEA)
                    .instabreak()));
    public static final DeferredBlock<Block> ALT_PODZOL = registerBlock("alt_podzol",
            ()->new Block(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRAVEL)
                    .mapColor(MapColor.PODZOL)));
    public static final DeferredBlock<Block> ALT_MYCELIUM = registerBlock("alt_mycelium",
            ()->new Block(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRASS)
                    .mapColor(MapColor.COLOR_GRAY)));
    public static final DeferredBlock<Block> ALT_CRIMSON_NYLIUM = registerBlock("alt_crimson_nylium",
            ()->new Block(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRAVEL)
                    .mapColor(MapColor.PODZOL)));
    public static final DeferredBlock<Block> ALT_WARPED_NYLIUM = registerBlock("alt_warped_nylium",
            ()->new NyliumBlock(
                    BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_NYLIUM)
                            .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
                            .strength(0.4F).sound(SoundType.NYLIUM).randomTicks()));
    public static final DeferredBlock<Block> ALT_DRY_FARMLAND = registerBlock("alt_dry_farmland",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT)
                            .strength(0.6F).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<Block> ALT_WET_FARMLAND = registerBlock("alt_wet_farmland",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT)
                    .strength(0.6F).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<Block> PURPUR_TILE = registerBlock("purpur_tile",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> ALT_DRIED_KELP_BLOCK = registerBlock("alt_dried_kelp_block",
            ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN).strength(0.5F, 2.5F).sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> ALT_HAY_BALE = registerBlock("alt_hay_bale",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)
                    .instrument(NoteBlockInstrument.BANJO).strength(0.5F).sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> ACTIVE_REDSTONE_LAMP = registerBlock("active_redstone_lamp",
            ()->new Block(BlockBehaviour.Properties.of().lightLevel(i -> 15).strength(0.3F).sound(SoundType.GLASS)));
    //CASINGS
    public static final DeferredBlock<Block> OBSIDIAN_CASING = registerBlock("obsidian_casing",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
                    .requiresCorrectToolForDrops().strength(1.5F, 6.0F).noOcclusion()));
    public static final DeferredBlock<Block> STONE_CASING = registerBlock("stone_casing",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .requiresCorrectToolForDrops().strength(1.5F, 6.0F).noOcclusion()));
    public static final DeferredBlock<Block> DEEPSLATE_CASING = registerBlock("deepslate_casing",
            ()->new CasingBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.DEEPSLATE).noOcclusion()));
    public static final DeferredBlock<Block> BLACKSTONE_CASING = registerBlock("blackstone_casing",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F).noOcclusion()));
    public static final DeferredBlock<Block> PLANT_CASING = registerBlock("plant_casing",
            ()->new CasingBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).strength(0.2F)
                    .sound(SoundType.GRASS).noOcclusion().ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> SOUL_IRON_CASING = registerBlock("soul_iron_casing",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .noOcclusion().sound(SoundType.VAULT).strength(10.0F)));
    public static final DeferredBlock<Block> SOUL_GOLD_CASING = registerBlock("soul_gold_casing",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM).noOcclusion()
                    .sound(SoundType.VAULT).strength(10.0F)));
    public static final DeferredBlock<Block> BONE_CASING = registerBlock("bone_casing",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM).noOcclusion()
                    .sound(SoundType.VAULT).strength(10.0F)));
    public static final DeferredBlock<Block> ALT_COPPER_GRATE = registerBlock("alt_copper_grate",
            ()->new CasingBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER_GRATE).mapColor(MapColor.COLOR_ORANGE)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ALT_EXPOSED_COPPER_GRATE = registerBlock("alt_exposed_copper_grate",
            ()->new CasingBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER_GRATE).mapColor(MapColor.WARPED_STEM)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ALT_WEATHERED_COPPER_GRATE = registerBlock("alt_weathered_copper_grate",
            ()->new CasingBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER_GRATE).mapColor(MapColor.WARPED_NYLIUM)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ALT_OXIDIZED_COPPER_GRATE = registerBlock("alt_oxidized_copper_grate",
            ()->new CasingBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER_GRATE).mapColor(MapColor.WARPED_NYLIUM)
                    .noOcclusion().requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> COPPER_FRAME = registerBlock("copper_grate",
            ()->new CasingBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER_GRATE).mapColor(MapColor.COLOR_ORANGE)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> EXPOSED_COPPER_FRAME = registerBlock("exposed_copper_frame",
            ()->new CasingBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER_GRATE).mapColor(MapColor.WARPED_STEM)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WEATHERED_COPPER_FRAME = registerBlock("weathered_copper_frame",
            ()->new CasingBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER_GRATE).mapColor(MapColor.WARPED_NYLIUM)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> OXIDIZED_COPPER_FRAME = registerBlock("oxidized_copper_frame",
            ()->new CasingBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER_GRATE).mapColor(MapColor.WARPED_NYLIUM)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> OAK_FRAME = registerBlock("oak_frame",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> JUNGLE_FRAME = registerBlock("jungle_frame",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ACACIA_FRAME = registerBlock("acacia_frame",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MANGROVE_FRAME = registerBlock("mangrove_frame",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> CHERRY_FRAME = registerBlock("cherry_frame",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BAMBOO_FRAME = registerBlock("bamboo_frame",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).sound(SoundType.BAMBOO).strength(3.0F)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> CRIMSON_FRAME = registerBlock("crimson_frame",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_STEM)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WARPED_FRAME = registerBlock("warped_frame",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F)
                    .noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> IRON_FRAME = registerBlock("iron_frame",
            ()->new CasingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .strength(3.0F).noOcclusion().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ALT_BRAIN_CORAL_BLOCK = registerBlock("alt_brain_coral_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final DeferredBlock<Block> ALT_BUBBLE_CORAL_BLOCK = registerBlock("alt_bubble_coral_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final DeferredBlock<Block> ALT_HORN_CORAL_BLOCK = registerBlock("alt_horn_coral_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final DeferredBlock<Block> ALT_TUBE_CORAL_BLOCK = registerBlock("alt_tube_coral_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final DeferredBlock<Block> ALT_FIRE_CORAL_BLOCK = registerBlock("alt_fire_coral_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final DeferredBlock<Block> ALT_BROWN_MUSHROOM_BLOCK = registerBlock(
            "alt_brown_mushroom_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT)
                    .instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> ALT_RED_MUSHROOM_BLOCK = registerBlock(
            "alt_red_mushroom_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> ALT_MUSHROOM_STEM = registerBlock(
            "alt_mushroom_stem",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL)
                    .instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MUSHROOM_STEM = registerBlock(
            "stripped_mushroom_stem",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> ALT_FIRE_CORAL = registerDPlant("alt_fire_coral",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_FIRE_CORAL_FAN = registerDPlant("alt_fire_coral_fan",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_FIRE_CORAL_WALL_FAN = registerODPlant("alt_fire_coral_wall_fan",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_DEAD_FIRE_CORAL = registerDPlant("alt_dead_fire_coral",SoundType.CORAL_BLOCK);
    public static final DeferredBlock<Block> ALT_DEAD_FIRE_CORAL_FAN = registerDPlant("alt_dead_fire_coral_fan",SoundType.CORAL_BLOCK);
    public static final DeferredBlock<Block> ALT_DEAD_FIRE_CORAL_WALL_FAN = registerODPlant("alt_dead_fire_coral_wall_fan",SoundType.CORAL_BLOCK);

    public static final DeferredBlock<Block> ALT_HORN_CORAL = registerDPlant("alt_horn_coral",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_HORN_CORAL_FAN = registerDPlant("alt_horn_coral_fan",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_HORN_CORAL_WALL_FAN = registerODPlant("alt_horn_coral_wall_fan",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_DEAD_HORN_CORAL = registerDPlant("alt_dead_horn_coral",SoundType.CORAL_BLOCK);
    public static final DeferredBlock<Block> ALT_DEAD_HORN_CORAL_FAN = registerDPlant("alt_dead_horn_coral_fan",SoundType.CORAL_BLOCK);
    public static final DeferredBlock<Block> ALT_DEAD_HORN_CORAL_WALL_FAN = registerODPlant("alt_dead_horn_coral_wall_fan",SoundType.CORAL_BLOCK);

    public static final DeferredBlock<Block> ALT_TUBE_CORAL = registerDPlant("alt_tube_coral",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_TUBE_CORAL_FAN = registerDPlant("alt_tube_coral_fan",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_TUBE_CORAL_WALL_FAN = registerODPlant("alt_tube_coral_wall_fan",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_DEAD_TUBE_CORAL = registerDPlant("alt_dead_tube_coral",SoundType.CORAL_BLOCK);
    public static final DeferredBlock<Block> ALT_DEAD_TUBE_CORAL_FAN = registerDPlant("alt_dead_tube_coral_fan",SoundType.CORAL_BLOCK);
    public static final DeferredBlock<Block> ALT_DEAD_TUBE_CORAL_WALL_FAN = registerODPlant("alt_dead_tube_coral_wall_fan",SoundType.CORAL_BLOCK);

    public static final DeferredBlock<Block> ALT_BRAIN_CORAL = registerDPlant("alt_brain_coral",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_BRAIN_CORAL_FAN = registerDPlant("alt_brain_coral_fan",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_BRAIN_CORAL_WALL_FAN = registerODPlant("alt_brain_coral_wall_fan",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_DEAD_BRAIN_CORAL = registerDPlant("alt_dead_brain_coral",SoundType.CORAL_BLOCK);
    public static final DeferredBlock<Block> ALT_DEAD_BRAIN_CORAL_FAN = registerDPlant("alt_dead_brain_coral_fan",SoundType.CORAL_BLOCK);
    public static final DeferredBlock<Block> ALT_DEAD_BRAIN_CORAL_WALL_FAN = registerODPlant("alt_dead_brain_coral_wall_fan",SoundType.CORAL_BLOCK);

    public static final DeferredBlock<Block> ALT_BUBBLE_CORAL = registerDPlant("alt_bubble_coral",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_BUBBLE_CORAL_FAN = registerDPlant("alt_bubble_coral_fan",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_BUBBLE_CORAL_WALL_FAN = registerODPlant("alt_bubble_coral_wall_fan",SoundType.WET_GRASS);
    public static final DeferredBlock<Block> ALT_DEAD_BUBBLE_CORAL = registerDPlant("alt_dead_bubble_coral",SoundType.CORAL_BLOCK);
    public static final DeferredBlock<Block> ALT_DEAD_BUBBLE_CORAL_FAN = registerDPlant("alt_dead_bubble_coral_fan",SoundType.CORAL_BLOCK);
    public static final DeferredBlock<Block> ALT_DEAD_BUBBLE_CORAL_WALL_FAN = registerODPlant("alt_dead_bubble_coral_wall_fan",SoundType.CORAL_BLOCK);

    //FUNGI
    public static final DeferredBlock<Block> ALT_BROWN_MUSHROOM = registerDPlant("alt_brown_mushroom",SoundType.FUNGUS);
    public static final DeferredBlock<Block> ALT_RED_MUSHROOM = registerDPlant("alt_red_mushroom",SoundType.FUNGUS);
    public static final DeferredBlock<Block> ALT_CRIMSON_FUNGUS = registerDPlant("alt_crimson_fungus",SoundType.FUNGUS);
    public static final DeferredBlock<Block> ALT_WARPED_FUNGUS = registerDPlant("alt_warped_fungus",SoundType.FUNGUS);
    public static final DeferredBlock<Block> ALT_GLOW_LICHEN = registerBlock("alt_glow_lichen",
            ()->new GlowLichenBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .replaceable().noCollission().strength(0.2F).sound(SoundType.GLOW_LICHEN)
                    .lightLevel(GlowLichenBlock.emission(7)).ignitedByLava().pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> PORTALIC_BLOCK = registerBlock("portalic_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
                    .noOcclusion().strength(1f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> WATER_TANK = registerBlock("water_tank",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WATER)
                    .noOcclusion().strength(1f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> LAVA_TANK = registerBlock("lava_tank",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE)
                    .noOcclusion().strength(1f).sound(SoundType.GLASS)));

    //VANILLA TEXTURE           WIWWIMC BLOCK SET
    //enchanting_table_top      Diamond Core =
    //beacon                    Nether Star Block =
    //nether_core_sky           Stellar Core =
    //conduit                   Nautilous Shell Block/Pillar

    //respawn_anchor_top        Obsidian Frame
    //sculk_shrieker_inner_top  Sculk Frame
    //sculk_catalyst_top        Idle Sculk
    //sculk_catalyst_bottom     Sculk Core {NEEDS BONE}
    //sculk_sensor_top          Condensed Sculk

    //sculk_catalyst_side       Bone Pillar

    //daylight_det_bottom       /
    //daylight_det_top          /

    //cauldron_bottom           Cast Iron
    //cauldron_side             Chiseled Cast Iron
    //anvil_top/side            Smithed Iron
    //smithing_table_top        Iron Tile

    //stonecutter_bottom        Smooth Stone Tile
    //furnace_bottom            Sturdy Stone
    //crafter_bottom            Sturdy Stone Tile
    //lodestone_side            Chiseled Andesite
    //lodestone_top             Andesite Tile
    //chiseled_tuff_brick_top   Tuff Tile
    //chiseled_resin_brick_top  Resin Tile

    //piston_top                Smithed Oak
    //beehive_top               Oak Layers
    //beehive_side              Smooth Oak
    //beehive_front             Boarded Smooth Oak
    //chiseled_bookshelf_top    Oak Mosaic
    //chiseled_bookshelf_front  Oak Vents
    //chiseled_bookshelf_side   Chiseled Oak
    //lectern_top               Oak Tile
    //crafter_side              Stone Encased Oak
    //crafter_back              Stone Encased Oak Pillar

    //fletching_table_top       Birch Tile
    //chest_top                 Jungle Tile

    //bee_nest_top              Bamboo Tile
    //bee_nest_side             Bamboo Layers (+Color)

    //loom_side                 Spruce Vents
    //composter_side            Spruce Layers
    //loom_top                  Smithed Spruce
    //composter_bottom          Chiseled Spruce
    //barrel_top                Spruce Tile

    //smithing_table_side(s)    Chiseled Dark Oak (+Fr)
    //smithing_table_bottom     Dark Oak Tile
    //loom_bottom               Dark Oak Layers

    //TEXTURE ->  REGULAR  ->  OMINOUS(stone) OR TEXTURE -> REG/OM
    //vault_top
    //vault_bottom -> Soul Quartz
    //vault_side -> Soul Iron Bars
    //vault_front -> Chiseled Soul Iron Bars
    //(M)trial_spawner_top -> Soul Iron Block
    //(M)trial_spawner_top_ejecting -> Framed Soul Gold
    //trial_spawner_bottom -> Soul Gold Bars
    //trial_spawner_top_ejecting(Inner) -> Polished Ender Core
    //trial_spawner_side_inactive -> (OM) Soul Gold Grate
    //(M)monster_spawner -> Soul Iron Grate
    //daylight_detector_bottom
    //daylight_detector_top
    //ender_chest_top -> Soul Gold Block

    //REDSTONE DEVICES
    //vault_side                Player Distance Detector
}
