package com.timelesskeeper.additionalweapon.items;

import com.timelesskeeper.additionalweapon.AdditionalWeapon;
import com.timelesskeeper.additionalweapon.api.items.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AdditionalWeapon.MOD_ID);

    public static final RegistryObject<Item> WOODEN_POLE = ModItems.ITEMS.register("wooden_pole", () ->
            new Item((new Item.Properties()).tab(CreativeTab.ADDITIONAL_WEAPON)));

    public static final WeaponFactory STONE = new WeaponFactory(ModToolTiers.STONE);
    public static final WeaponFactory IRON = new WeaponFactory(ModToolTiers.IRON);
    public static final WeaponFactory GOLD = new WeaponFactory(ModToolTiers.GOLD);
    public static final WeaponFactory DIAMOND = new WeaponFactory(ModToolTiers.DIAMOND);
    public static final WeaponFactory NETHERITE = new WeaponFactory(ModToolTiers.NETHERITE);

    //public static final WeaponModdedFactory TIN = new WeaponModdedFactory(ModToolTiers.TIN, ModArmorTiers.TIN);
    //public static final WeaponModdedFactory ZINC = new WeaponModdedFactory(ModToolTiers.ZINC, ModArmorTiers.ZINC);
    //public static final WeaponModdedFactory BRASS = new WeaponModdedFactory(ModToolTiers.BRASS, ModArmorTiers.BRASS);
    //public static final WeaponModdedFactory BRONZE = new WeaponModdedFactory(ModToolTiers.BRONZE, ModArmorTiers.BRONZE);
    //public static final WeaponModdedFactory ROSEGOLD = new WeaponModdedFactory(ModToolTiers.ROSEGOLD, ModArmorTiers.ROSEGOLD);
    //public static final WeaponModdedFactory STEEL = new WeaponModdedFactory(ModToolTiers.STEEL, ModArmorTiers.STEEL);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
