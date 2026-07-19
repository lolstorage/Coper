package me.cope.noobs.ui;

import me.cope.noobs.module.Module;
import me.cope.noobs.module.ModuleManager;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ClickGUI extends Screen {
    private final int boxWidth = 120;
    private final int boxHeight = 20;
    private final int padding = 6;

    public ClickGUI() {
        super(Component.literal("Coper ClickGUI"));
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics, mouseX, mouseY, partialTick);
        
        List<Module> modules = ModuleManager.INSTANCE.getModules();
        int startX = 50;
        int startY = 50;

        for (int i = 0; i < modules.size(); i++) {
            Module m = modules.get(i);
            int y = startY + (i * (boxHeight + padding));
            
            // Draw background
            graphics.fill(startX, y, startX + boxWidth, y + boxHeight, 0xCC000000);
            
            // Draw border when hovering
            if (mouseX >= startX && mouseX <= startX + boxWidth && mouseY >= y && mouseY <= y + boxHeight) {
                graphics.renderOutline(startX, y, boxWidth, boxHeight, 0xFFFFFFFF);
            }

            // Draw text
            int color = m.isEnabled() ? 0x00FF00 : 0xFFFFFF;
            graphics.drawString(this.font, m.getName(), startX + 8, y + 6, color);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        List<Module> modules = ModuleManager.INSTANCE.getModules();
        int startX = 50;
        int startY = 50;

        for (int i = 0; i < modules.size(); i++) {
            int y = startY + (i * (boxHeight + padding));
            if (mouseX >= startX && mouseX <= startX + boxWidth && mouseY >= y && mouseY <= y + boxHeight) {
                modules.get(i).toggle();
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
