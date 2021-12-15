package io.github.apple502j.nodonkeydupe.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.HorseScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenHandler.class)
public class ScreenHandlerMixin {
    @Inject(method = "internalOnSlotClick", at = @At("HEAD"), cancellable = true)
    protected void checkEntityDiscard(int slotIndex, int button, SlotActionType actionType, PlayerEntity player, CallbackInfo ci) {
    }
}
