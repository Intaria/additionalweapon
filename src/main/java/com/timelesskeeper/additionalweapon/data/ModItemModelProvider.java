package com.timelesskeeper.additionalweapon.data;

import com.timelesskeeper.additionalweapon.AdditionalWeapon;
import com.timelesskeeper.additionalweapon.api.data.BaseItemModelProvider;
import com.timelesskeeper.additionalweapon.api.items.IConfigItem;
import com.timelesskeeper.additionalweapon.api.items.WeaponFactory;
import com.timelesskeeper.additionalweapon.api.items.WeaponModdedFactory;
import com.timelesskeeper.additionalweapon.items.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends BaseItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerWeaponFactory(ModItems.STONE);
        registerWeaponFactory(ModItems.GOLD);
        registerWeaponFactory(ModItems.DIAMOND);
        registerWeaponFactory(ModItems.NETHERITE);

        //registerWeaponNoddedFactory(ModItems.TIN);
        //registerWeaponNoddedFactory(ModItems.ZINC);
        //registerWeaponNoddedFactory(ModItems.BRASS);
        //registerWeaponNoddedFactory(ModItems.BRONZE);
        //registerWeaponNoddedFactory(ModItems.ROSEGOLD);
        //registerWeaponNoddedFactory(ModItems.STEEL);
    }

    private void registerWeaponFactory(WeaponFactory weapons) {
        ModelFile greatswordParent = getModedModelFile("iron_greatsword");
        ModelFile scimitarParent = getModedModelFile("iron_scimitar");
        ModelFile katanaParent = getModedModelFile("iron_katana");
        ModelFile greataxeParent = getModedModelFile("iron_greataxe");
        ModelFile spearParent = getModedModelFile("iron_spear");
        ModelFile halberdParent = getModedModelFile("iron_halberd");
        ModelFile glaiveParent = getModedModelFile("iron_glaive");
        ModelFile battlestaffParent = getModedModelFile("iron_battlestaff");

        builder(greatswordParent, weapons.GREATSWORDS.get().toString());
        builder(scimitarParent, weapons.SCIMITARS.get().toString());
        builder(katanaParent, weapons.KATANAS.get().toString());
        builder(greataxeParent, weapons.GREATAXES.get().toString());
        builder(spearParent, weapons.SPEARS.get().toString());
        builder(halberdParent, weapons.HALBERDS.get().toString());
        builder(glaiveParent, weapons.GLAIVES.get().toString());
        builder(battlestaffParent, weapons.BATTLESTAFFS.get().toString());
    }

    private void  registerWeaponNoddedFactory(WeaponModdedFactory weapons) {
        registerWeaponFactory(weapons);

        ModelFile helmetParent = getVanillaModelFile("iron_helmet");
        ModelFile chestplateParent = getVanillaModelFile("iron_chestplate");
        ModelFile leggingsParent = getVanillaModelFile("iron_leggings");
        ModelFile bootsParent = getVanillaModelFile("iron_boots");

        builder(helmetParent, weapons.HELMETS.get().toString());
        builder(chestplateParent, weapons.CHESTPLATES.get().toString());
        builder(leggingsParent, weapons.LEGGINGS.get().toString());
        builder(bootsParent, weapons.BOOTS.get().toString());

        ModelFile swordParent = getVanillaModelFile("iron_sword");
        ModelFile shovelParent = getVanillaModelFile("iron_shovel");
        ModelFile pickaxeParent = getVanillaModelFile("iron_pickaxe");
        ModelFile axeParent = getVanillaModelFile("iron_axe");
        ModelFile hoeParent = getVanillaModelFile("iron_hoe");

        builder(swordParent, weapons.SWORDS.get().toString());
        builder(shovelParent, weapons.SHOVELS.get().toString());
        builder(pickaxeParent, weapons.PICKAXES.get().toString());
        builder(axeParent, weapons.AXES.get().toString());
        builder(hoeParent, weapons.HOES.get().toString());
    }
}
