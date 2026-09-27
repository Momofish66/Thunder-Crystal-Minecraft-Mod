package com.fish.thundercrystal.event;

import com.fish.thundercrystal.item.ModItems;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;

public class ModEvents {

    public static void registerEvents() {
        AttackEntityCallback.EVENT.register(
                (PlayerEntity player,
                 net.minecraft.world.World world,
                 net.minecraft.util.Hand hand,
                 net.minecraft.entity.Entity entity,
                 net.minecraft.util.hit.EntityHitResult hitResult
                 ) -> {
                    if (player.getMainHandStack().isOf(ModItems.THUNDER_SWORD) || player.getMainHandStack().isOf(ModItems.THUNDER_AXE)) {
                        if (world.random.nextFloat() < 0.25f) {
                            if (world instanceof ServerWorld serverWorld) {
                                LightningEntity lightning =
                                        EntityType.LIGHTNING_BOLT.create(serverWorld);

                                if (lightning != null) {
                                    lightning.refreshPositionAfterTeleport(
                                            entity.getX(),
                                            entity.getY(),
                                            entity.getZ()
                                    );

                                    serverWorld.spawnEntity(lightning);
                                }
                            }
                        }
                    }
                    return ActionResult.PASS;
                }
        );
    }

}
