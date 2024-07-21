package com.dmcpacks.dirtmonds.item;

import com.dmcpacks.dirtmonds.Dirtmonds;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {


    public static final RegistryKey<ItemGroup> DIRTMONDS = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(Dirtmonds.MOD_ID, "dirtmonds_group"));

    public static void registerItemGroup() {
        Registry.register(Registries.ITEM_GROUP, DIRTMONDS, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.DIRTMOND))
                .displayName(Text.translatable("itemGroup.dirtmonds.dirtmonds"))
                .build()); // build() no longer registers by itself
    }
}
