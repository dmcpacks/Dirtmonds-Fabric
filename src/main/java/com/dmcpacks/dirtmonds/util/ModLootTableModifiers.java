package com.dmcpacks.dirtmonds.util;

import com.dmcpacks.dirtmonds.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModLootTableModifiers {
    private static final Identifier VILLAGE_TOOLSMITH_ID = Identifier.ofVanilla("chests/village/village_toolsmith");
    private static final Identifier VILLAGE_WEAPONSMITH_ID = Identifier.ofVanilla("chests/village/village_weaponsmith");

    public static void modifyLootTables() {
        // 637898971158033062
        // /tp 6693 67 9403

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if(VILLAGE_TOOLSMITH_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.7f)) //0.7% chance drop
                        .with(ItemEntry.builder(ModItems.DIRTMOND))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f,2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(VILLAGE_TOOLSMITH_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.6f)) //0.6% chance drop
                        .with(ItemEntry.builder(ModItems.DIRTMOND_CHESTPLATE))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_BOOTS))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_LEGGINGS))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_HELMET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f,1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(VILLAGE_WEAPONSMITH_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.65f)) //0.65% chance drop
                        .with(ItemEntry.builder(ModItems.DIRTMOND))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f,2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(VILLAGE_WEAPONSMITH_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.7f)) //0.7% chance drop
                        .with(ItemEntry.builder(ModItems.DIRTMOND_CHESTPLATE))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_BOOTS))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_LEGGINGS))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_HELMET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f,1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
