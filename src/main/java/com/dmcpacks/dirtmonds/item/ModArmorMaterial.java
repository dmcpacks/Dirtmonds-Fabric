package com.dmcpacks.dirtmonds.item;

import com.dmcpacks.dirtmonds.Dirtmonds;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.*;
import net.minecraft.util.*;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterial {
public static final RegistryEntry<ArmorMaterial> DIRTMOND = register(
        Dirtmonds.MOD_ID +  ":" + "dirtmond_armor",
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.HELMET, 1);
        map.put(ArmorItem.Type.CHESTPLATE, 4);
        map.put(ArmorItem.Type.LEGGINGS, 3);
        map.put(ArmorItem.Type.BOOTS, 2);
        }),
        0,
        SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
        2.0F,
        0.2F,
        () -> Ingredient.ofItems(ModItems.DIRTMOND));

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.of(Dirtmonds.MOD_ID, "dirtmond_armor")));

        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, defense.get(type));
        }
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Dirtmonds.MOD_ID, "dirtmond_armor"), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, list, toughness, knockbackResistance));
    }
}
