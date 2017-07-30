package me.minidigger.voxelgameslib.deathmatch;

import me.minidigger.voxelgameslib.GameConstants;
import me.minidigger.voxelgameslib.feature.features.GameModeFeature;
import me.minidigger.voxelgameslib.feature.features.MapFeature;
import me.minidigger.voxelgameslib.feature.features.SpawnFeature;
import me.minidigger.voxelgameslib.feature.features.TeamFeature;
import me.minidigger.voxelgameslib.phase.TimedPhase;

import org.bukkit.GameMode;

/**
 * Created by Martin on 28.01.2017.
 */
public class DeathmatchPhase extends TimedPhase {

    @Override
    public void init() {
        setName("DeathmatchPhase");
        setTicks(2 * 60 * GameConstants.TPS);
        super.init();
        setAllowJoin(false);
        setAllowSpectate(true);

        MapFeature mapFeature = getGame().createFeature(MapFeature.class, this);
        mapFeature.setShouldUnload(true);
        addFeature(mapFeature);
  
        SpawnFeature spawnFeature = getGame().createFeature(SpawnFeature.class, this);
        spawnFeature.setRespawn(false);
        addFeature(spawnFeature);

        GameModeFeature gameModeFeature = getGame().createFeature(GameModeFeature.class, this);
        gameModeFeature.setGameMode(GameMode.SURVIVAL);
        addFeature(gameModeFeature);

        DeathmatchFeature deathmatchFeature = getGame().createFeature(DeathmatchFeature.class, this);
        addFeature(deathmatchFeature);

        TeamFeature teamFeature = getGame().createFeature(TeamFeature.class, this);
        addFeature(teamFeature);
    }
}
