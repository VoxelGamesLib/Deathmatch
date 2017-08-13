package me.minidigger.voxelgameslib.deathmatch;

import javax.annotation.Nonnull;

import com.voxelgameslib.voxelgameslib.event.GameEvent;
import com.voxelgameslib.voxelgameslib.feature.AbstractFeature;
import com.voxelgameslib.voxelgameslib.feature.features.TeamFeature;

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

    @GameEvent
    public void onDeath(@Nonnull PlayerDeathEvent e) {

    }

    @Override
    @Nonnull
    public Class[] getDependencies() {
        return new Class[]{TeamFeature.class};
    }
}
