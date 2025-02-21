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
    NETHERITE("netherite", Tiers.NETHERITE);

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
