package com.timelesskeeper.additionalweapon.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.HashMap;
import java.util.Map;

public class CommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static final Map<String, MaterialConfig> MATERIALS = new HashMap<>();
    public static final Map<String, WeaponConfig> WEAPONS = new HashMap<>();

    static {
        BUILDER.comment("Modify the value of the new added weapon.").push("weapon_setting");

        WEAPONS.put("battlestaff", new WeaponConfig(BUILDER, "battlestaff"));
        WEAPONS.put("glaive", new WeaponConfig(BUILDER, "glaive"));
        WEAPONS.put("greataxe", new WeaponConfig(BUILDER, "greataxe"));
        WEAPONS.put("greatsword", new WeaponConfig(BUILDER, "greatsword"));
        WEAPONS.put("halberd", new WeaponConfig(BUILDER, "halberd"));
        WEAPONS.put("katana", new WeaponConfig(BUILDER, "katana"));
        WEAPONS.put("scimitar", new WeaponConfig(BUILDER, "scimitar"));
        WEAPONS.put("spear", new WeaponConfig(BUILDER, "spear"));

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
