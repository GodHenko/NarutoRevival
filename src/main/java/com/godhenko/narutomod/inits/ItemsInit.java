package com.godhenko.narutomod.inits;

import com.godhenko.narutomod.util.Registration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ItemsInit {

    public static final RegistryObject<Item> RAMEN =
            Registration.ITEMS.register("ramen",
                    () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));


    public static void register() { }
}
