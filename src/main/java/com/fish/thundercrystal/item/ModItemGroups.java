package com.fish.thundercrystal.item;

import com.fish.thundercrystal.ThunderCrystal;
import com.fish.thundercrystal.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.lwjgl.system.windows.CRYPTPROTECT_PROMPTSTRUCT;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> THUNDER_CRYSTAL = register("thunder_crystal");

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(ThunderCrystal.MOD_ID, id));
    }

    public static void registerModItemGroups() {
        Registry.register(Registries.ITEM_GROUP, THUNDER_CRYSTAL,
                ItemGroup.create(ItemGroup.Row.TOP, 7).displayName(Text.translatable("itemGroup.thunder-crystal.thunder_crystal"))
                        .icon(() -> new ItemStack(ModItems.THUNDER_CRYSTAL))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.THUNDER_CRYSTAL);
                            entries.add(ModItems.THUNDER_SWORD);
                            entries.add(ModItems.THUNDER_SHOVEL);
                            entries.add(ModItems.THUNDER_PICKAXE);
                            entries.add(ModItems.THUNDER_AXE);
                            entries.add(ModItems.THUNDER_HOE);
                            entries.add(ModBlocks.THUNDER_CRYSTAL_ORE);
                            entries.add(ModBlocks.THUNDER_CRYSTAL_BLOCK);
                        }).build());
        ThunderCrystal.LOGGER.info("Registering Item Groups");
    }
}
