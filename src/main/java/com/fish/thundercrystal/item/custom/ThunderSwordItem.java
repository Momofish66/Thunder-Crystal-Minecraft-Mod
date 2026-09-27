package com.fish.thundercrystal.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.particle.ParticleTypes;

import java.util.List;

public class ThunderSwordItem extends SwordItem {

    public ThunderSwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) player.setCurrentHand(hand);

        return new TypedActionResult<>(
                ActionResult.CONSUME,
                player.getStackInHand(hand)
        );
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        int useTime = getMaxUseTime(stack, user) - remainingUseTicks;

        if (useTime >= 60) {
            if (!world.isClient && user instanceof PlayerEntity player) {
                strikeLightning(world, player);
                stack.damage(5, player, LivingEntity.getSlotForHand(player.getActiveHand()));

                player.stopUsingItem();
            }
        }
    }

    private void strikeLightning(World world, PlayerEntity player) {
        Box box = player.getBoundingBox().expand(16);

        List<LivingEntity> entities = world.getEntitiesByClass(
                LivingEntity.class,
                box,
                entity -> entity != player
        );

        for (LivingEntity entity : entities) {
            LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);

            lightning.refreshPositionAfterTeleport(
                    entity.getX(),
                    entity.getY(),
                    entity.getZ()
            );

            world.spawnEntity(lightning);
        }
    }

}
