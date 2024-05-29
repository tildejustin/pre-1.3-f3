package dev.tildejustin.seedless.mixin;

import net.minecraft.client.gui.GameGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(GameGui.class)
public abstract class GameGuiMixin {
    @ModifyArg(
            method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GameGui;drawString(Lnet/minecraft/client/render/TextRenderer;Ljava/lang/String;III)V"),
            slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getSeed()J"))
    )
    private String hideSeed(String original) {
        return "Seed: Hidden";
    }
}
