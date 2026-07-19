package me.cope.noobs.module.modules.movement;

import me.cope.noobs.module.Module;
import net.minecraft.client.Minecraft;

public class Flight extends Module {
    private final Minecraft mc = Minecraft.getInstance();

    public Flight() {
        super("Flight");
    }

    @Override
    public void onEnable() {
        if (mc.player != null) {
            mc.player.getAbilities().mayfly = true;
            mc.player.getAbilities().flying = true;
        }
    }

    @Override
    public void onDisable() {
        if (mc.player != null && !mc.player.isCreative() && !mc.player.isSpectator()) {
            mc.player.getAbilities().flying = false;
            mc.player.getAbilities().mayfly = false;
        }
    }
}
