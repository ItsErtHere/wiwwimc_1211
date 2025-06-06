package com.itserthere.wiwwimc;

import com.itserthere.wiwwimc.Blocks.DripleafBlock;
import com.itserthere.wiwwimc.Blocks.MultidirectionalBlock;
import com.itserthere.wiwwimc.Blocks.RedstoneCoreBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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
            registerBlock("sculk_tube", ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(DyeColor.CYAN).requiresCorrectToolForDrops().strength(1)
                    .sound(SoundType.SCULK)));
    public static final DeferredBlock<Block> CONDENSED_SCULK_CATALYST =
            registerBlock("condensed_sculk_catalyst", ()->new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(DyeColor.CYAN).requiresCorrectToolForDrops().strength(1)
                    .sound(SoundType.SCULK)) {
            });
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
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));
    public static final DeferredBlock<Block> SOUL_IRON_BARS_BLOCK = registerBlock("soul_iron_bars_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));
    public static final DeferredBlock<Block> CHISELED_SOUL_IRON_BARS_BLOCK = registerBlock("chiseled_soul_iron_bars_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));
    public static final DeferredBlock<Block> SOUL_GOLD_GRATES = registerBlock("soul_gold_grates",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));
    public static final DeferredBlock<Block> SOUL_GOLD_TILE = registerBlock("soul_gold_tile",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));
    public static final DeferredBlock<Block> SOUL_GOLD_BLOCK = registerBlock("soul_gold_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));
    public static final DeferredBlock<Block> SOUL_IRON_BLOCK = registerBlock("soul_iron_block",
            ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.VAULT)));

    //VANILLA TEXTURE           WIWWIMC BLOCK SET
    //enchanting_table_top      Diamond Core =
    //beacon                    Nether Star Block =
    //nether_core_sky           Fiery Stellar Core+++ =
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
