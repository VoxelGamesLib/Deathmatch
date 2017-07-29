package me.minidigger.voxelgameslib.deathmatch;

import javax.annotation.Nonnull;

import me.minidigger.voxelgameslib.feature.features.TeamSelectFeature;
import me.minidigger.voxelgameslib.game.AbstractGame;
import me.minidigger.voxelgameslib.game.GameDefinition;
import me.minidigger.voxelgameslib.game.GameInfo;
import me.minidigger.voxelgameslib.phase.phases.GracePhase;
import me.minidigger.voxelgameslib.phase.phases.LobbyWithVotePhase;

/**
 * Created by Martin on 28.01.2017.
 */
@GameInfo(name = "Deathmatch", author = "MiniDigger", version = "v1.0", description = "Deathmatch Description")
public class DeathmatchGame extends AbstractGame {

    public DeathmatchGame() {
        super(DeathmatchPlugin.GAMEMODE);
    }

    @Override
    public void initGameFromModule() {
        setMinPlayers(2);
        setMaxPlayers(2);

        LobbyWithVotePhase votePhase = createPhase(LobbyWithVotePhase.class);
        GracePhase gracePhase = createPhase(GracePhase.class);
        DeathmatchPhase survivalGamesPhase = createPhase(DeathmatchPhase.class);

        votePhase.addFeature(createFeature(TeamSelectFeature.class, votePhase));

        votePhase.setNextPhase(gracePhase);
        gracePhase.setNextPhase(survivalGamesPhase);

        activePhase = votePhase;

        loadMap();
    }

    @Override
    public void initGameFromDefinition(@Nonnull GameDefinition gameDefinition) {
        super.initGameFromDefinition(gameDefinition);

        loadMap();
    }
}
