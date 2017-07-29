package me.minidigger.voxelgameslib.deathmatch;

import me.minidigger.voxelgameslib.event.GameEvent;
import me.minidigger.voxelgameslib.feature.AbstractFeature;
import me.minidigger.voxelgameslib.feature.features.TeamFeature;

import org.bukkit.event.entity.PlayerDeathEvent;

import lombok.extern.java.Log;

@Log
public class DeathmatchFeature extends AbstractFeature {

    @Override
    public void start() {
        TeamFeature teamFeature = getPhase().getFeature(TeamFeature.class);

        getPhase().getGame().getPlayers().forEach(user ->
                teamFeature.getTeam(user).ifPresent(team -> log.finer(user.getRawDisplayName() + " is on team " + team.getName())));
    }

    @Override
    public void stop() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void init() {

    }

    @GameEvent
    public void onDeath(PlayerDeathEvent e) {

    }

    @Override
    public Class[] getDependencies() {
        return new Class[]{TeamFeature.class};
    }
}
