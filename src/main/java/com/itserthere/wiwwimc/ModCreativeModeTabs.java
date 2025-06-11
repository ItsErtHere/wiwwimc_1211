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
                                output.accept(ModBlocks.SMITHED_STURDY_STONE);
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
                                output.accept(ModBlocks.SOUL_QUARTZ);
                                output.accept(ModBlocks.SOUL_QUARTZ_BULBS);
                                output.accept(ModBlocks.SOUL_QUARTZ_TILES);
                                output.accept(ModBlocks.ENCASED_SOUL_QUARTZ);
                                output.accept(ModBlocks.SOUL_GOLD_BLOCK);
                                output.accept(ModBlocks.SOUL_GOLD_TILE);
                                output.accept(ModBlocks.SOUL_GOLD_BARS_BLOCK);
                                output.accept(ModBlocks.SOUL_GOLD_GRATES);
                                output.accept(ModBlocks.SOUL_IRON_BLOCK);
                                output.accept(ModBlocks.SOUL_IRON_BARS_BLOCK);
                                output.accept(ModBlocks.CHISELED_SOUL_IRON_BARS_BLOCK);
                                output.accept(ModBlocks.GLOWING_OBSIDIAN);
                                output.accept(ModBlocks.AZALEA_BUSH);
                                output.accept(ModBlocks.FLOWERING_AZALEA_BUSH);
                                output.accept(ModBlocks.ALT_PODZOL);
                                output.accept(ModBlocks.ALT_MYCELIUM);
                                output.accept(ModBlocks.ALT_CRIMSON_NYLIUM);
                                output.accept(ModBlocks.ALT_WARPED_NYLIUM);
                                output.accept(ModBlocks.ALT_DRY_FARMLAND);
                                output.accept(ModBlocks.ALT_WET_FARMLAND);
                                output.accept(ModBlocks.PURPUR_TILE);
                                output.accept(ModBlocks.STONE_CASING);
                                output.accept(ModBlocks.OBSIDIAN_CASING);
                                output.accept(ModBlocks.DEEPSLATE_CASING);
                                output.accept(ModBlocks.BLACKSTONE_CASING);
                                output.accept(ModBlocks.PLANT_CASING);
                                output.accept(ModBlocks.SOUL_GOLD_CASING);
                                output.accept(ModBlocks.SOUL_IRON_CASING);
                                output.accept(ModBlocks.BONE_CASING);
                                output.accept(ModBlocks.ALT_COPPER_GRATE);
                                output.accept(ModBlocks.ALT_EXPOSED_COPPER_GRATE);
                                output.accept(ModBlocks.ALT_WEATHERED_COPPER_GRATE);
                                output.accept(ModBlocks.ALT_OXIDIZED_COPPER_GRATE);
                                output.accept(ModBlocks.COPPER_FRAME);
                                output.accept(ModBlocks.EXPOSED_COPPER_FRAME);
                                output.accept(ModBlocks.WEATHERED_COPPER_FRAME);
                                output.accept(ModBlocks.OXIDIZED_COPPER_FRAME);
                                output.accept(ModBlocks.OAK_FRAME);
                                output.accept(ModBlocks.JUNGLE_FRAME);
                                output.accept(ModBlocks.ACACIA_FRAME);
                                output.accept(ModBlocks.MANGROVE_FRAME);
                                output.accept(ModBlocks.CHERRY_FRAME);
                                output.accept(ModBlocks.BAMBOO_FRAME);
                                output.accept(ModBlocks.CRIMSON_FRAME);
                                output.accept(ModBlocks.WARPED_FRAME);
                                output.accept(ModBlocks.IRON_FRAME);

                                output.accept(ModBlocks.ALT_FIRE_CORAL_BLOCK);
                                output.accept(ModBlocks.ALT_HORN_CORAL_BLOCK);
                                output.accept(ModBlocks.ALT_TUBE_CORAL_BLOCK);
                                output.accept(ModBlocks.ALT_BRAIN_CORAL_BLOCK);
                                output.accept(ModBlocks.ALT_BUBBLE_CORAL_BLOCK);
                                output.accept(ModBlocks.STRIPPED_MUSHROOM_STEM);
                                output.accept(ModBlocks.ALT_BROWN_MUSHROOM_BLOCK);
                                output.accept(ModBlocks.ALT_RED_MUSHROOM_BLOCK);
                                output.accept(ModBlocks.ALT_MUSHROOM_STEM);

                                output.accept(ModBlocks.ALT_FIRE_CORAL_FAN);
                                output.accept(ModBlocks.ALT_FIRE_CORAL_WALL_FAN);
                                output.accept(ModBlocks.ALT_FIRE_CORAL);
                                output.accept(ModBlocks.ALT_DEAD_FIRE_CORAL_FAN);
                                output.accept(ModBlocks.ALT_DEAD_FIRE_CORAL_WALL_FAN);
                                output.accept(ModBlocks.ALT_DEAD_FIRE_CORAL);

                                output.accept(ModBlocks.ALT_HORN_CORAL_FAN);
                                output.accept(ModBlocks.ALT_HORN_CORAL_WALL_FAN);
                                output.accept(ModBlocks.ALT_HORN_CORAL);
                                output.accept(ModBlocks.ALT_DEAD_HORN_CORAL_FAN);
                                output.accept(ModBlocks.ALT_DEAD_HORN_CORAL_WALL_FAN);
                                output.accept(ModBlocks.ALT_DEAD_HORN_CORAL);

                                output.accept(ModBlocks.ALT_TUBE_CORAL_FAN);
                                output.accept(ModBlocks.ALT_TUBE_CORAL_WALL_FAN);
                                output.accept(ModBlocks.ALT_TUBE_CORAL);
                                output.accept(ModBlocks.ALT_DEAD_TUBE_CORAL_FAN);
                                output.accept(ModBlocks.ALT_DEAD_TUBE_CORAL_WALL_FAN);
                                output.accept(ModBlocks.ALT_DEAD_TUBE_CORAL);

                                output.accept(ModBlocks.ALT_BRAIN_CORAL_FAN);
                                output.accept(ModBlocks.ALT_BRAIN_CORAL_WALL_FAN);
                                output.accept(ModBlocks.ALT_BRAIN_CORAL);
                                output.accept(ModBlocks.ALT_DEAD_BRAIN_CORAL_FAN);
                                output.accept(ModBlocks.ALT_DEAD_BRAIN_CORAL_WALL_FAN);
                                output.accept(ModBlocks.ALT_DEAD_BRAIN_CORAL);

                                output.accept(ModBlocks.ALT_BUBBLE_CORAL_FAN);
                                output.accept(ModBlocks.ALT_BUBBLE_CORAL_WALL_FAN);
                                output.accept(ModBlocks.ALT_BUBBLE_CORAL);
                                output.accept(ModBlocks.ALT_DEAD_BUBBLE_CORAL_FAN);
                                output.accept(ModBlocks.ALT_DEAD_BUBBLE_CORAL_WALL_FAN);
                                output.accept(ModBlocks.ALT_DEAD_BUBBLE_CORAL);

                                output.accept(ModBlocks.ALT_BROWN_MUSHROOM);
                                output.accept(ModBlocks.ALT_RED_MUSHROOM);
                                output.accept(ModBlocks.ALT_CRIMSON_FUNGUS);
                                output.accept(ModBlocks.ALT_WARPED_FUNGUS);
                                output.accept(ModBlocks.ALT_GLOW_LICHEN);

                                output.accept(ModBlocks.ALT_HAY_BALE);
                                output.accept(ModBlocks.ALT_DRIED_KELP_BLOCK);
                                output.accept(ModBlocks.ACTIVE_REDSTONE_LAMP);
                                output.accept(ModBlocks.ALT_REINFORCED_DEEPSLATE);
                                output.accept(ModBlocks.ALT_BASALT);
                                output.accept(ModBlocks.ALT_CHISELED_TUFF);
                                output.accept(ModBlocks.ALT_CHISELED_TUFF_BRICKS);
                                output.accept(ModBlocks.SMITHED_DEEPSLATE);
                                output.accept(ModBlocks.STURDY_STONE_VENTS);
                                output.accept(ModBlocks.ALT_BONE_BLOCK);
                                output.accept(ModBlocks.PORTALIC_BLOCK);
                                output.accept(ModBlocks.WATER_TANK);
                                output.accept(ModBlocks.LAVA_TANK);

    }).build());
}
