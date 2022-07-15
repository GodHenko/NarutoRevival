package com.godhenko.narutomod.network.packets;

import com.godhenko.narutomod.data.capabilities.CapabilityData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketTaijutsu {
    private int data;

    public PacketTaijutsu() {
    }

    public PacketTaijutsu(int data) {
        this.data = data;
    }

    public static void encode(PacketTaijutsu message, PacketBuffer buf) {
        buf.writeInt(message.data);
    }

    public static PacketTaijutsu decode(PacketBuffer buffer) {
        return new PacketTaijutsu(buffer.readInt());
    }

    public static void handle(PacketTaijutsu message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (ctx.get().getDirection().getReceptionSide().isServer() && ctx.get().getDirection().getOriginationSide().isClient()) {
                PlayerEntity player = ctx.get().getSender();
                player.getCapability(CapabilityData.ENTITY_DATA_CAPABILITY).ifPresent(data1 -> {
                    data1.setTaijutsu(message.data);
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
