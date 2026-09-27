package com.fish.thundercrystal.item;

import com.fish.thundercrystal.ThunderCrystal;
import com.fish.thundercrystal.block.ModBlocks;
import com.fish.thundercrystal.item.custom.ThunderSwordItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import javax.tools.Tool;
import java.awt.image.PixelGrabber;

public class ModItems {

    public static final ToolMaterial THUNDER = new ToolMaterial() {

        @Override
        public int getDurability() {
            return 1561;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 10.0f;
        }

        @Override
        public float getAttackDamage() {
            return 4.0f;
        }

        @Override
        public TagKey<Block> getInverseTag() {
            return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
        }

        @Override
        public int getEnchantability() {
            return 15;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.THUNDER_CRYSTAL);
        }
    };

    public static final Item THUNDER_CRYSTAL = registerItem("thunder_crystal", new Item(new Item.Settings()));
    public static final Item THUNDER_SWORD = registerItem("thunder_sword",
            new ThunderSwordItem(ToolMaterials.DIAMOND,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND,
                            5,
                            -2.4f))));
    public static final Item THUNDER_SHOVEL = registerItem("thunder_shovel",
            new ShovelItem(THUNDER,
                    new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(THUNDER,
                            2.5f,
                            -3.0f))));
    public static final Item THUNDER_PICKAXE = registerItem("thunder_pickaxe",
            new PickaxeItem(THUNDER,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(THUNDER,
                            2,
                            -2.4f))));
    public static final Item THUNDER_AXE = registerItem("thunder_axe",
            new AxeItem(THUNDER,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(THUNDER,
                            6,
                            -3.0f))));
    public static final Item THUNDER_HOE = registerItem("thunder_hoe",
            new HoeItem(THUNDER,
                    new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(THUNDER,
                            -3,
                            0f))));
    private static Item registerItem(String id, Item item) {
        return Registry.register(
                Registries.ITEM,
                Identifier.of(ThunderCrystal.MOD_ID, id),
                item
        );
    }

    private static void addItemToIG(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(THUNDER_CRYSTAL);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIG);
        ThunderCrystal.LOGGER.info("Registering Items");
    }
}