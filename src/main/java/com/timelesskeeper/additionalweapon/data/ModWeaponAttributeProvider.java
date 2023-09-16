package com.timelesskeeper.additionalweapon.data;

import com.timelesskeeper.additionalweapon.api.data.BaseWeaponAttributeProvider;
import com.timelesskeeper.additionalweapon.api.data.bettercombat.FinishedWeaponAttribute;
import com.timelesskeeper.additionalweapon.api.items.WeaponFactory;
import com.timelesskeeper.additionalweapon.api.items.WeaponModdedFactory;
import com.timelesskeeper.additionalweapon.items.ModItems;
import net.minecraft.data.DataGenerator;

import java.util.function.Consumer;

public class ModWeaponAttributeProvider extends BaseWeaponAttributeProvider {
    public ModWeaponAttributeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildBetterCombatData(Consumer<FinishedWeaponAttribute> pWeaponAttributeConsumer) {
        registerWeaponFactory(pWeaponAttributeConsumer, ModItems.STONE);
        registerWeaponFactory(pWeaponAttributeConsumer, ModItems.IRON);
        registerWeaponFactory(pWeaponAttributeConsumer, ModItems.GOLD);
        registerWeaponFactory(pWeaponAttributeConsumer, ModItems.DIAMOND);
        registerWeaponFactory(pWeaponAttributeConsumer, ModItems.NETHERITE);

        //registerWeaponNoddedFactory(pWeaponAttributeConsumer, ModItems.TIN);
        //registerWeaponNoddedFactory(pWeaponAttributeConsumer, ModItems.ZINC);
        //registerWeaponNoddedFactory(pWeaponAttributeConsumer, ModItems.BRASS);
        //registerWeaponNoddedFactory(pWeaponAttributeConsumer, ModItems.BRONZE);
        //registerWeaponNoddedFactory(pWeaponAttributeConsumer, ModItems.ROSEGOLD);
        //registerWeaponNoddedFactory(pWeaponAttributeConsumer, ModItems.STEEL);
    }

    private void registerWeaponFactory(Consumer<FinishedWeaponAttribute> pWeaponAttributeConsumer, WeaponFactory weapons) {
        greatsword(pWeaponAttributeConsumer, weapons.GREATSWORDS);
        scimitar(pWeaponAttributeConsumer, weapons.SCIMITARS);
        katana(pWeaponAttributeConsumer, weapons.KATANAS);
        greataxe(pWeaponAttributeConsumer, weapons.GREATAXES);
        spear(pWeaponAttributeConsumer, weapons.SPEARS);
        halberd(pWeaponAttributeConsumer, weapons.HALBERDS);
        glaive(pWeaponAttributeConsumer, weapons.GLAIVES);
        battlestaff(pWeaponAttributeConsumer, weapons.BATTLESTAFFS);
    }

    private void  registerWeaponNoddedFactory(Consumer<FinishedWeaponAttribute> pWeaponAttributeConsumer,
                                              WeaponModdedFactory weapons) {
        registerWeaponFactory(pWeaponAttributeConsumer, weapons);

        sword(pWeaponAttributeConsumer, weapons.SWORDS);
    }
}
