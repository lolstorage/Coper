package me.cope.noobs.module;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static final ModuleManager INSTANCE = new ModuleManager();
    private final List<Module> modules = new ArrayList<>();

    public void init() {
        // Register modules here: modules.add(new FlightModule());
    }

    public List<Module> getModules() {
        return modules;
    }
}
