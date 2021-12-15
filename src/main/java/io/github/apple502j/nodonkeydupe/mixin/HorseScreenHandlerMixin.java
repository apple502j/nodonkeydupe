package io.github.apple502j.nodonkeydupe.mixin;

import io.github.apple502j.nodonkeydupe.Mod;
import net.minecraft.entity.passive.HorseBaseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.HorseScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HorseScreenHandler.class)
public class HorseScreenHandlerMixin extends ScreenHandlerMixin {
    @Shadow @Final private HorseBaseEntity entity;

    @Override
    protected void checkEntityDiscard(int slotIndex, int button, SlotActionType actionType, PlayerEntity player, CallbackInfo ci) {
        if (this.entity.isRemoved()) {
            ci.cancel();
            if (player instanceof ServerPlayerEntity serverPlayer) {
                Mod.LOGGER.warn("Prevented slot transfer on discarded entity");
                serverPlayer.networkHandler.disconnect(new LiteralText("Slot transfer on discarded horse, cheating?"));
            }
        }
    }
}
