package me.minidigger.voxelgameslib.deathmatch;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Nonnull;

import com.voxelgameslib.voxelgameslib.api.event.GameEvent;
import com.voxelgameslib.voxelgameslib.api.feature.AbstractFeature;
import com.voxelgameslib.voxelgameslib.api.feature.Feature;
import com.voxelgameslib.voxelgameslib.api.feature.features.TeamFeature;

import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathmatchFeature extends AbstractFeature {

    private static final Logger log = Logger.getLogger(DeathmatchFeature.class.getName());

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
