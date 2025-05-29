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
                                output.accept(ModBlocks.SCULK_FRAME);
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
    }).build());
}
