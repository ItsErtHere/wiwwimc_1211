package com.itserthere.wiwwimc;

import com.itserthere.wiwwimc.Blocks.RedstoneCoreBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(WIWWIMC.MODID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(),new Item.Properties()));
    }
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> bl = BLOCKS.register(name,block);
        registerBlockItem(name, bl);
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
    public static DeferredBlock<Block> registerCoreBlock(String name, MapColor mapColor) {
        return registerBlock(name,
                ()->new RedstoneCoreBlock(
                        BlockBehaviour.Properties.of().strength(0.4f,0.6f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.GLASS).mapColor(mapColor)));
    }
    public static final DeferredBlock<Block> IRON_TILE =
            registerMetalBlock("iron_tile",MapColor.COLOR_BLACK);
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
    public static final DeferredBlock<Block> FIRM_DRIPLEAF =
            registerBlock("firm_dripleaf", ()->new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).sound(SoundType.BIG_DRIPLEAF)
                    .pushReaction(PushReaction.DESTROY).strength(0.1f)));
    public static final DeferredBlock<Block> SMITHED_OAK_PLANKS =
            registerWoodenBlock("smithed_oak_planks");
    public static final DeferredBlock<Block> FULL_GRASS =
            registerWoodenBlock("full_grass");
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
            "smithed_oak_planks_fence", ()->new FenceGateBlock(WoodType.OAK,
                    BlockBehaviour.Properties.of().strength(0.2f)));
    public static final DeferredBlock<WallBlock> NETHER_CORE_WALL = registerBlock(
            "nether_core_wall",()->new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    //VANILLA TEXTURE           WIWWIMC BLOCK SET
    //enchanting_table_top      Diamond Core
    //beacon                    Nether Star Block
    //nether_core_sky           Fiery Stellar Core+++
    //conduit                   Nautilous Shell Block/Pillar
    //respawn_anchor_top        Obsidian Frame

    //sculk_shrieker_top        Sculk Frame
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

    //vault_top                 Warped Mosaic
    //vault_bottom              Soul Iron Block
    //trial_spawner_top         Warped Tile
    //monster_spawner           Soul Iron Grates
    //trial_spawner_bottom      Soul Iron Bars
    //daylight_det_bottom       Cast Soul Iron
    //daylight_detector_top     Cast Soul Iron Bulb (+Tiled)
}
