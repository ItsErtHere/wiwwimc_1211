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
    }).build());
}
