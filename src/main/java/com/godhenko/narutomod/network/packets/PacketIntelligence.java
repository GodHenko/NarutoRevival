package com.godhenko.narutomod.network.packets;

import com.godhenko.narutomod.data.capabilities.CapabilityData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketIntelligence {
    private int data;

    public PacketIntelligence() {
    }

    public PacketIntelligence(int data) {
        this.data = data;
    }

    public static void encode(PacketIntelligence message, PacketBuffer buf) {
        buf.writeInt(message.data);
    }

    public static PacketIntelligence decode(PacketBuffer buffer) {
        return new PacketIntelligence(buffer.readInt());
    }

    public static void handle(PacketIntelligence message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (ctx.get().getDirection().getReceptionSide().isServer() && ctx.get().getDirection().getOriginationSide().isClient()) {
                PlayerEntity player = ctx.get().getSender();
                player.getCapability(CapabilityData.ENTITY_DATA_CAPABILITY).ifPresent(data1 -> {
                    data1.setIntelligence(message.data);
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
