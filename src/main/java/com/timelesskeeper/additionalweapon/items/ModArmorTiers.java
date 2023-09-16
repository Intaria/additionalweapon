package com.timelesskeeper.additionalweapon.items;

import com.timelesskeeper.additionalweapon.AdditionalWeapon;
import com.timelesskeeper.additionalweapon.api.items.IConfigArmorMaterial;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum ModArmorTiers implements IConfigArmorMaterial {
    TIN("tin", 8, new int[]{2, 3, 5, 2}, 22, SoundEvents.ARMOR_EQUIP_IRON,
            0.0F, 0.0F, () -> Ingredient.of(ModTags.INGOTS_TIN)),
    ZINC("zinc", 9, new int[]{2, 3, 5, 2}, 20, SoundEvents.ARMOR_EQUIP_IRON,
            0.0F, 0.0F, () -> Ingredient.of(ModTags.INGOTS_ZINC)),
    BRASS("brass", 11, new int[]{2, 4, 6, 2}, 18, SoundEvents.ARMOR_EQUIP_IRON,
            0.0F, 0.0F, () -> Ingredient.of(ModTags.INGOTS_BRASS)),
    BRONZE("bronze", 13, new int[]{2, 5, 6, 2}, 16, SoundEvents.ARMOR_EQUIP_IRON,
            0.0F, 0.0F, () -> Ingredient.of(ModTags.INGOTS_BRONZE)),
    ROSEGOLD("rosegold", 11, new int[]{2, 4, 5, 2}, 22, SoundEvents.ARMOR_EQUIP_GOLD,
            0.0F, 0.0F, () -> Ingredient.of(ModTags.INGOTS_ROSEGOLD)),
    STEEL("steel", 20, new int[]{2, 5, 7, 3}, 10, SoundEvents.ARMOR_EQUIP_IRON,
            1.0F, 0.0F, () -> Ingredient.of(ModTags.INGOTS_STEEL));

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModArmorTiers(String pName, int pDurabilityMultiplier, int[] pSlotProtections, int pEnchantmentValue, SoundEvent pSound,
                  float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
        this.name = pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.slotProtections = pSlotProtections;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }

    public String getName() {
        return AdditionalWeapon.MOD_ID + ":" + this.name;
    }

    public String getMaterial() {
        return this.name;
    }

    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDurabilityMultiplier() {
        return this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot pSlot) {
        return this.slotProtections[pSlot.getIndex()];
    }

    @Override
    public int[] getSlotProtections() {
        return this.slotProtections;
    }

    @Override
    public boolean getEnable() {
        return true;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}