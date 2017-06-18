package me.minidigger.voxelgameslib.deathmatch;

import com.google.inject.Singleton;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import me.minidigger.voxelgameslib.game.GameHandler;
import me.minidigger.voxelgameslib.game.GameMode;
import me.minidigger.voxelgameslib.module.Module;
import me.minidigger.voxelgameslib.module.ModuleInfo;

/**
 * Created by Martin on 28.01.2017.
 */
@Singleton
@ModuleInfo(name = "Deathmatch", authors = "MiniDigger", version = "1.0.0")
public class DeathmatchModule implements Module {

    public static final GameMode GAMEMODE = new GameMode("Deathmatch", DeathmatchGame.class);

    @Inject
    private GameHandler gameHandler;

    @Override
    public void enable() {
        gameHandler.registerGameMode(GAMEMODE);
    }

    @Override
    public void disable() {

    }
}
