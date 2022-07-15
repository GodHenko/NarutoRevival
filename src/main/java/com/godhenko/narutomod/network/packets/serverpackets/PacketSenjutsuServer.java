package com.godhenko.narutomod.network.packets.serverpackets;

import com.godhenko.narutomod.data.capabilities.CapabilityData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketSenjutsuServer {
    private int data;

    public PacketSenjutsuServer() {
    }

    public PacketSenjutsuServer(int data) {
        this.data = data;
    }

    public static void encode(PacketSenjutsuServer message, PacketBuffer buf) {
        buf.writeInt(message.data);
    }

    public static PacketSenjutsuServer decode(PacketBuffer buffer) {
        return new PacketSenjutsuServer(buffer.readInt());
    }

    public static void handle(PacketSenjutsuServer message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (ctx.get().getDirection().getReceptionSide().isServer() && ctx.get().getDirection().getOriginationSide().isClient()) {
                PlayerEntity player = ctx.get().getSender();
                player.getCapability(CapabilityData.ENTITY_DATA_CAPABILITY).ifPresent(data1 -> {
                    data1.setSenjutsu(message.data);
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
