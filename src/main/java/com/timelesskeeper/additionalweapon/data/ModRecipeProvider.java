package com.timelesskeeper.additionalweapon.data;

import com.google.common.collect.ImmutableMap;
import com.timelesskeeper.additionalweapon.api.data.BaseRecipeProvider;
import com.timelesskeeper.additionalweapon.api.items.WeaponFactory;
import com.timelesskeeper.additionalweapon.api.items.WeaponModdedFactory;
import com.timelesskeeper.additionalweapon.items.ModItems;
import com.timelesskeeper.additionalweapon.items.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;

import java.util.Map;
import java.util.function.Consumer;

public class ModRecipeProvider extends BaseRecipeProvider {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    private static final Map<String, String> smithMaterials = ImmutableMap.of(
            "netherite", "diamond"
    );

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        ShapedRecipeBuilder.shaped(ModItems.WOODEN_POLE.get())
                .define('/', Items.STICK)
                .pattern("  /")
                .pattern(" / ")
                .pattern("/  ")
                .unlockedBy("has_item", has(Items.STICK))
                .save(pFinishedRecipeConsumer);

        registerWeaponFactory(pFinishedRecipeConsumer, ModItems.WOODEN, ItemTags.PLANKS);
        registerWeaponFactory(pFinishedRecipeConsumer, ModItems.STONE, ItemTags.STONE_TOOL_MATERIALS);
        registerWeaponFactory(pFinishedRecipeConsumer, ModItems.IRON, Tags.Items.INGOTS_IRON);
        registerWeaponFactory(pFinishedRecipeConsumer, ModItems.GOLD, Tags.Items.INGOTS_GOLD);
        registerWeaponFactory(pFinishedRecipeConsumer, ModItems.DIAMOND, Tags.Items.GEMS_DIAMOND);
        registerSmithingFactory(pFinishedRecipeConsumer, ModItems.DIAMOND, ModItems.NETHERITE, Tags.Items.INGOTS_NETHERITE);

        registerWeaponNoddedFactory(pFinishedRecipeConsumer, ModItems.TIN, ModTags.INGOTS_TIN);
        registerWeaponNoddedFactory(pFinishedRecipeConsumer, ModItems.ZINC, ModTags.INGOTS_ZINC);
        registerWeaponNoddedFactory(pFinishedRecipeConsumer, ModItems.COPPER, Tags.Items.INGOTS_COPPER);
        registerWeaponNoddedFactory(pFinishedRecipeConsumer, ModItems.BRASS, ModTags.INGOTS_BRASS);
        registerWeaponNoddedFactory(pFinishedRecipeConsumer, ModItems.BRONZE, ModTags.INGOTS_BRONZE);
        registerWeaponNoddedFactory(pFinishedRecipeConsumer, ModItems.ROSEGOLD, ModTags.INGOTS_ROSEGOLD);
        registerWeaponNoddedFactory(pFinishedRecipeConsumer, ModItems.STEEL, ModTags.INGOTS_STEEL);
    }

    private void registerWeaponFactory(Consumer<FinishedRecipe> pFinishedRecipeConsumer, WeaponFactory weapons,
                                       TagKey<Item> bladeItem) {
        registerGreatsword(pFinishedRecipeConsumer, weapons.GREATSWORDS.get(), bladeItem);
        registerScimitar(pFinishedRecipeConsumer, weapons.SCIMITARS.get(), bladeItem);
        registerKatana(pFinishedRecipeConsumer, weapons.KATANAS.get(), bladeItem);
        registerGreataxe(pFinishedRecipeConsumer, weapons.GREATAXES.get(), bladeItem);
        registerSpear(pFinishedRecipeConsumer, weapons.SPEARS.get(), bladeItem);
        registerHalberd(pFinishedRecipeConsumer, weapons.HALBERDS.get(), bladeItem);
        registerGlaive(pFinishedRecipeConsumer, weapons.GLAIVES.get(), bladeItem);
        registerBattlestaff(pFinishedRecipeConsumer, weapons.BATTLESTAFFS.get(), bladeItem);
    }

    private void  registerWeaponNoddedFactory(Consumer<FinishedRecipe> pFinishedRecipeConsumer, WeaponModdedFactory weapons,
                                              TagKey<Item> bladeItem) {
        registerWeaponFactory(pFinishedRecipeConsumer, weapons, bladeItem);

        registerHelmet(pFinishedRecipeConsumer, weapons.HELMETS .get(), bladeItem);
        registerChestplate(pFinishedRecipeConsumer, weapons.CHESTPLATES .get(), bladeItem);
        registerLeggings(pFinishedRecipeConsumer, weapons.LEGGINGS .get(), bladeItem);
        registerBoots(pFinishedRecipeConsumer, weapons.BOOTS .get(), bladeItem);

        registerSword(pFinishedRecipeConsumer, weapons.SWORDS .get(), bladeItem);
        registerShovel(pFinishedRecipeConsumer, weapons.SHOVELS .get(), bladeItem);
        registerPickaxe(pFinishedRecipeConsumer, weapons.PICKAXES .get(), bladeItem);
        registerAxe(pFinishedRecipeConsumer, weapons.AXES .get(), bladeItem);
        registerHoe(pFinishedRecipeConsumer, weapons.HOES .get(), bladeItem);
    }

    private void registerSmithingFactory(Consumer<FinishedRecipe> pFinishedRecipeConsumer, WeaponFactory sources,
                                         WeaponFactory results, TagKey<Item> bladeItem) {
        registerSmithing(pFinishedRecipeConsumer, bladeItem, sources.GREATSWORDS.get(), results.GREATSWORDS.get());
        registerSmithing(pFinishedRecipeConsumer, bladeItem, sources.SCIMITARS.get(), results.SCIMITARS.get());
        registerSmithing(pFinishedRecipeConsumer, bladeItem, sources.KATANAS.get(), results.KATANAS.get());
        registerSmithing(pFinishedRecipeConsumer, bladeItem, sources.GREATAXES.get(), results.GREATAXES.get());
        registerSmithing(pFinishedRecipeConsumer, bladeItem, sources.SPEARS.get(), results.SPEARS.get());
        registerSmithing(pFinishedRecipeConsumer, bladeItem, sources.HALBERDS.get(), results.HALBERDS.get());
        registerSmithing(pFinishedRecipeConsumer, bladeItem, sources.GLAIVES.get(), results.GLAIVES.get());
        registerSmithing(pFinishedRecipeConsumer, bladeItem, sources.BATTLESTAFFS.get(), results.BATTLESTAFFS.get());
    }
}
