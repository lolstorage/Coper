package me.cope.noobs.module;

public abstract class Module {
    private final String name;
    private boolean enabled;

    public Module(String name) {
        this.name = name;
    }

    public void toggle() {
        this.enabled = !this.enabled;
        if (this.enabled) onEnable();
        else onDisable();
    }

    public void onEnable() {}
    public void onDisable() {}

    public String getName() { return name; }
    public boolean isEnabled() { return enabled; }
}
