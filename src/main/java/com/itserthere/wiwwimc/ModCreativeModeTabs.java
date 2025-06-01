package com.itserthere.wiwwimc;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WIWWIMC.MODID);
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
    public static final Supplier<CreativeModeTab> WIWWIMC_BLOCKS_TAB =
            CREATIVE_MODE_TAB.register("wiwwim_blocks_tab", ()-> CreativeModeTab.builder()
                            .icon(()->new ItemStack(ModBlocks.IRON_TILE.get()))
                            .title(Component.translatable("wiwwim_blocks.wiwwimc"))
                            .displayItems((itemDisplayParameters,output)->{
                                output.accept(ModBlocks.IRON_TILE);
                                output.accept(ModBlocks.POLISHED_IRON_TILE);
                                output.accept(ModBlocks.REDSTONE_CORE);
                                output.accept(ModBlocks.DIAMOND_CORE);
                                output.accept(ModBlocks.NETHER_CORE);
                                output.accept(ModBlocks.BLAZING_CORE);
                                output.accept(ModBlocks.STELLAR_CORE);
                                output.accept(ModBlocks.ENDER_CORE);
                                output.accept(ModBlocks.NETHER_CORE_WALL);
                                output.accept(ModBlocks.SMITHED_OAK_PLANKS);
                                output.accept(ModBlocks.SMITHED_OAK_PLANKS_STAIRS);
                                output.accept(ModBlocks.SMITHED_OAK_PLANKS_SLAB);
                                output.accept(ModBlocks.SMITHED_OAK_PLANKS_FENCE);
                                output.accept(ModBlocks.SMITHED_OAK_PLANKS_FENCE_GATE);
                                output.accept(ModBlocks.SMITHED_OAK_PLANKS_PRESSURE_PLATE);
                                output.accept(ModBlocks.FULL_GRASS);
                                output.accept(ModBlocks.FIRM_DRIPLEAF);
                                output.accept(ModBlocks.FIRM_DRIPLEAF_PARTIAL);
                                output.accept(ModBlocks.FIRM_DRIPLEAF_FULL);
                                output.accept(ModBlocks.FIRM_DRIPLEAF_XTRA);
                                output.accept(ModBlocks.DRIPLEAF_STEM);
                                output.accept(ModBlocks.HALF_DRIPLEAF);
                                output.accept(ModBlocks.HALF_DRIPLEAF_PARTIAL);
                                output.accept(ModBlocks.HALF_DRIPLEAF_FULL);
                                output.accept(ModBlocks.HALF_DRIPLEAF_XTRA);
                                output.accept(ModBlocks.HALF_DRIPLEAF_STEM);
                                output.accept(ModBlocks.DRIPLEAF_LEAF);
                                output.accept(ModBlocks.ACTIVE_SCULK_FRAME);
                                output.accept(ModBlocks.SCULK_CORE);
                                output.accept(ModBlocks.ACTIVE_SCULK_CORE);
                                output.accept(ModBlocks.SOULITE);
                                output.accept(ModBlocks.ENCASED_SOULITE);
                                output.accept(ModBlocks.IDLE_SCULK);
                                output.accept(ModBlocks.BLOOMING_SCULK);
                                output.accept(ModBlocks.BLUE_SCULK);
                                output.accept(ModBlocks.SCULK_FRAME);
                                output.accept(ModBlocks.BRIGHT_IDLE_SCULK);
                                output.accept(ModBlocks.SCULK_TUBE);
                                output.accept(ModBlocks.CONDENSED_SCULK_CATALYST);
                                output.accept(ModBlocks.CAST_IRON);
                                output.accept(ModBlocks.CHISELED_CAST_IRON);
                                output.accept(ModBlocks.SMITHED_IRON);
                                output.accept(ModBlocks.STURDY_STONE);
                                output.accept(ModBlocks.CHISELED_STURDY_STONE);
                                output.accept(ModBlocks.SMOOTH_STURDY_STONE);
                                output.accept(ModBlocks.STURDY_STONE_TILE);
                                output.accept(ModBlocks.CHISELED_ANDESITE);
                                output.accept(ModBlocks.ANDESITE_TILE);
                                output.accept(ModBlocks.SMITHED_TUFF);
                                output.accept(ModBlocks.TUFF_TILE);
                                output.accept(ModBlocks.TUFF_BRICK_TILE);
                                output.accept(ModBlocks.TUFF_MOSAIC);
                                output.accept(ModBlocks.TUFF_BRICK_MOSAIC);
                                output.accept(ModBlocks.OAK_LAYERS);
                                output.accept(ModBlocks.OAK_MOSAIC);
                                output.accept(ModBlocks.OAK_TILE);
                                output.accept(ModBlocks.OAK_VENTS);
                                output.accept(ModBlocks.SMOOTH_OAK_PLANKS);
                                output.accept(ModBlocks.BORDERED_SMOOTH_OAK_PLANKS);
                                output.accept(ModBlocks.CHISELED_OAK_PLANKS);
                                output.accept(ModBlocks.ENCASED_OAK_PLANKS);
                                output.accept(ModBlocks.BIRCH_TILE);
                                output.accept(ModBlocks.BAMBOO_LAYERS);
                                output.accept(ModBlocks.BAMBOO_TILE);
                                output.accept(ModBlocks.JUNGLE_TILE);
                                output.accept(ModBlocks.SPRUCE_LAYERS);
                                output.accept(ModBlocks.ENCASED_SPRUCE_PLANKS);
                                output.accept(ModBlocks.SPRUCE_TILE);
                                output.accept(ModBlocks.SPRUCE_VENTS);
                                output.accept(ModBlocks.SMITHED_SPRUCE_PLANKS);
                                output.accept(ModBlocks.CHISELED_SPRUCE_PLANKS);
                                output.accept(ModBlocks.CHISELED_DARK_OAK_PLANKS);
                                output.accept(ModBlocks.DARK_OAK_LAYERS);
                                output.accept(ModBlocks.DARK_OAK_TILE);
                                output.accept(ModBlocks.SOUL_QUARTZ_BULBS);
                                output.accept(ModBlocks.SOUL_QUARTZ_TILES);
                                output.accept(ModBlocks.ENCASED_SOUL_QUARTZ);
                                output.accept(ModBlocks.SOUL_GOLD_BARS_BLOCK);
                                output.accept(ModBlocks.SOUL_GOLD_GRATES);
                                output.accept(ModBlocks.SOUL_IRON_BARS_BLOCK);
                                output.accept(ModBlocks.CHISELED_SOUL_IRON_BARS_BLOCK);
                                output.accept(ModBlocks.SOUL_QUARTZ);
                                output.accept(ModBlocks.SOUL_GOLD_BLOCK);
                                output.accept(ModBlocks.SOUL_IRON_BLOCK);
                                output.accept(ModBlocks.SOUL_GOLD_TILE);

    }).build());
}
