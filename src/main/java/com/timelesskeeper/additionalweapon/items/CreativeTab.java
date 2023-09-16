package com.timelesskeeper.additionalweapon.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CreativeTab {

    public static final CreativeModeTab ADDITIONAL_WEAPON = new CreativeModeTab("additionalweapons")
    {
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack(ModItems.GOLD.GREATSWORDS.get());
        }
    };

    public static final CreativeModeTab ADDITIONAL_WEAPON_VANILLA = new CreativeModeTab("additionalweapons_vanilla")
    {
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack(ModItems.GOLD.GREATSWORDS.get());
        }
    };
}
