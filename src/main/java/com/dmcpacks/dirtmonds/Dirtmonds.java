package com.dmcpacks.dirtmonds;

import com.dmcpacks.dirtmonds.block.ModBlocks;
import com.dmcpacks.dirtmonds.config.ModConfigs;
import com.dmcpacks.dirtmonds.item.ModItemGroup;
import com.dmcpacks.dirtmonds.item.ModItems;
import com.dmcpacks.dirtmonds.item.custom.DirtmondFinder;
import com.dmcpacks.dirtmonds.util.ModLootTableModifiers;
import com.dmcpacks.dirtmonds.world.OreJsonRegistration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class Dirtmonds implements ModInitializer {

	public static final String MOD_ID = "dirtmonds";

	//dirtmond finder

	public static final Item DIRTMOND_FINDER = new DirtmondFinder(new Item.Settings()
			.maxCount(1));

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();
		ModItemGroup.registerItemGroup();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		OreJsonRegistration.registerOreGeneration();

		if(ModConfigs.dirtmondfinder) {
			Registry.register(Registries.ITEM, new Identifier("dirtmonds", "dirtmond_finder"), DIRTMOND_FINDER);
		}


		System.out.print("Fully registered " + MOD_ID + "\n");
	}
}
