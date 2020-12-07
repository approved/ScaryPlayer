package dev.odd.scaryplayer.mixin.entity.passive;

import dev.odd.scaryplayer.CanBeScary;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerEntity.class)
public class VillagerEntityMixin {

    @Inject(at = @At("HEAD"), method = "interactMob", cancellable = true)
    public void onInteractMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (((CanBeScary)(Object)player).isScary()) {
            sayNo();
            cir.setReturnValue(ActionResult.FAIL);
        }
    }

    @Shadow
    private void sayNo() {};
}
