package com.fish.thundercrystal.block;

import com.fish.thundercrystal.ThunderCrystal;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block THUNDER_CRYSTAL_ORE = registerBlock("thunder_crystal_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(6, 14), AbstractBlock.Settings.create().strength(3.0f).requiresTool()));
    public static final Block THUNDER_CRYSTAL_BLOCK = registerBlock("thunder_crystal_block",
            new Block(AbstractBlock.Settings.create().strength(4.0f).requiresTool()));

    private static Item registerBlockItem(String id, Block block){

        return Registry.register(
                Registries.ITEM,
                Identifier.of(ThunderCrystal.MOD_ID, id),
                new BlockItem(block, new Item.Settings())
        );
    }

    private static Block registerBlock(String id, Block block) {

        Block registeredBlock = Registry.register(
                Registries.BLOCK,
                Identifier.of(ThunderCrystal.MOD_ID, id),
                block
        );

        registerBlockItem(id, registeredBlock);

        return registeredBlock;
    }

    private static void addBlockToIG(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(THUNDER_CRYSTAL_ORE);
        fabricItemGroupEntries.add(THUNDER_CRYSTAL_BLOCK);
    }

    public static void registerModBlockItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModBlocks::addBlockToIG);
        ThunderCrystal.LOGGER.info("Registering Blocks");
    }

}
