package me.cope.noobs;

import me.cope.noobs.module.ModuleManager;
import me.cope.noobs.ui.ClickGUI;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.TickEvent;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

@Mod(Coper.MODID)
public class Coper {
    public static final String MODID = "coper";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final KeyMapping OPEN_GUI = new KeyMapping("key.coper.gui", GLFW.GLFW_KEY_O, "key.category.coper");

    public Coper(IEventBus modEventBus, ModContainer modContainer) {
        // Initialize modules
        ModuleManager.INSTANCE.init();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerKeys);
        
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Coper Client Initialized and Modules Loaded.");
    }

    private void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(OPEN_GUI);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (OPEN_GUI.consumeClick()) {
                Minecraft.getInstance().setScreen(new ClickGUI());
            }
        }
    }
}
