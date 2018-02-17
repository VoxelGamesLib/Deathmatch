package me.minidigger.voxelgameslib.deathmatch;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

import com.voxelgameslib.voxelgameslib.event.GameEvent;
import com.voxelgameslib.voxelgameslib.feature.AbstractFeature;
import com.voxelgameslib.voxelgameslib.feature.Feature;
import com.voxelgameslib.voxelgameslib.feature.features.TeamFeature;

import org.bukkit.event.entity.PlayerDeathEvent;

import lombok.extern.java.Log;

@Log
public class DeathmatchFeature extends AbstractFeature {

    @Override
    public void enable() {
        TeamFeature teamFeature = getPhase().getFeature(TeamFeature.class);

        getPhase().getGame().getPlayers().forEach(user ->
                teamFeature.getTeam(user).ifPresent(team -> log.finer(user.getRawDisplayName() + " is on team " + team.getName())));
    }

    @GameEvent
    public void onDeath(@Nonnull PlayerDeathEvent e) {

    }

    @Override
    @Nonnull
    public List<Class<? extends Feature>> getDependencies() {
        return Collections.singletonList(TeamFeature.class);
    }
}
