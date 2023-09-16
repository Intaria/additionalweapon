package com.timelesskeeper.additionalweapon.data;

import com.timelesskeeper.additionalweapon.AdditionalWeapon;
import com.timelesskeeper.additionalweapon.api.data.lang.FinishedLang;
import com.timelesskeeper.additionalweapon.api.data.lang.LangBuilder;
import com.timelesskeeper.additionalweapon.api.data.lang.LangDataProvider;
import com.timelesskeeper.additionalweapon.api.items.ConfigSwordItem;
import com.timelesskeeper.additionalweapon.api.items.IConfigItem;
import com.timelesskeeper.additionalweapon.api.items.WeaponFactory;
import com.timelesskeeper.additionalweapon.api.items.WeaponModdedFactory;
import com.timelesskeeper.additionalweapon.api.items.impl.GreataxeItem;
import com.timelesskeeper.additionalweapon.items.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ModLangProvider extends LangDataProvider {
    public ModLangProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildLangData(Consumer<FinishedLang> pFinishedLangConsumer) {
        Map<String, String> descriptions = new HashMap<>();

        registerWeaponFactory(descriptions, ModItems.STONE, "Stone");
        registerWeaponFactory(descriptions, ModItems.IRON, "Iron");
        registerWeaponFactory(descriptions, ModItems.GOLD, "Golden");
        registerWeaponFactory(descriptions, ModItems.DIAMOND, "Diamond");
        registerWeaponFactory(descriptions, ModItems.NETHERITE, "Netherite");

        //registerWeaponNoddedFactory(descriptions, ModItems.TIN, "Tin");
        //registerWeaponNoddedFactory(descriptions, ModItems.ZINC, "Zinc");
        //registerWeaponNoddedFactory(descriptions, ModItems.BRASS, "Brass");
        //registerWeaponNoddedFactory(descriptions, ModItems.BRONZE, "Bronze");
        //registerWeaponNoddedFactory(descriptions, ModItems.ROSEGOLD, "Rose Gold");
        //registerWeaponNoddedFactory(descriptions, ModItems.STEEL, "Steel");

        new LangBuilder()
                .description("itemGroup.additionalweapons", "Additional Weapons")
                .description("itemGroup.additionalweapons_vanilla", "Additional Weapons - Vanilla")
                .description("item.additionalweapon.wooden_pole", "Wooden Pole")
                .descriptions(descriptions)
                .save(pFinishedLangConsumer, new ResourceLocation(AdditionalWeapon.MOD_ID + ":en_us"));
    }

    private void registerWeaponFactory(Map<String, String> descriptions, WeaponFactory weapons, String name) {
        descriptions.put(weapons.GREATSWORDS.get().getDescriptionId(), name + " Greatsword");
        descriptions.put(weapons.SCIMITARS.get().getDescriptionId(), name + " Scimitar");
        descriptions.put(weapons.KATANAS.get().getDescriptionId(), name + " Katana");
        descriptions.put(weapons.GREATAXES.get().getDescriptionId(), name + " Greataxe");
        descriptions.put(weapons.SPEARS.get().getDescriptionId(), name + " Spear");
        descriptions.put(weapons.HALBERDS.get().getDescriptionId(), name + " Halberd");
        descriptions.put(weapons.GLAIVES.get().getDescriptionId(), name + " Glaive");
        descriptions.put(weapons.BATTLESTAFFS.get().getDescriptionId(), name + " Battlestaff");
    }

    private void  registerWeaponNoddedFactory(Map<String, String> descriptions, WeaponModdedFactory weapons, String name) {
        registerWeaponFactory(descriptions, weapons, name);

        descriptions.put(weapons.HELMETS.get().getDescriptionId(), name + " Helmet");
        descriptions.put(weapons.CHESTPLATES.get().getDescriptionId(), name + " Chestplate");
        descriptions.put(weapons.LEGGINGS.get().getDescriptionId(), name + " Leggings");
        descriptions.put(weapons.BOOTS.get().getDescriptionId(), name + " Boots");

        descriptions.put(weapons.SWORDS.get().getDescriptionId(), name + " Sword");
        descriptions.put(weapons.SHOVELS.get().getDescriptionId(), name + " Shovel");
        descriptions.put(weapons.PICKAXES.get().getDescriptionId(), name + " Pickaxe");
        descriptions.put(weapons.AXES.get().getDescriptionId(), name + " Axe");
        descriptions.put(weapons.HOES.get().getDescriptionId(), name + " Hoe");
    }
}
