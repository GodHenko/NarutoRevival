package com.godhenko.narutomod.network;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.network.packets.*;
import com.godhenko.narutomod.network.packets.serverpackets.*;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Networking {
    private static SimpleChannel INSTANCE;
    private static int ID = 0;

    private static int nextID() {
        return ID++;
    }

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(NarutoMod.MOD_ID, "narutorevival_channel"),
                () -> "1.0",
                s -> true,
                s -> true);
        INSTANCE.messageBuilder(PacketChakra.class, nextID())
                .encoder(PacketChakra::encode)
                .decoder(PacketChakra::decode)
                .consumer(PacketChakra::handle)
                .add();
        INSTANCE.messageBuilder(PacketExp.class, nextID())
                .encoder(PacketExp::encode)
                .decoder(PacketExp::decode)
                .consumer(PacketExp::handle)
                .add();
        INSTANCE.messageBuilder(PacketGenjutsu.class, nextID())
                .encoder(PacketGenjutsu::encode)
                .decoder(PacketGenjutsu::decode)
                .consumer(PacketGenjutsu::handle)
                .add();
        INSTANCE.messageBuilder(PacketHealth.class, nextID())
                .encoder(PacketHealth::encode)
                .decoder(PacketHealth::decode)
                .consumer(PacketHealth::handle)
                .add();
        INSTANCE.messageBuilder(PacketIntelligence.class, nextID())
                .encoder(PacketIntelligence::encode)
                .decoder(PacketIntelligence::decode)
                .consumer(PacketIntelligence::handle)
                .add();
        INSTANCE.messageBuilder(PacketKenjutsu.class, nextID())
                .encoder(PacketKenjutsu::encode)
                .decoder(PacketKenjutsu::decode)
                .consumer(PacketKenjutsu::handle)
                .add();
        INSTANCE.messageBuilder(PacketKinjutsu.class, nextID())
                .encoder(PacketKinjutsu::encode)
                .decoder(PacketKinjutsu::decode)
                .consumer(PacketKinjutsu::handle)
                .add();
        INSTANCE.messageBuilder(PacketLevel.class, nextID())
                .encoder(PacketLevel::encode)
                .decoder(PacketLevel::decode)
                .consumer(PacketLevel::handle)
                .add();
        INSTANCE.messageBuilder(PacketMaxSpeed.class, nextID())
                .encoder(PacketMaxSpeed::encode)
                .decoder(PacketMaxSpeed::decode)
                .consumer(PacketMaxSpeed::handle)
                .add();
        INSTANCE.messageBuilder(PacketNinjutsu.class, nextID())
                .encoder(PacketNinjutsu::encode)
                .decoder(PacketNinjutsu::decode)
                .consumer(PacketNinjutsu::handle)
                .add();
        INSTANCE.messageBuilder(PacketSenjutsu.class, nextID())
                .encoder(PacketSenjutsu::encode)
                .decoder(PacketSenjutsu::decode)
                .consumer(PacketSenjutsu::handle)
                .add();
        INSTANCE.messageBuilder(PacketSetHealth.class, nextID())
                .encoder(PacketSetHealth::encode)
                .decoder(PacketSetHealth::decode)
                .consumer(PacketSetHealth::handle)
                .add();
        INSTANCE.messageBuilder(PacketShurikenjutsu.class, nextID())
                .encoder(PacketShurikenjutsu::encode)
                .decoder(PacketShurikenjutsu::decode)
                .consumer(PacketShurikenjutsu::handle)
                .add();
        INSTANCE.messageBuilder(PacketSkillpoints.class, nextID())
                .encoder(PacketSkillpoints::encode)
                .decoder(PacketSkillpoints::decode)
                .consumer(PacketSkillpoints::handle)
                .add();
        INSTANCE.messageBuilder(PacketSpeed.class, nextID())
                .encoder(PacketSpeed::encode)
                .decoder(PacketSpeed::decode)
                .consumer(PacketSpeed::handle)
                .add();
        INSTANCE.messageBuilder(PacketSummoning.class, nextID())
                .encoder(PacketSummoning::encode)
                .decoder(PacketSummoning::decode)
                .consumer(PacketSummoning::handle)
                .add();
        INSTANCE.messageBuilder(PacketTaijutsu.class, nextID())
                .encoder(PacketTaijutsu::encode)
                .decoder(PacketTaijutsu::decode)
                .consumer(PacketTaijutsu::handle)
                .add();
        INSTANCE.messageBuilder(PacketGenjutsuServer.class, nextID())
                .encoder(PacketGenjutsuServer::encode)
                .decoder(PacketGenjutsuServer::decode)
                .consumer(PacketGenjutsuServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketIntelligenceServer.class, nextID())
                .encoder(PacketIntelligenceServer::encode)
                .decoder(PacketIntelligenceServer::decode)
                .consumer(PacketIntelligenceServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketKenjutsuServer.class, nextID())
                .encoder(PacketKenjutsuServer::encode)
                .decoder(PacketKenjutsuServer::decode)
                .consumer(PacketKenjutsuServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketKinjutsuServer.class, nextID())
                .encoder(PacketKinjutsuServer::encode)
                .decoder(PacketKinjutsuServer::decode)
                .consumer(PacketKinjutsuServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketNinjutsuServer.class, nextID())
                .encoder(PacketNinjutsuServer::encode)
                .decoder(PacketNinjutsuServer::decode)
                .consumer(PacketNinjutsuServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketSenjutsuServer.class, nextID())
                .encoder(PacketSenjutsuServer::encode)
                .decoder(PacketSenjutsuServer::decode)
                .consumer(PacketSenjutsuServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketSetHealthServer.class, nextID())
                .encoder(PacketSetHealthServer::encode)
                .decoder(PacketSetHealthServer::decode)
                .consumer(PacketSetHealthServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketShurikenjutsuServer.class, nextID())
                .encoder(PacketShurikenjutsuServer::encode)
                .decoder(PacketShurikenjutsuServer::decode)
                .consumer(PacketShurikenjutsuServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketSkillpointsServer.class, nextID())
                .encoder(PacketSkillpointsServer::encode)
                .decoder(PacketSkillpointsServer::decode)
                .consumer(PacketSkillpointsServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketSpeedServer.class, nextID())
                .encoder(PacketSpeedServer::encode)
                .decoder(PacketSpeedServer::decode)
                .consumer(PacketSpeedServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketSummoningServer.class, nextID())
                .encoder(PacketSummoningServer::encode)
                .decoder(PacketSummoningServer::decode)
                .consumer(PacketSummoningServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketTaijutsuServer.class, nextID())
                .encoder(PacketTaijutsuServer::encode)
                .decoder(PacketTaijutsuServer::decode)
                .consumer(PacketTaijutsuServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketMedicalServer.class, nextID())
                .encoder(PacketMedicalServer::encode)
                .decoder(PacketMedicalServer::decode)
                .consumer(PacketMedicalServer::handle)
                .add();
        INSTANCE.messageBuilder(PacketMedical.class, nextID())
                .encoder(PacketMedical::encode)
                .decoder(PacketMedical::decode)
                .consumer(PacketMedical::handle)
                .add();
    }

    public static void sendToClient(Object packet, ServerPlayerEntity player) {
        INSTANCE.sendTo(packet, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendToServer(Object packet) {
        INSTANCE.sendToServer(packet);
    }
}
