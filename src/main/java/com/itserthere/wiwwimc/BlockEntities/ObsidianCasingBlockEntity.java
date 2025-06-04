package com.itserthere.wiwwimc.BlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class ObsidianCasingBlockEntity extends CasingBlockEntity {
    public ObsidianCasingBlockEntity(BlockPos pos, BlockState blockState) {
        super(pos, blockState);
    }
    public final ItemStackHandler inventory = super.inventory;
    public void clearContents() {inventory.setStackInSlot(0, ItemStack.EMPTY);}
    public void drops() {
        SimpleContainer inv = new SimpleContainer(inventory.getSlots());
        for(int i=0; i<inventory.getSlots(); i++) {
            inv.setItem(i,inventory.getStackInSlot(i));
        }
        Containers.dropContents(this.level,this.worldPosition,inv);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {return super.getUpdatePacket();}

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
    }
}
