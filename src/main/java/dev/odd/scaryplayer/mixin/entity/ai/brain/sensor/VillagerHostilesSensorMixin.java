package dev.odd.scaryplayer.mixin.entity.ai.brain.sensor;

import dev.odd.scaryplayer.CanBeScary;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.sensor.VillagerHostilesSensor;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerHostilesSensor.class)
public class VillagerHostilesSensorMixin {

    private static final double playerDetectionRange;

    @Inject(at = @At("HEAD"), method = "isHostile", cancellable = true)
    private void onIsHostile(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof PlayerEntity) {
            if (((CanBeScary)(Object)entity).isScary()) {
                cir.setReturnValue(true);
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "isCloseEnoughForDanger", cancellable = true)
    private void onIsCloseEnoughForDanger(LivingEntity villager, LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof PlayerEntity) {
            cir.setReturnValue(entity.squaredDistanceTo(villager) <= playerDetectionRange * playerDetectionRange);
        }
    }

    static {
         playerDetectionRange = 12;
    }
}
