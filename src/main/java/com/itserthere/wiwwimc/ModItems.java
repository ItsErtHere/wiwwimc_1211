package com.itserthere.wiwwimc;

import com.itserthere.wiwwimc.Items.CustomDyeItem;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WIWWIMC.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public static DeferredItem<Item> registerItem(String name) {
        return ITEMS.register(name,()->new Item(new Item.Properties()));
    }

    public static final DeferredItem<Item> WOODEN_CHUNK = registerItem("wooden_chunk");
    public static final DeferredItem<Item> CUSTOM_DYE =
            ITEMS.register("custom_dye",()->new CustomDyeItem(
                    new Item.Properties().durability(3)));
}
