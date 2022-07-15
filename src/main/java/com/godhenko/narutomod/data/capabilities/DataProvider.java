package com.godhenko.narutomod.data.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DataProvider implements ICapabilitySerializable<CompoundNBT> {

    private final Data data = new Data();
    private final LazyOptional<IData> dataOptional = LazyOptional.of(() -> data);

    public void invalidate() {
        dataOptional.invalidate();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return dataOptional.cast();
    }

    @Override
    public CompoundNBT serializeNBT() {
        if (CapabilityData.ENTITY_DATA_CAPABILITY== null) {
            return new CompoundNBT();
        } else {
            return (CompoundNBT) CapabilityData.ENTITY_DATA_CAPABILITY.writeNBT(data, null);
        }
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (CapabilityData.ENTITY_DATA_CAPABILITY != null) {
            CapabilityData.ENTITY_DATA_CAPABILITY.readNBT(data, null, nbt);
        }
    }
}