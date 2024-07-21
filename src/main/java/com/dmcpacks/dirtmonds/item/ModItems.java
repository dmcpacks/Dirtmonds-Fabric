package com.dmcpacks.dirtmonds.item;

import com.dmcpacks.dirtmonds.item.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.dmcpacks.dirtmonds.Dirtmonds;

public class ModItems {

    public static final Item DIRTMOND = registerItem("dirtmond", new Item(new Item.Settings()
            ));

    public static final Item DIRTMOND_SWORD = registerItem("dirtmond_sword", new ModSwordItem(ModToolMaterial.DIRTMOND,
            new Item.Settings()
            ));

    public static final Item DIRTMOND_SHOVEL = registerItem("dirtmond_shovel", new ShovelItem(ModToolMaterial.DIRTMOND,
            new Item.Settings()
            ));

    public static final Item DIRTMOND_AXE = registerItem("dirtmond_axe", new ModAxeItem(ModToolMaterial.DIRTMOND,
            new Item.Settings()
            ));

    public static final Item DIRTMOND_PICKAXE = registerItem("dirtmond_pickaxe", new ModPickaxeItem(ModToolMaterial.DIRTMOND,
            new Item.Settings()
            ));

    public static final Item DIRTMOND_HOE = registerItem("dirtmond_hoe", new ModHoeItem(ModToolMaterial.DIRTMOND,
            new Item.Settings()
            ));

    public static final Item DIRTMOND_HELMET = registerItem("dirtmond_helmet", new ModArmorItem(ModArmorMaterial.DIRTMOND, ArmorItem.Type.HELMET,
            new Item.Settings().maxCount(1)
            ));

    public static final Item DIRTMOND_CHESTPLATE = registerItem("dirtmond_chestplate", new ModArmorItem(ModArmorMaterial.DIRTMOND, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxCount(1)
            ));

    public static final Item DIRTMOND_LEGGINGS = registerItem("dirtmond_leggings", new ModArmorItem(ModArmorMaterial.DIRTMOND, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxCount(1)
            ));

    public static final Item DIRTMOND_BOOTS = registerItem("dirtmond_boots", new ModArmorItem(ModArmorMaterial.DIRTMOND, ArmorItem.Type.BOOTS,
            new Item.Settings().maxCount(1)
            ));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Dirtmonds.MOD_ID, name), item);
    }

    public static void addItemsToItemGroups() {
        addToItemGroup(DIRTMOND);
        addToItemGroup(DIRTMOND_SWORD);
        addToItemGroup(DIRTMOND_SHOVEL);
        addToItemGroup(DIRTMOND_AXE);
        addToItemGroup(DIRTMOND_PICKAXE);
        addToItemGroup(DIRTMOND_HOE);
        addToItemGroup(DIRTMOND_HELMET);
        addToItemGroup(DIRTMOND_CHESTPLATE);
        addToItemGroup(DIRTMOND_LEGGINGS);
        addToItemGroup(DIRTMOND_BOOTS);
    }

    public static void addToItemGroup(Item item) {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.DIRTMONDS).register(entries -> entries.add(item));
    }


    public static void registerModItems() {
        addItemsToItemGroups();
        System.out.println("Registered Dirtmonds items");
    }
}
