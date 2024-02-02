package com.timelesskeeper.additionalweapon.compat;

import com.timelesskeeper.additionalweapon.AdditionalWeapon;
import com.timelesskeeper.additionalweapon.api.items.IConfigItem;
import com.timelesskeeper.additionalweapon.api.items.WeaponFactory;
import com.timelesskeeper.additionalweapon.api.items.WeaponModdedFactory;
import com.timelesskeeper.additionalweapon.items.ModItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

@JeiPlugin
public class AdditionalWeaponJeiPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(AdditionalWeapon.MOD_ID, "jei");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Collection<ItemStack> toRemove = new ArrayList<>();

        registerWeaponFactory(toRemove, ModItems.STONE);
        registerWeaponFactory(toRemove, ModItems.IRON);
        registerWeaponFactory(toRemove, ModItems.GOLD);
        registerWeaponFactory(toRemove, ModItems.DIAMOND);
        registerWeaponFactory(toRemove, ModItems.NETHERITE);

        //registration.getIngredientManager().removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, toRemove);
    }

    private void registerWeaponFactory(Collection<ItemStack> toRemove, WeaponFactory weapons) {
        registerWeapon(toRemove, weapons.GREATSWORDS.get());
        registerWeapon(toRemove, weapons.SCIMITARS.get());
        registerWeapon(toRemove, weapons.KATANAS.get());
        registerWeapon(toRemove, weapons.GREATAXES.get());
        registerWeapon(toRemove, weapons.SPEARS.get());
        registerWeapon(toRemove, weapons.HALBERDS.get());
        registerWeapon(toRemove, weapons.GLAIVES.get());
        registerWeapon(toRemove, weapons.BATTLESTAFFS.get());
    }

    private void registerWeapon(Collection<ItemStack> toRemove, Item weapon) {
        if (!((IConfigItem) weapon).isEnabled()) {
            toRemove.add(new ItemStack(weapon));
        }
    }
}
