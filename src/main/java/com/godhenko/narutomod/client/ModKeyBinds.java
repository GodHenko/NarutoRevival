package com.godhenko.narutomod.client;

import com.godhenko.narutomod.NarutoMod;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.swing.text.JTextComponent;
import java.awt.event.KeyEvent;

@OnlyIn(Dist.CLIENT)
public class ModKeyBinds {

    public static KeyBinding stats;



        public static void register(final FMLClientSetupEvent event){
            stats = create("stats_key", KeyEvent.VK_C);

            ClientRegistry.registerKeyBinding(stats);

    }
    private static KeyBinding create(String name, int key){
        return new KeyBinding("key." + NarutoMod.MOD_ID + "." + name, key, "key.category." + NarutoMod.MOD_ID);
    }
}
