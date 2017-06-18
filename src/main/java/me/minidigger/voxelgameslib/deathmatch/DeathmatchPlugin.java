package me.minidigger.voxelgameslib.deathmatch;

import me.minidigger.voxelgameslib.module.ModuleHandler;

import org.bukkit.plugin.java.JavaPlugin;

public class DeathmatchPlugin extends JavaPlugin {

    @Override
    public void onLoad() {
        ModuleHandler.offerModule(DeathmatchModule.class);
    }
}
