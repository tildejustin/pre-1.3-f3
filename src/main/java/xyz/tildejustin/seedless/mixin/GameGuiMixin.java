package xyz.tildejustin.seedless.mixin;

import net.minecraft.client.gui.GameGui;
import net.minecraft.client.render.TextRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameGui.class)
public abstract class GameGuiMixin {
	@Redirect(
			method = "render",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/gui/GameGui;drawString(Lnet/minecraft/client/render/TextRenderer;Ljava/lang/String;III)V"
			)
	)
	private void seedless_stopSeedDisplay(GameGui instance, TextRenderer textRenderer, String s, int i, int j, int k) {
		if (!s.contains("Seed: ")) {
			instance.drawString(textRenderer, s, i, j, k);
		}

	}
}
