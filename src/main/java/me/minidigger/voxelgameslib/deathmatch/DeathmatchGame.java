package me.minidigger.voxelgameslib.deathmatch;

import com.voxelgameslib.voxelgameslib.feature.features.TeamSelectFeature;
import com.voxelgameslib.voxelgameslib.game.AbstractGame;
import com.voxelgameslib.voxelgameslib.game.GameDefinition;
import com.voxelgameslib.voxelgameslib.game.GameInfo;
import com.voxelgameslib.voxelgameslib.phase.phases.GracePhase;
import com.voxelgameslib.voxelgameslib.phase.phases.LobbyWithVotePhase;

import javax.annotation.Nonnull;

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
