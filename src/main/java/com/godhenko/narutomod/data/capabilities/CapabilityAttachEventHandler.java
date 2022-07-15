package com.godhenko.narutomod.data.capabilities;


import com.godhenko.narutomod.NarutoMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityAttachEventHandler {
    public static final ResourceLocation DATA_CAP = new ResourceLocation(NarutoMod.MOD_ID, "playerdata");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        Entity entity = (Entity) event.getObject();
        if (entity instanceof PlayerEntity) {
            DataProvider provider = new DataProvider();
            event.addCapability(DATA_CAP, provider);
            event.addListener(provider::invalidate);
        }
    }
}