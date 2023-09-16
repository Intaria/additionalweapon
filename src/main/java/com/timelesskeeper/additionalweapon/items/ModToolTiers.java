package com.timelesskeeper.additionalweapon.items;

import com.timelesskeeper.additionalweapon.api.items.IConfigTier;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum ModToolTiers implements IConfigTier {
    STONE("stone", Tiers.STONE),
    IRON("iron", Tiers.IRON),
    GOLD("golden", Tiers.GOLD),
    DIAMOND("diamond", Tiers.DIAMOND),
    NETHERITE("netherite", Tiers.NETHERITE),

    TIN("tin", 1, 50, 11.5F, 0.0F, 20,
            () -> Ingredient.of(ModTags.INGOTS_TIN)),
    ZINC("zinc", 1, 100, 10F, 0.5F, 19,
            () -> Ingredient.of(ModTags.INGOTS_ZINC)),
    BRASS("brass", 2, 150, 8.5F, 1.5F, 18,
            () -> Ingredient.of(ModTags.INGOTS_BRASS)),
    BRONZE("bronze", 2, 200, 6.5F, 2F, 17,
            () -> Ingredient.of(ModTags.INGOTS_BRONZE)),
    ROSEGOLD("rosegold", 2, 150, 11F, 1.5F, 20,
            () -> Ingredient.of(ModTags.INGOTS_ROSEGOLD)),
    STEEL("steel", 3, 600, 7.0F, 2.5F, 14,
            () -> Ingredient.of(ModTags.INGOTS_STEEL));

    private final String name;
    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModToolTiers(String pName, Tier tier) {
        this.name = pName;
        this.level = tier.getLevel();
        this.uses = tier.getUses();
        this.speed = tier.getSpeed();
        this.damage = tier.getAttackDamageBonus();
        this.enchantmentValue = tier.getEnchantmentValue();
        this.repairIngredient = new LazyLoadedValue<>(() -> tier.getRepairIngredient());
    }

    ModToolTiers(String pName, int pLevel, int pUses, float pSpeed, float pDamage, int pEnchantmentValue,
                 Supplier<Ingredient> pRepairIngredient) {
        this.name = pName;
        this.level = pLevel;
        this.uses = pUses;
        this.speed = pSpeed;
        this.damage = pDamage;
        this.enchantmentValue = pEnchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }

    public String getName() { return this.name; }

    @Override
    public boolean getEnable() {
        return true;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
