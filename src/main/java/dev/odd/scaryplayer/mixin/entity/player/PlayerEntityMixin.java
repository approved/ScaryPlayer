package dev.odd.scaryplayer.mixin.entity.player;

import dev.odd.scaryplayer.CanBeScary;
import dev.odd.scaryplayer.ScaryPlayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin implements CanBeScary {

    public boolean isScary() {
        ItemStack mainItem = this.inventory.getMainHandStack();
        if (!mainItem.isEmpty() && mainItem.getItem().isIn(ScaryPlayer.SCARY_TAG)) {
            return true;
        }

        for (ItemStack armor: this.inventory.armor) {
            if (armor.getItem().isIn(ScaryPlayer.SCARY_TAG)) {
                return true;
            }
        }

        return false;
    }

    @Shadow
    @Final
    public PlayerInventory inventory;
}
