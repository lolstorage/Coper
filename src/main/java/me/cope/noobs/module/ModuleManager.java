package me.cope.noobs.module;

import me.cope.noobs.module.modules.movement.Flight;
import me.cope.noobs.module.modules.exploit.SP_God;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static final ModuleManager INSTANCE = new ModuleManager();
    private final List<Module> modules = new ArrayList<>();

    public void init() {
        // Registering your modules
        modules.add(new Flight());
        modules.add(new SP_God());
    }

    public List<Module> getModules() {
        return modules;
    }
}
