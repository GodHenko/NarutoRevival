package com.godhenko.narutomod.util;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.client.ModKeyBinds;
import net.minecraft.client.network.status.IClientStatusNetHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.system.CallbackI;

@Mod.EventBusSubscriber(modid = NarutoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        ModKeyBinds.register(event);

    }
}
