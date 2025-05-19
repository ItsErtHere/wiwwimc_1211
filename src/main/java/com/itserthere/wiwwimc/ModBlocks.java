package com.itserthere.wiwwimc;

import com.itserthere.wiwwimc.Blocks.RedstoneCoreBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PoweredBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
    public static DeferredBlock<Block> registerMetalBlock(String name, MapColor mapColor) {
        return registerBlock(name,
                ()->new PoweredBlock(BlockBehaviour.Properties.of().strength(0.4f,0.6f)
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
}
