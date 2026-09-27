package com.fish.thundercrystal;

import com.fish.thundercrystal.block.ModBlocks;
import com.fish.thundercrystal.event.ModEvents;
import com.fish.thundercrystal.item.ModItemGroups;
import com.fish.thundercrystal.world.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fish.thundercrystal.item.ModItems;

public class ThunderCrystal implements ModInitializer {
	public static final String MOD_ID = "thunder-crystal";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlockItems();
		ModItemGroups.registerModItemGroups();
		ModEvents.registerEvents();
		ModWorldGeneration.generationModWorldGen();
		LOGGER.info("Hello Fabric world!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
