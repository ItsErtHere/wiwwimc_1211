package com.itserthere.wiwwimc.datagen;

import com.itserthere.wiwwimc.ModBlocks;
import com.itserthere.wiwwimc.ModItems;
import com.itserthere.wiwwimc.WIWWIMC;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, WIWWIMC.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.WOODEN_CHUNK.get());
        basicItem(ModItems.CUSTOM_DYE.get());
        fenceItem(ModBlocks.SMITHED_OAK_PLANKS_FENCE,ModBlocks.SMITHED_OAK_PLANKS);
        wallItem(ModBlocks.NETHER_CORE_WALL,ModBlocks.NETHER_CORE);
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(),mcLoc("block/fence_inventory"))
                .texture("fence", ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,
                        "block/"+baseBlock.getId().getPath()));
    }
    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(),mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,
                        "block/"+baseBlock.getId().getPath()));
    }
}
