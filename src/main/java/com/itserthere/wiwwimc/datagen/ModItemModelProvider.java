package com.itserthere.wiwwimc.datagen;

import com.itserthere.wiwwimc.ModItems;
import com.itserthere.wiwwimc.WIWWIMC;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, WIWWIMC.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.WOODEN_CHUNK.get());
        basicItem(ModItems.CUSTOM_DYE.get());
    }
}
