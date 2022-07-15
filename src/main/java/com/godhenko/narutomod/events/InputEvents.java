package com.godhenko.narutomod.events;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.client.ModKeyBinds;
import com.godhenko.narutomod.screens.gui.GuiStats;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NarutoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class InputEvents {

    @SubscribeEvent
    public static void onKeyPress(InputEvent.KeyInputEvent event){
        Minecraft mc = Minecraft.getInstance();
        if (mc.world == null) return;
        onInput(mc, event.getKey(), event.getAction());
    }

    @SubscribeEvent
    public static void onMouseClick(InputEvent.MouseInputEvent event){
        Minecraft mc = Minecraft.getInstance();
        if (mc.world == null) return;
        onInput(mc, event.getButton(), event.getAction());
    }

    private static void onInput(Minecraft mc, int key, int action){
        if (mc.currentScreen == null && ModKeyBinds.stats.isPressed()){
            Minecraft.getInstance().displayGuiScreen(new GuiStats(Minecraft.getInstance().player));
        }
    }
}