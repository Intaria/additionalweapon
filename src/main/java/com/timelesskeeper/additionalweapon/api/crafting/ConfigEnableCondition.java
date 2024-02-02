package com.timelesskeeper.additionalweapon.api.crafting;

import com.google.gson.JsonObject;
import com.timelesskeeper.additionalweapon.AdditionalWeapon;
import com.timelesskeeper.additionalweapon.api.items.IConfigItem;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConfigEnableCondition implements ICondition {
    private static final ResourceLocation NAME = new ResourceLocation(AdditionalWeapon.MOD_ID, "config_enable");
    private final Item weapon;

    public ConfigEnableCondition(Item weapon)
    {
        this.weapon = weapon;
    }

    @Override
    public ResourceLocation getID() {
        return NAME;
    }

    @Override
    public boolean test(IContext context) {
        if (weapon instanceof IConfigItem) {
            return  ((IConfigItem)weapon).isEnabled();
        } else {
            return true;
        }
    }

    public static class Serializer implements IConditionSerializer<ConfigEnableCondition> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void write(JsonObject json, ConfigEnableCondition value) {
            json.addProperty("config_enable", Registry.ITEM.getKey(value.weapon).toString());
        }

        @Override
        public ConfigEnableCondition read(JsonObject json) {
            return new ConfigEnableCondition(GsonHelper.getAsItem(json, "config_enable"));
        }

        @Override
        public ResourceLocation getID() {
            return ConfigEnableCondition.NAME;
        }
    }
}
